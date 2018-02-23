package com.tongyuan.distributeFrame.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageInfo;
import com.tongyuan.distributeFrame.base.BaseController;
import com.tongyuan.distributeFrame.demo.entity.User;
import com.tongyuan.distributeFrame.demo.service.UserService;
import com.tongyuan.distributeFrame.util.InstanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by zhangcy on 2018/2/22
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    /*
    分页返回username开头匹配为str的user
     */
    @PostMapping("/query")
    @ResponseBody
    public Map<String,Object> queryPage(@RequestBody Map<String,Object> param){
        PageInfo<User> pageInfo = userService.queryUserPageByName(param);
        return setResponse(pageInfo);
    }
}