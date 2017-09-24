package com.cnten.bdlocation.conversionparam.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnten.platform.dao.CommonDAO;
import com.cnten.po.ConversionParam;
import com.cnten.po.ConversionProjection;
import com.cnten.vo.ConverAreaVO;
import com.cnten.vo.ConversionParamVO;

@Service
public class ConversionParamService {

	@Autowired
	CommonDAO commonDAO;

	public List<ConversionParam> getConversionParams() {
		String hql = "from ConversionParam where isDelete is null";
		List<ConversionParam> conversionParams = commonDAO
				.queryListByVariableParam(hql);
		List<ConversionParam> sortedConversionParams = new ArrayList<ConversionParam>();
		for (ConversionParam conversionParam : conversionParams) {
			if (StringUtils.isEmpty(conversionParam.getParentId())
					|| conversionParam.getParentId().equals("0")) {
				sortedConversionParams.add(conversionParam);
				addChildren(conversionParam, conversionParams,
						sortedConversionParams);
			}
		}
		return sortedConversionParams;
	}

	private void addChildren(ConversionParam conversionParam,
			List<ConversionParam> conversionParams,
			List<ConversionParam> sortedConversionParams) {
		for (ConversionParam m : conversionParams) {
			if (m.getParentId() != null
					&& conversionParam.getConversionParamId().equals(
							m.getParentId())) {
				sortedConversionParams.add(m);
				addChildren(m, conversionParams, sortedConversionParams);
			}
		}
	}

	public List<ConverAreaVO> getGisutilityConversions() throws Exception {
		String hql = "select new com.cnten.vo.ConverAreaVO(c.conversionParamId,c.parentId,c.conversionParamName,c.conversionParamCode) from ConversionParam c";
		hql += " where c.isDelete is null";
		List<ConverAreaVO> list = null;
		try {
			list = commonDAO.queryListByVariableParam(hql);
		} catch (Exception ex) {
			throw new Exception("查询数据库出错！");
		}
		if (list.size() == 0) {
			return new ArrayList<ConverAreaVO>();
		}
		List<ConverAreaVO> result = new ArrayList<ConverAreaVO>();
		getTree(list, result);
		return result;
	}

	private void getTree(List<ConverAreaVO> list, List<ConverAreaVO> result) {
		for (ConverAreaVO vo : list) {
			if (vo.getParentId() == null || vo.getParentId().equals("0")) {
				result.add(vo);
				addChildren(vo, list);
			}
		}
	}

	private void addChildren(ConverAreaVO converAreaVO,
			List<ConverAreaVO> converAreaVOs) {
		for (ConverAreaVO vo : converAreaVOs) {
			if (vo.getParentId() != null
					&& vo.getParentId().equals(converAreaVO.getId())) {
				converAreaVO.getChildren().add(vo);
				addChildren(vo, converAreaVOs);
			}
		}
	}

	public ConversionParamVO getGisutilityConversionById(
			String conversionParamId) throws Exception {
		String hql = "select new com.cnten.vo.ConversionParamVO(c.conversionParamId,c.conversionProjection.conversionProjectionId,c.x,c.y,c.z,c.k,c.xt,c.yt,c.zt,c.ellipoidSys,c.reverseX,c.reverseY,c.reverseZ,c.reverseK,c.reverseXt,c.reverseYt,c.reverseZt) from ConversionParam c";
		hql += " where c.isDelete is null and c.conversionParamId = ?";
		ConversionParamVO result;
		try {
			result = commonDAO.getByVariableParam(hql, conversionParamId);
			String conversionProjectionId = result.getProjectionId();
			hql = "from ConversionProjection where isDelete is null and conversionProjectionId = ?";
			ConversionProjection conversionProjection = commonDAO
					.getByVariableParam(hql, conversionProjectionId);
			result.setProjectionParam(conversionProjection);
		} catch (Exception ex) {
			throw new Exception("查询数据库出错！");
		}

		return result;
	}

