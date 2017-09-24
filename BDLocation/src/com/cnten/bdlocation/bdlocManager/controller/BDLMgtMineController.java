package com.cnten.bdlocation.bdlocManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.accountView.service.AccountViewService;
import com.cnten.bdlocation.busiapprove.service.BusinApproveService;
import com.cnten.bdlocation.clients.clientInfo.service.ClientBaseInfoService;
import com.cnten.bdlocation.clients.formalService.service.FormalService;
import com.cnten.bdlocation.clients.testService.service.TestService;
import com.cnten.bdlocation.companytemp.service.CompanyTempService;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.bdlocation.corsaccount.service.CorsAccountService;
import com.cnten.bdlocation.corsapply.service.CorsApplyService;
import com.cnten.bdlocation.corsgroup.service.CorsGroupService;
import com.cnten.bdlocation.oamarea.service.OamAreaService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.system.service.AttachmentService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Attachment;
import com.cnten.po.Company;
import com.cnten.po.CorsAccount;
import com.cnten.po.CorsAccountRepay;
import com.cnten.po.CorsApply;
import com.cnten.po.CorsApplyTemp;
import com.cnten.po.CorsCompanyGroup;
import com.cnten.po.User;
import com.cnten.vo.BusiApproveVO;

@Controller
public class BDLMgtMineController {
	@Autowired
	private AccountViewService accountViewService;
	@Autowired
	private CorsAccountService corsAccountService;
	@Autowired
	private BusinApproveService businApproveService;
	@Autowired
	private CorsGroupService corsGroupService;
	@Autowired
	private ClientBaseInfoService clientBaseInfoService;
	@Autowired
	private CorsApplyService corsApplyService;
	@Autowired
	private CompanyTempService companyTempService;
	@Autowired
	private TestService testService;
	
	@Autowired
	private FormalService formalService;
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private OamAreaService oamAreaService;
	
	/**
	 * 服务账号 列表查询
	 * @param corsAccount
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/bdloc/bdUser")
	public SuccessOrFailure getSysUser(String userId){
		try {
			User user = clientBaseInfoService.getUser(userId);
			return SuccessOrFailure.SUCCESS(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SuccessOrFailure.FAILURE("请求数据失败!");
	}
	
	/**
	 * 服务账号 列表查询
	 * @param corsAccount
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/bdloc/corsAccounts")
	public Page getCorsAccount(CorsAccount corsAccount,Integer pageIndex, Integer pageSize){
		Page tempPage = accountViewService.getAccountViewsPage(corsAccount, pageIndex, pageSize);
		return tempPage;
	}
	
	//绑定应用区域和设备
	@ResponseBody
	@RequestMapping("/bdloc/saveCorsAccount")
	public SuccessOrFailure showRegion(CorsAccount corsAccount){
		return SuccessOrFailure.SUCCESS(accountViewService.saveCorsAccount(corsAccount));
	}
	//激活
	@ResponseBody
	@RequestMapping("/bdloc/insertActiveApply")
	public SuccessOrFailure insertActiveApply(String corsAccountId){
		try {
			return accountViewService.saveActiveApply(corsAccountId);
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	//区域划分
	@ResponseBody
	@RequestMapping(value = "/bdloc/getArea")
	public Map<String, Object> getArea(){
		return oamAreaService.getPCity();
	}
	
	/**
	 * 订单管理	列表查询
	 * @param busiApproveVO
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/bdloc/corsOrders")
	public Page getCorsOrders(BusiApproveVO busiApproveVO, Integer pageIndex,
			Integer pageSize){
		Page page = businApproveService.getApprovesPage(busiApproveVO,
				pageIndex, pageSize);
		return page;
	}
	
	/**
	 * 购买订单详情
	 * @param corsApplyId
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/bdloc/buyDetailOrder")
	public CorsApply showBuyDetailOrder(String corsApplyId){
		CorsApply corsApply = corsApplyService.getCorsApply(corsApplyId);
		return corsApply;
	}
	
	/**
	 * 续费订单详情
	 * @param corsApplyId
	 * @param model
	 */
	@ResponseBody
	@RequestMapping(value = "/bdloc/repayDetailOrder")
	public CorsAccountRepay showRepayDetailOrder(String corsApplyId){
		CorsAccountRepay corsAccountRepay = corsApplyService.getCorsRepayApply(corsApplyId);
		return corsAccountRepay;
	}
	
	
	/**
	 * 企业认证（保存）
	 * 
	 */
	@ResponseBody
	@RequestMapping("/bdloc/saveInfo")
	public SuccessOrFailure saveInfo(Company company){
		Company oldCompany = clientBaseInfoService.getCompany(company.getCompanyId());
		String state =	oldCompany.getCompanyMaterialStateValue();
		if(state.equals(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_NOTE) || state.equals(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_SAVE) || state.equals(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_REFUSE)) {
			clientBaseInfoService.saveCompany(company,oldCompany);
			return SuccessOrFailure.SUCCESS("保存成功！");
		}else{
			return SuccessOrFailure.FAILURE("该企业已认证或正在审核中，保存失败！");
		}
	}
	
	/**
	 * 企业认证（提交）
	 * 
	 */
	@ResponseBody
	@RequestMapping("/bdloc/submitMaterialApply")
	public SuccessOrFailure submitCompanyMaterialApply(Company company){
		return clientBaseInfoService.saveMaterialApply(company);
	}
	
