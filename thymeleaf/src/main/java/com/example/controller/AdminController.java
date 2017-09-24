package com.example.controller;

import com.example.model.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/5 0005.
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;


    /**************************************************************************************************************************************************************************
     * **************************************************************************************************************************************************************************
     *后台业务
     * **************************************************************************************************************************************************************************
     ***************************************************************************************************************************************************************************/


    /**
     * 登录跳转
     * @param model
     * @return
     */
    @GetMapping("/admin/login")
    public String loginGet(Model model) {
        model.addAttribute("projectName", "杨双鹏");
        return "login";
    }

    /**
     * 登录
     * @param admin
     * @param model
     * @param httpSession
     * @return
     */
    @PostMapping("/admin/login")
    public String loginPost(Admin admin, Model model, HttpSession httpSession) {
        model.addAttribute("projectName", "杨双鹏");
        Admin adminRes = adminService.findByNameAndPassword(admin);
        if(adminRes != null){
            httpSession.setAttribute("admin", adminRes);
            return "redirect:dashboard";
        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }
    }

    /**
     * 注册
     * @param model
     * @return
     */
    @GetMapping("/admin/register")
    public String register(Model model) {
        model.addAttribute("projectName", "杨双鹏");
        return "register";
    }

    /**
     * 仪表板页面
     * @param model
     * @return
     */
    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }
}
