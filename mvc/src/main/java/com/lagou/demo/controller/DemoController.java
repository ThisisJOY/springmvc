package com.lagou.demo.controller;

import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotations.LagouAutowired;
import com.lagou.edu.mvcframework.annotations.LagouController;
import com.lagou.edu.mvcframework.annotations.LagouRequestMapping;
import com.lagou.edu.mvcframework.annotations.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@LagouController
@LagouRequestMapping("/demo")
@Security({"zhangsan1", "lisi1", "zhangsan2", "lisi2"})
public class DemoController {


    @LagouAutowired
    private IDemoService demoService;


    /**
     * URL: /demo/handle01?username=zhangsan1
     *
     * @param request
     * @param response
     * @param username
     * @return
     */
    @LagouRequestMapping("/handle01")
    @Security({"zhangsan1", "lisi1"})
    public String handle01(HttpServletRequest request, HttpServletResponse response, String username) {
        return demoService.get(username);
    }


    /**
     * URL: /demo/handle02?username=zhangsan2
     *
     * @param request
     * @param response
     * @param username
     * @return
     */
    @LagouRequestMapping("/handle02")
    @Security({"zhangsan2", "lisi2"})
    public String handle02(HttpServletRequest request, HttpServletResponse response, String username) {
        return demoService.get(username);
    }
}
