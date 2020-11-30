package com.leekoko.block.meituan;

import lombok.Data;

@Data
public class ShopObj {

    private String address;
    private String averagePriceTip;
    private String deliveryTimeTip;
    private String deliveryType;
//    private String discounts2;    折扣信息不需要
    private String distance;
    private String minPriceTip;
    private String monthSalesTip;
    private String mtWmPoiId;
    private String origin_shipping_fee_tip;
    private String picUrl;
    private String poiTypeIcon;
    private String shippingFeeTip;
    private String shipping_time;
    private String shopName;
    private String status;
    private String statusDesc;
    private String wmPoiScore;
}
