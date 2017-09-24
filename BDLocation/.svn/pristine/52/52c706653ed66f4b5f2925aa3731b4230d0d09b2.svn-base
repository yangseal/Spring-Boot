<!DOCTYPE>
<html>
<head>
<#include "/head.ftl"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="x-ua-compatible" content="IE=EmulateIE7" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <title>详情</title>
    <link rel="stylesheet" type="text/css" href="${rc.contextPath}/public/css/smoothDivScroll.css" />
    <link rel="stylesheet" type="text/css" href="${rc.contextPath}/public/css/bs_main.css" />

    <script src="${rc.contextPath}/public/js/lib/jquery.ui.widget.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/public/js/lib/jquery.smoothDivScroll-1.0-min.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/public/js/oamBaseStation/common.js" type="text/javascript"></script>
    <style>
        body
        {
            width: 700px;
            margin: auto;
            height: 100%;
        }
    </style>
    <script language="javascript" type="text/javascript">
        var stationId;
        $(document).ready(function() {
            var para = GetRequest();
            if (para != null) {
                if (para.stationId != null && para.stationId!= undefined) {
                    stationId = para.stationId;
                }
            }
          
            var para = {"stationId":stationId};
            $.post(rootDirectoryURL + "/oamBaseStationMap/getInfoByStaiton",para,getInfo);
        });
        function closebox1() {
            window.parent.document.body.removeChild(window.parent.document.getElementById("dialogCase"))
        }

        function getInfo(data) {
            if (data != undefined && data != "") {
                var json = data.message;
                $("#name").html(json.oamBaseStationName);
                $("#name1").html(json.oamBaseStationName);
                $("#baseCode").html(json.stationCode);
                $("#companyName").html(json.customerName);
                $("#projectName").html(json.projectName);
                $("#address").html(json.address);
                $("#ContactName").html(json.contacts);
                $("#Tel").html(json.contact);
                var work = [];
                if (json.aDSL == "1") {
                    work.push("ADSL");
                }
                if (json.opticalFiber == "1") {
                    work.push('光纤');
                }
                if (json.interchanger == "1") {
                    work.push('交换机');
                }
                if (json.router == "1") {
                    work.push('路由器');
                }
                if (json.otherNetwork != null &&  json.otherNetwork != "") {
                    work.push(json.otherNetwork);
                }
                $("#NetWire").html(work.join(','));
                var strArray = [];
                var params = {"entityName":"oamBaseStation","fieldName":"attachments","entityId":json.oamBaseStationId};
                $.ajax({ 
                	async : false,  
			        cache:false,  
			        type: 'POST', 
			        data: params, 
			        dataType : "json",  
			        url: rootDirectoryURL+"/oamBaseStationMap/getAttachments",//请求的action路径  
			        error: function () {//请求失败处理函数  
			        	myAlert('获得节点类型数据失败');  
			        },  
			        success:function(data){ //请求成功后处理函数。
			        	if(data.message != null && data.message.length > 0) {
			        		$(data.message).each(function(n, item) {
			        	 		var id = "";
                            	if (n == 0)
                                	id = ' id="startAtMe" ';
                            	strArray.push('<a href="#"><img src="${rc.contextPath}/oamBaseStationMap/download?attachmentId='+ item.attachmentId + '" alt="Demo image"  width="497"   style="max-height:360px  border:0"' + id + ' onclick="showPicture(\''+item.attachmentId+'\');" /></a>');
			        		});
			        		$(strArray.join("")).appendTo("#imglist");
	                    	$("#makeMeScrollable").smoothDivScroll({ autoScroll: "onstart",
								autoScrollDirection: "backandforth",
								autoScrollStep: 1,
								autoScrollInterval: 15,
								startAtElementId: "startAtMe",
								visibleHotSpots: "always" 
	                    	}); 
			        	} else {
			        	 	$("#makeMeScrollable").remove();
			        	}
			        }
                });
            }
            else {
                $("#makeMeScrollable").remove();
            }
        }
        
        function showPicture(attachmentId){
        	return;
			var html = "<img src='${rc.contextPath}/oamBaseStationMap/showPicture?attachmentId=";
			html += attachmentId;
			html += "' />";
			var dom = $(html);
			dialog({
				title: "查看图片",
				content: dom
			}).show();
		}
    </script>
    <script>
		var rootDirectoryURL='${rc.contextPath}'; 
	</script>
</head>
<body style="background-color: transparent">
    <div id="content">
        <div class="box_top">
            <div class="box_bt_left">
                <div class="box_bt_mid l">
                    <h2 class="l cf b f14">
                        <span id="name1"></span>
                    </h2>
                    <img src="${rc.contextPath}/public/img/close_icon.png" class="db r close_icon" onclick="closebox1()" style='cursor: pointer'
                        onmouseover="this.src='${rc.contextPath}/public/img/close_icon2.png'" onmouseout="this.src='${rc.contextPath}/public/img/close_icon.png'"
                        title="关闭" />
                </div>
                <div class="box_bt_right r">
                </div>
            </div>
     	</div>
        <div class="box_bottom fix">
            <table width="100%" border="1" cellspacing="0" cellpadding="0" class="box_table">
                <tr>
                    <td width="25%" class="b f14 pl">基站名称</td>
                    <td width="30%" class="pl">
                    	<span id="name"></span>
                    </td>
                    <td width="16%" class="b f14 pl">基站编号</td>
                    <td width="29%" class="pl">
                        <span id="baseCode"></span>
                    </td>
                </tr>
                <tr>
                    <td class="b f14 pl">客户名称 </td>
                    <td class="pl">
                        <span id="companyName"></span>
                    </td>
                    <td class="b f14 pl">项目</td>
                    <td class="pl">
                        <span id="projectName"></span>
                    </td>
                </tr>
                <tr>
                    <td class="b f14 pl">地址</td>
                    <td colspan="3" class="pl">
                        <span id="address"></span>
                    </td>
                </tr>
                <tr>
                    <td class="b f14 pl">联系人</td>
                    <td class="pl">
                        <span id="ContactName"></span>
                    </td>
                    <td class="b f14 pl">联系方式</td>
                    <td class="pl">
                        <span id="Tel">
                    </td>
                </tr>
                <tr>
                    <td class="b f14 pl">网络类别及配置</td>
                    <td colspan="3" class="pl">
                        <span id="NetWire"></span>
                    </td>
                </tr>
            </table>
            <div class="box_img">
                <div style="width: 441px; font-size: 12px; margin: auto">
                    <div id="makeMeScrollable">
                        <div class="scrollingHotSpotLeft">
                        </div>
                        <div class="scrollingHotSpotRight">
                        </div>
                        <div class="scrollWrapper">
                            <div class="scrollableArea" id="imglist">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="box_foot">
            <img src="${rc.contextPath}/public/img/bottom_left.png" class="db l" />
            <div class="foot_mid l"></div>
            <img src="${rc.contextPath}/public/img/bottom_right.png" class="db r" />
        </div>
    </div>
</body>
</html>