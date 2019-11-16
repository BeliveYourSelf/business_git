package com.youxu.business.utils.yuntu.yuntupojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResultYuntu {
    @ApiModelProperty(name = "retCode",value = "0.成功  1.处理中   2.失败")
    private Integer retCode;

    @ApiModelProperty(name = "retMsg",value = "当前状态描述信息")
    private String retMsg;

    @ApiModelProperty(name = "docId",value = "文档id")
    private String docId;

    @ApiModelProperty(name = "outputType",value = "文档转换类型：.dwg, .dwt, .dws, .dxf, .rtf, .doc, .docx, .dot, .dotx, .xls, .xlsx, .ppt, .pptx, .pps, .ppsx, .dps, .wps, .wpt, .et, .wpp, .png, .jpg, .gif, .tif, .bmp, .pdf, .txt, .java, .js, .c, .cpp, .html, .htm, .jsp, .css, .xml, .properties, .log")
    private String outputType;

    @ApiModelProperty(name = "docStatusPage",value = "文档状态信息页面url")
    private String docStatusPage;

    @ApiModelProperty(name = "outputURLs",value = "转换生成的结果（仅当retCode为0，返回）")
    private String[] outputURLs;
}
