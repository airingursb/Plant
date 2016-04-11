/**
 * Created by zyktrcn on 16/3/29.
 */

$(document).ready(function () {
    if (getCookie('loginstatus') == 1) {
        document.getElementById('unlogin').style.display = "none";
        document.getElementById('logined').style.display = "block";
        $("#person-head").attr('src',getCookie('userHead')) ;
        $("#person-name").html(getCookie('userName'));
    }else{
        document.getElementById('logined').style.display = "none";
        document.getElementById('unlogin').style.display = "block";
        $("#person-head").attr('src','') ;
        $("#person-name").html("");
    }
});

function js_login() {
    var count;
    var albert_content = ["网络错误", "登陆失败", "登陆成功", "其他错误"];
    var useraccount = document.getElementById('useraccount');
    var userpassword = document.getElementById('userpassword');
    if (useraccount.value == "" || !useraccount.value) {
        alert("用户账户为空，请重新输入");
        useraccount.focus();
        return;
    } else if (userpassword.value == "" || !userpassword.value) {
        alert("密码为空，请重新输入");
        userpassword.focus();
        return;
    }
    $.ajax({
        type: "POST",
        url: "http://192.168.20.102:8080/Plant/login.action",
        data: {userAccount: useraccount.value, userPassword: userpassword.value},
        success: function (data) {
            var result = data.status;
            switch (result) {
                case -1:
                    count = 0;
                    break;
                case 0:
                    count = 1;
                    break;
                case 1:
                    count = 2;
                    break;
                case 2:
                    count = 3;
                    break;
                default :
                    count = 3;
                    break;
            }
            if (count != 2) {
                alert(albert_content[count]);
            } else {
                setCookie('loginstatus', 1);
                setCookie('userId', data.userId);
                setCookie('userName', data.userName);
                setCookie('userHead', data.userHead);
                setCookie('userPhone', data.userPhone);
                window.location.reload();
            }
        },
        error: function (XMLHttpRequest, textStatus) {
            alert("XMLHttpRequest.status" + XMLHttpRequest.status);
            alert("XMLHttpRequest.readyState" + XMLHttpRequest.readyState);
            alert("textStatus" + textStatus);
        }
    });
}

function js_register() {
    var count;
    var albert_content = ["网络错误", "注册失败", "注册成功", "其他错误"];
    var account = document.getElementById('account');
    var password = document.getElementById('password');
    var confirmpassword = document.getElementById('confirmpassword');
    var name = document.getElementById('name');
    if (account.value == "" || !account.value) {
        alert("用户账户为空，请重新输入");
        account.focus();
        return;
    } else if (password.value == "" || !password.value) {
        alert("密码为空，请重新输入");
        password.focus();
        return;
    } else if (confirmpassword.value != password.value) {
        alert("请确认重复密码与密码相同");
        confirmpassword.focus();
        return;
    } else if (name.value == "" || !name.value) {
        alert("用户名为空，请重新输入");
        name.focus();
        return;
    }
    $.ajax({
        type: "POST",
        url: "http://192.168.20.102:8080/Plant/register.action",
        data: {userAccount: account.value, userPassword: password.value},
        success: function (data) {
            var result = data.status;
            switch (result) {
                case -1:
                    count = 0;
                    break;
                case 0:
                    count = 1;
                    break;
                case 1:
                    count = 2;
                    break;
                case 2:
                    count = 3;
                    break;
                default :
                    count = 3;
                    break;
            }
            if (count) {
                alert(albert_content[count]);
                if (count == 2) {
                    setCookie('loginstatus', 1);
                    setCookie('userId', data.userId);
                    setCookie('userName', data.userName);
                    setCookie('userHead', data.userHead);
                    setCookie('userSex', data.userSex);
                    window.location.reload();
                }
            }
        },
        error: function (XMLHttpRequest, textStatus) {
            alert("XMLHttpRequest.status" + XMLHttpRequest.status);
            alert("XMLHttpRequest.readyState" + XMLHttpRequest.readyState);
            alert("textStatus" + textStatus);
        }
    });
}

function js_quit() {
    setCookie('loginstatus', 0);
    setCookie('userId', '');
    setCookie('userName', '');
    setCookie('userHead', '');
    setCookie('userPhone', '');
    window.location.reload();
}

