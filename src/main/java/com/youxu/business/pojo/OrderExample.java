package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
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

        public Criteria andOrderAddresseeNameIsNull() {
            addCriterion("order_addressee_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameIsNotNull() {
            addCriterion("order_addressee_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameEqualTo(String value) {
            addCriterion("order_addressee_name =", value, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameNotEqualTo(String value) {
            addCriterion("order_addressee_name <>", value, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameGreaterThan(String value) {
            addCriterion("order_addressee_name >", value, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_addressee_name >=", value, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameLessThan(String value) {
            addCriterion("order_addressee_name <", value, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameLessThanOrEqualTo(String value) {
            addCriterion("order_addressee_name <=", value, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameLike(String value) {
            addCriterion("order_addressee_name like", value, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameNotLike(String value) {
            addCriterion("order_addressee_name not like", value, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameIn(List<String> values) {
            addCriterion("order_addressee_name in", values, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameNotIn(List<String> values) {
            addCriterion("order_addressee_name not in", values, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameBetween(String value1, String value2) {
            addCriterion("order_addressee_name between", value1, value2, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeNameNotBetween(String value1, String value2) {
            addCriterion("order_addressee_name not between", value1, value2, "orderAddresseeName");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneIsNull() {
            addCriterion("order_addressee_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneIsNotNull() {
            addCriterion("order_addressee_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneEqualTo(String value) {
            addCriterion("order_addressee_phone =", value, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneNotEqualTo(String value) {
            addCriterion("order_addressee_phone <>", value, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneGreaterThan(String value) {
            addCriterion("order_addressee_phone >", value, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("order_addressee_phone >=", value, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneLessThan(String value) {
            addCriterion("order_addressee_phone <", value, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneLessThanOrEqualTo(String value) {
            addCriterion("order_addressee_phone <=", value, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneLike(String value) {
            addCriterion("order_addressee_phone like", value, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneNotLike(String value) {
            addCriterion("order_addressee_phone not like", value, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneIn(List<String> values) {
            addCriterion("order_addressee_phone in", values, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneNotIn(List<String> values) {
            addCriterion("order_addressee_phone not in", values, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneBetween(String value1, String value2) {
            addCriterion("order_addressee_phone between", value1, value2, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseePhoneNotBetween(String value1, String value2) {
            addCriterion("order_addressee_phone not between", value1, value2, "orderAddresseePhone");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressIsNull() {
            addCriterion("order_addressee_address is null");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressIsNotNull() {
            addCriterion("order_addressee_address is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressEqualTo(String value) {
            addCriterion("order_addressee_address =", value, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressNotEqualTo(String value) {
            addCriterion("order_addressee_address <>", value, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressGreaterThan(String value) {
            addCriterion("order_addressee_address >", value, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("order_addressee_address >=", value, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressLessThan(String value) {
            addCriterion("order_addressee_address <", value, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressLessThanOrEqualTo(String value) {
            addCriterion("order_addressee_address <=", value, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressLike(String value) {
            addCriterion("order_addressee_address like", value, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressNotLike(String value) {
            addCriterion("order_addressee_address not like", value, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressIn(List<String> values) {
            addCriterion("order_addressee_address in", values, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressNotIn(List<String> values) {
            addCriterion("order_addressee_address not in", values, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressBetween(String value1, String value2) {
            addCriterion("order_addressee_address between", value1, value2, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderAddresseeAddressNotBetween(String value1, String value2) {
            addCriterion("order_addressee_address not between", value1, value2, "orderAddresseeAddress");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetIsNull() {
            addCriterion("order_from_store_get is null");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetIsNotNull() {
            addCriterion("order_from_store_get is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetEqualTo(String value) {
            addCriterion("order_from_store_get =", value, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetNotEqualTo(String value) {
            addCriterion("order_from_store_get <>", value, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetGreaterThan(String value) {
            addCriterion("order_from_store_get >", value, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetGreaterThanOrEqualTo(String value) {
            addCriterion("order_from_store_get >=", value, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetLessThan(String value) {
            addCriterion("order_from_store_get <", value, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetLessThanOrEqualTo(String value) {
            addCriterion("order_from_store_get <=", value, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetLike(String value) {
            addCriterion("order_from_store_get like", value, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetNotLike(String value) {
            addCriterion("order_from_store_get not like", value, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetIn(List<String> values) {
            addCriterion("order_from_store_get in", values, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetNotIn(List<String> values) {
            addCriterion("order_from_store_get not in", values, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetBetween(String value1, String value2) {
            addCriterion("order_from_store_get between", value1, value2, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetNotBetween(String value1, String value2) {
            addCriterion("order_from_store_get not between", value1, value2, "orderFromStoreGet");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereIsNull() {
            addCriterion("order_from_store_get_where is null");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereIsNotNull() {
            addCriterion("order_from_store_get_where is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereEqualTo(String value) {
            addCriterion("order_from_store_get_where =", value, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereNotEqualTo(String value) {
            addCriterion("order_from_store_get_where <>", value, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereGreaterThan(String value) {
            addCriterion("order_from_store_get_where >", value, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereGreaterThanOrEqualTo(String value) {
            addCriterion("order_from_store_get_where >=", value, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereLessThan(String value) {
            addCriterion("order_from_store_get_where <", value, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereLessThanOrEqualTo(String value) {
            addCriterion("order_from_store_get_where <=", value, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereLike(String value) {
            addCriterion("order_from_store_get_where like", value, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereNotLike(String value) {
            addCriterion("order_from_store_get_where not like", value, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereIn(List<String> values) {
            addCriterion("order_from_store_get_where in", values, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereNotIn(List<String> values) {
            addCriterion("order_from_store_get_where not in", values, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereBetween(String value1, String value2) {
            addCriterion("order_from_store_get_where between", value1, value2, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderFromStoreGetWhereNotBetween(String value1, String value2) {
            addCriterion("order_from_store_get_where not between", value1, value2, "orderFromStoreGetWhere");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeIsNull() {
            addCriterion("order_delivery_prescriptio_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeIsNotNull() {
            addCriterion("order_delivery_prescriptio_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeEqualTo(String value) {
            addCriterion("order_delivery_prescriptio_time =", value, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeNotEqualTo(String value) {
            addCriterion("order_delivery_prescriptio_time <>", value, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeGreaterThan(String value) {
            addCriterion("order_delivery_prescriptio_time >", value, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeGreaterThanOrEqualTo(String value) {
            addCriterion("order_delivery_prescriptio_time >=", value, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeLessThan(String value) {
            addCriterion("order_delivery_prescriptio_time <", value, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeLessThanOrEqualTo(String value) {
            addCriterion("order_delivery_prescriptio_time <=", value, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeLike(String value) {
            addCriterion("order_delivery_prescriptio_time like", value, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeNotLike(String value) {
            addCriterion("order_delivery_prescriptio_time not like", value, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeIn(List<String> values) {
            addCriterion("order_delivery_prescriptio_time in", values, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeNotIn(List<String> values) {
            addCriterion("order_delivery_prescriptio_time not in", values, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeBetween(String value1, String value2) {
            addCriterion("order_delivery_prescriptio_time between", value1, value2, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryPrescriptioTimeNotBetween(String value1, String value2) {
            addCriterion("order_delivery_prescriptio_time not between", value1, value2, "orderDeliveryPrescriptioTime");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyIsNull() {
            addCriterion("order_print_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyIsNotNull() {
            addCriterion("order_print_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyEqualTo(String value) {
            addCriterion("order_print_money =", value, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyNotEqualTo(String value) {
            addCriterion("order_print_money <>", value, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyGreaterThan(String value) {
            addCriterion("order_print_money >", value, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("order_print_money >=", value, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyLessThan(String value) {
            addCriterion("order_print_money <", value, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyLessThanOrEqualTo(String value) {
            addCriterion("order_print_money <=", value, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyLike(String value) {
            addCriterion("order_print_money like", value, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyNotLike(String value) {
            addCriterion("order_print_money not like", value, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyIn(List<String> values) {
            addCriterion("order_print_money in", values, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyNotIn(List<String> values) {
            addCriterion("order_print_money not in", values, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyBetween(String value1, String value2) {
            addCriterion("order_print_money between", value1, value2, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderPrintMoneyNotBetween(String value1, String value2) {
            addCriterion("order_print_money not between", value1, value2, "orderPrintMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyIsNull() {
            addCriterion("order_delivery_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyIsNotNull() {
            addCriterion("order_delivery_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyEqualTo(String value) {
            addCriterion("order_delivery_money =", value, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyNotEqualTo(String value) {
            addCriterion("order_delivery_money <>", value, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyGreaterThan(String value) {
            addCriterion("order_delivery_money >", value, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("order_delivery_money >=", value, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyLessThan(String value) {
            addCriterion("order_delivery_money <", value, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyLessThanOrEqualTo(String value) {
            addCriterion("order_delivery_money <=", value, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyLike(String value) {
            addCriterion("order_delivery_money like", value, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyNotLike(String value) {
            addCriterion("order_delivery_money not like", value, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyIn(List<String> values) {
            addCriterion("order_delivery_money in", values, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyNotIn(List<String> values) {
            addCriterion("order_delivery_money not in", values, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyBetween(String value1, String value2) {
            addCriterion("order_delivery_money between", value1, value2, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderDeliveryMoneyNotBetween(String value1, String value2) {
            addCriterion("order_delivery_money not between", value1, value2, "orderDeliveryMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyIsNull() {
            addCriterion("order_coupon_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyIsNotNull() {
            addCriterion("order_coupon_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyEqualTo(Double value) {
            addCriterion("order_coupon_money =", value, "orderCouponMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyNotEqualTo(Double value) {
            addCriterion("order_coupon_money <>", value, "orderCouponMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyGreaterThan(Double value) {
            addCriterion("order_coupon_money >", value, "orderCouponMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("order_coupon_money >=", value, "orderCouponMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyLessThan(Double value) {
            addCriterion("order_coupon_money <", value, "orderCouponMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyLessThanOrEqualTo(Double value) {
            addCriterion("order_coupon_money <=", value, "orderCouponMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyIn(List<Double> values) {
            addCriterion("order_coupon_money in", values, "orderCouponMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyNotIn(List<Double> values) {
            addCriterion("order_coupon_money not in", values, "orderCouponMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyBetween(Double value1, Double value2) {
            addCriterion("order_coupon_money between", value1, value2, "orderCouponMoney");
            return (Criteria) this;
        }

        public Criteria andOrderCouponMoneyNotBetween(Double value1, Double value2) {
            addCriterion("order_coupon_money not between", value1, value2, "orderCouponMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyIsNull() {
            addCriterion("order_actual_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyIsNotNull() {
            addCriterion("order_actual_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyEqualTo(String value) {
            addCriterion("order_actual_money =", value, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyNotEqualTo(String value) {
            addCriterion("order_actual_money <>", value, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyGreaterThan(String value) {
            addCriterion("order_actual_money >", value, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("order_actual_money >=", value, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyLessThan(String value) {
            addCriterion("order_actual_money <", value, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyLessThanOrEqualTo(String value) {
            addCriterion("order_actual_money <=", value, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyLike(String value) {
            addCriterion("order_actual_money like", value, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyNotLike(String value) {
            addCriterion("order_actual_money not like", value, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyIn(List<String> values) {
            addCriterion("order_actual_money in", values, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyNotIn(List<String> values) {
            addCriterion("order_actual_money not in", values, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyBetween(String value1, String value2) {
            addCriterion("order_actual_money between", value1, value2, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderActualMoneyNotBetween(String value1, String value2) {
            addCriterion("order_actual_money not between", value1, value2, "orderActualMoney");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyIsNull() {
            addCriterion("order_consume_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyIsNotNull() {
            addCriterion("order_consume_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyEqualTo(Double value) {
            addCriterion("order_consume_money =", value, "orderConsumeMoney");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyNotEqualTo(Double value) {
            addCriterion("order_consume_money <>", value, "orderConsumeMoney");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyGreaterThan(Double value) {
            addCriterion("order_consume_money >", value, "orderConsumeMoney");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("order_consume_money >=", value, "orderConsumeMoney");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyLessThan(Double value) {
            addCriterion("order_consume_money <", value, "orderConsumeMoney");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyLessThanOrEqualTo(Double value) {
            addCriterion("order_consume_money <=", value, "orderConsumeMoney");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyIn(List<Double> values) {
            addCriterion("order_consume_money in", values, "orderConsumeMoney");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyNotIn(List<Double> values) {
            addCriterion("order_consume_money not in", values, "orderConsumeMoney");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyBetween(Double value1, Double value2) {
            addCriterion("order_consume_money between", value1, value2, "orderConsumeMoney");
            return (Criteria) this;
        }

        public Criteria andOrderConsumeMoneyNotBetween(Double value1, Double value2) {
            addCriterion("order_consume_money not between", value1, value2, "orderConsumeMoney");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyIsNull() {
            addCriterion("order_extra_money is null");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyIsNotNull() {
            addCriterion("order_extra_money is not null");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyEqualTo(Double value) {
            addCriterion("order_extra_money =", value, "orderExtraMoney");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyNotEqualTo(Double value) {
            addCriterion("order_extra_money <>", value, "orderExtraMoney");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyGreaterThan(Double value) {
            addCriterion("order_extra_money >", value, "orderExtraMoney");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("order_extra_money >=", value, "orderExtraMoney");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyLessThan(Double value) {
            addCriterion("order_extra_money <", value, "orderExtraMoney");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyLessThanOrEqualTo(Double value) {
            addCriterion("order_extra_money <=", value, "orderExtraMoney");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyIn(List<Double> values) {
            addCriterion("order_extra_money in", values, "orderExtraMoney");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyNotIn(List<Double> values) {
            addCriterion("order_extra_money not in", values, "orderExtraMoney");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyBetween(Double value1, Double value2) {
            addCriterion("order_extra_money between", value1, value2, "orderExtraMoney");
            return (Criteria) this;
        }

        public Criteria andOrderExtraMoneyNotBetween(Double value1, Double value2) {
            addCriterion("order_extra_money not between", value1, value2, "orderExtraMoney");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThan(Date value) {
            addCriterion("order_create_time <", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeIsNull() {
            addCriterion("order_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeIsNotNull() {
            addCriterion("order_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeEqualTo(Date value) {
            addCriterion("order_modify_time =", value, "orderModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeNotEqualTo(Date value) {
            addCriterion("order_modify_time <>", value, "orderModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeGreaterThan(Date value) {
            addCriterion("order_modify_time >", value, "orderModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_modify_time >=", value, "orderModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeLessThan(Date value) {
            addCriterion("order_modify_time <", value, "orderModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_modify_time <=", value, "orderModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeIn(List<Date> values) {
            addCriterion("order_modify_time in", values, "orderModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeNotIn(List<Date> values) {
            addCriterion("order_modify_time not in", values, "orderModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeBetween(Date value1, Date value2) {
            addCriterion("order_modify_time between", value1, value2, "orderModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_modify_time not between", value1, value2, "orderModifyTime");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Boolean value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Boolean value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Boolean value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Boolean value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Boolean> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Boolean> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderProcessIsNull() {
            addCriterion("order_process is null");
            return (Criteria) this;
        }

        public Criteria andOrderProcessIsNotNull() {
            addCriterion("order_process is not null");
            return (Criteria) this;
        }

        public Criteria andOrderProcessEqualTo(Integer value) {
            addCriterion("order_process =", value, "orderProcess");
            return (Criteria) this;
        }

        public Criteria andOrderProcessNotEqualTo(Integer value) {
            addCriterion("order_process <>", value, "orderProcess");
            return (Criteria) this;
        }

        public Criteria andOrderProcessGreaterThan(Integer value) {
            addCriterion("order_process >", value, "orderProcess");
            return (Criteria) this;
        }

        public Criteria andOrderProcessGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_process >=", value, "orderProcess");
            return (Criteria) this;
        }

        public Criteria andOrderProcessLessThan(Integer value) {
            addCriterion("order_process <", value, "orderProcess");
            return (Criteria) this;
        }

        public Criteria andOrderProcessLessThanOrEqualTo(Integer value) {
            addCriterion("order_process <=", value, "orderProcess");
            return (Criteria) this;
        }

        public Criteria andOrderProcessIn(List<Integer> values) {
            addCriterion("order_process in", values, "orderProcess");
            return (Criteria) this;
        }

        public Criteria andOrderProcessNotIn(List<Integer> values) {
            addCriterion("order_process not in", values, "orderProcess");
            return (Criteria) this;
        }

        public Criteria andOrderProcessBetween(Integer value1, Integer value2) {
            addCriterion("order_process between", value1, value2, "orderProcess");
            return (Criteria) this;
        }

        public Criteria andOrderProcessNotBetween(Integer value1, Integer value2) {
            addCriterion("order_process not between", value1, value2, "orderProcess");
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