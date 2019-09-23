package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryClerkInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliveryClerkInfoExample() {
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

        public Criteria andDeliveryClerkNameIsNull() {
            addCriterion("delivery_clerk_name is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameIsNotNull() {
            addCriterion("delivery_clerk_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameEqualTo(String value) {
            addCriterion("delivery_clerk_name =", value, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameNotEqualTo(String value) {
            addCriterion("delivery_clerk_name <>", value, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameGreaterThan(String value) {
            addCriterion("delivery_clerk_name >", value, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_clerk_name >=", value, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameLessThan(String value) {
            addCriterion("delivery_clerk_name <", value, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameLessThanOrEqualTo(String value) {
            addCriterion("delivery_clerk_name <=", value, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameLike(String value) {
            addCriterion("delivery_clerk_name like", value, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameNotLike(String value) {
            addCriterion("delivery_clerk_name not like", value, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameIn(List<String> values) {
            addCriterion("delivery_clerk_name in", values, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameNotIn(List<String> values) {
            addCriterion("delivery_clerk_name not in", values, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameBetween(String value1, String value2) {
            addCriterion("delivery_clerk_name between", value1, value2, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkNameNotBetween(String value1, String value2) {
            addCriterion("delivery_clerk_name not between", value1, value2, "deliveryClerkName");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneIsNull() {
            addCriterion("delivery_clerk_phone is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneIsNotNull() {
            addCriterion("delivery_clerk_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneEqualTo(String value) {
            addCriterion("delivery_clerk_phone =", value, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneNotEqualTo(String value) {
            addCriterion("delivery_clerk_phone <>", value, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneGreaterThan(String value) {
            addCriterion("delivery_clerk_phone >", value, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_clerk_phone >=", value, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneLessThan(String value) {
            addCriterion("delivery_clerk_phone <", value, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneLessThanOrEqualTo(String value) {
            addCriterion("delivery_clerk_phone <=", value, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneLike(String value) {
            addCriterion("delivery_clerk_phone like", value, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneNotLike(String value) {
            addCriterion("delivery_clerk_phone not like", value, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneIn(List<String> values) {
            addCriterion("delivery_clerk_phone in", values, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneNotIn(List<String> values) {
            addCriterion("delivery_clerk_phone not in", values, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneBetween(String value1, String value2) {
            addCriterion("delivery_clerk_phone between", value1, value2, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andDeliveryClerkPhoneNotBetween(String value1, String value2) {
            addCriterion("delivery_clerk_phone not between", value1, value2, "deliveryClerkPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonIsNull() {
            addCriterion("emergency_person is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonIsNotNull() {
            addCriterion("emergency_person is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonEqualTo(String value) {
            addCriterion("emergency_person =", value, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonNotEqualTo(String value) {
            addCriterion("emergency_person <>", value, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonGreaterThan(String value) {
            addCriterion("emergency_person >", value, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonGreaterThanOrEqualTo(String value) {
            addCriterion("emergency_person >=", value, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonLessThan(String value) {
            addCriterion("emergency_person <", value, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonLessThanOrEqualTo(String value) {
            addCriterion("emergency_person <=", value, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonLike(String value) {
            addCriterion("emergency_person like", value, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonNotLike(String value) {
            addCriterion("emergency_person not like", value, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonIn(List<String> values) {
            addCriterion("emergency_person in", values, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonNotIn(List<String> values) {
            addCriterion("emergency_person not in", values, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonBetween(String value1, String value2) {
            addCriterion("emergency_person between", value1, value2, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPersonNotBetween(String value1, String value2) {
            addCriterion("emergency_person not between", value1, value2, "emergencyPerson");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneIsNull() {
            addCriterion("emergency_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneIsNotNull() {
            addCriterion("emergency_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneEqualTo(String value) {
            addCriterion("emergency_phone =", value, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneNotEqualTo(String value) {
            addCriterion("emergency_phone <>", value, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneGreaterThan(String value) {
            addCriterion("emergency_phone >", value, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("emergency_phone >=", value, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneLessThan(String value) {
            addCriterion("emergency_phone <", value, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneLessThanOrEqualTo(String value) {
            addCriterion("emergency_phone <=", value, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneLike(String value) {
            addCriterion("emergency_phone like", value, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneNotLike(String value) {
            addCriterion("emergency_phone not like", value, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneIn(List<String> values) {
            addCriterion("emergency_phone in", values, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneNotIn(List<String> values) {
            addCriterion("emergency_phone not in", values, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneBetween(String value1, String value2) {
            addCriterion("emergency_phone between", value1, value2, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andEmergencyPhoneNotBetween(String value1, String value2) {
            addCriterion("emergency_phone not between", value1, value2, "emergencyPhone");
            return (Criteria) this;
        }

        public Criteria andIdCardNumIsNull() {
            addCriterion("id_card_num is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNumIsNotNull() {
            addCriterion("id_card_num is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNumEqualTo(String value) {
            addCriterion("id_card_num =", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotEqualTo(String value) {
            addCriterion("id_card_num <>", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumGreaterThan(String value) {
            addCriterion("id_card_num >", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_num >=", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumLessThan(String value) {
            addCriterion("id_card_num <", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumLessThanOrEqualTo(String value) {
            addCriterion("id_card_num <=", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumLike(String value) {
            addCriterion("id_card_num like", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotLike(String value) {
            addCriterion("id_card_num not like", value, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumIn(List<String> values) {
            addCriterion("id_card_num in", values, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotIn(List<String> values) {
            addCriterion("id_card_num not in", values, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumBetween(String value1, String value2) {
            addCriterion("id_card_num between", value1, value2, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardNumNotBetween(String value1, String value2) {
            addCriterion("id_card_num not between", value1, value2, "idCardNum");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveIsNull() {
            addCriterion("id_card_positive is null");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveIsNotNull() {
            addCriterion("id_card_positive is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveEqualTo(String value) {
            addCriterion("id_card_positive =", value, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveNotEqualTo(String value) {
            addCriterion("id_card_positive <>", value, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveGreaterThan(String value) {
            addCriterion("id_card_positive >", value, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_positive >=", value, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveLessThan(String value) {
            addCriterion("id_card_positive <", value, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveLessThanOrEqualTo(String value) {
            addCriterion("id_card_positive <=", value, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveLike(String value) {
            addCriterion("id_card_positive like", value, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveNotLike(String value) {
            addCriterion("id_card_positive not like", value, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveIn(List<String> values) {
            addCriterion("id_card_positive in", values, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveNotIn(List<String> values) {
            addCriterion("id_card_positive not in", values, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveBetween(String value1, String value2) {
            addCriterion("id_card_positive between", value1, value2, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardPositiveNotBetween(String value1, String value2) {
            addCriterion("id_card_positive not between", value1, value2, "idCardPositive");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeIsNull() {
            addCriterion("id_card_other_size is null");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeIsNotNull() {
            addCriterion("id_card_other_size is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeEqualTo(String value) {
            addCriterion("id_card_other_size =", value, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeNotEqualTo(String value) {
            addCriterion("id_card_other_size <>", value, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeGreaterThan(String value) {
            addCriterion("id_card_other_size >", value, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_other_size >=", value, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeLessThan(String value) {
            addCriterion("id_card_other_size <", value, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeLessThanOrEqualTo(String value) {
            addCriterion("id_card_other_size <=", value, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeLike(String value) {
            addCriterion("id_card_other_size like", value, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeNotLike(String value) {
            addCriterion("id_card_other_size not like", value, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeIn(List<String> values) {
            addCriterion("id_card_other_size in", values, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeNotIn(List<String> values) {
            addCriterion("id_card_other_size not in", values, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeBetween(String value1, String value2) {
            addCriterion("id_card_other_size between", value1, value2, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andIdCardOtherSizeNotBetween(String value1, String value2) {
            addCriterion("id_card_other_size not between", value1, value2, "idCardOtherSize");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthIsNull() {
            addCriterion("cumulative_delivery_this_month is null");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthIsNotNull() {
            addCriterion("cumulative_delivery_this_month is not null");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthEqualTo(Integer value) {
            addCriterion("cumulative_delivery_this_month =", value, "cumulativeDeliveryThisMonth");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthNotEqualTo(Integer value) {
            addCriterion("cumulative_delivery_this_month <>", value, "cumulativeDeliveryThisMonth");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthGreaterThan(Integer value) {
            addCriterion("cumulative_delivery_this_month >", value, "cumulativeDeliveryThisMonth");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("cumulative_delivery_this_month >=", value, "cumulativeDeliveryThisMonth");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthLessThan(Integer value) {
            addCriterion("cumulative_delivery_this_month <", value, "cumulativeDeliveryThisMonth");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthLessThanOrEqualTo(Integer value) {
            addCriterion("cumulative_delivery_this_month <=", value, "cumulativeDeliveryThisMonth");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthIn(List<Integer> values) {
            addCriterion("cumulative_delivery_this_month in", values, "cumulativeDeliveryThisMonth");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthNotIn(List<Integer> values) {
            addCriterion("cumulative_delivery_this_month not in", values, "cumulativeDeliveryThisMonth");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthBetween(Integer value1, Integer value2) {
            addCriterion("cumulative_delivery_this_month between", value1, value2, "cumulativeDeliveryThisMonth");
            return (Criteria) this;
        }

        public Criteria andCumulativeDeliveryThisMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("cumulative_delivery_this_month not between", value1, value2, "cumulativeDeliveryThisMonth");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeIsNull() {
            addCriterion("cumulative_income is null");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeIsNotNull() {
            addCriterion("cumulative_income is not null");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeEqualTo(Double value) {
            addCriterion("cumulative_income =", value, "cumulativeIncome");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeNotEqualTo(Double value) {
            addCriterion("cumulative_income <>", value, "cumulativeIncome");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeGreaterThan(Double value) {
            addCriterion("cumulative_income >", value, "cumulativeIncome");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeGreaterThanOrEqualTo(Double value) {
            addCriterion("cumulative_income >=", value, "cumulativeIncome");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeLessThan(Double value) {
            addCriterion("cumulative_income <", value, "cumulativeIncome");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeLessThanOrEqualTo(Double value) {
            addCriterion("cumulative_income <=", value, "cumulativeIncome");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeIn(List<Double> values) {
            addCriterion("cumulative_income in", values, "cumulativeIncome");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeNotIn(List<Double> values) {
            addCriterion("cumulative_income not in", values, "cumulativeIncome");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeBetween(Double value1, Double value2) {
            addCriterion("cumulative_income between", value1, value2, "cumulativeIncome");
            return (Criteria) this;
        }

        public Criteria andCumulativeIncomeNotBetween(Double value1, Double value2) {
            addCriterion("cumulative_income not between", value1, value2, "cumulativeIncome");
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