package com.zuson.demo.strawVideo.service.impl;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.util.Iterator;
import java.util.List;

/**
 * @type: AuditCustomerController
 * @company: 立东生态
 * @author: zxj
 * @Date: 2019年11月23日
 * @Description:
 */



public class WebServiceUtil {

    public static Call GetWebServiceCall(String endpoint, String targetNamespace, String operationName, String[] paramsArr) throws ServiceException {
        // 定义service对象
        Service service = new Service();
        // 创建一个call对象
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(endpoint);
        // 设置目标地址，即webservice路径
        // 设置操作名称，即方法名称   http://WebXml.com.cn/
        call.setOperationName(new QName(targetNamespace,operationName));
        // 设置方法参数1
        for(String param:paramsArr){
            call.addParameter( new QName(targetNamespace,param),
                    XMLType.XSD_INT,
                   ParameterMode.IN);
        }
        call.setReturnClass(String.class);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI(targetNamespace+operationName);
        return call;
    }


    public static List<Element> XmlToElement(String xmlStr) throws Exception {
        LogUtils.info("============XmlToElement====[START]====");
        Document document = DocumentHelper.parseText(xmlStr);//解析xml文件
        Element root = document.getRootElement();
        List<Element> elements = root.elements("rows");
        for (Iterator<Element> it = elements.iterator(); it.hasNext();) {
            Element element = it.next();
            List<Element> elementList= element.elements();
            return elementList;
        }
        LogUtils.info("============XmlToElement====[END]====");
        return null;
    }

}
