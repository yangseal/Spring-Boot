<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/system/menus.js"></script>
</head>
<body>
<div class="cont_box">
<a  class="btn btn-success" onclick="addMenu();">
	<i class="glyphicon glyphicon-plus"></i>
    <span>新增一级菜单</span>
</a>
<table id="menusTable" class="table">
	<thead>
    	<tr >
        	<td>菜单名称</td>
        	<td>菜单编码</td>
        	<td>菜单地址</td>
        	<td>菜单排序</td>
            <td>操作</td>
        </tr>
    </thead >
    <tbody>
    	<#list menus as menu>
        <tr id="${menu.menuId}" <#if menu.parentId??>pid="${menu.parentId}"</#if>>
        	<td style="text-align:left"><span>${menu.menuName!}</span></td>
        	<td><span>${menu.menuCode!}</span></td>
        	<#if menu.action?? && menu.action?length gt 50>
			<td>${menu.action?substring(0,50)}...</td>
			<#else>
			<td><span>${menu.action!}</span></td>
			</#if>
        	<td><span>${menu.menuOrder!}</span></td>
            <td>
            	<div>
            		<a onclick='addMenu(this)' href='javascript:;' class="btn btn-success"><i class="glyphicon glyphicon-plus"></i></a>
            		<a onclick='editMenu(this)' href='javascript:;' class="btn btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
            		<a onclick='deleteMenu(this)' href='javascript:;' class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a>
            	</div>
            </td>
        </tr>               
        </#list> 
    </tbody>
</table>
</div>
</body>
</html>