function js_buy(userId, bookId) {
    if (userId && bookId) {
        $.ajax({
            type: "POST",
            url: "http://192.168.20.102:8080/Plant/buy.action",
            data: {userId:userId,bookId:bookId},
            success: function (data) {
                var result = data.status;
                if (result == 1) {
                    alert("购买书籍成功");
                    window.location.href = "person.html";
                } else {
                    alert("购买书籍失败");
                    window.location.reload();
                }
            },
            error: function (XMLHttpRequest, textStatus) {
                alert("XMLHttpRequest.status" + XMLHttpRequest.status);
                alert("XMLHttpRequest.readyState" + XMLHttpRequest.readyState);
                alert("textStatus" + textStatus);
            }
        });
    }else if(!userId){
        alert("请先登录");
    }else{
        alert("请选择购买的书本");
        window.location.href = "sort.html";
    }
}

function js_upload(){
    var bookName = $("#bookname");
    var bookAuthor = $("#bookauthor");
    var bookPublishCompany = $("#bookpublishcompany");
    var bookISBN = $("#bookisbn");
    var bookType;
    switch ($("#booktype").val()){
        case "白云区":
            bookType = 1;
            break;
        case "番禺":
            bookType = 2;
            break;
        case "花都区":
            bookType = 3;
            break;
        case "萝岗区":
            bookType = 4;
            break;
        case "大学城":
            bookType = 5;
            break;
        default :
            bookType = 0;
            break;
    }
    var bookContent = $("#bookcontent");
    var bookCoin = $("#bookcoin");
    var bookCover = getCookie('newbookurl');
    if(!bookName.val()){
        alert("请输入书名");
        bookName.focus();
        return;
    }else if (!bookAuthor.val()){
        alert("请输入作者");
        bookAuthor.focus();
        return;
    }else if (!bookPublishCompany.val()){
        alert("请输入出版社");
        bookPublishCompany.focus();
        return;
    }else if (!bookISBN.val()){
        alert("请输入ISBN");
        bookISBN.focus();
        return;
    }else if (!bookContent.val()){
        alert("请输入书本简介");
        bookContent.focus();
        return;
    }else if (!bookCoin.val()){
        alert("请输入售价");
        bookCoin.focus();
        return;
    }else if (!bookCover){
        alert("请上传书本封面");
        return;
    }

    var count;
    var albert_content = ["网络错误", "上传失败", "上传成功", "其他错误"];
    $.ajax({
        type: "POST",
        url: "http://121.42.195.113/Plant/add_book_action.action",
        data: {userId:getCookie('userId'),bookName:bookName.val(),bookAuthor:bookAuthor.val(),bookISBN:bookISBN.val(),bookLatitude:0,bookLongitude:0,typeId:bookType,bookCover:bookCover},
        success: function (data) {
            var result = data.status;
            switch (result) {
                case -1:
                    count = 0;
                    break;
                case 0:
                    count = 1;
                    break;
                case 1:
                    count = 2;
                    break;
                case 2:
                    count = 3;
                    break;
                default :
                    count = 3;
                    break;
            }
            if (count) {
                alert(albert_content[count]);
                if (count == 2) {
                    window.location.reload();
                }
            }
        },
        error: function (XMLHttpRequest, textStatus) {
            alert("XMLHttpRequest.status" + XMLHttpRequest.status);
            alert("XMLHttpRequest.readyState" + XMLHttpRequest.readyState);
            alert("textStatus" + textStatus);
        }
    });

}

