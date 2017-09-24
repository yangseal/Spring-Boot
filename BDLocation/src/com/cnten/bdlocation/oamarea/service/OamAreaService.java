package com.cnten.bdlocation.oamarea.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.OamArea;
import com.cnten.vo.OamAreaVO;

@Service
public class OamAreaService {

	@Autowired
	CommonDAO commonDAO;
	private static Integer LEVEL = 1;
	
	public List<String> getOamAreasVK() {
		String hql = "from OamArea where isDelete is null order by oamAreaName";
		List<OamArea> oamAreas = commonDAO.queryListByVariableParam(hql);
		List<String> sortedOamAreas = new ArrayList<String>();
		for(OamArea oamArea : oamAreas){
			if(StringUtils.isEmpty(oamArea.getParentId())){
				sortedOamAreas.add(oamArea.getOamAreaId()+":"+oamArea.getOamAreaName()+ ":" + LEVEL);
				addChildrenVK(oamArea, oamAreas, sortedOamAreas,LEVEL);
			}
		}
		return sortedOamAreas;
	}

	private void addChildrenVK(OamArea oamArea,List<OamArea> oamAreas,List<String> sortedOamAreas,Integer level){
		level += 1;
		for (int i = 0,l=oamAreas.size(); i<l; i++) {
			OamArea m = (OamArea)oamAreas.get(i);
			if(oamArea.getOamAreaId().equals(m.getParentId())){
				sortedOamAreas.add(m.getParentId()+":"+m.getOamAreaId()+":"+m.getOamAreaName()+":"+level);
				addChildrenVK(m, oamAreas, sortedOamAreas,level);
			}
		}
	}
	
	public List<OamArea> getOamAreas() {
		String hql = "from OamArea where isDelete is null order by oamAreaName";
		List<OamArea> oamAreas = commonDAO.queryListByVariableParam(hql);
		List<OamArea> sortedOamAreas = new ArrayList<OamArea>();
		for(OamArea oamArea : oamAreas){
			if(StringUtils.isEmpty(oamArea.getParentId())){
				sortedOamAreas.add(oamArea);
				addChildren(oamArea, oamAreas, sortedOamAreas);
			}
		}
		return sortedOamAreas;
	}

	private void addChildren(OamArea oamArea,List<OamArea> oamAreas,List<OamArea> sortedOamAreas){
		for(OamArea m : oamAreas){
			if(oamArea.getOamAreaId().equals(m.getParentId())){
				sortedOamAreas.add(m);
				addChildren(m, oamAreas, sortedOamAreas);
			}
		}
	}

	public OamArea getOamArea(String oamAreaId) {
		return commonDAO.get(OamArea.class, oamAreaId);
	}

	public void saveOamArea(OamArea oamArea) {
		String oamAreaId = oamArea.getOamAreaId();
		if(StringUtils.isEmpty(oamAreaId)){
			commonDAO.save(oamArea);
		}else{
			OamArea oldOamArea = commonDAO.load(OamArea.class, oamAreaId);
			oldOamArea.setOamAreaName(oamArea.getOamAreaName());
			oldOamArea.setOamAreaCode(oamArea.getOamAreaCode());
			oldOamArea.setLongitude(oamArea.getLongitude());
			oldOamArea.setLatitude(oamArea.getLatitude());
			oldOamArea.setCreateDate(oamArea.getCreateDate());
			commonDAO.update(oldOamArea);
		}
	}

	public void deleteOamArea(String oamAreaId){
		OamArea oldOamArea = commonDAO.load(OamArea.class, oamAreaId);
		oldOamArea.setIsDelete("Y");
		commonDAO.update(oldOamArea);
	}
	
	public List<OamAreaVO> getOamAreaVOs() {
		String hql = "select new com.cnten.vo.OamAreaVO(a.oamAreaId,a.oamAreaName,a.longitude,a.latitude,"
				+ "(select count(oamBaseStationId) from OamBaseStation where isDelete is null and oamArea.oamAreaId=a.oamAreaId and isEffectivity='1'),"
				+ "(select count(oamBaseStationId) from OamBaseStation where isDelete is null and oamArea.oamAreaId=a.oamAreaId and isEffectivity='1' and buildStage='1'),"
				+ "(select sum(pr.programme) from OamProject pr,OamCustomer cu where pr.isDelete is null and cu.isDelete is null and pr.oamCustomer.oamCustomerId=cu.oamCustomerId and cu.oamArea.oamAreaId=a.oamAreaId)"
				+ ") from OamArea a where a.isDelete is null and not exists( select 1 from OamArea  where parentId= a.oamAreaId) and exists(select 1 from OamBaseStation s where s.isDelete is null and s.oamArea.oamAreaId=a.oamAreaId and s.isEffectivity='1')";
		List<OamAreaVO> result = commonDAO.queryListByVariableParam(hql);
		hql = "select new com.cnten.vo.OamAreaVO(a.oamAreaId,a.oamAreaName,a.longitude,a.latitude,"
				+ "(select sum(pr.programme) from OamProject pr,OamCustomer cu where pr.isDelete is null and cu.isDelete is null and pr.oamCustomer.oamCustomerId=cu.oamCustomerId and cu.oamArea.oamAreaId=a.oamAreaId)"
				+ ") from OamArea a where a.isDelete is null and exists(select 1 from OamProject p,OamCustomer c where p.isDelete is null and c.isDelete is null and p.oamCustomer.oamCustomerId=c.oamCustomerId and c.oamArea.oamAreaId=a.oamAreaId)"
				+ " and not exists(select 1 from OamBaseStation s where s.isDelete is null and s.oamArea.oamAreaId=a.oamAreaId and s.isEffectivity='1')";
		List<OamAreaVO> result2 = commonDAO.queryListByVariableParam(hql);
		for(OamAreaVO areaVO : result2){
			if(areaVO.getPlan() > 0){
				result.add(areaVO);
			}
		}
		return result;
	}
	
