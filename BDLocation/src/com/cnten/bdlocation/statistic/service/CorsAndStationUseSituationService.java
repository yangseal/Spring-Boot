package com.cnten.bdlocation.statistic.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cnten.platform.dao.CommonDAO;

@Service
public class CorsAndStationUseSituationService {

	@Autowired
	private CommonDAO commonDAO;
	
	public List<Map<String, Object>> getCorsDayUseSituation(String daystr){
		try {
			String sql = " select h.* from ( " +
					 " select " +
					 " d.active_account,d.total_account,round((d.broad_data/1024),2) as broad_data,d.access_time,d.company_id,round((d.active_account/d.total_account)*100) active_fate,lc.company_name " +
					 " from( " +
					 " 	select COUNT(DISTINCT c.account_code)active_account,c.company_id,c.access_time,(sum(c.send_data)+sum(c.receive_data)) as broad_data, " +
					 " 	(select count(cors_account_code) from cors_account where company_id = c.company_id) as total_account " +
					 " 	from ( " +
					 " 			select b.*,c.company_id from " +
					 " 				(select a.account_code,DATE_FORMAT(a.access_time,'%Y-%m-%d') as access_time,sum(a.send_data) as send_data,sum(a.receive_data) as  receive_data " +
					 " 					from cors_realtime_logs a group by DATE_FORMAT(a.access_time,'%Y-%m-%d') ,a.account_code) b " +
					 " 				left join cors_account c on b.account_code = c.cors_account_code " +
					 " 		) c group by c.company_id,c.access_time " +
					 " ) d " +
					 " left join company lc on d.company_id = lc.company_id " +
					 " ) h where h.access_time like ? ";
			return commonDAO.sqlQueryListByVP(sql, daystr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Map<String, Object>> getCorsMonthUseSituation(String daystr){
		try {
			daystr = daystr.substring(0, 7);
			String sql = " select h.* from ( " +
					" select " +
					"  d.active_account,d.total_account,round((d.broad_data/1024),2) as broad_data,d.access_time,d.company_id,round((d.active_account/d.total_account)*100) active_fate,lc.company_name " +
					" from(" +
					" 	select COUNT(DISTINCT c.account_code)active_account,c.company_id,c.access_time,(sum(c.send_data)+sum(c.receive_data)) as broad_data, " +
					" 		(select count(cors_account_code) from cors_account where company_id = c.company_id) as total_account " +
					" 		from (" +
					" 				select b.*,c.company_id from" +
					" 					(select a.account_code,DATE_FORMAT(a.access_time,'%Y-%m') as access_time,sum(a.send_data) as send_data,sum(a.receive_data) as  receive_data " +
					" 						from cors_realtime_logs a group by DATE_FORMAT(a.access_time,'%Y-%m') ,a.account_code) b" +
					" 					left join cors_account c on b.account_code = c.cors_account_code" +
					" 			) c group by c.company_id,c.access_time" +
					" 	) d" +
					" 	left join company lc on d.company_id = lc.company_id" +
					" ) h where h.access_time like ? ";
			
				return commonDAO.sqlQueryListByVP(sql, daystr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Map<String,Object>> getStationDayUseSituation(String daystr){
		try {
			String sql = " select h.station_no,h.join_time,h.connect_nums,h.station_name,ROUND(h.broad_data/1024/1024/1024,2) as broad_data, h.offline_nums from ( " +
					" select b.*,c.station_name " +
					" from ( " +
					" 	select a.station_no,DATE_FORMAT(a.join_time,'%Y-%m-%d') as join_time,sum(a.connect_nums) as connect_nums,sum(a.broadcast_data) as  broad_data " + 
					"   ,sum(case a.station_state when 0 then 1 else 0 end) as offline_nums" +
					" 		from base_realtime_logs a group by DATE_FORMAT(a.join_time,'%Y-%m-%d'),a.station_no " +
					" ) b " +
					" left join base_construct c on b.station_no = c.station_map_no " +
					" ) h where h.join_time like ?";
			return commonDAO.sqlQueryListByVP(sql, daystr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Map<String,Object>> getStationMonthUseSituation(String daystr){
		try {
			daystr = daystr.substring(0, 7);
			String sql = " select h.station_no,h.join_time,h.connect_nums,h.station_name,ROUND(h.broad_data/1024/1024/1024,2) as broad_data,h.offline_nums from ( " +
					" select b.*,c.station_name " +
					" from ( " +
					" 	select a.station_no,DATE_FORMAT(a.join_time,'%Y-%m') as join_time,sum(a.connect_nums) as connect_nums,sum(a.broadcast_data) as  broad_data " +
					"   ,sum(case a.station_state when 0 then 1 else 0 end) as offline_nums" +
					" 		from base_realtime_logs a group by DATE_FORMAT(a.join_time,'%Y-%m'),a.station_no " +
					" ) b " +
					" left join base_construct c on b.station_no = c.station_map_no " +
					" ) h where h.join_time like ?";
			return commonDAO.sqlQueryListByVP(sql, daystr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
		
}
