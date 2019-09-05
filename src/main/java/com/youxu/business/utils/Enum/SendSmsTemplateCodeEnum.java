package com.youxu.business.utils.Enum;

public enum SendSmsTemplateCodeEnum {
    /**
     * 提供给发送验证码的模板
     */
    IDENTITYVERIFICATION("IDENTITYVERIFICATION","SMS_164416085"),
    LOGINAUTHENTICATION("LOGINAUTHENTICATION","SMS_164416084"),
    LOGINEXCEPTION("LOGINEXCEPTION","SMS_164416083"),
    REGISTER("REGISTER","SMS_164416082"),
    MODIFYPASSWORD("MODIFYPASSWORD","SMS_164416081"),
    INFORMATIONCHANGE("INFORMATIONCHANGE","SMS_164416080");
    private String TemplateCodekey;
    private String TemplateCodeValue;


    SendSmsTemplateCodeEnum(String templateCodekey, String templateCodeValue) {
        TemplateCodekey = templateCodekey;
        TemplateCodeValue = templateCodeValue;
    }

    public String getTemplateCodekey() {
        return TemplateCodekey;
    }

    public void setTemplateCodekey(String templateCodekey) {
        TemplateCodekey = templateCodekey;
    }

    public String getTemplateCodeValue() {
        return TemplateCodeValue;
    }

    public void setTemplateCodeValue(String templateCodeValue) {
        TemplateCodeValue = templateCodeValue;
    }
}
