package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserWalletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserWalletExample() {
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

        public Criteria andUserIntegralIsNull() {
            addCriterion("user_integral is null");
            return (Criteria) this;
        }

        public Criteria andUserIntegralIsNotNull() {
            addCriterion("user_integral is not null");
            return (Criteria) this;
        }

        public Criteria andUserIntegralEqualTo(Integer value) {
            addCriterion("user_integral =", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralNotEqualTo(Integer value) {
            addCriterion("user_integral <>", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralGreaterThan(Integer value) {
            addCriterion("user_integral >", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_integral >=", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralLessThan(Integer value) {
            addCriterion("user_integral <", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("user_integral <=", value, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralIn(List<Integer> values) {
            addCriterion("user_integral in", values, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralNotIn(List<Integer> values) {
            addCriterion("user_integral not in", values, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralBetween(Integer value1, Integer value2) {
            addCriterion("user_integral between", value1, value2, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andUserIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("user_integral not between", value1, value2, "userIntegral");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceIsNull() {
            addCriterion("wallet_balance is null");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceIsNotNull() {
            addCriterion("wallet_balance is not null");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceEqualTo(Double value) {
            addCriterion("wallet_balance =", value, "walletBalance");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceNotEqualTo(Double value) {
            addCriterion("wallet_balance <>", value, "walletBalance");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceGreaterThan(Double value) {
            addCriterion("wallet_balance >", value, "walletBalance");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("wallet_balance >=", value, "walletBalance");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceLessThan(Double value) {
            addCriterion("wallet_balance <", value, "walletBalance");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceLessThanOrEqualTo(Double value) {
            addCriterion("wallet_balance <=", value, "walletBalance");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceIn(List<Double> values) {
            addCriterion("wallet_balance in", values, "walletBalance");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceNotIn(List<Double> values) {
            addCriterion("wallet_balance not in", values, "walletBalance");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceBetween(Double value1, Double value2) {
            addCriterion("wallet_balance between", value1, value2, "walletBalance");
            return (Criteria) this;
        }

        public Criteria andWalletBalanceNotBetween(Double value1, Double value2) {
            addCriterion("wallet_balance not between", value1, value2, "walletBalance");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackIsNull() {
            addCriterion("wallet_cashback is null");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackIsNotNull() {
            addCriterion("wallet_cashback is not null");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackEqualTo(Double value) {
            addCriterion("wallet_cashback =", value, "walletCashback");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackNotEqualTo(Double value) {
            addCriterion("wallet_cashback <>", value, "walletCashback");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackGreaterThan(Double value) {
            addCriterion("wallet_cashback >", value, "walletCashback");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackGreaterThanOrEqualTo(Double value) {
            addCriterion("wallet_cashback >=", value, "walletCashback");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackLessThan(Double value) {
            addCriterion("wallet_cashback <", value, "walletCashback");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackLessThanOrEqualTo(Double value) {
            addCriterion("wallet_cashback <=", value, "walletCashback");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackIn(List<Double> values) {
            addCriterion("wallet_cashback in", values, "walletCashback");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackNotIn(List<Double> values) {
            addCriterion("wallet_cashback not in", values, "walletCashback");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackBetween(Double value1, Double value2) {
            addCriterion("wallet_cashback between", value1, value2, "walletCashback");
            return (Criteria) this;
        }

        public Criteria andWalletCashbackNotBetween(Double value1, Double value2) {
            addCriterion("wallet_cashback not between", value1, value2, "walletCashback");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeIsNull() {
            addCriterion("wallet_create_time is null");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeIsNotNull() {
            addCriterion("wallet_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeEqualTo(Date value) {
            addCriterion("wallet_create_time =", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeNotEqualTo(Date value) {
            addCriterion("wallet_create_time <>", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeGreaterThan(Date value) {
            addCriterion("wallet_create_time >", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wallet_create_time >=", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeLessThan(Date value) {
            addCriterion("wallet_create_time <", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("wallet_create_time <=", value, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeIn(List<Date> values) {
            addCriterion("wallet_create_time in", values, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeNotIn(List<Date> values) {
            addCriterion("wallet_create_time not in", values, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeBetween(Date value1, Date value2) {
            addCriterion("wallet_create_time between", value1, value2, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("wallet_create_time not between", value1, value2, "walletCreateTime");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeIsNull() {
            addCriterion("wallet_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeIsNotNull() {
            addCriterion("wallet_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeEqualTo(Date value) {
            addCriterion("wallet_modify_time =", value, "walletModifyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeNotEqualTo(Date value) {
            addCriterion("wallet_modify_time <>", value, "walletModifyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeGreaterThan(Date value) {
            addCriterion("wallet_modify_time >", value, "walletModifyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wallet_modify_time >=", value, "walletModifyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeLessThan(Date value) {
            addCriterion("wallet_modify_time <", value, "walletModifyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("wallet_modify_time <=", value, "walletModifyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeIn(List<Date> values) {
            addCriterion("wallet_modify_time in", values, "walletModifyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeNotIn(List<Date> values) {
            addCriterion("wallet_modify_time not in", values, "walletModifyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeBetween(Date value1, Date value2) {
            addCriterion("wallet_modify_time between", value1, value2, "walletModifyTime");
            return (Criteria) this;
        }

        public Criteria andWalletModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("wallet_modify_time not between", value1, value2, "walletModifyTime");
            return (Criteria) this;
        }

        public Criteria andWalletStatusIsNull() {
            addCriterion("wallet_status is null");
            return (Criteria) this;
        }

        public Criteria andWalletStatusIsNotNull() {
            addCriterion("wallet_status is not null");
            return (Criteria) this;
        }

        public Criteria andWalletStatusEqualTo(Boolean value) {
            addCriterion("wallet_status =", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusNotEqualTo(Boolean value) {
            addCriterion("wallet_status <>", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusGreaterThan(Boolean value) {
            addCriterion("wallet_status >", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("wallet_status >=", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusLessThan(Boolean value) {
            addCriterion("wallet_status <", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("wallet_status <=", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusIn(List<Boolean> values) {
            addCriterion("wallet_status in", values, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusNotIn(List<Boolean> values) {
            addCriterion("wallet_status not in", values, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("wallet_status between", value1, value2, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("wallet_status not between", value1, value2, "walletStatus");
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