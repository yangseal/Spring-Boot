/* ajax调用，获取json */
function GetJson(methodName, data, recallBack) {
    $.ajax({
        type: "post",
        contentType: "application/json",
        url: rootDirectoryURL + "/oamBaseStationMap/"+methodName,
        data: data,
        dataType: 'json',
        success: function(data) {
            recallBack(data);
        },
    	error: function (xhr) { alert('发生错误：' + xhr.responseText); }
    });
}

function CurentTime() {
    var str = "";
    todayDate = new Date();
    date = todayDate.getDate();
    month = todayDate.getMonth() + 1;
    year = todayDate.getFullYear();
    str = str + ("今天是");
    str = str + year + "年" + month + "月" + date + "日  ";
    if (todayDate.getDay() == 5) str = str + "星期五";
    if (todayDate.getDay() == 6) str = str + "星期六";
    if (todayDate.getDay() == 0) str = str + "星期日";
    if (todayDate.getDay() == 1) str = str + "星期一";
    if (todayDate.getDay() == 2) str = str + "星期二";
    if (todayDate.getDay() == 3) str = str + "星期三";
    if (todayDate.getDay() == 4) str = str + "星期四";
    document.getElementById("time").innerHTML = str;
}

function addFavorite2() {
    var url = window.location;
    var title = document.title;
    var ua = navigator.userAgent.toLowerCase();
    if (ua.indexOf("360se") > -1) {
        alert("由于360浏览器功能限制，请按 Ctrl+D 手动收藏！");
    }
    else if (ua.indexOf("msie 8") > -1) {
        window.external.AddToFavoritesBar(url, title); //IE8
    }
    else if (document.all) {
        try {
            window.external.addFavorite(url, title);
        } catch (e) {
            alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
        }
    }
    else if (window.sidebar) {
        window.sidebar.addPanel(title, url, "");
    }
    else {
        alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
    }
}


/* 获取url参数 */
//#region         
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
//#endregion


var sweetTitles = { x: 10, y: 20, tipElements: "a,span,img,div ", noTitle: false, init: function() {
    var noTitle = this.noTitle; $(this.tipElements).each(function() {
        $(this).mouseover(function(e) {
            if (noTitle) {
                isTitle = true;
            } else {
                isTitle = $.trim(this.title) != '';
            } if (isTitle) {
                this.myTitle = this.title; this.title = ""; var tooltip = "<div class='tooltip'><div class='tipsy-arrow tipsy-arrow-n'></div><div class='tipsy-inner'>" + this.myTitle + "</div></div>"; $('body').append(tooltip); $('.tooltip')
 .css({ "top": (e.pageY + 20) + "px", "left": (e.pageX - 20) + "px" }).show('fast');
            }
        }).mouseout(function() {
            if (this.myTitle != null) {
                this.title = this.myTitle; $('.tooltip').remove();
            }
        }).mousemove(function(e) {
            $('.tooltip')
 .css({ "top": (e.pageY + 20) + "px", "left": (e.pageX - 20) + "px" });
        });
    });
}
};  