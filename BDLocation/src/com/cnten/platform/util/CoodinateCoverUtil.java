package com.cnten.platform.util;

import GisUtility.Coordinate.ConvertCalculate.ConvertFac;
import GisUtility.Coordinate.ConvertCalculate.EnumCalType;
import GisUtility.Coordinate.ConvertCalculate.SuperConvert;
import GisUtility.Coordinate.EllipoidSys.EnumEllipsoid;
import GisUtility.Coordinate.Projection.EnumProjection;

import com.cnten.po.ConversionParam;

public class CoodinateCoverUtil {

	private Integer ellipoid_source;
	private Double param_x;
	private Double param_y;
	private Double param_z;
	private Double param_k;
	private Double param_xt;
	private Double param_yt;
	private Double param_zt;

	private Double param_reverse_x;
	private Double param_reverse_y;
	private Double param_reverse_z;
	private Double param_reverse_k;
	private Double param_reverse_xt;
	private Double param_reverse_yt;
	private Double param_reverse_zt;

	private Integer projection_type;
	private Integer projection_meridian;
	private Double projection_k;
	private Double projection_x;
	private Double projection_y;
	private Double projection_standerdlat;
	private Double projection_h;
	private Double projection_averageLat;

	private boolean verification;

	private CoodinateCoverUtil() {
	}

	/**
	 * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例 </br> 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
	 * 
	 * @author wdd
	 */
	private static class LazyHoder {
		/**
		 * 静态初始化器，由JVM来保证线程安全
		 */
		private static CoodinateCoverUtil INSTANCE = new CoodinateCoverUtil();
	}

	/**
	 * 获得实例
	 * 
	 * @return instance
	 */
	public static CoodinateCoverUtil getInstance() {
		return LazyHoder.INSTANCE;
	}

	public SuperConvert getCoverOfFourParam(ConversionParam param)
			throws IllegalArgumentException {
		initParam(param);
		if (!verification)
			throw new IllegalArgumentException("获取到错误的转换参数");

		SuperConvert convert = ConvertFac.GetConversion(EnumCalType.四参数法);
		convert.SetProjection(
				EnumEllipsoid.getEnumEllipsoidByCode(ellipoid_source),
				EnumProjection.getEnumProjectionByCode(projection_type),
				projection_meridian, projection_k, projection_x, projection_y,
				projection_standerdlat, projection_h, projection_averageLat);
		convert.SetConvertParam(param_x, param_y, param_z, param_xt, param_yt,
				param_zt, param_k);

		return convert;
	}

	public SuperConvert getReverseCoverOfFourParam(ConversionParam param)
			throws IllegalArgumentException {
		initParam(param);
		if (!verification)
			throw new IllegalArgumentException("获取到错误的转换参数");

		SuperConvert convert = ConvertFac.GetConversion(EnumCalType.四参数法);
		convert.SetProjection(
				EnumEllipsoid.getEnumEllipsoidByCode(ellipoid_source),
				EnumProjection.getEnumProjectionByCode(projection_type),
				projection_meridian, projection_k, projection_x, projection_y,
				projection_standerdlat, projection_h, projection_averageLat);
		convert.SetConvertParam(param_reverse_x, param_reverse_y,
				param_reverse_z, param_reverse_xt, param_reverse_yt,
				param_reverse_zt, param_reverse_k);

		return convert;
	}

	private void initParam(ConversionParam param) {
		verification = true;
		if (null == param.getEllipoidSys()) {
			verification = false;
			return;
		}
		if (null == param.getX()) {
			verification = false;
			return;
		}
		if (null == param.getY()) {
			verification = false;
			return;
		}
		if (null == param.getZ()) {
			verification = false;
			return;
		}
		if (null == param.getK()) {
			verification = false;
			return;
		}
		if (null == param.getXt()) {
			verification = false;
			return;
		}
		if (null == param.getYt()) {
			verification = false;
			return;
		}
		if (null == param.getZt()) {
			verification = false;
			return;
		}

		if (null == param.getReverseX()) {
			verification = false;
			return;
		}
		if (null == param.getReverseY()) {
			verification = false;
			return;
		}
		if (null == param.getReverseZ()) {
			verification = false;
			return;
		}
		if (null == param.getReverseK()) {
			verification = false;
			return;
		}
		if (null == param.getReverseXt()) {
			verification = false;
			return;
		}
		if (null == param.getReverseXt()) {
			verification = false;
			return;
		}
		if (null == param.getReverseZt()) {
			verification = false;
			return;
		}

		if (null == param.getConversionProjection()) {
			verification = false;
			return;
		}
		if (null == param.getConversionProjection().getProjectType()) {
			verification = false;
			return;
		}
		if (null == param.getConversionProjection().getMeridian()) {
			verification = false;
			return;
		}
		if (null == param.getConversionProjection().getK()) {
			verification = false;
			return;
		}
		if (null == param.getConversionProjection().getX()) {
			verification = false;
			return;
		}
		if (null == param.getConversionProjection().getY()) {
			verification = false;
			return;
		}
		if (null == param.getConversionProjection().getStanderdLat()) {
			verification = false;
			return;
		}
		if (null == param.getConversionProjection().getH()) {
			verification = false;
			return;
		}
		if (null == param.getConversionProjection().getAverageLat()) {
			verification = false;
			return;
		}

		ellipoid_source = param.getEllipoidSys();

		param_x = param.getX();
		param_y = param.getY();
		param_z = param.getZ();
		param_k = param.getK();
		param_xt = param.getXt();
		param_yt = param.getYt();
		param_zt = param.getZt();

		param_reverse_x = param.getReverseX();
		param_reverse_y = param.getReverseY();
		param_reverse_z = param.getReverseZ();
		param_reverse_k = param.getReverseK();
		param_reverse_xt = param.getReverseXt();
		param_reverse_yt = param.getReverseYt();
		param_reverse_zt = param.getReverseZt();

		projection_type = param.getConversionProjection().getProjectType();
		projection_meridian = param.getConversionProjection().getMeridian();
		projection_k = param.getConversionProjection().getK();
		projection_x = param.getConversionProjection().getX();
		projection_y = param.getConversionProjection().getY();
		projection_standerdlat = param.getConversionProjection()
				.getStanderdLat();
		projection_h = param.getConversionProjection().getH();
		projection_averageLat = param.getConversionProjection().getAverageLat();
	}

}