	public ConversionParam getConversionParam(String conversionParamId) {
		return commonDAO.get(ConversionParam.class, conversionParamId);
	}

	public void saveConversionParam(ConversionParam conversionParam) {
		if (conversionParam.getConversionProjection() != null
				&& StringUtils.isBlank(conversionParam
						.getConversionProjection().getConversionProjectionId())) {
			conversionParam.setConversionProjection(null);
		}
		String conversionParamId = conversionParam.getConversionParamId();
		if (StringUtils.isEmpty(conversionParamId)) {
			commonDAO.save(conversionParam);
		} else {
			ConversionParam oldConversionParam = commonDAO.load(
					ConversionParam.class, conversionParamId);
			oldConversionParam.setConversionParamName(conversionParam
					.getConversionParamName());
			oldConversionParam.setConversionParamCode(conversionParam
					.getConversionParamCode());
			oldConversionParam.setEllipoidSys(conversionParam.getEllipoidSys());
			oldConversionParam.setEllipoidSys2(conversionParam
					.getEllipoidSys2());
			oldConversionParam.setNorth(conversionParam.getNorth());
			oldConversionParam.setSouth(conversionParam.getSouth());
			oldConversionParam.setWest(conversionParam.getWest());
			oldConversionParam.setEast(conversionParam.getEast());
			oldConversionParam.setNorthLat(conversionParam.getNorthLat());
			oldConversionParam.setSouthLat(conversionParam.getSouthLat());
			oldConversionParam.setWestLng(conversionParam.getWestLng());
			oldConversionParam.setEastLng(conversionParam.getEastLng());
			oldConversionParam.setX(conversionParam.getX());
			oldConversionParam.setY(conversionParam.getY());
			oldConversionParam.setZ(conversionParam.getZ());
			oldConversionParam.setK(conversionParam.getK());
			oldConversionParam.setXt(conversionParam.getXt());
			oldConversionParam.setYt(conversionParam.getYt());
			oldConversionParam.setZt(conversionParam.getZt());
			oldConversionParam.setConversionType(conversionParam
					.getConversionType());
			oldConversionParam.setPt1B(conversionParam.getPt1B());
			oldConversionParam.setPt1L(conversionParam.getPt1L());
			oldConversionParam.setPt1H(conversionParam.getPt1H());
			oldConversionParam.setPt1X(conversionParam.getPt1X());
			oldConversionParam.setPt1Y(conversionParam.getPt1Y());
			oldConversionParam.setPt1Z(conversionParam.getPt1Z());
			oldConversionParam.setPt2B(conversionParam.getPt2B());
			oldConversionParam.setPt2L(conversionParam.getPt2L());
			oldConversionParam.setPt2H(conversionParam.getPt2H());
			oldConversionParam.setPt2X(conversionParam.getPt2X());
			oldConversionParam.setPt2Y(conversionParam.getPt2Y());
			oldConversionParam.setPt2Z(conversionParam.getPt2Z());
			oldConversionParam.setPt3B(conversionParam.getPt3B());
			oldConversionParam.setPt3L(conversionParam.getPt3L());
			oldConversionParam.setPt3H(conversionParam.getPt3H());
			oldConversionParam.setPt3X(conversionParam.getPt3X());
			oldConversionParam.setPt3Y(conversionParam.getPt3Y());
			oldConversionParam.setPt3Z(conversionParam.getPt3Z());
			oldConversionParam.setInfo(conversionParam.getInfo());
			oldConversionParam.setConversionProjection(conversionParam
					.getConversionProjection());
			commonDAO.update(oldConversionParam);
		}
	}

	public void deleteConversionParam(String conversionParamId) {
		ConversionParam oldConversionParam = commonDAO.load(
				ConversionParam.class, conversionParamId);
		oldConversionParam.setIsDelete("Y");
		commonDAO.update(oldConversionParam);
	}
}