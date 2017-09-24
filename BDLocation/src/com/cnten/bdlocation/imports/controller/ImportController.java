package com.cnten.bdlocation.imports.controller;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.cnten.bdlocation.imports.service.ImportService;
import com.cnten.platform.util.FileUtil;

@Controller
public class ImportController {
	
	@Value("${uploadDir}")
	private String uploadDir;
	
	@Autowired
	private ImportService importService;
	
	@RequestMapping(value = "/import/importStakeoutTasks")
	public void importStakeoutTasks() {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/import/uploadStakeoutTasks", method = RequestMethod.POST)
	public String uploadStakeoutTasks(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		if (!(request instanceof MultipartHttpServletRequest)){
			return "非法请求";
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("filename");
		String dirPath = uploadDir + "importExcel";
		FileUtil.createDir(dirPath);
		String sourceName = multipartFile.getOriginalFilename();
		String fileName = FileUtil.getUUIDFileName(sourceName);
		String filePath = dirPath + File.separatorChar + fileName;
		File file = new File(filePath);
		multipartFile.transferTo(file);
		FileInputStream is = new FileInputStream(filePath);
		HSSFWorkbook wb = new HSSFWorkbook(is);
		int sheetNum = wb.getNumberOfSheets();
		if(sheetNum > 0){
			for(int i=0; i<sheetNum; i++){
				Sheet sheet = wb.getSheetAt(i);
				String sheetName = sheet.getSheetName().trim();
				if(sheetName.equals("放样任务")){
					importService.saveImportStakeoutTask(filePath);
				}else if(sheetName.equals("放样点")){
					importService.saveImportStakeoutPoint(filePath);
				}
			}
			return "导入成功";
		}else{
			return "导入失败";
		}
	}
	
}
