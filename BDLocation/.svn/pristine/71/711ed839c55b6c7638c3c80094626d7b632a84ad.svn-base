package com.cnten.platform.system.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cnten.bdlocation.constants.CorsAccountConsts;
import com.cnten.platform.dao.CommonDAO;
import com.cnten.platform.util.FileUtil;
import com.cnten.platform.web.Constants;
import com.cnten.po.Attachment;
import com.cnten.po.User;

@Service
public class AttachmentService {
	
	@Value("${uploadDir}")
	private String uploadDir;
	
	@Autowired
	private CommonDAO commonDAO;

	public Attachment getAttachment(String attachmentId) {
		return commonDAO.get(Attachment.class, attachmentId);
	}
	
	public Attachment getAttachmentWithEntityId(String entityId){
		String hql = "from Attachment a where a.entityId = ? and a.isDelete is null";
		return commonDAO.getByVariableParam(hql, entityId);
	}
	
	public List<Attachment> getAttachments(Attachment attachment){
		String entityName = attachment.getEntityName();
		String entityId = attachment.getEntityId();
		String fieldName = attachment.getFieldName();
		if(StringUtils.isEmpty(entityId) || StringUtils.isEmpty(entityName)
				|| StringUtils.isEmpty(fieldName)){
			return null;
		}
		String hql = "from Attachment where isDelete is null and entityName = ?"
				+ " and fieldName = ? and entityId = ? order by createDate desc";
		return commonDAO.queryListByVariableParam(hql, entityName,fieldName,entityId);
	}
	
	public void deleteAttachment(String attachmentId){
		Attachment attachment = commonDAO.get(Attachment.class, attachmentId);
		attachment.setIsDelete("Y");
		commonDAO.update(attachment);
	}
	
	public void deleteAttachmentWithEntityId(String entityId){
		String hql = "from Attachment a where a.entityId =?";
//		HashMap<String,String> params = new HashMap<String,String>();
//		params.put("entityId", entityId);
		List<Attachment> attachments = commonDAO.queryListByVariableParam(hql, entityId);
		for (Attachment attachment : attachments) {
			if(!CorsAccountConsts.IS_DELETE.equals(attachment.getIsDelete())){
				attachment.setIsDelete("Y");
				commonDAO.update(attachment);
			}
		}
		
	
	}
	
	public void download(String attachmentId, HttpServletResponse response) throws Exception{
		Attachment attachment = getAttachment(attachmentId);
		String fullname = uploadDir + attachment.getEntityName()
				+ File.separatorChar + attachment.getFileName();
		File file = new File(fullname);
		if (!file.isFile()) {
			throw new RuntimeException("文件不存在");
		}
		response.setHeader("Content-Disposition", "attachment; filename=" 
				+ java.net.URLEncoder.encode(attachment.getAttachmentName(), "UTF-8"));
		ServletOutputStream out = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileUtil.writeStream(fis, out);
		fis.close();
		out.close();
	}

	public void save(Attachment attachment, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		if (!(request instanceof MultipartHttpServletRequest)) {
			throw new Exception("非法请求");
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultiValueMap<String, MultipartFile> fileMap = multipartRequest.getMultiFileMap();
		List<MultipartFile> files = new ArrayList<MultipartFile>();
		for (String key : fileMap.keySet()) {
			files.addAll(fileMap.get(key));
		}
		if (files.isEmpty()) {
			throw new Exception("请求中没有包含文件");
		}
		String dirPath = uploadDir + attachment.getEntityName();
		FileUtil.createDir(dirPath);
		for(MultipartFile multipartFile : files) {
			String attachmentName = multipartFile.getOriginalFilename();
			String fileName = FileUtil.getUUIDFileName(attachmentName);
			String filePath = dirPath + File.separatorChar + fileName;
			File file = new File(filePath);
			multipartFile.transferTo(file);
			Attachment attach = new Attachment();
			attach.setFileName(fileName);
			attach.setAttachmentName(attachmentName);
			attach.setEntityName(attachment.getEntityName());
			attach.setFieldName(attachment.getFieldName());
			attach.setEntityId(attachment.getEntityId());
			attach.setCreateDate(new Date());
			attach.setUser((User)request.getSession().getAttribute(Constants.USER_SESSION_KEY));
			String extensionName = FileUtil.getExtensionName(attachmentName).toUpperCase();
			if("JPG".equals(extensionName) || "JPEG".equals(extensionName)
					|| "PNG".equals(extensionName) || "GIF".equals(extensionName)
					|| "BMP".equals(extensionName)){
				attach.setAttachmentType("PICTURE");
				FileUtil.saveThumbnail(filePath,attachment.getEntityName());
			}
			commonDAO.save(attach);
		}
	}

	public void showPicture(String attachmentId, boolean isThumbnail,boolean pryKeySearch,
			HttpServletResponse response) throws Exception {
		Attachment attachment = null;
		if(pryKeySearch){
			attachment = getAttachment(attachmentId);
		} else {
			attachment = getAttachmentWithEntityId(attachmentId);
		}
		
		String fullname = uploadDir + attachment.getEntityName()
				+ File.separatorChar + attachment.getFileName();
		if(isThumbnail){
			fullname = FileUtil.getThumbnailFilePath(fullname);
		}
		File file = new File(fullname);
		if (file==null || !file.isFile()) {
			throw new Exception("文件不存在");
		}
		ServletOutputStream out = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileUtil.writeStream(fis, out);
		fis.close();
		out.close();
	}
	
	public File getFile(Attachment attachment,boolean isThumbnail) throws Exception {
		String fullname = uploadDir + attachment.getEntityName()
				+ File.separatorChar + attachment.getFileName();
		if(isThumbnail){
			fullname = FileUtil.getThumbnailFilePath(fullname);
		}
		File file = new File(fullname);
		if (file==null || !file.isFile()) {
			throw new Exception("附件文件已被移动位置或删除");
		}
		return file;
	}

}
