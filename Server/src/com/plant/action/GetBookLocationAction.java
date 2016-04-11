package com.plant.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.plant.util.HttpRequest;

public class GetBookLocationAction extends ActionSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2798316553412822227L;
	
	private String keywords;
	
	public String execute() throws IOException {
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ctx
				.get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String postResult = HttpRequest.sendPost("http://yuntuapi.amap.com/datasearch/local",
				"key=b443d3ea1afc1503f4cf573a1b27e051&tableid=5695e5ad305a2a2fb90ba018&keywords=" + keywords + "&city=全国");

		System.out.println(postResult);
		out.println(postResult);
		return null;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


}
