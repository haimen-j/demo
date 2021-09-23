package com.zuson.demo.websocketutil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@RequestMapping("/WebSoketDemo")
@RestController
public class WebSoketDemo {

  @RequestMapping("/sendMsg")
  public void sendMsg(HttpServletRequest request){
      String id = request.getParameter("id");
      String msg = request.getParameter("msg");
      try {
          WebSocketServer.sendInfo(msg,id);
      } catch (IOException e) {
          e.printStackTrace();
      }
  }


}
