package com.zuson.demo.strawVideo.service.impl;


import com.github.pagehelper.util.StringUtil;
import com.zuson.demo.strawVideo.service.SVService;
import org.apache.axis.client.Call;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.rpc.ServiceException;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.util.List;

@Service
public class SVServiceImpl implements SVService {

    @Value("${webService.endPort}")
    String endPoint;
    @Value("${webService.targetNamespace}")
    String targetNamespace;
    @Value("${webService.ip}")
    String ip;
    @Value("${webService.userName}")
    String userName;
    @Value("${webService.password}")
    String pwd;

    private static String TGT = null; //用户票据
    private static String TOKEN = null; //令牌

    public void SdkLogin() {
        LogUtils.info("LoginUtil ==>SdkLogin ====>[START] ");
        String operationName = "sdkLogin";//登陆方法
        String[] login={"loginAccount","password","serviceIp","clientIp","clientMac"};//登陆参数
        LogUtils.info("endpoint:"+endPoint);
        LogUtils.info("targetNamespace:"+targetNamespace);
        LogUtils.info("userName:"+userName);
        LogUtils.info("pwd:"+pwd);
        LogUtils.info("ip:"+ip);
        Call call= null;
        try {
            call = WebServiceUtil.GetWebServiceCall(endPoint,targetNamespace,operationName,login);
        } catch (ServiceException e) {
            LogUtils.error("call方法异常"+ExceptionUtils.getStackTraceAsString(e));
        }
        String xml= null;
        try {
            xml = (String) call.invoke(new Object[]{userName,pwd,ip,"",""});
        } catch (RemoteException e) {
            LogUtils.error("xml方法异常"+ExceptionUtils.getStackTraceAsString(e));
        }
        if (StringUtil.isNotEmpty(xml)) {
            List<Element> elementList= null;
            try {
                elementList = WebServiceUtil.XmlToElement(xml);
            } catch (Exception e) {
                LogUtils.error("elementList方法异常"+ExceptionUtils.getStackTraceAsString(e));
            }
            for(Element ele:elementList){
                TGT=ele.attribute("tgt").getValue();
            }
        }
        LogUtils.info("LoginUtil <==SdkLogin ====>[END] ");
    }
    @Override
    public String applyToken()  throws Exception {
        LogUtils.info("====开始获取登陆的token======");
        LogUtils.info("tgt:"+TGT);
        if (StringUtil.isEmpty(TGT)){
            SdkLogin();
        }
        String token = null;
        String operationName = "applyToken";//登陆方法
        String[] login={"tgt"};//登陆参数
        Call call= WebServiceUtil.GetWebServiceCall(endPoint,targetNamespace,operationName,login);
        String xml=(String) call.invoke(new Object[]{TGT});
        if(StringUtil.isNotEmpty(xml)){
            List<Element> elementList=WebServiceUtil.XmlToElement(xml);
            for(Element ele:elementList){
                token=ele.attribute("st").getValue();
            }
        }
        TOKEN = token;
        LogUtils.info("登录token获取成功token："+token);
        return token;
    }

    @Override
    public String getPreviewOcxOptions(String pointCode) {
        //获取token
        String token = null;
        try {
            token = applyToken();
        } catch (Exception e) {
            LogUtils.error("token获取失败"+ ExceptionUtils.getStackTraceAsString(e));
            return "token获取失败，请检查！";
        }
        if (StringUtil.isEmpty(TOKEN)){
            return "令牌获取失败！";
        }
        String operationName = "getPreviewOcxOptions";//获取预览控件取流xml 的方法名
        String[] paramsArr={"token","cameraIndexCode","clientIp"};//传入参数名称
        Call call= null;
        String xml = null;
        try {
            call = WebServiceUtil.GetWebServiceCall(endPoint,targetNamespace,operationName,paramsArr);
            xml=(String) call.invoke(new Object[]{token,pointCode,ip});
            LogUtils.info("获取的xml文件："+xml);
        } catch (Exception e) {
            LogUtils.error("获取预览的xml失败"+ExceptionUtils.getStackTraceAsString(e));
            return "获取预览xml失败！";
        }
        return xml;
    }

}
