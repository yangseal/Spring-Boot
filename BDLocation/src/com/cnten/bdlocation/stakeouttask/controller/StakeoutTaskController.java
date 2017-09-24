package com.cnten.bdlocation.stakeouttask.controller;

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

import com.cnten.bdlocation.stakeouttask.service.StakeoutTaskService;
import com.cnten.platform.dao.Page;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.StakeoutTask;

@Controller
public class StakeoutTaskController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Autowired
	private StakeoutTaskService stakeoutTaskService;

	@RequestMapping(value = "/stakeoutTask/showStakeoutTasks")
	public void showStakeoutTasks() {
	}

	@RequestMapping(value = "/stakeoutTask/showStakeoutTask")
	public void showStakeoutTask(String stakeoutTaskId, Model model) {
		StakeoutTask stakeoutTask = stakeoutTaskService.getStakeoutTask(stakeoutTaskId);
		model.addAttribute("stakeoutTask", stakeoutTask);
	}

	@RequestMapping(value = "/stakeoutTask/queryStakeoutTasks")
	public void queryStakeoutTasks(StakeoutTask stakeoutTask, Integer pageIndex, Integer pageSize, Model model) {
		Page page = stakeoutTaskService.getStakeoutTasksPage(stakeoutTask, pageIndex, pageSize);
		model.addAttribute(page);
	}

	// added by lanj 2016-06-23 根据任务获取任务
	@ResponseBody
	@RequestMapping(value = "/stakeoutTask/getStakeoutTasksByTask")
	public SuccessOrFailure getStakeoutTasksByTask(StakeoutTask stakeoutTask) {
		try {
			return SuccessOrFailure.SUCCESS(stakeoutTaskService.getStakeoutTasksByTask(stakeoutTask));
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	@RequestMapping(value = "/stakeoutTask/selectStakeoutTask")
	public void selectStakeoutTask() {
	}

	@RequestMapping(value = "/stakeoutTask/selectStakeoutTasks")
	public void selectStakeoutTasks(StakeoutTask stakeoutTask, Integer pageIndex, Integer pageSize, Model model) {
		Page page = stakeoutTaskService.getStakeoutTasksPage(stakeoutTask, pageIndex, pageSize);
		model.addAttribute(page);
	}

	@ResponseBody
	@RequestMapping(value = "/stakeoutTask/saveStakeoutTask")
	public SuccessOrFailure saveStakeoutTask(StakeoutTask stakeoutTask) {
		try {
			stakeoutTaskService.saveStakeoutTask(stakeoutTask);
			return SuccessOrFailure.SUCCESS(stakeoutTask.getStakeoutTaskId());
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping(value = "/stakeoutTask/deleteStakeoutTask")
	public SuccessOrFailure deleteStakeoutTask(String stakeoutTaskIds) {
		try {
			stakeoutTaskService.deleteStakeoutTask(stakeoutTaskIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	@ResponseBody
	@RequestMapping(value = "/stakeoutTask/updateStakeoutTaskState")
	public SuccessOrFailure updateStakeoutTaskState(String stakeoutTaskIds) {
		try {
			stakeoutTaskService.updateStakeoutTaskState(stakeoutTaskIds);
			return SuccessOrFailure.SUCCESS;
		} catch (Exception e) {
			return SuccessOrFailure.FAILURE(e.getMessage());
		}
	}

	@RequestMapping(value = "/stakeoutTask/exportStakeoutTasks")
	public void exportStakeoutTasks(StakeoutTask stakeoutTask, HttpServletResponse response) {
		try {
			stakeoutTaskService.exportStakeoutTasks(stakeoutTask, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
