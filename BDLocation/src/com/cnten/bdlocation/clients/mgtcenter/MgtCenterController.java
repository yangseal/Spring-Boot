package com.cnten.bdlocation.clients.mgtcenter;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.platform.system.service.MenuService;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.util.ContextUtil;
import com.cnten.po.Company;
import com.cnten.po.Menu;
import com.cnten.po.Role;
import com.cnten.po.User;

/**
 * 总览 控制器
 * @author Administrator
 */
@Controller
@RequestMapping(value="/client")
public class MgtCenterController {
	
	@Autowired
	private MgtCenterService mgtCenterService;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/mgtCenter/clientOverView/overView")
	public void overView(Model model){
		User user = ContextUtil.getCurrentUser();
		Map<String,Object> _map = mgtCenterService.getCorsAccountCount(user.getCompany().getCompanyId());
		_map.put("userCode", user.getUserCode());
		_map.put("phone", user.getPhone());
		_map.put("email", user.getEmail());
		
		Company company = mgtCenterService.getCompany();
		
		String _materialState = company.getCompanyMaterialState();
		if(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_PASS.equals(_materialState)){
			_map.put("companyMaterialStateName", CorsAccountConsts.ACCOUNT_STATE_NAME_APPROVED );
		} else if(CorsAccountConsts.ACCOUNT_STATE_EXAMINE_REFUSE.equals(_materialState)) {
			_map.put("companyMaterialStateName", CorsAccountConsts.ACCOUNT_STATE_NAME_UNAPPROVED);
		} else {
			_map.put("companyMaterialStateName", CorsAccountConsts.ACCOUNT_STATE_NAME_APPROVING);
		}
		model.addAllAttributes(_map);
	}
	
	/**
	 * 获取所有统计类型的 统计数据 进行组装返回
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="/overView/statistic")
	public  Map<String, Object> getCorsStatisticOfAll() {
		User user = ContextUtil.getCurrentUser();
		return mgtCenterService.getCorsStatisticOfAll(user.getCompany());
	}
	
}
