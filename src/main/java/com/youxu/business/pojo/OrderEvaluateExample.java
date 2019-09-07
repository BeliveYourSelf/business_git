package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderEvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderEvaluateExample() {
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

        public Criteria andOrderEvaluateStarIsNull() {
            addCriterion("order_evaluate_star is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarIsNotNull() {
            addCriterion("order_evaluate_star is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarEqualTo(Integer value) {
            addCriterion("order_evaluate_star =", value, "orderEvaluateStar");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarNotEqualTo(Integer value) {
            addCriterion("order_evaluate_star <>", value, "orderEvaluateStar");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarGreaterThan(Integer value) {
            addCriterion("order_evaluate_star >", value, "orderEvaluateStar");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_evaluate_star >=", value, "orderEvaluateStar");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarLessThan(Integer value) {
            addCriterion("order_evaluate_star <", value, "orderEvaluateStar");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarLessThanOrEqualTo(Integer value) {
            addCriterion("order_evaluate_star <=", value, "orderEvaluateStar");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarIn(List<Integer> values) {
            addCriterion("order_evaluate_star in", values, "orderEvaluateStar");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarNotIn(List<Integer> values) {
            addCriterion("order_evaluate_star not in", values, "orderEvaluateStar");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarBetween(Integer value1, Integer value2) {
            addCriterion("order_evaluate_star between", value1, value2, "orderEvaluateStar");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStarNotBetween(Integer value1, Integer value2) {
            addCriterion("order_evaluate_star not between", value1, value2, "orderEvaluateStar");
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

        public Criteria andOrderCommentIsNull() {
            addCriterion("order_comment is null");
            return (Criteria) this;
        }

        public Criteria andOrderCommentIsNotNull() {
            addCriterion("order_comment is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCommentEqualTo(String value) {
            addCriterion("order_comment =", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentNotEqualTo(String value) {
            addCriterion("order_comment <>", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentGreaterThan(String value) {
            addCriterion("order_comment >", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentGreaterThanOrEqualTo(String value) {
            addCriterion("order_comment >=", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentLessThan(String value) {
            addCriterion("order_comment <", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentLessThanOrEqualTo(String value) {
            addCriterion("order_comment <=", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentLike(String value) {
            addCriterion("order_comment like", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentNotLike(String value) {
            addCriterion("order_comment not like", value, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentIn(List<String> values) {
            addCriterion("order_comment in", values, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentNotIn(List<String> values) {
            addCriterion("order_comment not in", values, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentBetween(String value1, String value2) {
            addCriterion("order_comment between", value1, value2, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderCommentNotBetween(String value1, String value2) {
            addCriterion("order_comment not between", value1, value2, "orderComment");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeIsNull() {
            addCriterion("order_evaluate_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeIsNotNull() {
            addCriterion("order_evaluate_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeEqualTo(Date value) {
            addCriterion("order_evaluate_create_time =", value, "orderEvaluateCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeNotEqualTo(Date value) {
            addCriterion("order_evaluate_create_time <>", value, "orderEvaluateCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeGreaterThan(Date value) {
            addCriterion("order_evaluate_create_time >", value, "orderEvaluateCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_evaluate_create_time >=", value, "orderEvaluateCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeLessThan(Date value) {
            addCriterion("order_evaluate_create_time <", value, "orderEvaluateCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_evaluate_create_time <=", value, "orderEvaluateCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeIn(List<Date> values) {
            addCriterion("order_evaluate_create_time in", values, "orderEvaluateCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeNotIn(List<Date> values) {
            addCriterion("order_evaluate_create_time not in", values, "orderEvaluateCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_evaluate_create_time between", value1, value2, "orderEvaluateCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_evaluate_create_time not between", value1, value2, "orderEvaluateCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeIsNull() {
            addCriterion("order_evaluate_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeIsNotNull() {
            addCriterion("order_evaluate_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeEqualTo(Date value) {
            addCriterion("order_evaluate_modify_time =", value, "orderEvaluateModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeNotEqualTo(Date value) {
            addCriterion("order_evaluate_modify_time <>", value, "orderEvaluateModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeGreaterThan(Date value) {
            addCriterion("order_evaluate_modify_time >", value, "orderEvaluateModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_evaluate_modify_time >=", value, "orderEvaluateModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeLessThan(Date value) {
            addCriterion("order_evaluate_modify_time <", value, "orderEvaluateModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_evaluate_modify_time <=", value, "orderEvaluateModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeIn(List<Date> values) {
            addCriterion("order_evaluate_modify_time in", values, "orderEvaluateModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeNotIn(List<Date> values) {
            addCriterion("order_evaluate_modify_time not in", values, "orderEvaluateModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeBetween(Date value1, Date value2) {
            addCriterion("order_evaluate_modify_time between", value1, value2, "orderEvaluateModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_evaluate_modify_time not between", value1, value2, "orderEvaluateModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusIsNull() {
            addCriterion("order_evaluate_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusIsNotNull() {
            addCriterion("order_evaluate_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusEqualTo(Boolean value) {
            addCriterion("order_evaluate_status =", value, "orderEvaluateStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusNotEqualTo(Boolean value) {
            addCriterion("order_evaluate_status <>", value, "orderEvaluateStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusGreaterThan(Boolean value) {
            addCriterion("order_evaluate_status >", value, "orderEvaluateStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("order_evaluate_status >=", value, "orderEvaluateStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusLessThan(Boolean value) {
            addCriterion("order_evaluate_status <", value, "orderEvaluateStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("order_evaluate_status <=", value, "orderEvaluateStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusIn(List<Boolean> values) {
            addCriterion("order_evaluate_status in", values, "orderEvaluateStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusNotIn(List<Boolean> values) {
            addCriterion("order_evaluate_status not in", values, "orderEvaluateStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("order_evaluate_status between", value1, value2, "orderEvaluateStatus");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("order_evaluate_status not between", value1, value2, "orderEvaluateStatus");
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