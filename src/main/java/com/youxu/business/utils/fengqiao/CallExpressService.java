package com.youxu.business.utils.fengqiao;

import com.sf.csim.express.service.CallExpressServiceTools;
import com.youxu.business.pojo.Order;
import com.youxu.business.pojo.Store;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 顺丰-丰桥
 */
public class CallExpressService {
    /**
     * 下单
     */
    public Boolean insertSFOrder(Order order,Store store) {
        String reqXml = "";
        try {
            @SuppressWarnings("resource")
            InputStream is = new FileInputStream("src\\main\\java\\com\\youxu\\business\\utils\\fengqiao\\callExpressRequest\\1.order.txt");//下订单
            byte[] bs = new byte[is.available()];
            is.read(bs);
            reqXml = new String(bs);
        } catch (Exception e) {
        }

        //丰桥平台公共测试账号
        //SLKJ2019
        //FBIqMkZjzxbsZgo7jTpeq7PD8CVzLT4Q
        String reqURL = "https://bsp-oisp.sf-express.com/bsp-oisp/sfexpressService";
        String clientCode = "YXKJ_rwMKJ";//此处替换为您在丰桥平台获取的顾客编码
        String checkword = "E7colmyWpyJG77wr4LnUSkYjXTETJZrp";//此处替换为您在丰桥平台获取的校验码
        CallExpressServiceTools client = CallExpressServiceTools.getInstance();
        // 替换txt中的文件参数
        String myReqXML = replace(order, reqXml, store);
        System.out.println("请求报文：" + myReqXML);
        String respXml = client.callSfExpressServiceByCSIM(reqURL, myReqXML, clientCode, checkword);

        if (respXml != null) {
            System.out.println("--------------------------------------");
            System.out.println("返回报文: " + respXml);
            System.out.println("--------------------------------------");
        }
        return true;
    }

    private String replace(Order order, String reqXml, Store store) {

        reqXml = reqXml.replace("SLKJ2019", "YXKJ_rwMKJ");
        reqXml = reqXml.replace("QIAO-20180104001", order.getId().toString());
        reqXml = reqXml.replace("神罗科技", order.getOrderAddresseeAddress());
        reqXml = reqXml.replace("风一样的旭哥", order.getOrderAddresseeName());
        reqXml = reqXml.replace("33992159", order.getOrderAddresseePhone());
        reqXml = reqXml.replace("海珠区宝芝林大厦701室", order.getOrderAddresseeAddress());
        reqXml = reqXml.replace("iphone 7 plus", replenish(order.getOrderType())); //订单类别：1.证件照2.照片冲洗3.文档打印4.会员充值5.会员支付

        reqXml = reqXml.replace("顺丰镖局", store.getStoreName());
        reqXml = reqXml.replace("虾哥", store.getContactName());
        reqXml = reqXml.replace("15012345678", store.getStorePhone());
        reqXml = reqXml.replace("福田区新洲十一街万基商务大厦26楼", store.getStoreAddress());

        return reqXml;
    }
    private String replenish(Integer orderType){
        switch (orderType) {
            case 1:
                return "证件照";
            case 2:
                return "照片冲洗";
            case 3:
                return "文档打印";
            case 4:
                return "会员充值";
            case 5:
                return "会员支付";
        }
        return "文件";
    }
}
