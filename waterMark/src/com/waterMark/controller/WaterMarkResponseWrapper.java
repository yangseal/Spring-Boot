package com.waterMark.controller;

import com.waterMark.controller.WaterMarkOutputStream;
import com.waterMark.util.ImageUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/9 0009.
 */
public class WaterMarkResponseWrapper extends HttpServletResponseWrapper {
    private  String waterMarkFile;
    private HttpServletResponse response;
    private WaterMarkOutputStream waterMarkOutputStream = new WaterMarkOutputStream();

    public WaterMarkResponseWrapper(HttpServletResponse response, String waterMarkFile)throws IOException{
        super(response);
        this.response=response;
        this.waterMarkFile=waterMarkFile;
    }

    public ServletOutputStream getOutputStream()throws  IOException{
        return  waterMarkOutputStream;
    }

    public void flushBuffer() throws IOException {
        waterMarkOutputStream.flush();
    }

    public  void finishResponse() throws IOException {
        byte[] imageData =  waterMarkOutputStream.getByteArrayOutputStream().toByteArray();
        byte[] image = ImageUtil.waterMark(imageData, waterMarkFile);
        response.setContentLength(image.length);
        response.getOutputStream().write(image);
        waterMarkOutputStream.close();
    }


}
