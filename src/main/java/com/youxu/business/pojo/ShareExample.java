package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShareUserIdIsNull() {
            addCriterion("share_user_id is null");
            return (Criteria) this;
        }

        public Criteria andShareUserIdIsNotNull() {
            addCriterion("share_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andShareUserIdEqualTo(Integer value) {
            addCriterion("share_user_id =", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdNotEqualTo(Integer value) {
            addCriterion("share_user_id <>", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdGreaterThan(Integer value) {
            addCriterion("share_user_id >", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_user_id >=", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdLessThan(Integer value) {
            addCriterion("share_user_id <", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("share_user_id <=", value, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdIn(List<Integer> values) {
            addCriterion("share_user_id in", values, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdNotIn(List<Integer> values) {
            addCriterion("share_user_id not in", values, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdBetween(Integer value1, Integer value2) {
            addCriterion("share_user_id between", value1, value2, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andShareUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("share_user_id not between", value1, value2, "shareUserId");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityIsNull() {
            addCriterion("period_of_validity is null");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityIsNotNull() {
            addCriterion("period_of_validity is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityEqualTo(Date value) {
            addCriterion("period_of_validity =", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityNotEqualTo(Date value) {
            addCriterion("period_of_validity <>", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityGreaterThan(Date value) {
            addCriterion("period_of_validity >", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityGreaterThanOrEqualTo(Date value) {
            addCriterion("period_of_validity >=", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityLessThan(Date value) {
            addCriterion("period_of_validity <", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityLessThanOrEqualTo(Date value) {
            addCriterion("period_of_validity <=", value, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityIn(List<Date> values) {
            addCriterion("period_of_validity in", values, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityNotIn(List<Date> values) {
            addCriterion("period_of_validity not in", values, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityBetween(Date value1, Date value2) {
            addCriterion("period_of_validity between", value1, value2, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andPeriodOfValidityNotBetween(Date value1, Date value2) {
            addCriterion("period_of_validity not between", value1, value2, "periodOfValidity");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusIsNull() {
            addCriterion("extaction_code_status is null");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusIsNotNull() {
            addCriterion("extaction_code_status is not null");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusEqualTo(Boolean value) {
            addCriterion("extaction_code_status =", value, "extactionCodeStatus");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusNotEqualTo(Boolean value) {
            addCriterion("extaction_code_status <>", value, "extactionCodeStatus");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusGreaterThan(Boolean value) {
            addCriterion("extaction_code_status >", value, "extactionCodeStatus");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("extaction_code_status >=", value, "extactionCodeStatus");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusLessThan(Boolean value) {
            addCriterion("extaction_code_status <", value, "extactionCodeStatus");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("extaction_code_status <=", value, "extactionCodeStatus");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusIn(List<Boolean> values) {
            addCriterion("extaction_code_status in", values, "extactionCodeStatus");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusNotIn(List<Boolean> values) {
            addCriterion("extaction_code_status not in", values, "extactionCodeStatus");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("extaction_code_status between", value1, value2, "extactionCodeStatus");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("extaction_code_status not between", value1, value2, "extactionCodeStatus");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeIsNull() {
            addCriterion("extaction_code is null");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeIsNotNull() {
            addCriterion("extaction_code is not null");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeEqualTo(String value) {
            addCriterion("extaction_code =", value, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeNotEqualTo(String value) {
            addCriterion("extaction_code <>", value, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeGreaterThan(String value) {
            addCriterion("extaction_code >", value, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("extaction_code >=", value, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeLessThan(String value) {
            addCriterion("extaction_code <", value, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeLessThanOrEqualTo(String value) {
            addCriterion("extaction_code <=", value, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeLike(String value) {
            addCriterion("extaction_code like", value, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeNotLike(String value) {
            addCriterion("extaction_code not like", value, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeIn(List<String> values) {
            addCriterion("extaction_code in", values, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeNotIn(List<String> values) {
            addCriterion("extaction_code not in", values, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeBetween(String value1, String value2) {
            addCriterion("extaction_code between", value1, value2, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andExtactionCodeNotBetween(String value1, String value2) {
            addCriterion("extaction_code not between", value1, value2, "extactionCode");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusIsNull() {
            addCriterion("download_duplicated_print_status is null");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusIsNotNull() {
            addCriterion("download_duplicated_print_status is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusEqualTo(Boolean value) {
            addCriterion("download_duplicated_print_status =", value, "downloadDuplicatedPrintStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusNotEqualTo(Boolean value) {
            addCriterion("download_duplicated_print_status <>", value, "downloadDuplicatedPrintStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusGreaterThan(Boolean value) {
            addCriterion("download_duplicated_print_status >", value, "downloadDuplicatedPrintStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("download_duplicated_print_status >=", value, "downloadDuplicatedPrintStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusLessThan(Boolean value) {
            addCriterion("download_duplicated_print_status <", value, "downloadDuplicatedPrintStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("download_duplicated_print_status <=", value, "downloadDuplicatedPrintStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusIn(List<Boolean> values) {
            addCriterion("download_duplicated_print_status in", values, "downloadDuplicatedPrintStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusNotIn(List<Boolean> values) {
            addCriterion("download_duplicated_print_status not in", values, "downloadDuplicatedPrintStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("download_duplicated_print_status between", value1, value2, "downloadDuplicatedPrintStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("download_duplicated_print_status not between", value1, value2, "downloadDuplicatedPrintStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyIsNull() {
            addCriterion("download_duplicated_print_money is null");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyIsNotNull() {
            addCriterion("download_duplicated_print_money is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyEqualTo(Double value) {
            addCriterion("download_duplicated_print_money =", value, "downloadDuplicatedPrintMoney");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyNotEqualTo(Double value) {
            addCriterion("download_duplicated_print_money <>", value, "downloadDuplicatedPrintMoney");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyGreaterThan(Double value) {
            addCriterion("download_duplicated_print_money >", value, "downloadDuplicatedPrintMoney");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("download_duplicated_print_money >=", value, "downloadDuplicatedPrintMoney");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyLessThan(Double value) {
            addCriterion("download_duplicated_print_money <", value, "downloadDuplicatedPrintMoney");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyLessThanOrEqualTo(Double value) {
            addCriterion("download_duplicated_print_money <=", value, "downloadDuplicatedPrintMoney");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyIn(List<Double> values) {
            addCriterion("download_duplicated_print_money in", values, "downloadDuplicatedPrintMoney");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyNotIn(List<Double> values) {
            addCriterion("download_duplicated_print_money not in", values, "downloadDuplicatedPrintMoney");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyBetween(Double value1, Double value2) {
            addCriterion("download_duplicated_print_money between", value1, value2, "downloadDuplicatedPrintMoney");
            return (Criteria) this;
        }

        public Criteria andDownloadDuplicatedPrintMoneyNotBetween(Double value1, Double value2) {
            addCriterion("download_duplicated_print_money not between", value1, value2, "downloadDuplicatedPrintMoney");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNull() {
            addCriterion("qr_code is null");
            return (Criteria) this;
        }

        public Criteria andQrCodeIsNotNull() {
            addCriterion("qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andQrCodeEqualTo(String value) {
            addCriterion("qr_code =", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotEqualTo(String value) {
            addCriterion("qr_code <>", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThan(String value) {
            addCriterion("qr_code >", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("qr_code >=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThan(String value) {
            addCriterion("qr_code <", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLessThanOrEqualTo(String value) {
            addCriterion("qr_code <=", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeLike(String value) {
            addCriterion("qr_code like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotLike(String value) {
            addCriterion("qr_code not like", value, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeIn(List<String> values) {
            addCriterion("qr_code in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotIn(List<String> values) {
            addCriterion("qr_code not in", values, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeBetween(String value1, String value2) {
            addCriterion("qr_code between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andQrCodeNotBetween(String value1, String value2) {
            addCriterion("qr_code not between", value1, value2, "qrCode");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageIsNull() {
            addCriterion("usre_head_image is null");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageIsNotNull() {
            addCriterion("usre_head_image is not null");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageEqualTo(String value) {
            addCriterion("usre_head_image =", value, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageNotEqualTo(String value) {
            addCriterion("usre_head_image <>", value, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageGreaterThan(String value) {
            addCriterion("usre_head_image >", value, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageGreaterThanOrEqualTo(String value) {
            addCriterion("usre_head_image >=", value, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageLessThan(String value) {
            addCriterion("usre_head_image <", value, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageLessThanOrEqualTo(String value) {
            addCriterion("usre_head_image <=", value, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageLike(String value) {
            addCriterion("usre_head_image like", value, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageNotLike(String value) {
            addCriterion("usre_head_image not like", value, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageIn(List<String> values) {
            addCriterion("usre_head_image in", values, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageNotIn(List<String> values) {
            addCriterion("usre_head_image not in", values, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageBetween(String value1, String value2) {
            addCriterion("usre_head_image between", value1, value2, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andUsreHeadImageNotBetween(String value1, String value2) {
            addCriterion("usre_head_image not between", value1, value2, "usreHeadImage");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}