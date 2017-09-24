package com.cnten.bdlocation.pointtypeauthorize.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.Company;
import com.cnten.po.PointType;
import com.cnten.po.PointTypeAuthorize;

@Service
public class PointTypeAuthorizeService {

	@Autowired
	CommonDAO commonDAO;
	
	public List<PointTypeAuthorize> getPointTypeAuthorizes(PointTypeAuthorize pointTypeAuthorize) {
		String hql = "from PointTypeAuthorize where isDelete is null";
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(StringUtils.isEmpty(pointTypeAuthorize.getAffiliationCompanyId())) {
			return new ArrayList<PointTypeAuthorize>();
		} else {
			hql += " and affiliationCompany.companyId = :companyId";
			params.put("companyId", pointTypeAuthorize.getAffiliationCompanyId());
		}
		if(!StringUtils.isEmpty(pointTypeAuthorize.getAffiliationPointTypeId())) {
			hql += " and affiliationPointType.pointTypeId = :pointTypeId";
			params.put("pointTypeId", pointTypeAuthorize.getAffiliationPointTypeId());
		}
		List<PointTypeAuthorize> list = commonDAO.queryList(hql, params);
		return list;
	}

	public PointTypeAuthorize getPointTypeAuthorize(String pointTypeAuthorizeId) {
		return commonDAO.get(PointTypeAuthorize.class, pointTypeAuthorizeId);
	}

	public void savePointTypeAuthorize(String affiliationCompanyId,String[] pointTypeIds) {
		if(null == pointTypeIds) {
			return;
		}
		Company company = null;
		PointTypeAuthorize pointTypeAuthorize = null;
		if(!StringUtils.isEmpty(affiliationCompanyId)){
			company = new Company(affiliationCompanyId);
		}
		for(int i=0; i<pointTypeIds.length; i++) {
			if(StringUtils.isEmpty(pointTypeIds[i])) {
				continue;
			}
			pointTypeAuthorize = new PointTypeAuthorize();
			pointTypeAuthorize.setAffiliationCompany(company);
			pointTypeAuthorize.setAffiliationPointType(new PointType(pointTypeIds[i]));
			pointTypeAuthorize.setAuthorizeDate(new Date());
			commonDAO.save(pointTypeAuthorize);
		}	
	}

	public void deletePointTypeAuthorize(String affiliationCompanyId, String[] affiliationPointTypeIds){
		if(null == affiliationCompanyId || affiliationCompanyId == "" ||null == affiliationPointTypeIds) {
			return;
		}
		for(String affiliationPointTypeId : affiliationPointTypeIds){
			if(StringUtils.isEmpty(affiliationPointTypeId)) {
				continue;
			}
			PointTypeAuthorize pointTypeAuthorize = new PointTypeAuthorize();
			pointTypeAuthorize.setAffiliationCompanyId(affiliationCompanyId);
			pointTypeAuthorize.setAffiliationPointTypeId(affiliationPointTypeId);
			PointTypeAuthorize oldPointTypeAuthorize =	getPointTypeAuthorizes(pointTypeAuthorize).get(0);
			oldPointTypeAuthorize.setIsDelete("Y");
			commonDAO.update(oldPointTypeAuthorize);
		}
	}
}