function get_Index() {
    var count;
    var albert_content = ["网络错误", "获取书籍失败", "获取书籍成功", "其他错误"];
    $.ajax({
        type: "POST",
        url: "http://192.168.20.102:8080/Plant/main.action",
        data: {},
        success: function (data) {
            var result = data.status;
            switch (result) {
                case -1:
                    count = 0;
                    break;
                case 0:
                    count = 1;
                    break;
                case 1:
                    count = 2;
                    break;
                case 2:
                    count = 3;
                    break;
                default :
                    count = 3;
                    break;
            }
            if (count != 2) {
                alert(albert_content[count]);
                return;
            } else {
                var hotList = data.hotList;
                var suggestList = data.suggestList;
                for (var i = 0; i < hotList.length; i++) {
                    $('#hotList').html($('#hotList').html() + "<div class=\'col-md-3\'><a href=\'javascript:to_detail(" + hotList[i].bookId + ")\'><img src=\'" + hotList[i].bookCover + "\' class=\'bookCover\' /></a><h4 class=\'text-title\'><a href=\'javascript:to_detail(" + hotList[i].bookId + ")\'>" + hotList[i].bookName + "</a> </h4> <div class=\'text-author\'>author:" + hotList[i].bookAuthor + "</div> <div class=\'text-cost\'>sell:" + hotList[i].bookCoin + " </div> </div>");
                }
                for (var i = 0; i < suggestList.length; i++) {
                    $('#suggestList').html($('#suggestList').html() + "<div class=\'col-md-3\'><a href=\'javascript:to_detail(" + suggestList[i].bookId + ")\'><img src=\'" + suggestList[i].bookCover + "\' class=\'bookCover\' /></a><h4 class=\'text-title\'><a href=\'javascript:to_detail(" + hotList[i].bookId + ")\'>" + suggestList[i].bookName + "</a> </h4> <div class=\'text-author\'>author:" + suggestList[i].bookAuthor + "</div> <div class=\'text-cost\'>sell:" + suggestList[i].bookCoin + " </div> </div>");
                }

            }
        },
        error: function (XMLHttpRequest, textStatus) {
            alert("XMLHttpRequest.status" + XMLHttpRequest.status);
            alert("XMLHttpRequest.readyState" + XMLHttpRequest.readyState);
            alert("textStatus" + textStatus);
        }
    });
}

function list_book(typeId, pageNum) {
    var count;
    var albert_content = ["网络错误", "获取书籍失败", "获取书籍成功", "其他错误"];
    $.ajax({
        type: "POST",
        url: "http://192.168.20.102:8080/Plant/type.action",
        data: {typeId: typeId, pageNum: pageNum},
        success: function (data) {
            var result = data.status;
            switch (result) {
                case -1:
                    count = 0;
                    break;
                case 0:
                    count = 1;
                    break;
                case 1:
                    count = 2;
                    break;
                case 2:
                    count = 3;
                    break;
                default :
                    count = 3;
                    break;
            }
            if (count != 2) {
                alert(albert_content[count]);
                return;
            }
            if (count == 2) {
                var bookList = data.bookListData;
                for (var i = 0; i < bookList.length; i++) {
                    $("#bookList").html($("#bookList").html() + "<li><div class=\'col-md-2\'><a href=\'javascript:to_detail(" + bookList[i].bookId + ")\'><img src=\'" + bookList[i].bookCover + "\'></a></div><div class=\'col-md-8\'><a href=\'javascript:to_detail(" + bookList[i].bookId + ")\'><h3>" + bookList[i].bookName + "</h3></a><small>" + bookList[i].userName + "</small><small>" + bookList[i].bookLocantion + "</small><p>" + bookList[i].bookContent + "</p></div><div class=\'col-md-2 text-center\'><h1>" + bookList[i].bookCoin + "</h1></div></li>")
                }
            }
        },
        error: function (XMLHttpRequest, textStatus) {
            alert("XMLHttpRequest.status" + XMLHttpRequest.status);
            alert("XMLHttpRequest.readyState" + XMLHttpRequest.readyState);
            alert("textStatus" + textStatus);
        }
    });
}


function type_book(typeId) {
    setCookie('typeId', typeId);
    $("#bookList").html("");
    list_book(typeId, 1);
}

function to_detail(bookId) {
    setCookie('bookId', bookId);
    window.location.href = "detail.html";
}

