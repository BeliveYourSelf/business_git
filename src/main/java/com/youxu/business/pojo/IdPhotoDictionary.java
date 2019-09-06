package com.youxu.business.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class IdPhotoDictionary {
    private Integer id;

    private String idPhotoDictionaryName;

    private Integer idPhotoDictionarySpecId;

    private Double idPhotoDictionaryPrice;

    private Date idPhotoDictionaryCreateTime;

    private Date idPhotoDictionaryModifyTime;

    private Boolean idPhotoDictionaryStatus;


}