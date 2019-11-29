package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderEvaluateOptionCartMapperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderEvaluateOptionCartMapperExample() {
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

        public Criteria andOrderEvaluateIdIsNull() {
            addCriterion("order_evaluate_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdIsNotNull() {
            addCriterion("order_evaluate_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdEqualTo(Integer value) {
            addCriterion("order_evaluate_id =", value, "orderEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdNotEqualTo(Integer value) {
            addCriterion("order_evaluate_id <>", value, "orderEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdGreaterThan(Integer value) {
            addCriterion("order_evaluate_id >", value, "orderEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_evaluate_id >=", value, "orderEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdLessThan(Integer value) {
            addCriterion("order_evaluate_id <", value, "orderEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_evaluate_id <=", value, "orderEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdIn(List<Integer> values) {
            addCriterion("order_evaluate_id in", values, "orderEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdNotIn(List<Integer> values) {
            addCriterion("order_evaluate_id not in", values, "orderEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdBetween(Integer value1, Integer value2) {
            addCriterion("order_evaluate_id between", value1, value2, "orderEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_evaluate_id not between", value1, value2, "orderEvaluateId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdIsNull() {
            addCriterion("order_evaluate_option_cart_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdIsNotNull() {
            addCriterion("order_evaluate_option_cart_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdEqualTo(Integer value) {
            addCriterion("order_evaluate_option_cart_id =", value, "orderEvaluateOptionCartId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdNotEqualTo(Integer value) {
            addCriterion("order_evaluate_option_cart_id <>", value, "orderEvaluateOptionCartId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdGreaterThan(Integer value) {
            addCriterion("order_evaluate_option_cart_id >", value, "orderEvaluateOptionCartId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_evaluate_option_cart_id >=", value, "orderEvaluateOptionCartId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdLessThan(Integer value) {
            addCriterion("order_evaluate_option_cart_id <", value, "orderEvaluateOptionCartId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_evaluate_option_cart_id <=", value, "orderEvaluateOptionCartId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdIn(List<Integer> values) {
            addCriterion("order_evaluate_option_cart_id in", values, "orderEvaluateOptionCartId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdNotIn(List<Integer> values) {
            addCriterion("order_evaluate_option_cart_id not in", values, "orderEvaluateOptionCartId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdBetween(Integer value1, Integer value2) {
            addCriterion("order_evaluate_option_cart_id between", value1, value2, "orderEvaluateOptionCartId");
            return (Criteria) this;
        }

        public Criteria andOrderEvaluateOptionCartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_evaluate_option_cart_id not between", value1, value2, "orderEvaluateOptionCartId");
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