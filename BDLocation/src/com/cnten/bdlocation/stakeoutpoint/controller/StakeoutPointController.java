package com.cnten.bdlocation.stakeoutpoint.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.stakeoutpoint.service.StakeoutPointService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.StakeoutPoint;

@Controller
public class StakeoutPointController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private StakeoutPointService stakeoutPointService;

	@RequestMapping(value = "/stakeoutPoint/showStakeoutPoints")
	public void showStakeoutPoints() {
	}

	@RequestMapping(value = "/stakeoutPoint/showStakeoutPoint")
	public void showStakeoutPoint(String stakeoutPointId, Model model) {
		StakeoutPoint stakeoutPoint = stakeoutPointService.getStakeoutPoint(stakeoutPointId);
		model.addAttribute("stakeoutPoint", stakeoutPoint);
	}

	@RequestMapping(value = "/stakeoutPoint/queryStakeoutPoints")
	public void queryStakeoutPoints(StakeoutPoint stakeoutPoint, Integer pageIndex, Integer pageSize, Model model) {
		Page page = stakeoutPointService.getStakeoutPointsPage(stakeoutPoint, pageIndex, pageSize);
		model.addAttribute(page);
	}

	@RequestMapping(value = "/stakeoutPoint/selectStakeoutPoint")
	public void selectStakeoutPoint() {
	}

	@RequestMapping(value = "/stakeoutPoint/selectStakeoutPoints")
	public void selectStakeoutPoints(StakeoutPoint stakeoutPoint, Integer pageIndex, Integer pageSize, Model model) {
		Page page = stakeoutPointService.getStakeoutPointsPage(stakeoutPoint, pageIndex, pageSize);
		model.addAttribute(page);
	}

	// added by lanj 2016-06-23 根据放样任务ID获取放样点对象
	@ResponseBody
	@RequestMapping(value = "/stakeoutPoint/getStakeoutPointByTaskId")
	public SuccessOrFailure getStakeoutPointByTaskId(String taskId) {
		try {
			return SuccessOrFailure.SUCCESS(stakeoutPointService.getStakeoutPointByTaskId(taskId));
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping(value = "/stakeoutPoint/saveStakeoutPoint")
	public SuccessOrFailure saveStakeoutPoint(StakeoutPoint stakeoutPoint) {
		try {
			stakeoutPointService.saveStakeoutPoint(stakeoutPoint);
			return SuccessOrFailure.SUCCESS(stakeoutPoint.getStakeoutPointId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping(value = "/stakeoutPoint/deleteStakeoutPoint")
	public SuccessOrFailure deleteStakeoutPoint(String stakeoutPointIds) {
		try {
			stakeoutPointService.deleteStakeoutPoint(stakeoutPointIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	@RequestMapping(value = "/stakeoutPoint/exportStakeoutPoints")
	public void exportStakeoutPoints(StakeoutPoint stakeoutPoint, HttpServletResponse response) {
		try {
			stakeoutPointService.exportStakeoutPoints(stakeoutPoint, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
