package com.cnten.bdlocation.oambasestationmap.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cnten.bdlocation.oamaccount.service.OamAccountService;
import com.cnten.bdlocation.oamarea.service.OamAreaService;
import com.cnten.bdlocation.oambasestation.service.OamBaseStationService;
import com.cnten.bdlocation.oamstationaddress.service.OamStationAddressService;
import com.cnten.platform.system.service.AttachmentService;
import com.cnten.platform.web.SuccessOrFailure;
import com.cnten.po.Attachment;
import com.cnten.po.OamBaseStation;
import com.cnten.po.OamProject;
import com.cnten.po.OamStationAddress;

@Controller
@RequestMapping(value = "/oamBaseStationMap")
public class OamBaseStationMapController {
	
	@Autowired
	private OamAreaService oamAreaService;
	@Autowired
	private OamBaseStationService oamBaseStationService;
	@Autowired
	private OamStationAddressService oamStationAddressService;
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private OamAccountService oamAccountService;
	/**
	 * 位置服务基站主页请求
	 */
	@RequestMapping(value = "/base_main")
	public void getMainPage() {
	}
	@RequestMapping(value = "/bs_head")
	public void getHead() {
	}
	@RequestMapping(value = "/bs_footer")
	public void getFooter() {
	}
	@RequestMapping(value = "/bs_monitor")
	public void getMonitor() {
	}
	@RequestMapping(value = "/bs_mainList")
	public void getMainList() {
	}
	@RequestMapping(value = "/bs_stationInfo")
	public void getStationInfo() {
	}
	@RequestMapping(value = "/bs_monitorCity")
	public void getMonitorCity() {
	}
	
	/**
     * 获取城市及基站数
    * @return 
     */
    @RequestMapping(value = "/getCityAndStationCount", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> getCityAndStationCount() {
    	Map<String, Object> result = new HashMap<String, Object>();
		result.put("CityInfo", oamAreaService.getOamAreaVOs());
		return result;
    }
    
    /**
     * 获取城市内的基站信息
     * @param areaId  城市id
     */
    @RequestMapping(value = "/getInfoByCityId", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> getInfoByCityId( @RequestParam(value = "oamAreaId", required = false) String oamAreaId) {
    	if(null == oamAreaId)
			return null;
		Map<String, Object> result = new HashMap<String, Object>();
		List<OamBaseStation> list = oamBaseStationService.getOamBaseStations(oamAreaId);
		List<OamStationAddress> listAddress = new ArrayList<>();
		for(OamBaseStation oamBaseStation : list) {
			listAddress.add(oamStationAddressService.getAddressByStationId(oamBaseStation.getOamBaseStationId()));
		}
		result.put("BaseStation",list);
		result.put("Address", listAddress);
		return result;
    }
    
    /**
	 * 获取已完成基站的情况及正常运行数
	 */
     @RequestMapping(value = "/getMonitor", method = RequestMethod.POST)
     public @ResponseBody SuccessOrFailure getMonitorStations() {
    	return SuccessOrFailure.SUCCESS(oamAreaService.getMonitorOamAreaVOs());
     } 
     @RequestMapping(value = "/getInfoByStaiton", method = RequestMethod.POST)
     public @ResponseBody SuccessOrFailure getInfoByStaiton(String stationId) {
    	 return SuccessOrFailure.SUCCESS(oamBaseStationService.getOamBaseStationVO(stationId));
     }
     @RequestMapping(value = "/getCityMonitor")
 	public @ResponseBody SuccessOrFailure getMonitorStations(String oamAreaId){
 		if(null == oamAreaId)
 			return SuccessOrFailure.FAILURE("");
 		List<OamBaseStation> list = oamBaseStationService.getMonitorStations(oamAreaId);
 		for(OamBaseStation oamBaseStation : list) {
 			if(null == oamBaseStation.getOamProject()) {
 				oamBaseStation.setOamProject(new OamProject());
 			}
 		}
 		return SuccessOrFailure.SUCCESS(list);
 	}
     
    @ResponseBody
 	@RequestMapping(value = "/getAttachments")
 	public SuccessOrFailure getAttachments(Attachment attachment){
 		try {
 			return SuccessOrFailure.SUCCESS(attachmentService.getAttachments(attachment));
 		} catch (Exception e) {
 			return SuccessOrFailure.FAILURE(e.getMessage());
 		}
 	}
    @RequestMapping(value = "/download")
	public void download(String attachmentId, HttpServletResponse response){
		try{
			attachmentService.download(attachmentId, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    @RequestMapping(value = "/showPicture")
	public void showPicture(String attachmentId, boolean isThumbnail, HttpServletResponse response){
		try{
			attachmentService.showPicture(attachmentId, isThumbnail,true, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    @ResponseBody
    @RequestMapping(value="/getAccounts")
    public SuccessOrFailure getAccount(String areaId) {
    	try {
 			return SuccessOrFailure.SUCCESS(oamAccountService.getOamAccounts(areaId));
 		} catch (Exception e) {
 			return SuccessOrFailure.FAILURE(e.getMessage());
 		}
    }
	
}
