package com.zuson.demo.controller;

import com.zuson.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "测试项目是否搭建成功的接口")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "返回成功！！";
    }

    @ApiOperation(value = "返回两个参数")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name",value = "名称",dataType = "String" ,required = true),
        @ApiImplicitParam(name = "sex",value = "性别 1:男，2:女",dataType = "Integer" ,required = false),
    })
    @PostMapping("/returnTow")
    public Map returnTow(String name,Integer sex){
        Map map = new HashMap<>();
        map.put("name",name);
        map.put("sex",sex==1?"男":"女");
        return map;
    }

    @ApiOperation(value = "测试返回一个对象")
//    @ApiImplicitParam(name = "user" ,value = "用户对象" ,required = true)
    @PutMapping("/user")
    public User getUser(@RequestBody User user){
    System.out.println("接受到的参数："+user);
        return user;
    };

    @RequestMapping("/downFile")
    public void downFile(HttpServletResponse response){
        Map<String, Object> dataMap=new HashMap<String, Object>();
        dataMap.put("time","2020-08-26");
        dataMap.put("reporter","甄亚新");
        dataMap.put("rphone","15101161025");
        dataMap.put("caseSource","微信");
        dataMap.put("caseCode","111111");
        dataMap.put("level","是");
        dataMap.put("recorder","甄亚新");
        dataMap.put("handoutTime","19:09");
        dataMap.put("backTime","19:10");
        dataMap.put("reportContent","测试");
        dataMap.put("receiveUser","admin");
        String doc = DocUtil.createDoc(dataMap, "new交办单模板.xml", "D:\\template\\");
        DocUtil.downloadFile(response,doc);
    }

}