	public List<OamAreaVO> getMonitorOamAreaVOs() {
		String hql = "select new com.cnten.vo.OamAreaVO(a.oamAreaId,a.oamAreaName,a.longitude,a.latitude,"
				+ "(select count(oamBaseStationId) from OamBaseStation where isDelete is null and oamArea.oamAreaId=a.oamAreaId and isEffectivity='1' and buildStage='1'),"
				+ "(select count(oamBaseStationId) from OamBaseStation where isDelete is null and oamArea.oamAreaId=a.oamAreaId and isEffectivity='1' and buildStage='1' and (state is null or state='1')),"
				+ "0) from OamArea a where a.isDelete is null and exists(select 1 from OamBaseStation s where s.isDelete is null and s.oamArea.oamAreaId=a.oamAreaId and s.isEffectivity='1' and s.buildStage='1')";
		return commonDAO.queryListByVariableParam(hql);
	}
	
	/**
	 * 组装数据
	 * 只获取省、市信息
	 * @return
	 * @date 2016年11月21日
	 */
	public Map<String, Object> getPCity(){
		//TODO 增加类型， 省、市、区
		Map<String, Object> retMap = new HashMap<String, Object>();
		List<OamArea> pList = getProvince();
		String hql = "from OamArea a where a.isDelete is null";
		List<OamArea> allList = commonDAO.queryList(hql, null);
		//组装省、市数据
		Map<String, Object> pJson = new LinkedHashMap<String, Object>();			//省数据
		Map<String, List<Map<String, String>>> cJson = new HashMap<String, List<Map<String, String>>>();			//市数据
		if(null != pList && !pList.isEmpty()){
			for(int i = 0; i < pList.size(); i++){
				OamArea pArea = pList.get(i);
				Map<String, String> pMap = new HashMap<String, String>();
				pMap.put("id", pArea.getOamAreaId());
				pJson.put(pArea.getOamAreaName(), pMap);
				if(null != allList && !allList.isEmpty()){
					for(int j = 0; j < allList.size(); j++){
						OamArea area = allList.get(j);
						List<Map<String, String>> cList = cJson.get(pArea.getOamAreaId());
						if(null == cList)
							cList = new ArrayList<Map<String, String>>();
						if(pArea.getOamAreaId().equals(area.getParentId())){
							Map<String, String> cMap = new HashMap<String, String>();
							cMap.put("id", area.getOamAreaId());
							cMap.put("name", area.getOamAreaName());
							cList.add(cMap);
						}
						cJson.put(pArea.getOamAreaId(), cList);
					}
				}
			}
		}
		retMap.put("pJson", pJson);
		retMap.put("cJson", cJson);
		return retMap;
	}
	
	/**
	 * 根据上级查询
	 * @return
	 * @date 2016年11月21日
	 */
	public List<Map<String, Object>> getAreaByPid(String pId){
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		HashMap<String,Object> params = new HashMap<String,Object>();
		String hql = "from OamArea where parentId = :parentId and isDelete is null ";
		params.put("parentId", pId);
		List<OamArea> pList = commonDAO.queryList(hql, params);
		if(null != pList && !pList.isEmpty()){
			for(int i = 0; i < pList.size(); i++){
				OamArea oamArea = pList.get(i);
				Map<String, Object> mMap = new HashMap<String, Object>();
				mMap.put("id", oamArea.getOamAreaId());
				mMap.put("name", oamArea.getOamAreaName());
				retList.add(mMap);
			}
		}
		return retList;
	}
	
	/**
	 * 获取省数据
	 * @return
	 * @date 2016年11月21日
	 */
	private List<OamArea> getProvince(){
		String hql = "from OamArea a WHERE EXISTS (SELECT 1 FROM OamArea b "
													+ "WHERE a.parentId = b.oamAreaId AND b.parentId IS NULL and isDelete is null) "
													+ "and isDelete is null order by a.oamOrder";
		List<OamArea> pList = commonDAO.queryList(hql, null);
		return pList;
	}
}