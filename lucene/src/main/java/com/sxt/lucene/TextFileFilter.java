package com.sxt.lucene;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by Yangshuangpeng on 2017/7/2.
 */
public class TextFileFilter implements FileFilter{
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().endsWith(".txt");
    }
}
