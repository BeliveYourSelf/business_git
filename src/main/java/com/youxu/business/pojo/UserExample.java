package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserOpenIdIsNull() {
            addCriterion("user_open_id is null");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdIsNotNull() {
            addCriterion("user_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdEqualTo(String value) {
            addCriterion("user_open_id =", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdNotEqualTo(String value) {
            addCriterion("user_open_id <>", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdGreaterThan(String value) {
            addCriterion("user_open_id >", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_open_id >=", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdLessThan(String value) {
            addCriterion("user_open_id <", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdLessThanOrEqualTo(String value) {
            addCriterion("user_open_id <=", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdLike(String value) {
            addCriterion("user_open_id like", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdNotLike(String value) {
            addCriterion("user_open_id not like", value, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdIn(List<String> values) {
            addCriterion("user_open_id in", values, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdNotIn(List<String> values) {
            addCriterion("user_open_id not in", values, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdBetween(String value1, String value2) {
            addCriterion("user_open_id between", value1, value2, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserOpenIdNotBetween(String value1, String value2) {
            addCriterion("user_open_id not between", value1, value2, "userOpenId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlIsNull() {
            addCriterion("user_piecture_url is null");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlIsNotNull() {
            addCriterion("user_piecture_url is not null");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlEqualTo(String value) {
            addCriterion("user_piecture_url =", value, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlNotEqualTo(String value) {
            addCriterion("user_piecture_url <>", value, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlGreaterThan(String value) {
            addCriterion("user_piecture_url >", value, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("user_piecture_url >=", value, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlLessThan(String value) {
            addCriterion("user_piecture_url <", value, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlLessThanOrEqualTo(String value) {
            addCriterion("user_piecture_url <=", value, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlLike(String value) {
            addCriterion("user_piecture_url like", value, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlNotLike(String value) {
            addCriterion("user_piecture_url not like", value, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlIn(List<String> values) {
            addCriterion("user_piecture_url in", values, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlNotIn(List<String> values) {
            addCriterion("user_piecture_url not in", values, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlBetween(String value1, String value2) {
            addCriterion("user_piecture_url between", value1, value2, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andUserPiectureUrlNotBetween(String value1, String value2) {
            addCriterion("user_piecture_url not between", value1, value2, "userPiectureUrl");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeIsNull() {
            addCriterion("others_resourceQR_code is null");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeIsNotNull() {
            addCriterion("others_resourceQR_code is not null");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeEqualTo(String value) {
            addCriterion("others_resourceQR_code =", value, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeNotEqualTo(String value) {
            addCriterion("others_resourceQR_code <>", value, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeGreaterThan(String value) {
            addCriterion("others_resourceQR_code >", value, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("others_resourceQR_code >=", value, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeLessThan(String value) {
            addCriterion("others_resourceQR_code <", value, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeLessThanOrEqualTo(String value) {
            addCriterion("others_resourceQR_code <=", value, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeLike(String value) {
            addCriterion("others_resourceQR_code like", value, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeNotLike(String value) {
            addCriterion("others_resourceQR_code not like", value, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeIn(List<String> values) {
            addCriterion("others_resourceQR_code in", values, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeNotIn(List<String> values) {
            addCriterion("others_resourceQR_code not in", values, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeBetween(String value1, String value2) {
            addCriterion("others_resourceQR_code between", value1, value2, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andOthersResourceqrCodeNotBetween(String value1, String value2) {
            addCriterion("others_resourceQR_code not between", value1, value2, "othersResourceqrCode");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIsNull() {
            addCriterion("user_create_time is null");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIsNotNull() {
            addCriterion("user_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeEqualTo(Date value) {
            addCriterion("user_create_time =", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotEqualTo(Date value) {
            addCriterion("user_create_time <>", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeGreaterThan(Date value) {
            addCriterion("user_create_time >", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_create_time >=", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeLessThan(Date value) {
            addCriterion("user_create_time <", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_create_time <=", value, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeIn(List<Date> values) {
            addCriterion("user_create_time in", values, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotIn(List<Date> values) {
            addCriterion("user_create_time not in", values, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeBetween(Date value1, Date value2) {
            addCriterion("user_create_time between", value1, value2, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_create_time not between", value1, value2, "userCreateTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeIsNull() {
            addCriterion("user_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeIsNotNull() {
            addCriterion("user_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeEqualTo(Date value) {
            addCriterion("user_modify_time =", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeNotEqualTo(Date value) {
            addCriterion("user_modify_time <>", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeGreaterThan(Date value) {
            addCriterion("user_modify_time >", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("user_modify_time >=", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeLessThan(Date value) {
            addCriterion("user_modify_time <", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("user_modify_time <=", value, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeIn(List<Date> values) {
            addCriterion("user_modify_time in", values, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeNotIn(List<Date> values) {
            addCriterion("user_modify_time not in", values, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeBetween(Date value1, Date value2) {
            addCriterion("user_modify_time between", value1, value2, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("user_modify_time not between", value1, value2, "userModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNull() {
            addCriterion("user_status is null");
            return (Criteria) this;
        }

        public Criteria andUserStatusIsNotNull() {
            addCriterion("user_status is not null");
            return (Criteria) this;
        }

        public Criteria andUserStatusEqualTo(Boolean value) {
            addCriterion("user_status =", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotEqualTo(Boolean value) {
            addCriterion("user_status <>", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThan(Boolean value) {
            addCriterion("user_status >", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_status >=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThan(Boolean value) {
            addCriterion("user_status <", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("user_status <=", value, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusIn(List<Boolean> values) {
            addCriterion("user_status in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotIn(List<Boolean> values) {
            addCriterion("user_status not in", values, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("user_status between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_status not between", value1, value2, "userStatus");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersIsNull() {
            addCriterion("user_is_members is null");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersIsNotNull() {
            addCriterion("user_is_members is not null");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersEqualTo(Boolean value) {
            addCriterion("user_is_members =", value, "userIsMembers");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersNotEqualTo(Boolean value) {
            addCriterion("user_is_members <>", value, "userIsMembers");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersGreaterThan(Boolean value) {
            addCriterion("user_is_members >", value, "userIsMembers");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_is_members >=", value, "userIsMembers");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersLessThan(Boolean value) {
            addCriterion("user_is_members <", value, "userIsMembers");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersLessThanOrEqualTo(Boolean value) {
            addCriterion("user_is_members <=", value, "userIsMembers");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersIn(List<Boolean> values) {
            addCriterion("user_is_members in", values, "userIsMembers");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersNotIn(List<Boolean> values) {
            addCriterion("user_is_members not in", values, "userIsMembers");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersBetween(Boolean value1, Boolean value2) {
            addCriterion("user_is_members between", value1, value2, "userIsMembers");
            return (Criteria) this;
        }

        public Criteria andUserIsMembersNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_is_members not between", value1, value2, "userIsMembers");
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