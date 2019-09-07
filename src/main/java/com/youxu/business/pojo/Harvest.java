package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Harvest extends PageInfo{
    private Integer id;

    private Integer userId;

    private String harvestAddressName;

    private String harvestAddressMobilePhone;

    private String harvestAddressReceivingAddress;

    private Boolean harvestAddressDefaultAddress;

    private Date harvestAddressCreateTime;

    private Date harvestAddressModifyTime;

    private Boolean harvestAddressStatus;

    private Integer distributionCategory;


}