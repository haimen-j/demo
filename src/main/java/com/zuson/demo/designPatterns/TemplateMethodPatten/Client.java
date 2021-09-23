package com.zuson.demo.designPatterns.TemplateMethodPatten;

import com.zuson.demo.designPatterns.TemplateMethodPatten.TemplateMethod.HummeH1Model;
import com.zuson.demo.designPatterns.TemplateMethodPatten.TemplateMethod.HummeH2Model;
import com.zuson.demo.designPatterns.TemplateMethodPatten.TemplateMethod.HummeModel;

public class Client {

  public static void main(String[] args) {
      //调用h1
      HummeModel humme = new HummeH1Model();
      humme.setAlarmStatus(false);
      humme.run();
  }
}
