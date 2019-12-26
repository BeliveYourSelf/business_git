package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.List;

public class SuperAdminDocumentSizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SuperAdminDocumentSizeExample() {
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

        public Criteria andDocumentSizeIdIsNull() {
            addCriterion("document_size_id is null");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdIsNotNull() {
            addCriterion("document_size_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdEqualTo(Integer value) {
            addCriterion("document_size_id =", value, "documentSizeId");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdNotEqualTo(Integer value) {
            addCriterion("document_size_id <>", value, "documentSizeId");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdGreaterThan(Integer value) {
            addCriterion("document_size_id >", value, "documentSizeId");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("document_size_id >=", value, "documentSizeId");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdLessThan(Integer value) {
            addCriterion("document_size_id <", value, "documentSizeId");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("document_size_id <=", value, "documentSizeId");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdIn(List<Integer> values) {
            addCriterion("document_size_id in", values, "documentSizeId");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdNotIn(List<Integer> values) {
            addCriterion("document_size_id not in", values, "documentSizeId");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdBetween(Integer value1, Integer value2) {
            addCriterion("document_size_id between", value1, value2, "documentSizeId");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("document_size_id not between", value1, value2, "documentSizeId");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIsNull() {
            addCriterion("document_size is null");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIsNotNull() {
            addCriterion("document_size is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeEqualTo(String value) {
            addCriterion("document_size =", value, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeNotEqualTo(String value) {
            addCriterion("document_size <>", value, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeGreaterThan(String value) {
            addCriterion("document_size >", value, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeGreaterThanOrEqualTo(String value) {
            addCriterion("document_size >=", value, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeLessThan(String value) {
            addCriterion("document_size <", value, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeLessThanOrEqualTo(String value) {
            addCriterion("document_size <=", value, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeLike(String value) {
            addCriterion("document_size like", value, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeNotLike(String value) {
            addCriterion("document_size not like", value, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeIn(List<String> values) {
            addCriterion("document_size in", values, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeNotIn(List<String> values) {
            addCriterion("document_size not in", values, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeBetween(String value1, String value2) {
            addCriterion("document_size between", value1, value2, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeNotBetween(String value1, String value2) {
            addCriterion("document_size not between", value1, value2, "documentSize");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusIsNull() {
            addCriterion("document_size_status is null");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusIsNotNull() {
            addCriterion("document_size_status is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusEqualTo(Boolean value) {
            addCriterion("document_size_status =", value, "documentSizeStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusNotEqualTo(Boolean value) {
            addCriterion("document_size_status <>", value, "documentSizeStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusGreaterThan(Boolean value) {
            addCriterion("document_size_status >", value, "documentSizeStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("document_size_status >=", value, "documentSizeStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusLessThan(Boolean value) {
            addCriterion("document_size_status <", value, "documentSizeStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("document_size_status <=", value, "documentSizeStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusIn(List<Boolean> values) {
            addCriterion("document_size_status in", values, "documentSizeStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusNotIn(List<Boolean> values) {
            addCriterion("document_size_status not in", values, "documentSizeStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("document_size_status between", value1, value2, "documentSizeStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentSizeStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("document_size_status not between", value1, value2, "documentSizeStatus");
            return (Criteria) this;
        }

        public Criteria andIsBindingIsNull() {
            addCriterion("is_binding is null");
            return (Criteria) this;
        }

        public Criteria andIsBindingIsNotNull() {
            addCriterion("is_binding is not null");
            return (Criteria) this;
        }

        public Criteria andIsBindingEqualTo(Integer value) {
            addCriterion("is_binding =", value, "isBinding");
            return (Criteria) this;
        }

        public Criteria andIsBindingNotEqualTo(Integer value) {
            addCriterion("is_binding <>", value, "isBinding");
            return (Criteria) this;
        }

        public Criteria andIsBindingGreaterThan(Integer value) {
            addCriterion("is_binding >", value, "isBinding");
            return (Criteria) this;
        }

        public Criteria andIsBindingGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_binding >=", value, "isBinding");
            return (Criteria) this;
        }

        public Criteria andIsBindingLessThan(Integer value) {
            addCriterion("is_binding <", value, "isBinding");
            return (Criteria) this;
        }

        public Criteria andIsBindingLessThanOrEqualTo(Integer value) {
            addCriterion("is_binding <=", value, "isBinding");
            return (Criteria) this;
        }

        public Criteria andIsBindingIn(List<Integer> values) {
            addCriterion("is_binding in", values, "isBinding");
            return (Criteria) this;
        }

        public Criteria andIsBindingNotIn(List<Integer> values) {
            addCriterion("is_binding not in", values, "isBinding");
            return (Criteria) this;
        }

        public Criteria andIsBindingBetween(Integer value1, Integer value2) {
            addCriterion("is_binding between", value1, value2, "isBinding");
            return (Criteria) this;
        }

        public Criteria andIsBindingNotBetween(Integer value1, Integer value2) {
            addCriterion("is_binding not between", value1, value2, "isBinding");
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