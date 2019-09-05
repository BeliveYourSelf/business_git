package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IdPhotoDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IdPhotoDictionaryExample() {
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

        public Criteria andIdPhotoDictionaryNameIsNull() {
            addCriterion("id_photo_dictionary_name is null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameIsNotNull() {
            addCriterion("id_photo_dictionary_name is not null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameEqualTo(String value) {
            addCriterion("id_photo_dictionary_name =", value, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameNotEqualTo(String value) {
            addCriterion("id_photo_dictionary_name <>", value, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameGreaterThan(String value) {
            addCriterion("id_photo_dictionary_name >", value, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameGreaterThanOrEqualTo(String value) {
            addCriterion("id_photo_dictionary_name >=", value, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameLessThan(String value) {
            addCriterion("id_photo_dictionary_name <", value, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameLessThanOrEqualTo(String value) {
            addCriterion("id_photo_dictionary_name <=", value, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameLike(String value) {
            addCriterion("id_photo_dictionary_name like", value, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameNotLike(String value) {
            addCriterion("id_photo_dictionary_name not like", value, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameIn(List<String> values) {
            addCriterion("id_photo_dictionary_name in", values, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameNotIn(List<String> values) {
            addCriterion("id_photo_dictionary_name not in", values, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameBetween(String value1, String value2) {
            addCriterion("id_photo_dictionary_name between", value1, value2, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryNameNotBetween(String value1, String value2) {
            addCriterion("id_photo_dictionary_name not between", value1, value2, "idPhotoDictionaryName");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdIsNull() {
            addCriterion("id_photo_dictionary_spec_id is null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdIsNotNull() {
            addCriterion("id_photo_dictionary_spec_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdEqualTo(Integer value) {
            addCriterion("id_photo_dictionary_spec_id =", value, "idPhotoDictionarySpecId");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdNotEqualTo(Integer value) {
            addCriterion("id_photo_dictionary_spec_id <>", value, "idPhotoDictionarySpecId");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdGreaterThan(Integer value) {
            addCriterion("id_photo_dictionary_spec_id >", value, "idPhotoDictionarySpecId");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_photo_dictionary_spec_id >=", value, "idPhotoDictionarySpecId");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdLessThan(Integer value) {
            addCriterion("id_photo_dictionary_spec_id <", value, "idPhotoDictionarySpecId");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdLessThanOrEqualTo(Integer value) {
            addCriterion("id_photo_dictionary_spec_id <=", value, "idPhotoDictionarySpecId");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdIn(List<Integer> values) {
            addCriterion("id_photo_dictionary_spec_id in", values, "idPhotoDictionarySpecId");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdNotIn(List<Integer> values) {
            addCriterion("id_photo_dictionary_spec_id not in", values, "idPhotoDictionarySpecId");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdBetween(Integer value1, Integer value2) {
            addCriterion("id_photo_dictionary_spec_id between", value1, value2, "idPhotoDictionarySpecId");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionarySpecIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id_photo_dictionary_spec_id not between", value1, value2, "idPhotoDictionarySpecId");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeIsNull() {
            addCriterion("id_photo_dictionary_create_time is null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeIsNotNull() {
            addCriterion("id_photo_dictionary_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeEqualTo(Date value) {
            addCriterion("id_photo_dictionary_create_time =", value, "idPhotoDictionaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeNotEqualTo(Date value) {
            addCriterion("id_photo_dictionary_create_time <>", value, "idPhotoDictionaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeGreaterThan(Date value) {
            addCriterion("id_photo_dictionary_create_time >", value, "idPhotoDictionaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("id_photo_dictionary_create_time >=", value, "idPhotoDictionaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeLessThan(Date value) {
            addCriterion("id_photo_dictionary_create_time <", value, "idPhotoDictionaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("id_photo_dictionary_create_time <=", value, "idPhotoDictionaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeIn(List<Date> values) {
            addCriterion("id_photo_dictionary_create_time in", values, "idPhotoDictionaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeNotIn(List<Date> values) {
            addCriterion("id_photo_dictionary_create_time not in", values, "idPhotoDictionaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeBetween(Date value1, Date value2) {
            addCriterion("id_photo_dictionary_create_time between", value1, value2, "idPhotoDictionaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("id_photo_dictionary_create_time not between", value1, value2, "idPhotoDictionaryCreateTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeIsNull() {
            addCriterion("id_photo_dictionary_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeIsNotNull() {
            addCriterion("id_photo_dictionary_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeEqualTo(Date value) {
            addCriterion("id_photo_dictionary_modify_time =", value, "idPhotoDictionaryModifyTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeNotEqualTo(Date value) {
            addCriterion("id_photo_dictionary_modify_time <>", value, "idPhotoDictionaryModifyTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeGreaterThan(Date value) {
            addCriterion("id_photo_dictionary_modify_time >", value, "idPhotoDictionaryModifyTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("id_photo_dictionary_modify_time >=", value, "idPhotoDictionaryModifyTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeLessThan(Date value) {
            addCriterion("id_photo_dictionary_modify_time <", value, "idPhotoDictionaryModifyTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("id_photo_dictionary_modify_time <=", value, "idPhotoDictionaryModifyTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeIn(List<Date> values) {
            addCriterion("id_photo_dictionary_modify_time in", values, "idPhotoDictionaryModifyTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeNotIn(List<Date> values) {
            addCriterion("id_photo_dictionary_modify_time not in", values, "idPhotoDictionaryModifyTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeBetween(Date value1, Date value2) {
            addCriterion("id_photo_dictionary_modify_time between", value1, value2, "idPhotoDictionaryModifyTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("id_photo_dictionary_modify_time not between", value1, value2, "idPhotoDictionaryModifyTime");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusIsNull() {
            addCriterion("id_photo_dictionary_status is null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusIsNotNull() {
            addCriterion("id_photo_dictionary_status is not null");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusEqualTo(Boolean value) {
            addCriterion("id_photo_dictionary_status =", value, "idPhotoDictionaryStatus");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusNotEqualTo(Boolean value) {
            addCriterion("id_photo_dictionary_status <>", value, "idPhotoDictionaryStatus");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusGreaterThan(Boolean value) {
            addCriterion("id_photo_dictionary_status >", value, "idPhotoDictionaryStatus");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("id_photo_dictionary_status >=", value, "idPhotoDictionaryStatus");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusLessThan(Boolean value) {
            addCriterion("id_photo_dictionary_status <", value, "idPhotoDictionaryStatus");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("id_photo_dictionary_status <=", value, "idPhotoDictionaryStatus");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusIn(List<Boolean> values) {
            addCriterion("id_photo_dictionary_status in", values, "idPhotoDictionaryStatus");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusNotIn(List<Boolean> values) {
            addCriterion("id_photo_dictionary_status not in", values, "idPhotoDictionaryStatus");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("id_photo_dictionary_status between", value1, value2, "idPhotoDictionaryStatus");
            return (Criteria) this;
        }

        public Criteria andIdPhotoDictionaryStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("id_photo_dictionary_status not between", value1, value2, "idPhotoDictionaryStatus");
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