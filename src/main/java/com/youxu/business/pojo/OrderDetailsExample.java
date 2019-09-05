package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDetailsExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameIsNull() {
            addCriterion("order_details_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameIsNotNull() {
            addCriterion("order_details_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameEqualTo(String value) {
            addCriterion("order_details_name =", value, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameNotEqualTo(String value) {
            addCriterion("order_details_name <>", value, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameGreaterThan(String value) {
            addCriterion("order_details_name >", value, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_details_name >=", value, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameLessThan(String value) {
            addCriterion("order_details_name <", value, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameLessThanOrEqualTo(String value) {
            addCriterion("order_details_name <=", value, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameLike(String value) {
            addCriterion("order_details_name like", value, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameNotLike(String value) {
            addCriterion("order_details_name not like", value, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameIn(List<String> values) {
            addCriterion("order_details_name in", values, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameNotIn(List<String> values) {
            addCriterion("order_details_name not in", values, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameBetween(String value1, String value2) {
            addCriterion("order_details_name between", value1, value2, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNameNotBetween(String value1, String value2) {
            addCriterion("order_details_name not between", value1, value2, "orderDetailsName");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountIsNull() {
            addCriterion("order_details_count is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountIsNotNull() {
            addCriterion("order_details_count is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountEqualTo(Integer value) {
            addCriterion("order_details_count =", value, "orderDetailsCount");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountNotEqualTo(Integer value) {
            addCriterion("order_details_count <>", value, "orderDetailsCount");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountGreaterThan(Integer value) {
            addCriterion("order_details_count >", value, "orderDetailsCount");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_details_count >=", value, "orderDetailsCount");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountLessThan(Integer value) {
            addCriterion("order_details_count <", value, "orderDetailsCount");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountLessThanOrEqualTo(Integer value) {
            addCriterion("order_details_count <=", value, "orderDetailsCount");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountIn(List<Integer> values) {
            addCriterion("order_details_count in", values, "orderDetailsCount");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountNotIn(List<Integer> values) {
            addCriterion("order_details_count not in", values, "orderDetailsCount");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountBetween(Integer value1, Integer value2) {
            addCriterion("order_details_count between", value1, value2, "orderDetailsCount");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("order_details_count not between", value1, value2, "orderDetailsCount");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlIsNull() {
            addCriterion("order_details_one_picture_url is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlIsNotNull() {
            addCriterion("order_details_one_picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlEqualTo(String value) {
            addCriterion("order_details_one_picture_url =", value, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlNotEqualTo(String value) {
            addCriterion("order_details_one_picture_url <>", value, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlGreaterThan(String value) {
            addCriterion("order_details_one_picture_url >", value, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("order_details_one_picture_url >=", value, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlLessThan(String value) {
            addCriterion("order_details_one_picture_url <", value, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlLessThanOrEqualTo(String value) {
            addCriterion("order_details_one_picture_url <=", value, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlLike(String value) {
            addCriterion("order_details_one_picture_url like", value, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlNotLike(String value) {
            addCriterion("order_details_one_picture_url not like", value, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlIn(List<String> values) {
            addCriterion("order_details_one_picture_url in", values, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlNotIn(List<String> values) {
            addCriterion("order_details_one_picture_url not in", values, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlBetween(String value1, String value2) {
            addCriterion("order_details_one_picture_url between", value1, value2, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsOnePictureUrlNotBetween(String value1, String value2) {
            addCriterion("order_details_one_picture_url not between", value1, value2, "orderDetailsOnePictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlIsNull() {
            addCriterion("order_details_typesetting_picture_url is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlIsNotNull() {
            addCriterion("order_details_typesetting_picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlEqualTo(String value) {
            addCriterion("order_details_typesetting_picture_url =", value, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlNotEqualTo(String value) {
            addCriterion("order_details_typesetting_picture_url <>", value, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlGreaterThan(String value) {
            addCriterion("order_details_typesetting_picture_url >", value, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("order_details_typesetting_picture_url >=", value, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlLessThan(String value) {
            addCriterion("order_details_typesetting_picture_url <", value, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("order_details_typesetting_picture_url <=", value, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlLike(String value) {
            addCriterion("order_details_typesetting_picture_url like", value, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlNotLike(String value) {
            addCriterion("order_details_typesetting_picture_url not like", value, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlIn(List<String> values) {
            addCriterion("order_details_typesetting_picture_url in", values, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlNotIn(List<String> values) {
            addCriterion("order_details_typesetting_picture_url not in", values, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlBetween(String value1, String value2) {
            addCriterion("order_details_typesetting_picture_url between", value1, value2, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTypesettingPictureUrlNotBetween(String value1, String value2) {
            addCriterion("order_details_typesetting_picture_url not between", value1, value2, "orderDetailsTypesettingPictureUrl");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceIsNull() {
            addCriterion("order_details_total_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceIsNotNull() {
            addCriterion("order_details_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceEqualTo(Double value) {
            addCriterion("order_details_total_price =", value, "orderDetailsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceNotEqualTo(Double value) {
            addCriterion("order_details_total_price <>", value, "orderDetailsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceGreaterThan(Double value) {
            addCriterion("order_details_total_price >", value, "orderDetailsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("order_details_total_price >=", value, "orderDetailsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceLessThan(Double value) {
            addCriterion("order_details_total_price <", value, "orderDetailsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceLessThanOrEqualTo(Double value) {
            addCriterion("order_details_total_price <=", value, "orderDetailsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceIn(List<Double> values) {
            addCriterion("order_details_total_price in", values, "orderDetailsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceNotIn(List<Double> values) {
            addCriterion("order_details_total_price not in", values, "orderDetailsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceBetween(Double value1, Double value2) {
            addCriterion("order_details_total_price between", value1, value2, "orderDetailsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsTotalPriceNotBetween(Double value1, Double value2) {
            addCriterion("order_details_total_price not between", value1, value2, "orderDetailsTotalPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeIsNull() {
            addCriterion("order_details_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeIsNotNull() {
            addCriterion("order_details_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeEqualTo(Date value) {
            addCriterion("order_details_create_time =", value, "orderDetailsCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeNotEqualTo(Date value) {
            addCriterion("order_details_create_time <>", value, "orderDetailsCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeGreaterThan(Date value) {
            addCriterion("order_details_create_time >", value, "orderDetailsCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_details_create_time >=", value, "orderDetailsCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeLessThan(Date value) {
            addCriterion("order_details_create_time <", value, "orderDetailsCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_details_create_time <=", value, "orderDetailsCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeIn(List<Date> values) {
            addCriterion("order_details_create_time in", values, "orderDetailsCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeNotIn(List<Date> values) {
            addCriterion("order_details_create_time not in", values, "orderDetailsCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_details_create_time between", value1, value2, "orderDetailsCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_details_create_time not between", value1, value2, "orderDetailsCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeIsNull() {
            addCriterion("order_details_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeIsNotNull() {
            addCriterion("order_details_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeEqualTo(Date value) {
            addCriterion("order_details_modify_time =", value, "orderDetailsModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeNotEqualTo(Date value) {
            addCriterion("order_details_modify_time <>", value, "orderDetailsModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeGreaterThan(Date value) {
            addCriterion("order_details_modify_time >", value, "orderDetailsModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_details_modify_time >=", value, "orderDetailsModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeLessThan(Date value) {
            addCriterion("order_details_modify_time <", value, "orderDetailsModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_details_modify_time <=", value, "orderDetailsModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeIn(List<Date> values) {
            addCriterion("order_details_modify_time in", values, "orderDetailsModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeNotIn(List<Date> values) {
            addCriterion("order_details_modify_time not in", values, "orderDetailsModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeBetween(Date value1, Date value2) {
            addCriterion("order_details_modify_time between", value1, value2, "orderDetailsModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_details_modify_time not between", value1, value2, "orderDetailsModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusIsNull() {
            addCriterion("order_details_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusIsNotNull() {
            addCriterion("order_details_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusEqualTo(Boolean value) {
            addCriterion("order_details_status =", value, "orderDetailsStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusNotEqualTo(Boolean value) {
            addCriterion("order_details_status <>", value, "orderDetailsStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusGreaterThan(Boolean value) {
            addCriterion("order_details_status >", value, "orderDetailsStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("order_details_status >=", value, "orderDetailsStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusLessThan(Boolean value) {
            addCriterion("order_details_status <", value, "orderDetailsStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("order_details_status <=", value, "orderDetailsStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusIn(List<Boolean> values) {
            addCriterion("order_details_status in", values, "orderDetailsStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusNotIn(List<Boolean> values) {
            addCriterion("order_details_status not in", values, "orderDetailsStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("order_details_status between", value1, value2, "orderDetailsStatus");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("order_details_status not between", value1, value2, "orderDetailsStatus");
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