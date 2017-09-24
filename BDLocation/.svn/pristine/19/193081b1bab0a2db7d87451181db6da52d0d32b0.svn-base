package com.cnten.bdlocation.synserver.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;

/**
 * 基站、CORS服务
 * @author Administrator
 *
 */
@Service
public class CorsAndStationService {
	@Autowired
	private CommonDAO commonDAO;
	
	public List<Map<String, Object>> getStationOfChecked(){
		String sql = " SELECT ab.*,c.oam_area_name as own_province_name ,1 as isOnline " +
					 " from "+
					 " (SELECT "+
					 " c.base_construct_id,c.check_state,c.station_name,c.own_city_name, "+
					 " c.customer_name,d.oam_area_id,c.own_city_id,d.parent_id,c.base_lat,c.base_lng "+
					 " FROM  "+
					 " (SELECT "+
					 " 	a.base_construct_id,a.check_state,a.oam_area_Id as own_city_id,b.oam_area_name as own_city_name, "+
					 " 	a.base_customer_id,a.station_name,dd.customer_name,ds.base_lat,ds.base_lng, "+
					 " 		CASE "+
					 " 	WHEN b.oam_order IS NOT NULL THEN "+
					 " 		b.oam_area_id "+
					 " 	ELSE "+
					 " 			b.parent_id "+
					 " 	END AS oamAreaId "+
					 " 	FROM "+
					 " 			base_construct a "+
					 " 	LEFT JOIN oam_area b ON a.oam_area_Id = b.oam_area_id "+
					 " 	left join base_customer dd on dd.base_customer_id = a.base_customer_id "+
					 " 	left join base_check_matetial ds on ds.base_construct_id = a.base_construct_id "+
					 " ) c "+
					 " LEFT JOIN oam_area d ON c.oamAreaId = d.oam_area_id "+
					 " ) ab, "+
					 " (SELECT  "+
					 " b.oam_area_id, "+
					 " b.oam_area_name, "+
					 " b.oam_order "+
					 " FROM "+
					 " oam_area b "+
					 " WHERE "+
					 " b.parent_id IN ( "+
					 " SELECT "+
					 " oam_area_id "+
					 " FROM "+
					 " 	oam_area a "+
					 " WHERE "+
					 " 	a.parent_id IS NULL "+
					 " AND is_delete IS NULL "+
					 " ) "+
					 " ) c "+
					 " WHERE "+
					 " ( "+
					 " ab.oam_area_id = c.oam_area_id "+
					 " OR ab.parent_id = c.oam_area_id "+
					 " ) "+
					 " AND ab.check_state = 'YYS'";
		return commonDAO.sqlQueryListByVP(sql, null);
	}
}
