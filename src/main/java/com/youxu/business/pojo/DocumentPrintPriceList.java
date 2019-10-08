package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class DocumentPrintPriceList {
    @ApiModelProperty(name = "id",value = "订单对象")
    private Integer id;

    @ApiModelProperty(name = "storeId",value = "订单对象")
    private String storeId;

    @ApiModelProperty(name = "documentPrintPriceListCode",value = "文档打印价格表排列组合")
    private String documentPrintPriceListCode;

    @ApiModelProperty(name = "documentPrintPriceListPrice",value = "内页价格")
    private Double documentPrintPriceListPrice;

    @ApiModelProperty(name = "documentPrintPriceCover",value = "封面价格")
    private Double documentPrintPriceCover;

    @ApiModelProperty(name = "documentPrintPriceListCreateTime",value = "创建时间")
    private Date documentPrintPriceListCreateTime;

    @ApiModelProperty(name = "documentPrintPriceListModifyTime",value = "修改时间")
    private Date documentPrintPriceListModifyTime;

    @ApiModelProperty(name = "documentPrintPriceListStatus",value = "显示状态")
    private Boolean documentPrintPriceListStatus;



    // 新增
    @ApiModelProperty(name = "count",value = "文档打印黑白份数")
    private Integer count;

    @ApiModelProperty(name = "countColour",value = "文档打印彩色份数")
    private Integer countColour;

    @ApiModelProperty(name = "pageNumber",value = "文档页数")
    private Integer pageNumber;

    @ApiModelProperty(name = "totalPrice",value = "总价格")
    private Double totalPrice;

}