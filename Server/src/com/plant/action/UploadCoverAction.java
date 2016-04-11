package com.plant.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.plant.util.JsonResult;

public class UploadCoverAction extends ActionSupport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2073890113632845391L;

	private File upload;
	
	private String uploadFileName;
	
	private String savePath;
		
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() throws Exception{
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}
	
	public String execute() throws Exception{
		String path = getSavePath() ;
		System.out.println(path);
		File file = new File(path);
        if(!file.exists()){
        	file.mkdirs();
        }
		FileOutputStream fos = new FileOutputStream(path + "/" + getUploadFileName());
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = fis.read(buffer)) > 0){
			fos.write(buffer, 0, len);
		}
		fis.close();
		fos.close();
	
		String url;
		url = "http://121.42.113.192/Plant/images/" + getUploadFileName();
		
		Gson gson = new Gson();
		JsonResult result = new JsonResult();
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE); 
		PrintWriter out = response.getWriter();
		result.setStatus(1);
		result.setUrl(url);

//		ActionContext ctx = ActionContext.getContext();
//		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE); 
//		PrintWriter out = response.getWriter();
//		UploadQiniu qiniu = new UploadQiniu();
//		qiniu.upload();
//		String url = "";
		out.println("<script>window.parent.callback(\"" + url + "\")</script>");

		return null;
	}



}
