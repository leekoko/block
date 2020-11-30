package com.leekoko.block.meituan;

import cn.hutool.core.date.DateUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiCha {

    /**
     * 获取美团数据，转化加密数字
     */
    HashMap<String, String> numEncryptMap = new HashMap<String, String>(){
        {
            put("&#xf8ce;","0");
            put("&#xf66b;","1");
            put("&#xe53a;","2");
            put("&#xf3c0;","3");
            put("&#xf533;","4");
            put("&#xe78b;","5");
            put("&#xf515;","6");
            put("&#xebd0;","7");
            put("&#xee6c;","8");
            put("&#xe0c2;","9");
        }
    };
    HashMap<String, String> numEncryptMap2 = new HashMap<String, String>(){
        {
            put("&#xe09d;","0");
            put("&#xe1ce;","1");
            put("&#xf77a;","2");
            put("&#xebeb;","3");
            put("&#xe6ef;","4");
            put("&#xf22b;","5");
            put("&#xf6c9;","6");
            put("&#xf25b;","7");
            put("&#xe01b;","8");
            put("&#xea58;","9");
        }
    };
    HashMap<String, String> numEncryptMap3 = new HashMap<String, String>(){
        {
            put("&#xead2;","0");
            put("&#xf5bb;","1");
            put("&#xefb7;","2");
            put("&#xe71d;","3");
            put("&#xf89f;","4");
            put("&#xe877;","5");
            put("&#xf3e0;","6");
            put("？？？","7");
            put("&#xe795;","8");
            put("&#xef15;","9");
        }
    };


    @Test
    public void parseData() throws SQLException {
        String formerData = "{\"data\":{\"poiTotalNum\":0,\"poiHasNextPage\":false,\"nextStartIndex\":8,\"shopList\":[{\"mtWmPoiId\":\"1000917574264221\",\"shopName\":\"荣诚饼家（东山店）\",\"wmPoiScore\":49,\"monthSalesTip\":\"月售&#xea58;&#xe09d;&#xe09d;+\",\"picUrl\":\"http://p1.meituan.net/waimaipoi/1b5c7332d56dd2ff42f77407dc8d3e6649471.jpg@180w_132h_1e_1c\",\"poiTypeIcon\":\"\",\"deliveryTimeTip\":\"&#xebeb;&#xe09d;分钟\",\"deliveryType\":1,\"minPriceTip\":\"起送 ¥&#xe1ce;&#xf22b;\",\"shippingFeeTip\":\"配送 ¥&#xe6ef;.&#xf22b;\",\"origin_shipping_fee_tip\":\"\",\"status\":3,\"statusDesc\":\"休息中\",\"distance\":\"&#xebeb;.&#xe09d;km\",\"averagePriceTip\":\"人均 ¥&#xebeb;&#xe09d;\",\"discounts2\":[{\"info\":\"满36减9\",\"iconUrl\":\"http://p0.meituan.net/activityconfig/6087b33fd42d14fd94e899084aaef56d1720.png\",\"promotionType\":2,\"activityId\":2}],\"address\":\"\",\"shipping_time\":\"\"},{\"mtWmPoiId\":\"923346169908577\",\"shopName\":\"热带猫（烘焙·冷饮·下午茶）\",\"wmPoiScore\":48,\"monthSalesTip\":\"月售&#xe1ce;&#xe09d;&#xe09d;+\",\"picUrl\":\"http://p1.meituan.net/business/82089913650a0cbd7f09638fab798c91161633.jpg@180w_132h_1e_1c\",\"poiTypeIcon\":\"\",\"deliveryTimeTip\":\"&#xebeb;&#xe09d;分钟\",\"deliveryType\":1,\"minPriceTip\":\"起送 ¥&#xe1ce;&#xf22b;\",\"shippingFeeTip\":\"配送 ¥&#xe6ef;.&#xf22b;\",\"origin_shipping_fee_tip\":\"\",\"status\":3,\"statusDesc\":\"休息中\",\"distance\":\"&#xe1ce;.&#xe01b;km\",\"averagePriceTip\":\"人均 ¥&#xebeb;&#xe1ce;\",\"address\":\"\",\"shipping_time\":\"\"},{\"mtWmPoiId\":\"1111882349309095\",\"shopName\":\"平北池仔鲎粿\",\"wmPoiScore\":0,\"monthSalesTip\":\"月售&#xe1ce;&#xebeb;\",\"picUrl\":\"http://p1.meituan.net/waimaipoi/94a602febf1d1887e370d4381c753195498733.jpg@180w_132h_1e_1c\",\"poiTypeIcon\":\"\",\"deliveryTimeTip\":\"&#xebeb;&#xe09d;分钟\",\"deliveryType\":1,\"minPriceTip\":\"起送 ¥&#xe1ce;&#xf22b;\",\"shippingFeeTip\":\"配送 ¥&#xe6ef;\",\"origin_shipping_fee_tip\":\"\",\"status\":3,\"statusDesc\":\"休息中\",\"distance\":\"&#xf77a;.&#xe1ce;km\",\"averagePriceTip\":\"人均 ¥&#xf77a;&#xf6c9;\",\"address\":\"\",\"shipping_time\":\"\"}],\"judasData\":{\"rankTraceId\":\"B84DF8F0D0EC1FC92F3C2DC8B3E503EE\"}},\"code\":0,\"msg\":\"成功\"}\n";
        JSONObject jsonObject = new JSONObject(formerData);
        JSONObject dataObj = (JSONObject)jsonObject.getObj("data");
        JSONArray shopList = (JSONArray) dataObj.getObj("shopList");
        for (Object obj : shopList) {
            ShopObj shopObj = JSONUtil.toBean((JSONObject) obj, ShopObj.class, true);
            System.out.println(shopObj.getShopName());
            if(handlerNumEncrypt(shopObj.getMinPriceTip()).length() > 8){
                System.out.println("金额转化错误");
                return;
            }
            Db.use().insert(Entity.create("shop").set("shop_Name",shopObj.getShopName())
                    .set("month_Sales_Tip",handlerNumEncrypt(shopObj.getMonthSalesTip()))
                    .set("min_Price_Tip", handlerNumEncrypt(shopObj.getMinPriceTip()))
                    .set("average_Price_Tip",handlerNumEncrypt(shopObj.getAveragePriceTip()))
                    .set("del_flag",0)
                    .set("createDate", DateUtil.now()).set("creator","leekoko"));
        }

        System.out.println(1);
    }

    private String handlerNumEncrypt(String oldNumStr){
        List<HashMap<String, String>> mapList = new ArrayList<HashMap<String, String>>(){{
            add(numEncryptMap);
            add(numEncryptMap2);
            add(numEncryptMap3);
        }};
        for (HashMap<String, String> numEncryptMap : mapList) {
            for (String key : numEncryptMap.keySet()) {
                oldNumStr = oldNumStr.replaceAll(key, numEncryptMap.get(key));
            }
        }
        return oldNumStr;
    }
}
