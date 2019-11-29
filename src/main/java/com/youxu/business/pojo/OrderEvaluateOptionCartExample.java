package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderEvaluateOptionCartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderEvaluateOptionCartExample() {
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

        public Criteria andOrderEvaluateOptionCartNameIsNull() {
            addCriterion("order_evaluate_option_cart_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameIsNotNull() {
            addCriterion("order_evaluate_option_cart_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameEqualTo(String value) {
            addCriterion("order_evaluate_option_cart_name =", value, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameNotEqualTo(String value) {
            addCriterion("order_evaluate_option_cart_name <>", value, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameGreaterThan(String value) {
            addCriterion("order_evaluate_option_cart_name >", value, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_evaluate_option_cart_name >=", value, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameLessThan(String value) {
            addCriterion("order_evaluate_option_cart_name <", value, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameLessThanOrEqualTo(String value) {
            addCriterion("order_evaluate_option_cart_name <=", value, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameLike(String value) {
            addCriterion("order_evaluate_option_cart_name like", value, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameNotLike(String value) {
            addCriterion("order_evaluate_option_cart_name not like", value, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameIn(List<String> values) {
            addCriterion("order_evaluate_option_cart_name in", values, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameNotIn(List<String> values) {
            addCriterion("order_evaluate_option_cart_name not in", values, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameBetween(String value1, String value2) {
            addCriterion("order_evaluate_option_cart_name between", value1, value2, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartNameNotBetween(String value1, String value2) {
            addCriterion("order_evaluate_option_cart_name not between", value1, value2, "orderEvaluateOptionCartName");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeIsNull() {
            addCriterion("order_evaluate_option_cart_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeIsNotNull() {
            addCriterion("order_evaluate_option_cart_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeEqualTo(Date value) {
            addCriterion("order_evaluate_option_cart_create_time =", value, "orderEvaluateOptionCartCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeNotEqualTo(Date value) {
            addCriterion("order_evaluate_option_cart_create_time <>", value, "orderEvaluateOptionCartCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeGreaterThan(Date value) {
            addCriterion("order_evaluate_option_cart_create_time >", value, "orderEvaluateOptionCartCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_evaluate_option_cart_create_time >=", value, "orderEvaluateOptionCartCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeLessThan(Date value) {
            addCriterion("order_evaluate_option_cart_create_time <", value, "orderEvaluateOptionCartCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_evaluate_option_cart_create_time <=", value, "orderEvaluateOptionCartCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeIn(List<Date> values) {
            addCriterion("order_evaluate_option_cart_create_time in", values, "orderEvaluateOptionCartCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeNotIn(List<Date> values) {
            addCriterion("order_evaluate_option_cart_create_time not in", values, "orderEvaluateOptionCartCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_evaluate_option_cart_create_time between", value1, value2, "orderEvaluateOptionCartCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_evaluate_option_cart_create_time not between", value1, value2, "orderEvaluateOptionCartCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeIsNull() {
            addCriterion("order_evaluate_option_cart_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeIsNotNull() {
            addCriterion("order_evaluate_option_cart_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeEqualTo(Date value) {
            addCriterion("order_evaluate_option_cart_modify_time =", value, "orderEvaluateOptionCartModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeNotEqualTo(Date value) {
            addCriterion("order_evaluate_option_cart_modify_time <>", value, "orderEvaluateOptionCartModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeGreaterThan(Date value) {
            addCriterion("order_evaluate_option_cart_modify_time >", value, "orderEvaluateOptionCartModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_evaluate_option_cart_modify_time >=", value, "orderEvaluateOptionCartModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeLessThan(Date value) {
            addCriterion("order_evaluate_option_cart_modify_time <", value, "orderEvaluateOptionCartModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_evaluate_option_cart_modify_time <=", value, "orderEvaluateOptionCartModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeIn(List<Date> values) {
            addCriterion("order_evaluate_option_cart_modify_time in", values, "orderEvaluateOptionCartModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeNotIn(List<Date> values) {
            addCriterion("order_evaluate_option_cart_modify_time not in", values, "orderEvaluateOptionCartModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeBetween(Date value1, Date value2) {
            addCriterion("order_evaluate_option_cart_modify_time between", value1, value2, "orderEvaluateOptionCartModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_evaluate_option_cart_modify_time not between", value1, value2, "orderEvaluateOptionCartModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusIsNull() {
            addCriterion("order_evaluate_option_cart_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusIsNotNull() {
            addCriterion("order_evaluate_option_cart_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusEqualTo(Integer value) {
            addCriterion("order_evaluate_option_cart_status =", value, "orderEvaluateOptionCartStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusNotEqualTo(Integer value) {
            addCriterion("order_evaluate_option_cart_status <>", value, "orderEvaluateOptionCartStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusGreaterThan(Integer value) {
            addCriterion("order_evaluate_option_cart_status >", value, "orderEvaluateOptionCartStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_evaluate_option_cart_status >=", value, "orderEvaluateOptionCartStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusLessThan(Integer value) {
            addCriterion("order_evaluate_option_cart_status <", value, "orderEvaluateOptionCartStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusLessThanOrEqualTo(Integer value) {
            addCriterion("order_evaluate_option_cart_status <=", value, "orderEvaluateOptionCartStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusIn(List<Integer> values) {
            addCriterion("order_evaluate_option_cart_status in", values, "orderEvaluateOptionCartStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusNotIn(List<Integer> values) {
            addCriterion("order_evaluate_option_cart_status not in", values, "orderEvaluateOptionCartStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusBetween(Integer value1, Integer value2) {
            addCriterion("order_evaluate_option_cart_status between", value1, value2, "orderEvaluateOptionCartStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("order_evaluate_option_cart_status not between", value1, value2, "orderEvaluateOptionCartStatus");
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