package com.cnten.bdlocation.clients.mgtcenter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.util.ContextUtil;
import com.cnten.platform.util.StringUtil;
import com.cnten.po.Company;
import com.cnten.po.CorsAccount;

/**
 * 总览 	服务类
 * @author Administrator
 */
@Service
public class MgtCenterService {
	
	@Autowired
	private CommonDAO commonDAO;
	/**
	 * 获取账号使用情况统计数据
	 * @return 
	 */
	public Map<String, Object> getCorsAccountCount(String companyId){
		String sql = " select a.*,b.*,c.*,d.* from " +
					 " (select count(1) as corsCountOfAll from cors_account a where a.company_id = :companyId) a, " +
					 " (select count(1) as corsCountOfActive from cors_account a where a.company_id = :companyId and a.cors_account_state = '"+CorsAccountConsts.ACCOUNT_STATE_NORMAL+"') b, " +
					 " (select count(1) as corsCountOfSoon from cors_account a where a.company_id = :companyId and a.cors_account_state = '"+CorsAccountConsts.ACCOUNT_STATE_JUST_EXPIRE+"') c, " +
					 " (select count(1) as corsCountOfExpired from cors_account a where a.company_id = :companyId and a.cors_account_state = '"+CorsAccountConsts.ACCOUNT_STATE_INVALID+"') d ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("companyId", companyId);
		return commonDAO.sqlGet(sql, params);
	}
	
