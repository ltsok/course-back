package com.lts.course.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lts.course.conf.Access;
import com.lts.course.entity.User;
import com.lts.course.service.IUserService;
import com.lts.course.utils.Result;
import com.lts.course.utils.ResultCode;
import com.lts.course.utils.ResultUtils;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Map;


@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    @Access(operation = "查询单个用户")
    public Result user(@PathVariable("id") String id){
        logger.info("query single user");
        String userId = id;
        User user = this.userService.getById(userId);
        logger.info("ltsok");
        return ResultUtils.success(user);
    }

    @PostMapping()
    @Access(operation = "新增用户")
    public Result save(@RequestBody String params) throws IOException {
        logger.info("add user");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        User user = mapper.readValue(params, User.class);
        Result result = userService.addUser(user);
        return result;
    }

    @PostMapping("/deleteUser")
    @Access(operation = "删除用户")
    public Result delete(@RequestBody String params) throws IOException {
        logger.info("delete user");
        if (params == null || params.length() <= 0) {
            return ResultUtils.warn(ResultCode.PARAMETER_ERROR);
        }
        Result result = userService.deleteUser(params);
        return result;
    }
}
