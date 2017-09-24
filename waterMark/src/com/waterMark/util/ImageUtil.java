package com.waterMark.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/9 0009.
 */
public class ImageUtil {
    public static  byte[] waterMark(byte[] imageData, String waterMarkFile)throws IOException{
        int paddingRight = 10;
        int paddingBottom = 10;
        Image image = new ImageIcon(imageData).getImage();
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        Image waterMark = ImageIO.read(new File(waterMarkFile));
        int waterMarkWidth = waterMark.getWidth(null);
        int waterMarkHeight = waterMark.getHeight(null);
        if(imageWidth<waterMarkWidth+2*paddingRight || imageHeight<waterMarkHeight+2*paddingBottom){
            return imageData;
        }
        BufferedImage bufferedImage  = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_BGR);
        Graphics g = bufferedImage.createGraphics();
        //   绘图用的Graphic
        g.drawImage(image, 0, 0, imageWidth, imageHeight, null);
        //绘制原始图
        g.drawImage(waterMark, imageWidth-waterMarkWidth-paddingRight,imageHeight-waterMarkHeight-paddingBottom,waterMarkWidth,waterMarkHeight,null);
        g.dispose();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(bufferedImage);
        byte[] data = out.toByteArray();
        out.close();
        return data;

    }
}
