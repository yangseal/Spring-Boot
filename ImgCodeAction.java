package com.hj.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import com.hj.util.CodeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImgCodeAction extends ActionSupport {
	
	private static final long serialVersionUID = -712962347758638769L;
	private InputStream imageStream;
	
	public InputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}


//	生成验证码图片,然后交给stream的result返回
	public String execute(){
		Map<String,BufferedImage> map=CodeUtil.createImage();
		String code=map.keySet().iterator().next();//获取图片字符
		Map<String,Object> session=ActionContext.getContext().getSession();//ActionContext 工具类
		session.put("code", code);
		BufferedImage image=map.get(code);//获取图片
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(bos);
		try {
			encoder.encode(image);
			byte[] bits=bos.toByteArray();
			imageStream=new ByteArrayInputStream(bits);
			return this.SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return this.ERROR;
		}
		
	}

	
}
