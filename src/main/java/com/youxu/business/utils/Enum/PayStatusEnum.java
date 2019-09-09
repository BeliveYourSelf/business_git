package com.youxu.business.utils.Enum;

public enum PayStatusEnum {
    WAIT_PAY("WAIT_PAY",1),PAYING("PAYING",2),COMPLETE("COMPLETE",3),CANCEL("CANCEL",4);
    private String code;
    private Integer valueCode;
     PayStatusEnum(String code, Integer valueCode) {
        this.code = code;
        this.valueCode = valueCode;
    }

    public String getCode() {
        return code;
    }
    public Integer getValueCode() {
        return valueCode;
    }
}
