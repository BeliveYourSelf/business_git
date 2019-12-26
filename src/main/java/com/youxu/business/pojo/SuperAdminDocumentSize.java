package com.youxu.business.pojo;

public class SuperAdminDocumentSize {
    private Integer documentSizeId;

    private String documentSize;

    private Boolean documentSizeStatus;

    private Integer isBinding;

    public Integer getDocumentSizeId() {
        return documentSizeId;
    }

    public void setDocumentSizeId(Integer documentSizeId) {
        this.documentSizeId = documentSizeId;
    }

    public String getDocumentSize() {
        return documentSize;
    }

    public void setDocumentSize(String documentSize) {
        this.documentSize = documentSize == null ? null : documentSize.trim();
    }

    public Boolean getDocumentSizeStatus() {
        return documentSizeStatus;
    }

    public void setDocumentSizeStatus(Boolean documentSizeStatus) {
        this.documentSizeStatus = documentSizeStatus;
    }

    public Integer getIsBinding() {
        return isBinding;
    }

    public void setIsBinding(Integer isBinding) {
        this.isBinding = isBinding;
    }
}