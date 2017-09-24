package com.cnten.bdlocation.clients.clientInfo.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.clients.clientInfo.service.ClientBaseInfoService;
import com.cnten.platform.system.service.AttachmentService;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Attachment;
import com.cnten.po.Company;
import com.cnten.po.User;

@Controller
public class ClientBaseInfoController {
	@Autowired
	private ClientBaseInfoService clientBaseInfoService;
	@Autowired
	private AttachmentService attachmentService;
	
	@RequestMapping(value="client/mgtCenter/clientInfo/showInfo")
	public void showClientInfo(Model model){
		Company company = clientBaseInfoService.getCompany();
		User user = clientBaseInfoService.getUser();
		model.addAttribute("company", company);
		model.addAttribute("user", user);
	}
	@ResponseBody
	@RequestMapping(value="client/mgtCenter/clientInfo/saveInfo")
	public SuccessOrFailure saveInfo(Company company,Model model){
		User user = ContextUtil.getCurrentUser();
		String state =	user.getCompany().getCompanyMaterialStateValue();
		if(state.equals(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_NOTE) || state.equals(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_SAVE) || state.equals(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_REFUSE)) {
			clientBaseInfoService.saveCompany(company,user.getCompany());
			return SuccessOrFailure.SUCCESS("保存成功！");
		}else{
			return SuccessOrFailure.FAILURE("该企业已认证或正在审核中，保存失败！");
		}
	}
	//快速保存
	@ResponseBody
	@RequestMapping(value="client/mgtCenter/clientInfo/saveQuickInfo")
	public SuccessOrFailure saveQuickInfo(User user){
			clientBaseInfoService.saveQuickUser(user);
			return SuccessOrFailure.SUCCESS("保存成功！");
	}
	//上传图片
	@ResponseBody
	@RequestMapping(value = "client/mgtCenter/clientInfo/upload", method = RequestMethod.POST)
	public SuccessOrFailure upload(Attachment attachment, HttpServletRequest request, HttpServletResponse response){
		try{
			if(clientBaseInfoService.ifConfirm()== null){
				return SuccessOrFailure.SUCCESS("该企业已认证，上传失败");
			}else{
				attachmentService.save(attachment, request, response);
				return SuccessOrFailure.SUCCESS;
			}
			
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	//上传文件后展示图片
	@ResponseBody
	@RequestMapping(value="client/mgtCenter/clientInfo/showPicture")
	public String showPicture(String entityId){
		if(clientBaseInfoService.getPicture(entityId) == null){
			return null;
		}else{
			return clientBaseInfoService.getPicture(entityId).getAttachmentId();
		}
	}
	
	//上传文件后展示图片
	@ResponseBody
	@RequestMapping(value="client/mgtCenter/clientInfo/deletePicture")
	public void deletePicture(String entityId){
		Attachment attachMent = clientBaseInfoService.getPicture(entityId);
		
		if(attachMent != null){
			attachmentService.deleteAttachment(attachMent.getAttachmentId());
		}
	}
	
	//是否认证
	@ResponseBody
	@RequestMapping(value="/clientInfo/ifConfirm")
	public SuccessOrFailure ifConfirm(){
		return clientBaseInfoService.ifConfirm();
	}
	
	@ResponseBody
	@RequestMapping(value="/clientInfo/submitMaterialApply")
	public SuccessOrFailure submitCompanyMaterialApply(Company company){
		return clientBaseInfoService.saveMaterialApply(company);
	}
	
	//修改密码
	@RequestMapping(value="/client/mgtCenter/clientInfo/showPwd")
	public void showPwd(){
		
	}
	
	//验证密码
	@ResponseBody
	@RequestMapping(value="/client/mgtCenter/clientInfo/verifyPwd")
	public SuccessOrFailure verifyPwd(String pwd){
		return clientBaseInfoService.ifPwd(pwd);
	}
	
	//更新密码
	@ResponseBody
	@RequestMapping(value="/client/mgtCenter/clientInfo/updatePwd")
	public SuccessOrFailure updatePwd(String pwd){
		return clientBaseInfoService.updatePwd(null,pwd);
	}
	
}
	