	/**
	 * 分组管理    列表查询
	 * @param corsGroup
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/bdloc/corsGroups")
	public Page getCorsGroups(CorsCompanyGroup corsGroup,Integer pageIndex, Integer pageSize){
		Page page = corsGroupService.getCorsGroupsPage(corsGroup, pageIndex, pageSize);
		return page;
	}
	
	/**
	 * 分组管理   配额详情
	 * @param corsGroupId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/bdloc/queryCorsAccount")
	public Page getCorsAccountByGroupId(String corsGroupId) {
		return corsAccountService.getCorsAccountByGroupId(corsGroupId);
	}
	
	/**
	 * 添加、编辑分组
	 * @param corsGroup
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/bdloc/saveGroup")
	public SuccessOrFailure saveClientGroup(CorsCompanyGroup corsGroup) {
		try {
			CorsCompanyGroup corsCompanyGroup = corsGroupService.saveGroupForApp(corsGroup);
			if(corsCompanyGroup == null){
				return SuccessOrFailure.SUCCESS;
			}else{
				return SuccessOrFailure.SUCCESS;
			}
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	/**
	 * 查询	未分组的 cors账号
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/bdloc/noDevidedCorsNo")
	public Page queryNotDevideCorsNo(Company company){
		return corsAccountService.getCorsAccountsNotGroup(company);
	}
	
	/**
	 * 移除 分组中  某一cors数据
	 * @param corsAccountId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/bdloc/removeCorsAccount")
	public SuccessOrFailure removeCorsAccount(String corsAccountId){
		try {
			corsAccountService.updateAccountGroup(corsAccountId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			SuccessOrFailure.FAILURE(e.getMessage());
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/bdloc/confirmDivide")
	public SuccessOrFailure confirmDivide(String corsAccountIds,String companyGroupId){
		try{
			corsAccountService.saveDivide(corsAccountIds, companyGroupId);
			return SuccessOrFailure.SUCCESS;
		}catch(Exception e){
			SuccessOrFailure.FAILURE(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 公司编码唯一校验
	 * @param companyCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/bdloc/verifyCompanyCode")
	public SuccessOrFailure verifyCompanyCode(String companyCode){
		return companyTempService.validateCompanyCode(companyCode);
	}
	
	/**
	 * 用户 登录账号 唯一校验
	 * @param userCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/bdloc/verifyUserCode")
	public SuccessOrFailure verifyUserCode(String userCode){
		return companyTempService.getUserCode(userCode);
	}
	
	/**
	 * 提交 	使用订单
	 * @param serviceType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/bdloc/submitTestApply")
	public SuccessOrFailure submitTestApply(String serviceType, String userId){
		try {
			return testService.saveApplyByService(serviceType, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
		
	}
	
	/**
	 * 添加 购买服务 至  购物车
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/bdloc/addServiceToCard")
	public SuccessOrFailure addServiceToCard(CorsApplyTemp corsApplyTemp){
		try {
			formalService.saveCorsApply(corsApplyTemp);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**
	 *  移除   购物车 中 购买服务
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/bdloc/delServiceOfCard")
	public SuccessOrFailure delServiceFromCard(String corsApplyId){
		try {
			formalService.deleteCorsApply(corsApplyId);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**
	 * 查询  购物车中   购买服务 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/bdloc/queryServiceOfCard")
	public Map<String, Object> queryServiceOfCard(String companyId){
		List<CorsApply> corsApply = formalService.getCorsApplys(companyId);
		if(corsApply != null){
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("corsApplyTempList", corsApply);
			return map;
		}
		return null;
	}
	
	/**
	 * 提交  购物车中   购买服务 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/bdloc/subServiceOfCard")
	public SuccessOrFailure subServiceOfCard(String corsApplyTempParams){
		try {
			formalService.saveConfirmList(corsApplyTempParams);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**
	 * 更新 添加到购物车中的   临时账号的数量
	 * @param corsApplyTemp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/bdloc/updServiceCountOfCard")
	public SuccessOrFailure updateCorsApplyTempOfCount(CorsApplyTemp corsApplyTemp){
		try {
			formalService.updateCorsApplyTemp(corsApplyTemp);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**
	 * 附件	上传服务删除之前上传的
	 * @param attachment
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/bdloc/delAfterUpload", method = RequestMethod.POST)
	public SuccessOrFailure singleUpload(Attachment attachment, HttpServletRequest request, HttpServletResponse response){
		try{
			attachmentService.deleteAttachmentWithEntityId(attachment.getEntityId());;
			attachmentService.save(attachment, request, response);
			return SuccessOrFailure.SUCCESS;
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	/**
	 * 附件	上传服务
	 * @param attachment
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/bdloc/upload", method = RequestMethod.POST)
	public SuccessOrFailure upload(Attachment attachment, HttpServletRequest request, HttpServletResponse response){
		try{
			attachmentService.save(attachment, request, response);
			return SuccessOrFailure.SUCCESS;
		}catch(Exception e){
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/bdloc/showPicture")
	public void showPicture(String entityId, boolean isThumbnail, HttpServletResponse response){
		try{
			attachmentService.showPicture(entityId, isThumbnail,false, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
