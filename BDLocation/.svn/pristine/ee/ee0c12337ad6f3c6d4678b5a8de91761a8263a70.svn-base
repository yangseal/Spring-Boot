package com.cnten.bdlocation.pointtypeauthorize.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.pointtypeauthorize.service.PointTypeAuthorizeService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.PointTypeAuthorize;

@Controller
public class PointTypeAuthorizeController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private PointTypeAuthorizeService pointTypeAuthorizeService;
	
	@RequestMapping(value = "/pointTypeAuthorize/showPointTypeAuthorize")
	public void showPointTypeAuthorize() {
	}
	
	@ResponseBody
	@RequestMapping(value = "/pointTypeAuthorize/queryPointTypeAuthorizes")
	public List<PointTypeAuthorize> queryPointTypeAuthorizes(PointTypeAuthorize pointTypeAuthorize) {
		return pointTypeAuthorizeService.getPointTypeAuthorizes(pointTypeAuthorize);
	}
		
	@ResponseBody
	@RequestMapping(value = "/pointTypeAuthorize/savePointTypeAuthorize")
	public SuccessOrFailure savePointTypeAuthorize(String affiliationCompanyId,@RequestParam(value = "addNodeList[]",required=false) String[] addNodeList,@RequestParam(value = "delNodeList[]",required=false) String[] delNodeList){
		try {
			if(null != addNodeList) {
				pointTypeAuthorizeService.savePointTypeAuthorize(affiliationCompanyId,addNodeList);
			}
			if(null != delNodeList) {
				pointTypeAuthorizeService.deletePointTypeAuthorize(affiliationCompanyId, delNodeList);
			}
			return SuccessOrFailure.SUCCESS(affiliationCompanyId);
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}
}