	/**
	 * 获取所有统计类型的 统计数据 进行组装返回
	 */
	public Map<String,Object> getCorsStatisticOfAll(Company company) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("StatisticOfAccountState", getCorsAccountCount(company.getCompanyId()));
		result.put("StatisticOfServiceType", getCorsStatisticOfServiceType(company));
		result.put("StatisticOfGroup", getCorsStatisticOfGroup(company));
		result.put("StatisticOfActiveState", getCorsStatisticOfActiveState(company));
		result.put("StatisticOfBindDev", getCorsStatisticOfBindDev(company));
		result.put("StatisticOfUserPeriod", getCorsStatisticOfUserPeriod(company));
		return result;
	}
	
	/**
	 * 根据服务类型 统计账号分布情况
	 * @return 
	 */
	public List<Map<String, Object>> getCorsStatisticOfServiceType(Company company){
		String sql = " SELECT count(1) as value, bd_device_accuracy as name from cors_account a where a.company_id =:companyId "
				+ " group by bd_device_accuracy";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("companyId", company.getCompanyId());
		List<Map<String, Object>> _maps = commonDAO.sqlQueryList(sql, params);
		for (Map<String, Object> map : _maps) {
			if( map.get("name")!= null && CorsAccountConsts.ACCOUNT_NET_PRECISION_centimeter.equals(map.get("name"))){
				map.put("typeName", CorsAccountConsts.ACCOUNT_NET_PRECISION_centimeter);
				map.put("name", CorsAccountConsts.ACCOUNT_NET_PRECISION_centimeter_name + ":" + map.get("value"));
				map.put("value", map.get("value"));
			}
			if( map.get("name")!= null && CorsAccountConsts.ACCOUNT_NET_PRECISION_meter.equals(map.get("name"))){
				map.put("typeName", CorsAccountConsts.ACCOUNT_NET_PRECISION_meter);
				map.put("name",CorsAccountConsts.ACCOUNT_NET_PRECISION_meter_name + ":" + map.get("value"));
				map.put("value", map.get("value"));
			}
			if( map.get("name")!= null && CorsAccountConsts.ACCOUNT_NET_PRECISION_mi.equals(map.get("name"))){
				map.put("typeName", CorsAccountConsts.ACCOUNT_NET_PRECISION_mi);
				map.put("name",CorsAccountConsts.ACCOUNT_NET_PRECISION_mi_name + ":" + map.get("value"));
				map.put("value", map.get("value"));
			}
		}
		return _maps;
	}
	
	/**
	 * 根据分组情况统计 账号分布情况
	 * @return 
	 */
	public List<Map<String, Object>> getCorsStatisticOfGroup(Company company){
		String sql = " select count(b.cors_account_id) as value ,IFNULL(a.group_name,c.company_name) as name from cors_company_group a " +
					 " left join cors_account b " +
					 " on a.company_group_id = b.company_group_id " +
					 " left join company c " +
					 " on a.company_id = c.company_id " +
					 " where a.company_id = :companyId " +
					 " group by a.company_group_id,c.company_name";
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("companyId", company.getCompanyId());
		List<Map<String, Object>> _maps = commonDAO.sqlQueryList(sql, params);
		List<Map<String, Object>> rltListMap = new ArrayList<Map<String,Object>>();
		if(_maps.size() == 0){
			Map<String,Object> _default = new HashMap<String,Object>();
			_default.put("name", "默认分组");
			_default.put("value", 0);
			rltListMap.add(_default);
		}else {
			rltListMap = _maps;
		}
		return rltListMap;
	}
	
	/**
	 * 根据激活状态  统计账号分布情况
	 * @return 
	 */
	public List<Map<String, Object>> getCorsStatisticOfActiveState(Company company){
		String sql = " select count(cors_account_id) as value ,IFNULL(a.cors_account_state,'unactive') as activeState from cors_account a where a.company_id = :companyId "
				   + " and a.cors_account_state = '"+ CorsAccountConsts.ACCOUNT_STATE_UNACTIVE +"' "
				   + " union all "
				   + " select count(cors_account_id),a.cors_account_state from cors_account a " 
				   + " where a.company_id = :companyId and ( a.cors_account_state != '"+ CorsAccountConsts.ACCOUNT_STATE_UNACTIVE 
				   + "' or a.cors_account_state is null) ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("companyId", company.getCompanyId());
		List<Map<String, Object>> _list = commonDAO.sqlQueryList(sql, params);
		List<Map<String,Object>> rltList = new ArrayList<Map<String,Object>>();
		Integer sumAccount = 0;
		for (Map<String, Object> map : _list) {
			String _state = (String) map.get("activeState");
			if (CorsAccountConsts.ACCOUNT_STATE_UNACTIVE.equals(_state)){ //未激活
				map.put("typeName", CorsAccountConsts.ACCOUNT_STATE_UNACTIVE);
				map.put("name", "未激活 "+map.get("value"));
			} else {
				map.put("typeName", CorsAccountConsts.ACCOUNT_ACTIVE_SUM);
				map.put("name", "已激活 "+map.get("value"));
			}
			rltList.add((HashMap<String, Object>) map);
			sumAccount += ((BigInteger)map.get("value")).intValue();
		}
		Map<String,Object> sumMap = new HashMap<String,Object>();
		sumMap.put("typeName", CorsAccountConsts.ACCOUNT_OF_SUM);
		sumMap.put("name", "总配额 " + sumAccount);
		sumMap.put("value", sumAccount);
		rltList.add(sumMap);
		return rltList;
	}
	
	/**
	 * 根据设备绑定状态  统计账号分布情况
	 * @return 
	 */
	public List<Map<String, Object>> getCorsStatisticOfBindDev(Company company){
		String sql = " select count(cors_account_id) as value,'unbind' as name from cors_account a where a.company_id = :companyId and a.bd_device is null "+
					 " union all " +
					 " select count(cors_account_id) as value,'binded' as name from cors_account a " + 
					 " where a.company_id = :companyId and a.bd_device is not null";
		
	   HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("companyId", company.getCompanyId());
		List<Map<String, Object>> _list = commonDAO.sqlQueryList(sql, params);
		List<Map<String,Object>> rltList = new ArrayList<Map<String,Object>>();
		Integer sumAccount = 0;
		for (Map<String, Object> map : _list) {
			String _name = (String) map.get("name");
			if (CorsAccountConsts.ACCOUNT_DEVICE_UNBIND.equals(_name)){
				map.put("typeName", CorsAccountConsts.ACCOUNT_DEVICE_UNBIND);
				map.put("name", "未绑定" + " " + map.get("value"));
			} else {
				map.put("typeName", CorsAccountConsts.ACCOUNT_DEVICE_BINDED);
				map.put("name", "已绑定" + " " + map.get("value"));
			}
			sumAccount += ((BigInteger)map.get("value")).intValue();
			rltList.add(map);
		}
		Map<String,Object> sumMap = new HashMap<String,Object>();
		sumMap.put("typeName", CorsAccountConsts.ACCOUNT_OF_SUM);
		sumMap.put("name", "总配额 " + sumAccount);
		sumMap.put("value", sumAccount);
		rltList.add(sumMap);
		return rltList;
	}
	
	/**
	 * 
	 * 根据服务账号期限  统计账号分布情况
	 * @param company
	 * @return
	 */
	public List<Map<String, Object>> getCorsStatisticOfUserPeriod(Company company){
		String sql = " select count(cors_account_id) as value,a.cors_account_state from cors_account a where a.company_id = :companyId " + 
					 " and a.cors_account_state is not null and a.cors_account_state != :corsAccountState " +
					 " group by a.cors_account_state ";
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("companyId", company.getCompanyId());
		params.put("corsAccountState", CorsAccountConsts.ACCOUNT_STATE_UNACTIVE);
		List<Map<String, Object>> _list = commonDAO.sqlQueryList(sql, params);
		for (Map<String, Object> map : _list) {
			String cors_account_state = (String) map.get("cors_account_state");
			map.put("name", StringUtil.getDictName(cors_account_state, CorsAccount.corsAccountStateDictStatement) + " " + map.get("value"));
			map.put("typeName", cors_account_state);
			map.remove("cors_account_state");
		}
		return _list;
	}
	
	 public Company getCompany(){
		 Company company = commonDAO.get(Company.class, ContextUtil.getCurrentUser().getCompany().getCompanyId());
		 return company;
	 }

}
