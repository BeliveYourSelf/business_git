package com.youxu.business.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class SuperAdminDocumentSize {
    private Integer documentSizeId;

    private String documentSize;

    private Boolean documentSizeStatus;
    @JsonIgnore
    private Integer isBinding;


}