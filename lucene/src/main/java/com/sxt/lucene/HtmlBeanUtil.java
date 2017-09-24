package com.sxt.lucene;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;


import java.io.File;
import java.io.IOException;
/**
 * Created by Yangshuangpeng on 2017/6/17.
 */
public class HtmlBeanUtil {

    public  static HtmlBean  parseHtml(File file) throws IOException {
       // String path     = "F:\\www.bjsxt.com\\index.html";
        Source source   = new Source(file);
        Element title = source.getFirstElement(HTMLElementName.TITLE);
        if(title==null||title.getTextExtractor()==null){
            return  null;
        }
        String content  = source.getTextExtractor().toString();
        HtmlBean hb     = new HtmlBean();
        hb.setTitle(title.getTextExtractor().toString());
        hb.setContent(content);
        String path     = file.getAbsolutePath();
        hb.setUrl("http://" + path.substring(3));
        return  hb;
    }
}