function detail_book(bookId) {
    var count;
    var albert_content = ["网络错误", "获取书籍失败", "获取书籍成功", "其他错误"];
    $.ajax({
        type: "POST",
        url: "http://192.168.20.102:8080/Plant/get_book_info.action",
        data: {bookId: bookId},
        success: function (data) {
            var result = data.status;
            switch (result) {
                case -1:
                    count = 0;
                    break;
                case 0:
                    count = 1;
                    break;
                case 1:
                    count = 2;
                    break;
                case 2:
                    count = 3;
                    break;
                default :
                    count = 3;
                    break;
            }
            if (count != 2) {
                alert(albert_content[count]);
                window.location.href = "index.html";
            } else {
                $("#bookCover").attr('src',data.bookCover);
                $("#bookNmae").html(data.bookName);
                $("#bookAuthor").html(data.bookAuthor);
                $("#publishCompany").html(data.bookPublishingCompany);
                $("#bookcontent").html(data.bookContent);
                $("#bookCoin").html(data.bookCoin);
                var hotList = data.hotList;
                for (var i = 0; i < hotList.length; i++) {
                    $('#hotList').html($('#hotList').html() + "<div class=\'col-md-3\'><a href=\'javascript:to_detail(" + hotList[i].bookId + ")\'><img src=\'" + hotList[i].bookCover + "\' class=\'bookCover\' /></a><h4 class=\'text-title\'><a href=\'javascript:to_detail(" + hotList[i].bookId + ")\'>" + hotList[i].bookName + "</a> </h4> <div class=\'text-author\'>author:" + hotList[i].bookAuthor + "</div> <div class=\'text-cost\'>sell:" + hotList[i].bookCoin + " </div> </div>");
                }
            }
        },
        error: function (XMLHttpRequest, textStatus) {
            alert("XMLHttpRequest.status" + XMLHttpRequest.status);
            alert("XMLHttpRequest.readyState" + XMLHttpRequest.readyState);
            alert("textStatus" + textStatus);
        }
    });
}

function get_person(userId,pageNum) {
    var count;
    var albert_content = ["网络错误", "获取个人信息失败", "获取个人信息成功", "其他错误"];
    $.ajax({
        type: "POST",
        url: "http://192.168.20.102:8080/Plant/get_user_info.action",
        data: {userId: userId,pageNum:pageNum},
        success: function (data) {
            var result = data.status;
            switch (result) {
                case -1:
                    count = 0;
                    break;
                case 0:
                    count = 1;
                    break;
                case 1:
                    count = 2;
                    break;
                case 2:
                    count = 3;
                    break;
                default :
                    count = 3;
                    break;
            }
            if (count != 2) {
                alert(albert_content[count]);
                window.location.href = "index.html";
            } else {
                if (pageNum == 1){
                    $('#userhead').attr('src',getCookie('userHead'));
                    $('#username').html(getCookie('userName'));
                    $('#userphone').html(getCookie('userPhone'));
                    $('#usercoins').html(data.userCoin);
                }
                var bookList = data.bookListData;
                for (var i = 0; i < bookList.length; i++) {
                    $("#bookList").html($("#bookList").html() + "<li><div class=\'col-md-2\'><a href=\'javascript:to_detail(" + bookList[i].bookId + ")\'><img src=\'" + bookList[i].bookCover + "\'></a></div><div class=\'col-md-8\'><a href=\'javascript:to_detail(" + bookList[i].bookId + ")\'><h3>" + bookList[i].bookName + "</h3></a><small>" + bookList[i].userName + "</small><small>" + bookList[i].bookLocantion + "</small><p>" + bookList[i].bookContent + "</p></div><div class=\'col-md-2 text-center\'><h1>" + bookList[i].bookCoin + "</h1></div></li>")
                }
                var buyBook = data.buyBookData;
                for (var i = 0; i < buyBook.length; i++) {
                    $("#buyBook").html($("#buyBook").html() + "<li><div class=\'col-md-2\'><a href=\'javascript:to_detail(" + buyBook[i].bookId + ")\'><img src=\'" + buyBook[i].bookCover + "\'></a></div><div class=\'col-md-8\'><a href=\'javascript:to_detail(" + buyBook[i].bookId + ")\'><h3>" + buyBook[i].bookName + "</h3></a><small>" + buyBook[i].userName + "</small><small>" + buyBook[i].bookLocantion + "</small><p>" + buyBook[i].bookContent + "</p></div><div class=\'col-md-2 text-center\'><h1>" + buyBook[i].bookCoin + "</h1></div></li>")
                }
            }
        },
        error: function (XMLHttpRequest, textStatus) {
            alert("XMLHttpRequest.status" + XMLHttpRequest.status);
            alert("XMLHttpRequest.readyState" + XMLHttpRequest.readyState);
            alert("textStatus" + textStatus);
        }
    });
}


//set cookie
function setCookie(c_name, value, expiredays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    document.cookie = c_name + "=" + escape(value) +
        ((expiredays == null) ? "" : "; expires=" + exdate.toUTCString() );
}
//get cookie
function getCookie(c_name) {
    if (document.cookie.length > 0) {
        var c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            var c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1) c_end = document.cookie.length;
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
    return ""
}