  <div class="ads_con">
    <div class="ads_box base_box">
      <div class="as_tit">账号信息</div>
      <div class="base_img">
        <p>
          <i><img src="${rc.contextPath}/public/propaganda/css_img/user.png"></i>
          <#--<b id="ifConfirm">未认证</b>-->
           <b id="ifConfirm"><#if company??>${company.companyMaterialStateName!}</#if></b>
           	<#if company?? && company.companyMaterialState?? && company.companyMaterialState !='2' >
           	 	<span id="ifBuy">您的企业尚未认证，请认证后购买服务 </span>
           	</#if>
        </p>
      </div>
      <div class="base_txt" id="contactInfo">
        <p><label>登陆账号</label>
        	<input type="text" name="userCode" value="<#if user.userCode??>${user.userCode}</#if>" disabled="disabled">
        </p>
        <p id="emailInfo"><label id="sEmailLabel">注册邮箱</label>
        	<input type="text" name="email" id="sEmail" placeholder="请输入正确的注册邮箱" value="<#if user.email!??>${user.email!}</#if>"  isNotNull validateExp="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$" disabled="disabled">
        	<i id="sEmailTip"></i>
        	<a onclick="quickSave(this)" class="save">保存</a>
        	<a class="revise">修改</a>
        </p>
        <p id="telInfo"><label id="sphoneLabel">注册电话</label>
        	<input type="text" name="phone" placeholder="请输入正确的手机号码"  id="sphone" value="<#if user.phone??>${user.phone!}</#if>" maxlength="12" validateExp="(^(1\d{10})$|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)" isNotNull disabled>
        	<i id="sphoneTip"></i>
        	<a onclick="quickSave(this)" class="save">保存</a>
        	<a class="revise">修改</a>
        </p>
        <p id="openPwd"><label>密码</label>
	        <input type="password" name="password" value="<#if user.password??>123456789</#if>" disabled>
	        <a onclick="updatePass()">修改</a>
        </p>
      </div>
    </div>
     <input type="hidden" id="companyMaterialState" value="${company.companyMaterialState}"/>
    <div class="ads_box base_box" id="disabled_box">
      <div class="as_tit">企业信息</div>
      <form id="company_info">
      <div class="enterprise_info">
          <p><label>企业名称</label><input type="text" placeholder="请输入企业名称" isNotNull name="companyName" id="companyName" maxlength="30"  value="<#if company.companyName??>${company.companyName}</#if>"><span id="companyNameTip" style="color:red;padding-left:10px">*</span>
          </p>
          <p><label>企业电话</label><input type="text" placeholder="请输入电话  (例：029-8888888)" isNotNull maxlength="15" tel-validate="请输入电话(例:029-8888888)" name="phone" id="phone" value="<#if company.phone??>${company.phone}</#if>" ><span id="phoneTip"  style="color:red;padding-left:10px">*</span></p>
          <p><label>企业邮箱</label><input type="text" placeholder="例：abcxyz@mail.com" maxlength="40" isNotNull email-validate="请输入正确的企业邮箱" name="email" id="email" value="<#if company.email??>${company.email}</#if>" ><span id="emailTip"  style="color:red;padding-left:10px">*</span></p>
          <p class="qy_add"><label>企业地址</label><input placeholder="请输入企业地址" type="text" maxlength="50" isNotNull  name="address" id="address" value="<#if company.address??>${company.address}</#if>" ><span id="addressTip"  style="color:red;padding-left:10px">*</span></p>
          <p><label>联系人姓名</label><input type="text" placeholder="请输入联系人姓名" name="contacts" isNotNull id="contacts" maxlength="30" value="<#if company.contacts??>${company.contacts}</#if>" ><span id="contactsTip"  style="color:red;padding-left:10px">*</span></p>
          <p><label>联系人电话</label><input type="text"  placeholder="请输入正确的手机号码" maxlength="12" isNotNull phone-validate="请输入正确的手机号码" name="tel" id="tel" value="<#if company.tel??>${company.tel}</#if>" ><span id="telTip"  style="color:red;padding-left:10px">*</span></p>
      </div>
      <div class="as_tit tit_bot">企业认证资料</div>
      <div class="enterprise_data">
      	  <p><label>企业编码</label><input type="text" disabled value="<#if company.companyCode??>${company.companyCode}</#if>" /></p>
          <input type="hidden" id="companyCodeHide" name="companyCode" value="<#if company.companyCode??>${company.companyCode}</#if>" />
          <p><label>法定代表人</label><input type="text" name="corporate" id="corporate" isNotNull placeholder="请输入法定代表人" maxlength="30" value="<#if company.corporate??>${company.corporate}</#if>" ><span id="corporateTip" style="color:red;padding-left:10px">*</span></p>
          <p><label>营业执照编号</label><input type="text" name="businessLicense" id="businessLicense" isNotNull placeholder="请输入营业执照编号" maxlength="30" value="<#if company.businessLicense??>${company.businessLicense}</#if>" ><span id="businessLicenseTip"  style="color:red;padding-left:10px">*</span></p>
          <p class="enterprise_img"><img id="imgFile" src="${rc.contextPath}/public/img/lisence.jpg"></p>
          <p><label>营业执照附件</label>
	         <#-- <form id="menu_pic"  enctype="multipart/form-data" >
	          		<input type="file" style="display:none"  name="uploadFile" id="uploadFile" /> 
	          		<button id="selDoc" type="button">选择文件</button> 
	          </form>-->
	          <button id="selDoc" type="button">选择文件</button> 
	          <input id="uploadFile" type="file" name="files[]" multiple style="display:none;" />
          </p> 
      </div>
      <div class="enterprise_bt">
         <a onclick="saveInfo()">保存</a>
         <a onclick="submitInfo()">提交</a>
      </div>
      <input type="hidden" id="companyId" name="companyId" value="<#if company.companyId?? >${company.companyId} </#if>" />
      </form>
    </div>
  </div>
  <script type="text/javascript"  src="${rc.contextPath}/public/js/client/clientInfo/clientInfo.js" />