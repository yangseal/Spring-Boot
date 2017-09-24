package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2017/5/8 0008.
 */
@Controller
public class DianCanController  {
    @GetMapping("/diancan")
    public String loginGet(Model model){
        return "diancan";
    }

}
