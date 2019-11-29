package com.youxu.business.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DocumentPrintPriceList {
    @ApiModelProperty(name = "id",value = "订单对象")
    private Integer id;

    @ApiModelProperty(name = "storeId",value = "订单对象")
    private String storeId;

    @ApiModelProperty(name = "documentPrintPriceListCode",value = "文档打印价格表排列组合--弃用     单双面：1.单面2.双面/ 颜色:0黑白 1彩色 ")
    private String documentPrintPriceListCode;

    @ApiModelProperty(name = "documentPrintPriceListCodeBlackAndWhite",value = "文档打印价格表排列组合-黑白      单双面：1.单面  2.双面/      黑白:0黑 1白")
    private List<String> documentPrintPriceListCodeBlackAndWhite;

    @ApiModelProperty(name = "documentPrintPriceListCodeColour",value = "文档打印价格表排列组合-彩色")
    private List<String> documentPrintPriceListCodeColour;

    @ApiModelProperty(name = "documentPrintPriceListPrice",value = "内页价格--弃用")
    private Double documentPrintPriceListPrice;

    @ApiModelProperty(name = "documentPrintPriceListPriceBlackAndWhite",value = "内页价格--黑白单价")
    private Double documentPrintPriceListPriceBlackAndWhite;

    @ApiModelProperty(name = "documentPrintPriceListPriceCodeColour",value = "内页价格--彩色单价")
    private Double documentPrintPriceListPriceCodeColour;

    @ApiModelProperty(name = "documentPrintPriceCover",value = "封面价格--弃用")
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