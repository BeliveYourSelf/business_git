package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HarvestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HarvestExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameIsNull() {
            addCriterion("harvest_address_name is null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameIsNotNull() {
            addCriterion("harvest_address_name is not null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameEqualTo(String value) {
            addCriterion("harvest_address_name =", value, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameNotEqualTo(String value) {
            addCriterion("harvest_address_name <>", value, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameGreaterThan(String value) {
            addCriterion("harvest_address_name >", value, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameGreaterThanOrEqualTo(String value) {
            addCriterion("harvest_address_name >=", value, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameLessThan(String value) {
            addCriterion("harvest_address_name <", value, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameLessThanOrEqualTo(String value) {
            addCriterion("harvest_address_name <=", value, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameLike(String value) {
            addCriterion("harvest_address_name like", value, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameNotLike(String value) {
            addCriterion("harvest_address_name not like", value, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameIn(List<String> values) {
            addCriterion("harvest_address_name in", values, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameNotIn(List<String> values) {
            addCriterion("harvest_address_name not in", values, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameBetween(String value1, String value2) {
            addCriterion("harvest_address_name between", value1, value2, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressNameNotBetween(String value1, String value2) {
            addCriterion("harvest_address_name not between", value1, value2, "harvestAddressName");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneIsNull() {
            addCriterion("harvest_address_mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneIsNotNull() {
            addCriterion("harvest_address_mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneEqualTo(String value) {
            addCriterion("harvest_address_mobile_phone =", value, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneNotEqualTo(String value) {
            addCriterion("harvest_address_mobile_phone <>", value, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneGreaterThan(String value) {
            addCriterion("harvest_address_mobile_phone >", value, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("harvest_address_mobile_phone >=", value, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneLessThan(String value) {
            addCriterion("harvest_address_mobile_phone <", value, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("harvest_address_mobile_phone <=", value, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneLike(String value) {
            addCriterion("harvest_address_mobile_phone like", value, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneNotLike(String value) {
            addCriterion("harvest_address_mobile_phone not like", value, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneIn(List<String> values) {
            addCriterion("harvest_address_mobile_phone in", values, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneNotIn(List<String> values) {
            addCriterion("harvest_address_mobile_phone not in", values, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneBetween(String value1, String value2) {
            addCriterion("harvest_address_mobile_phone between", value1, value2, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("harvest_address_mobile_phone not between", value1, value2, "harvestAddressMobilePhone");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressIsNull() {
            addCriterion("harvest_address_receiving_address is null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressIsNotNull() {
            addCriterion("harvest_address_receiving_address is not null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressEqualTo(String value) {
            addCriterion("harvest_address_receiving_address =", value, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressNotEqualTo(String value) {
            addCriterion("harvest_address_receiving_address <>", value, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressGreaterThan(String value) {
            addCriterion("harvest_address_receiving_address >", value, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("harvest_address_receiving_address >=", value, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressLessThan(String value) {
            addCriterion("harvest_address_receiving_address <", value, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressLessThanOrEqualTo(String value) {
            addCriterion("harvest_address_receiving_address <=", value, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressLike(String value) {
            addCriterion("harvest_address_receiving_address like", value, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressNotLike(String value) {
            addCriterion("harvest_address_receiving_address not like", value, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressIn(List<String> values) {
            addCriterion("harvest_address_receiving_address in", values, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressNotIn(List<String> values) {
            addCriterion("harvest_address_receiving_address not in", values, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressBetween(String value1, String value2) {
            addCriterion("harvest_address_receiving_address between", value1, value2, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressReceivingAddressNotBetween(String value1, String value2) {
            addCriterion("harvest_address_receiving_address not between", value1, value2, "harvestAddressReceivingAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressIsNull() {
            addCriterion("harvest_address_default_address is null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressIsNotNull() {
            addCriterion("harvest_address_default_address is not null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressEqualTo(Boolean value) {
            addCriterion("harvest_address_default_address =", value, "harvestAddressDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressNotEqualTo(Boolean value) {
            addCriterion("harvest_address_default_address <>", value, "harvestAddressDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressGreaterThan(Boolean value) {
            addCriterion("harvest_address_default_address >", value, "harvestAddressDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressGreaterThanOrEqualTo(Boolean value) {
            addCriterion("harvest_address_default_address >=", value, "harvestAddressDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressLessThan(Boolean value) {
            addCriterion("harvest_address_default_address <", value, "harvestAddressDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressLessThanOrEqualTo(Boolean value) {
            addCriterion("harvest_address_default_address <=", value, "harvestAddressDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressIn(List<Boolean> values) {
            addCriterion("harvest_address_default_address in", values, "harvestAddressDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressNotIn(List<Boolean> values) {
            addCriterion("harvest_address_default_address not in", values, "harvestAddressDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressBetween(Boolean value1, Boolean value2) {
            addCriterion("harvest_address_default_address between", value1, value2, "harvestAddressDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressDefaultAddressNotBetween(Boolean value1, Boolean value2) {
            addCriterion("harvest_address_default_address not between", value1, value2, "harvestAddressDefaultAddress");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeIsNull() {
            addCriterion("harvest_address_create_time is null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeIsNotNull() {
            addCriterion("harvest_address_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeEqualTo(Date value) {
            addCriterion("harvest_address_create_time =", value, "harvestAddressCreateTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeNotEqualTo(Date value) {
            addCriterion("harvest_address_create_time <>", value, "harvestAddressCreateTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeGreaterThan(Date value) {
            addCriterion("harvest_address_create_time >", value, "harvestAddressCreateTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("harvest_address_create_time >=", value, "harvestAddressCreateTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeLessThan(Date value) {
            addCriterion("harvest_address_create_time <", value, "harvestAddressCreateTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("harvest_address_create_time <=", value, "harvestAddressCreateTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeIn(List<Date> values) {
            addCriterion("harvest_address_create_time in", values, "harvestAddressCreateTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeNotIn(List<Date> values) {
            addCriterion("harvest_address_create_time not in", values, "harvestAddressCreateTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeBetween(Date value1, Date value2) {
            addCriterion("harvest_address_create_time between", value1, value2, "harvestAddressCreateTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("harvest_address_create_time not between", value1, value2, "harvestAddressCreateTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeIsNull() {
            addCriterion("harvest_address_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeIsNotNull() {
            addCriterion("harvest_address_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeEqualTo(Date value) {
            addCriterion("harvest_address_modify_time =", value, "harvestAddressModifyTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeNotEqualTo(Date value) {
            addCriterion("harvest_address_modify_time <>", value, "harvestAddressModifyTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeGreaterThan(Date value) {
            addCriterion("harvest_address_modify_time >", value, "harvestAddressModifyTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("harvest_address_modify_time >=", value, "harvestAddressModifyTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeLessThan(Date value) {
            addCriterion("harvest_address_modify_time <", value, "harvestAddressModifyTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("harvest_address_modify_time <=", value, "harvestAddressModifyTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeIn(List<Date> values) {
            addCriterion("harvest_address_modify_time in", values, "harvestAddressModifyTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeNotIn(List<Date> values) {
            addCriterion("harvest_address_modify_time not in", values, "harvestAddressModifyTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeBetween(Date value1, Date value2) {
            addCriterion("harvest_address_modify_time between", value1, value2, "harvestAddressModifyTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("harvest_address_modify_time not between", value1, value2, "harvestAddressModifyTime");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusIsNull() {
            addCriterion("harvest_address_status is null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusIsNotNull() {
            addCriterion("harvest_address_status is not null");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusEqualTo(Boolean value) {
            addCriterion("harvest_address_status =", value, "harvestAddressStatus");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusNotEqualTo(Boolean value) {
            addCriterion("harvest_address_status <>", value, "harvestAddressStatus");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusGreaterThan(Boolean value) {
            addCriterion("harvest_address_status >", value, "harvestAddressStatus");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("harvest_address_status >=", value, "harvestAddressStatus");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusLessThan(Boolean value) {
            addCriterion("harvest_address_status <", value, "harvestAddressStatus");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("harvest_address_status <=", value, "harvestAddressStatus");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusIn(List<Boolean> values) {
            addCriterion("harvest_address_status in", values, "harvestAddressStatus");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusNotIn(List<Boolean> values) {
            addCriterion("harvest_address_status not in", values, "harvestAddressStatus");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("harvest_address_status between", value1, value2, "harvestAddressStatus");
            return (Criteria) this;
        }

        public Criteria andHarvestAddressStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("harvest_address_status not between", value1, value2, "harvestAddressStatus");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryIsNull() {
            addCriterion("distribution_category is null");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryIsNotNull() {
            addCriterion("distribution_category is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryEqualTo(Integer value) {
            addCriterion("distribution_category =", value, "distributionCategory");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryNotEqualTo(Integer value) {
            addCriterion("distribution_category <>", value, "distributionCategory");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryGreaterThan(Integer value) {
            addCriterion("distribution_category >", value, "distributionCategory");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("distribution_category >=", value, "distributionCategory");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryLessThan(Integer value) {
            addCriterion("distribution_category <", value, "distributionCategory");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("distribution_category <=", value, "distributionCategory");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryIn(List<Integer> values) {
            addCriterion("distribution_category in", values, "distributionCategory");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryNotIn(List<Integer> values) {
            addCriterion("distribution_category not in", values, "distributionCategory");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryBetween(Integer value1, Integer value2) {
            addCriterion("distribution_category between", value1, value2, "distributionCategory");
            return (Criteria) this;
        }

        public Criteria andDistributionCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("distribution_category not between", value1, value2, "distributionCategory");
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