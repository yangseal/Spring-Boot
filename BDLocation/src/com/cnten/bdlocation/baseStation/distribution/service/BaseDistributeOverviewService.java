package com.cnten.bdlocation.baseStation.distribution.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;


@Service
public class BaseDistributeOverviewService {
	@Autowired
	private CommonDAO commonDAO;
	
	public Map<String,Object> getDistributes(){
		Map<String,Object> result = new HashMap<String,Object>();
		String hql = "select new com.cnten.vo.OamAreaVO(a.oamAreaId,a.oamAreaName,a.longitude,a.latitude,"
				+ "(select count(baseConstructId) from BaseConstruct where isDelete is null and oamArea.oamAreaId=a.oamAreaId )"
				+ ") from OamArea a where a.isDelete is null and not exists( select 1 from OamArea  where parentId= a.oamAreaId) and exists(select 1 from BaseConstruct s where s.isDelete is null and s.oamArea.oamAreaId=a.oamAreaId)";
		result.put("baseDistributes", commonDAO.queryListByVariableParam(hql));
		hql = " from BaseConstruct where isDelete is null ";
		result.put("stationSumNumber", commonDAO.getCount(hql, null));
		return result;
	}
	
	public List<Map<String, Object>> getBaseStationProvince(){
		
		String sql = " select c.oam_area_name as oamAreaName, "+
				" ( select count(ab.base_construct_id)  "+
				" from "+
				" ( "+
				" select c.base_construct_id,c.check_state,d.oam_area_id,d.parent_id from ( "+
				" 	select a.base_construct_id,a.check_state, "+
				" 		case when b.oam_order is not null then b.oam_area_id "+
				" 				else b.parent_id end as oamAreaId "+
				" 		from base_construct a  "+
				" 		left join oam_area b on a.oam_area_Id = b.oam_area_id "+
				" 	) c left join oam_area d on c.oamAreaId = d.oam_area_id "+
				" ) ab   "+
				"  where (ab.oam_area_id = c.oam_area_id or ab.parent_id = c.oam_area_id)  "+
				"    and ab.check_state != 'YYS'   "+
				"  ) as unchecked,   "+
				" ( select count(ab.base_construct_id)  "+
				" from "+
				" ( "+
				" 	select c.base_construct_id,c.check_state,d.oam_area_id,d.parent_id from ( "+
				" 	select a.base_construct_id,a.check_state, "+
				" 			case when b.oam_order is not null then b.oam_area_id "+
				" 				 else b.parent_id end as oamAreaId "+
				" 		from base_construct a  "+
				" 		left join oam_area b on a.oam_area_Id = b.oam_area_id "+
				" 	) c left join oam_area d on c.oamAreaId = d.oam_area_id "+
				" )  ab   "+
				"  where(ab.oam_area_id = c.oam_area_id or ab.parent_id = c.oam_area_id)  "+
				"  and ab.check_state = 'YYS'   "+
				" ) as checked   "+
				" from "+
				" (   select b.oam_area_id,b.oam_area_name,b.oam_order  "+
				" 	from oam_area b  "+
				" 	where b.parent_id in ( "+
				" 		select oam_area_id  "+
				" 	from oam_area a  "+
				" 	where a.parent_id is null and is_delete is null) "+
				" ) c  "+
				" order by checked desc ,unchecked desc";
		
		return commonDAO.sqlQueryList(sql, null);
	}
	
	public List<Map<String, Object>> getBaseStationCitys(){
		String sql = " select "+
				" c.oam_area_name as oamAreaName,"+
				" IFNULL((select checked from"+
				" 		(select a.oam_area_Id,count(*) as checked from base_construct a where a.check_state = 'YYS' group by a.oam_area_Id) b"+
				" 	 where  b.oam_area_Id = c.oam_area_id),0) as checked,"+
				" IFNULL((select unchecked from"+
				" 	(select a.oam_area_Id,count(*) as unchecked from base_construct a where a.check_state != 'YYS' group by a.oam_area_Id) b"+
				" where  b.oam_area_Id = c.oam_area_id),0) as unchecked"+
				" from "+
				" ("+
				" select distinct b.oam_area_id,b.oam_area_name from base_construct a"+
				" left join oam_area b on a.oam_area_Id = b.oam_area_id"+
				" ) c"+
				" order by checked desc, unchecked desc";
		
		return commonDAO.sqlQueryList(sql, null);
	}
}
