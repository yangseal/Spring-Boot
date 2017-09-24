package com.cnten.platform.util;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.lang3.StringUtils;

import com.cnten.bdlocation.constants.CorsAccountConsts;

public class FileUtil {

	public static void createDir(String dirPath){
		if(StringUtils.isEmpty(dirPath)){
			return;
		}
		File file = new File(dirPath);
		if(!file.exists()){
			file.setWritable(true, false);//在linux 下java 的默认的文件写入权限仅局限在执行目录之下
			file.mkdirs();
		}
	}
	
	public static String getExtensionName(String fileName) {
		String extension = "";
		if(StringUtils.isNotBlank(fileName)){
			int lastIndex = fileName.lastIndexOf('.');
			lastIndex = lastIndex > 0 ? lastIndex + 1 : 0;
			extension = fileName.substring(lastIndex);
		}
		return extension;
	}

	public static String getUUIDFileName(String fileName) {
		StringBuffer newName = new StringBuffer();
		if(StringUtils.isNotBlank(fileName)){
			newName.append(UUIDUtil.getUUID());
			newName.append('.');
			newName.append(getExtensionName(fileName));
		}
		return newName.toString();
	}

	public static String getThumbnailFilePath(String filePath) {
		StringBuffer thumbnailFilePath = new StringBuffer();
		if(StringUtils.isNotBlank(filePath)){
			int lastIndex = filePath.lastIndexOf('.');
			lastIndex = lastIndex > 0 ? lastIndex : 0;
			thumbnailFilePath.append(filePath.substring(0,lastIndex));
			thumbnailFilePath.append("_thumbnail");
			thumbnailFilePath.append('.');
			thumbnailFilePath.append(getExtensionName(filePath));
		}
		return thumbnailFilePath.toString();
	}

	public static void saveThumbnail(String filePath,String thumbnailType){
		if(StringUtils.isBlank(filePath)) return;
		String thumbnailFilePath = getThumbnailFilePath(filePath);
		try {
			if(CorsAccountConsts.COMPANY_LICENSE_ENTITY_NAME.equals(thumbnailType)){
				Thumbnails.of(filePath).size(220, 160).toFile(thumbnailFilePath);
			}else{
				Thumbnails.of(filePath).size(130, 92).toFile(thumbnailFilePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	public static void writeStream(InputStream is, OutputStream os) throws Exception{
		byte[] buff = new byte[1024];
		int readCount = 0;
		readCount = is.read(buff);
		while (readCount != -1) {
			os.write(buff, 0, readCount);
			readCount = is.read(buff);
		}
	}
}
