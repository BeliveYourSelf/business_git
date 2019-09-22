package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDetailsBookBindingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDetailsBookBindingExample() {
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

        public Criteria andOrderDetailsIdIsNull() {
            addCriterion("order_details_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdIsNotNull() {
            addCriterion("order_details_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdEqualTo(Integer value) {
            addCriterion("order_details_id =", value, "orderDetailsId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdNotEqualTo(Integer value) {
            addCriterion("order_details_id <>", value, "orderDetailsId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdGreaterThan(Integer value) {
            addCriterion("order_details_id >", value, "orderDetailsId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_details_id >=", value, "orderDetailsId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdLessThan(Integer value) {
            addCriterion("order_details_id <", value, "orderDetailsId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_details_id <=", value, "orderDetailsId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdIn(List<Integer> values) {
            addCriterion("order_details_id in", values, "orderDetailsId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdNotIn(List<Integer> values) {
            addCriterion("order_details_id not in", values, "orderDetailsId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdBetween(Integer value1, Integer value2) {
            addCriterion("order_details_id between", value1, value2, "orderDetailsId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_details_id not between", value1, value2, "orderDetailsId");
            return (Criteria) this;
        }

        public Criteria andCoverColorIsNull() {
            addCriterion("cover_color is null");
            return (Criteria) this;
        }

        public Criteria andCoverColorIsNotNull() {
            addCriterion("cover_color is not null");
            return (Criteria) this;
        }

        public Criteria andCoverColorEqualTo(String value) {
            addCriterion("cover_color =", value, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorNotEqualTo(String value) {
            addCriterion("cover_color <>", value, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorGreaterThan(String value) {
            addCriterion("cover_color >", value, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorGreaterThanOrEqualTo(String value) {
            addCriterion("cover_color >=", value, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorLessThan(String value) {
            addCriterion("cover_color <", value, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorLessThanOrEqualTo(String value) {
            addCriterion("cover_color <=", value, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorLike(String value) {
            addCriterion("cover_color like", value, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorNotLike(String value) {
            addCriterion("cover_color not like", value, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorIn(List<String> values) {
            addCriterion("cover_color in", values, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorNotIn(List<String> values) {
            addCriterion("cover_color not in", values, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorBetween(String value1, String value2) {
            addCriterion("cover_color between", value1, value2, "coverColor");
            return (Criteria) this;
        }

        public Criteria andCoverColorNotBetween(String value1, String value2) {
            addCriterion("cover_color not between", value1, value2, "coverColor");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionIsNull() {
            addCriterion("face_direction is null");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionIsNotNull() {
            addCriterion("face_direction is not null");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionEqualTo(String value) {
            addCriterion("face_direction =", value, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionNotEqualTo(String value) {
            addCriterion("face_direction <>", value, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionGreaterThan(String value) {
            addCriterion("face_direction >", value, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("face_direction >=", value, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionLessThan(String value) {
            addCriterion("face_direction <", value, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionLessThanOrEqualTo(String value) {
            addCriterion("face_direction <=", value, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionLike(String value) {
            addCriterion("face_direction like", value, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionNotLike(String value) {
            addCriterion("face_direction not like", value, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionIn(List<String> values) {
            addCriterion("face_direction in", values, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionNotIn(List<String> values) {
            addCriterion("face_direction not in", values, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionBetween(String value1, String value2) {
            addCriterion("face_direction between", value1, value2, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andFaceDirectionNotBetween(String value1, String value2) {
            addCriterion("face_direction not between", value1, value2, "faceDirection");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlIsNull() {
            addCriterion("cover_file_url is null");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlIsNotNull() {
            addCriterion("cover_file_url is not null");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlEqualTo(String value) {
            addCriterion("cover_file_url =", value, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlNotEqualTo(String value) {
            addCriterion("cover_file_url <>", value, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlGreaterThan(String value) {
            addCriterion("cover_file_url >", value, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cover_file_url >=", value, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlLessThan(String value) {
            addCriterion("cover_file_url <", value, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlLessThanOrEqualTo(String value) {
            addCriterion("cover_file_url <=", value, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlLike(String value) {
            addCriterion("cover_file_url like", value, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlNotLike(String value) {
            addCriterion("cover_file_url not like", value, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlIn(List<String> values) {
            addCriterion("cover_file_url in", values, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlNotIn(List<String> values) {
            addCriterion("cover_file_url not in", values, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlBetween(String value1, String value2) {
            addCriterion("cover_file_url between", value1, value2, "coverFileUrl");
            return (Criteria) this;
        }

        public Criteria andCoverFileUrlNotBetween(String value1, String value2) {
            addCriterion("cover_file_url not between", value1, value2, "coverFileUrl");
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