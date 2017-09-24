<!doctype html>
<html>
<head>
<#include "/head.ftl"/>
<script type="text/javascript" src="${rc.contextPath}/public/js/companyOrg/orgMgt/companyOrg.js"></script>
</head>
<body>
<div class="cont_box">
<a  class="btn btn-success" onclick="addOrg();">
	<i class="glyphicon glyphicon-plus"></i>
    <span>新增子机构</span>
</a>
<table id="orgsTable" class="table">
	<thead>
    	<tr >
        	<td>机构名称</td>
        	<td>所属公司</td>
        	<td>管理员账号</td>
        	<td>管理员密码</td>
        	<td>机构层级</td>
            <td>操作</td>
        </tr>
    </thead >
    <tbody>
    	<#list companyOrgs as org>
        <tr id="${org.companyOrgId}" <#if org.parentOrgId??>pid="${org.parentOrgId}"</#if> orgLevel="${org.orgLevel!}">
        	<td style="text-align:left"><span>${org.orgName!}</span></td>
        	<td><span>${org.company.companyName!}</span></td>
        	<td><span>${org.adminCode!"--"}</span></td>
        	<td><span>${org.adminPwd!"--"}</span></td>
        	<td><span>${org.orgLevel!"--"}</span></td>
            <td>
            	<div>
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
