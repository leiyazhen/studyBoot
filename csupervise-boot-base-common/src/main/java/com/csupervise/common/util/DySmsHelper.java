package com.csupervise.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;


/**
 * Created on 17/6/7.
 * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dysmsapi.jar
 *
 * 备注:Demo工程编码采用UTF-8
 * 国际短信发送请勿参照此DEMO
 */
public class DySmsHelper {
	
	private final static Logger logger=LoggerFactory.getLogger(DySmsHelper.class);

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static  String accessKeyId;
    static  String accessKeySecret;

    public static void setAccessKeyId(String accessKeyId) {
        DySmsHelper.accessKeyId = accessKeyId;
    }

    public static void setAccessKeySecret(String accessKeySecret) {
        DySmsHelper.accessKeySecret = accessKeySecret;
    }

    public static String getAccessKeyId() {
        return accessKeyId;
    }

    public static String getAccessKeySecret() {
        return accessKeySecret;
    }
    
    
    public static boolean sendSms(String phone,JSONObject templateParamJson,DySmsEnum dySmsEnum)  {
    	//可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        boolean result = false;

        return result;
        
    }
    
    private static void validateParam(JSONObject templateParamJson,DySmsEnum dySmsEnum) {
    	String keys = dySmsEnum.getKeys();
    	String [] keyArr = keys.split(",");
    	for(String item :keyArr) {
    		if(!templateParamJson.containsKey(item)) {
    			throw new RuntimeException("模板缺少参数："+item);
    		}
    	}
    }
    

}
