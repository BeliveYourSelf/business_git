package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentPrintPriceListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocumentPrintPriceListExample() {
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

        public Criteria andDocumentPrintPriceListCodeIsNull() {
            addCriterion("document_print_price_list_code is null");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeIsNotNull() {
            addCriterion("document_print_price_list_code is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeEqualTo(String value) {
            addCriterion("document_print_price_list_code =", value, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeNotEqualTo(String value) {
            addCriterion("document_print_price_list_code <>", value, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeGreaterThan(String value) {
            addCriterion("document_print_price_list_code >", value, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeGreaterThanOrEqualTo(String value) {
            addCriterion("document_print_price_list_code >=", value, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeLessThan(String value) {
            addCriterion("document_print_price_list_code <", value, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeLessThanOrEqualTo(String value) {
            addCriterion("document_print_price_list_code <=", value, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeLike(String value) {
            addCriterion("document_print_price_list_code like", value, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeNotLike(String value) {
            addCriterion("document_print_price_list_code not like", value, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeIn(List<String> values) {
            addCriterion("document_print_price_list_code in", values, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeNotIn(List<String> values) {
            addCriterion("document_print_price_list_code not in", values, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeBetween(String value1, String value2) {
            addCriterion("document_print_price_list_code between", value1, value2, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCodeNotBetween(String value1, String value2) {
            addCriterion("document_print_price_list_code not between", value1, value2, "documentPrintPriceListCode");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceIsNull() {
            addCriterion("document_print_price_list_price is null");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceIsNotNull() {
            addCriterion("document_print_price_list_price is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceEqualTo(Double value) {
            addCriterion("document_print_price_list_price =", value, "documentPrintPriceListPrice");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceNotEqualTo(Double value) {
            addCriterion("document_print_price_list_price <>", value, "documentPrintPriceListPrice");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceGreaterThan(Double value) {
            addCriterion("document_print_price_list_price >", value, "documentPrintPriceListPrice");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("document_print_price_list_price >=", value, "documentPrintPriceListPrice");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceLessThan(Double value) {
            addCriterion("document_print_price_list_price <", value, "documentPrintPriceListPrice");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceLessThanOrEqualTo(Double value) {
            addCriterion("document_print_price_list_price <=", value, "documentPrintPriceListPrice");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceIn(List<Double> values) {
            addCriterion("document_print_price_list_price in", values, "documentPrintPriceListPrice");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceNotIn(List<Double> values) {
            addCriterion("document_print_price_list_price not in", values, "documentPrintPriceListPrice");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceBetween(Double value1, Double value2) {
            addCriterion("document_print_price_list_price between", value1, value2, "documentPrintPriceListPrice");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListPriceNotBetween(Double value1, Double value2) {
            addCriterion("document_print_price_list_price not between", value1, value2, "documentPrintPriceListPrice");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeIsNull() {
            addCriterion("document_print_price_list_create_time is null");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeIsNotNull() {
            addCriterion("document_print_price_list_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeEqualTo(Date value) {
            addCriterion("document_print_price_list_create_time =", value, "documentPrintPriceListCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeNotEqualTo(Date value) {
            addCriterion("document_print_price_list_create_time <>", value, "documentPrintPriceListCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeGreaterThan(Date value) {
            addCriterion("document_print_price_list_create_time >", value, "documentPrintPriceListCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("document_print_price_list_create_time >=", value, "documentPrintPriceListCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeLessThan(Date value) {
            addCriterion("document_print_price_list_create_time <", value, "documentPrintPriceListCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("document_print_price_list_create_time <=", value, "documentPrintPriceListCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeIn(List<Date> values) {
            addCriterion("document_print_price_list_create_time in", values, "documentPrintPriceListCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeNotIn(List<Date> values) {
            addCriterion("document_print_price_list_create_time not in", values, "documentPrintPriceListCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeBetween(Date value1, Date value2) {
            addCriterion("document_print_price_list_create_time between", value1, value2, "documentPrintPriceListCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("document_print_price_list_create_time not between", value1, value2, "documentPrintPriceListCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeIsNull() {
            addCriterion("document_print_price_list_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeIsNotNull() {
            addCriterion("document_print_price_list_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeEqualTo(Date value) {
            addCriterion("document_print_price_list_modify_time =", value, "documentPrintPriceListModifyTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeNotEqualTo(Date value) {
            addCriterion("document_print_price_list_modify_time <>", value, "documentPrintPriceListModifyTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeGreaterThan(Date value) {
            addCriterion("document_print_price_list_modify_time >", value, "documentPrintPriceListModifyTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("document_print_price_list_modify_time >=", value, "documentPrintPriceListModifyTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeLessThan(Date value) {
            addCriterion("document_print_price_list_modify_time <", value, "documentPrintPriceListModifyTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("document_print_price_list_modify_time <=", value, "documentPrintPriceListModifyTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeIn(List<Date> values) {
            addCriterion("document_print_price_list_modify_time in", values, "documentPrintPriceListModifyTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeNotIn(List<Date> values) {
            addCriterion("document_print_price_list_modify_time not in", values, "documentPrintPriceListModifyTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeBetween(Date value1, Date value2) {
            addCriterion("document_print_price_list_modify_time between", value1, value2, "documentPrintPriceListModifyTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("document_print_price_list_modify_time not between", value1, value2, "documentPrintPriceListModifyTime");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusIsNull() {
            addCriterion("document_print_price_list_status is null");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusIsNotNull() {
            addCriterion("document_print_price_list_status is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusEqualTo(Boolean value) {
            addCriterion("document_print_price_list_status =", value, "documentPrintPriceListStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusNotEqualTo(Boolean value) {
            addCriterion("document_print_price_list_status <>", value, "documentPrintPriceListStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusGreaterThan(Boolean value) {
            addCriterion("document_print_price_list_status >", value, "documentPrintPriceListStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("document_print_price_list_status >=", value, "documentPrintPriceListStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusLessThan(Boolean value) {
            addCriterion("document_print_price_list_status <", value, "documentPrintPriceListStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("document_print_price_list_status <=", value, "documentPrintPriceListStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusIn(List<Boolean> values) {
            addCriterion("document_print_price_list_status in", values, "documentPrintPriceListStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusNotIn(List<Boolean> values) {
            addCriterion("document_print_price_list_status not in", values, "documentPrintPriceListStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("document_print_price_list_status between", value1, value2, "documentPrintPriceListStatus");
            return (Criteria) this;
        }

        public Criteria andDocumentPrintPriceListStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("document_print_price_list_status not between", value1, value2, "documentPrintPriceListStatus");
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