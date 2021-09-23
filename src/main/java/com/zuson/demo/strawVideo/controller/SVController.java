package com.zuson.demo.strawVideo.controller;

import com.zuson.demo.strawVideo.service.SVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/SVController")
public class SVController {

    @Autowired
    SVService svService;

    /**
     * 每隔30s获取一次token
     * @return
     * @throws Exception
     */
   /* @Scheduled(cron = "30/0 * * * * ?")
    @RequestMapping("/applyToken")
    public String applyToken()throws Exception{
      return svService.applyToken();
    }*/

    /**
     * 获取预览控件取流XML
     * @param pointCode 监控点编码
     * @return
     */
    @RequestMapping("/getPreviewOcxOptions")
    public String getPreviewOcxOptions(String pointCode){
        return svService.getPreviewOcxOptions(pointCode);
    }
}
