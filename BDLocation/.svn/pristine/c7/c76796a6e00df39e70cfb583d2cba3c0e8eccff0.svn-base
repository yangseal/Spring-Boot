<form id="userInfoForm">
<div  class="det_wrap">
  <div class="integral_tit">
   <span>基本资料</span>
  </div>
  <div class="my_info_con">
    <span>昵称：</span>
    <p>
      <input type="text" name="postUserNickname" value="<#if postUser??>${postUser.postUserNickname!}</#if>"/>
    </p>
  </div>
  <div class="my_info_con">
    <span>性别：</span>
    <p>
      <label><input name="postUserSex" <#if postUser?? && postUser.postUserSex?? && postUser.postUserSex == 'MALE'>checked="checked"</#if> type="radio" value="MALE"> 男</label>
      <label><input name="postUserSex" <#if postUser?? && postUser.postUserSex?? && postUser.postUserSex == 'FEMALE'>checked="checked"</#if> type="radio" value="FEMALE"> 女</label>
    </p>
  </div>
  <div class="my_info_con">
    <span>生日：</span>
    <p>
      <select id="postUserBirthYear">
        <option value="<#if postUser?? && postUser.postUserBirth?? && postUser.postUserBirth?length gt 4>${postUser.postUserBirth?substring(0,4)}</#if>"><#if postUser?? && postUser.postUserBirth?? && postUser.postUserBirth?length gt 4>${postUser.postUserBirth?substring(0,4)}</#if></option>
        <option value="2017">2017</option>
        <option value="2016">2016</option>
        <option value="2015">2015</option>
        <option value="2014">2014</option>
        <option value="2013">2013</option>
        <option value="2012">2012</option>
        <option value="2011">2011</option>
        <option value="2010">2010</option>
        <option value="2009">2009</option>
        <option value="2008">2008</option>
        <option value="2007">2007</option>
        <option value="2006">2006</option>
        <option value="2005">2005</option>
        <option value="2004">2004</option>
        <option value="2003">2003</option>
        <option value="2002">2002</option>
        <option value="2001">2001</option>
        <option value="2000">2000</option>
        <option value="1999">1999</option>
        <option value="1998">1998</option>
        <option value="1997">1997</option>
        <option value="1996">1996</option>
        <option value="1995">1995</option>
        <option value="1994">1994</option>
        <option value="1993">1993</option>
        <option value="1992">1992</option>
        <option value="1991">1991</option>
        <option value="1990">1990</option>
        <option value="1989">1989</option>
        <option value="1988">1988</option>
        <option value="1987">1987</option>
        <option value="1986">1986</option>
        <option value="1985">1985</option>
        <option value="1984">1984</option>
        <option value="1983">1983</option>
        <option value="1982">1982</option>
        <option value="1981">1981</option>
        <option value="1980">1980</option>
        <option value="1979">1979</option>
        <option value="1978">1978</option>
        <option value="1977">1977</option>
        <option value="1976">1976</option>
        <option value="1975">1975</option>
        <option value="1974">1974</option>
        <option value="1973">1973</option>
        <option value="1972">1972</option>
        <option value="1971">1971</option>
        <option value="1970">1970</option>
        <option value="1969">1969</option>
        <option value="1968">1968</option>
        <option value="1967">1967</option>
        <option value="1966">1966</option>
        <option value="1965">1965</option>
        <option value="1964">1964</option>
        <option value="1963">1963</option>
        <option value="1962">1962</option>
        <option value="1961">1961</option>
        <option value="1960">1960</option>
      </select>
      年
      <select id="postUserBirthMonth">
        <option value="<#if postUser?? && postUser.postUserBirth?? && postUser.postUserBirth?length gt 7>${postUser.postUserBirth?substring(5,7)}</#if>"><#if postUser?? && postUser.postUserBirth?? && postUser.postUserBirth?length gt 7>${postUser.postUserBirth?substring(5,7)}</#if></option>
        <option value="1">01</br></option>
        <option value="2">02</option>
        <option value="3">03</option>
        <option value="4">04</option>
        <option value="5">05</option>
        <option value="6">06</option>
        <option value="7">07</option>
        <option value="8">08</option>
        <option value="9">09</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
      </select>
      月
    </p>
  </div>
  <div class="my_info_con" id="sjld" style="position:relative;">
    <span>所在城市：</span>
    <div class="m_zlxg" id="shenfen">
        <p title="">选择省份</p>
        <div class="m_zlxg2">
          <ul></ul>
        </div>
    </div>
    <div class="m_zlxg" id="chengshi">
      <p title="">选择城市</p>
      <div class="m_zlxg2">
        <ul></ul>
      </div>
    </div>
    <div class="m_zlxg" id="quyu">
      <p title="">选择区域</p>
      <div class="m_zlxg2">
        <ul></ul>
      </div>
    </div>
    <input id="domicile" type="hidden" value="${postUser.postUserDomicile!}" />
    <input id="sfdq_num" type="hidden" value="" />
    <input id="csdq_num" type="hidden" value="" />
    <input id="sfdq_tj" type="hidden" value="" />
    <input id="csdq_tj" type="hidden" value="" />
    <input id="qydq_tj" type="hidden" value="" />
  </div>
  <div class="my_info_con">
    <span>个人简介：</span>
    <p style="line-height: normal;">
      <textarea rows="10" name="postUserIntroduction"><#if postUser?? && postUser.postUserIntroduction??>${postUser.postUserIntroduction!}</#if></textarea>
    </p>
  </div>
  <div class="my_info_con">
    <span>更换头像：</span>
    <p class="up_img"><img id="imgFile" src="${rc.contextPath}/public/img/forum/1.jpg"></p>
    <p class="up_bt">
    	<a id="selDoc">选择文件</a>
    </p>
    <input id="uploadFile" type="file" name="files[]" multiple style="display:none;"/>
  </div>
  <div onclick="infoConfirm(this)" class="my_ok">确认</div>
</div>
</form>
