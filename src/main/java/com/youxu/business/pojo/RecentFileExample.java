package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.List;

public class RecentFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecentFileExample() {
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

        public Criteria andRecentFileIdIsNull() {
            addCriterion("recent_file_id is null");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdIsNotNull() {
            addCriterion("recent_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdEqualTo(Integer value) {
            addCriterion("recent_file_id =", value, "recentFileId");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdNotEqualTo(Integer value) {
            addCriterion("recent_file_id <>", value, "recentFileId");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdGreaterThan(Integer value) {
            addCriterion("recent_file_id >", value, "recentFileId");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recent_file_id >=", value, "recentFileId");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdLessThan(Integer value) {
            addCriterion("recent_file_id <", value, "recentFileId");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("recent_file_id <=", value, "recentFileId");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdIn(List<Integer> values) {
            addCriterion("recent_file_id in", values, "recentFileId");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdNotIn(List<Integer> values) {
            addCriterion("recent_file_id not in", values, "recentFileId");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdBetween(Integer value1, Integer value2) {
            addCriterion("recent_file_id between", value1, value2, "recentFileId");
            return (Criteria) this;
        }

        public Criteria andRecentFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recent_file_id not between", value1, value2, "recentFileId");
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

        public Criteria andRecentFileNameIsNull() {
            addCriterion("recent_file_name is null");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameIsNotNull() {
            addCriterion("recent_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameEqualTo(String value) {
            addCriterion("recent_file_name =", value, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameNotEqualTo(String value) {
            addCriterion("recent_file_name <>", value, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameGreaterThan(String value) {
            addCriterion("recent_file_name >", value, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("recent_file_name >=", value, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameLessThan(String value) {
            addCriterion("recent_file_name <", value, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameLessThanOrEqualTo(String value) {
            addCriterion("recent_file_name <=", value, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameLike(String value) {
            addCriterion("recent_file_name like", value, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameNotLike(String value) {
            addCriterion("recent_file_name not like", value, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameIn(List<String> values) {
            addCriterion("recent_file_name in", values, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameNotIn(List<String> values) {
            addCriterion("recent_file_name not in", values, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameBetween(String value1, String value2) {
            addCriterion("recent_file_name between", value1, value2, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileNameNotBetween(String value1, String value2) {
            addCriterion("recent_file_name not between", value1, value2, "recentFileName");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeIsNull() {
            addCriterion("recent_file_size is null");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeIsNotNull() {
            addCriterion("recent_file_size is not null");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeEqualTo(String value) {
            addCriterion("recent_file_size =", value, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeNotEqualTo(String value) {
            addCriterion("recent_file_size <>", value, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeGreaterThan(String value) {
            addCriterion("recent_file_size >", value, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeGreaterThanOrEqualTo(String value) {
            addCriterion("recent_file_size >=", value, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeLessThan(String value) {
            addCriterion("recent_file_size <", value, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeLessThanOrEqualTo(String value) {
            addCriterion("recent_file_size <=", value, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeLike(String value) {
            addCriterion("recent_file_size like", value, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeNotLike(String value) {
            addCriterion("recent_file_size not like", value, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeIn(List<String> values) {
            addCriterion("recent_file_size in", values, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeNotIn(List<String> values) {
            addCriterion("recent_file_size not in", values, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeBetween(String value1, String value2) {
            addCriterion("recent_file_size between", value1, value2, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFileSizeNotBetween(String value1, String value2) {
            addCriterion("recent_file_size not between", value1, value2, "recentFileSize");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathIsNull() {
            addCriterion("recent_file_path is null");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathIsNotNull() {
            addCriterion("recent_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathEqualTo(String value) {
            addCriterion("recent_file_path =", value, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathNotEqualTo(String value) {
            addCriterion("recent_file_path <>", value, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathGreaterThan(String value) {
            addCriterion("recent_file_path >", value, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("recent_file_path >=", value, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathLessThan(String value) {
            addCriterion("recent_file_path <", value, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathLessThanOrEqualTo(String value) {
            addCriterion("recent_file_path <=", value, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathLike(String value) {
            addCriterion("recent_file_path like", value, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathNotLike(String value) {
            addCriterion("recent_file_path not like", value, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathIn(List<String> values) {
            addCriterion("recent_file_path in", values, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathNotIn(List<String> values) {
            addCriterion("recent_file_path not in", values, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathBetween(String value1, String value2) {
            addCriterion("recent_file_path between", value1, value2, "recentFilePath");
            return (Criteria) this;
        }

        public Criteria andRecentFilePathNotBetween(String value1, String value2) {
            addCriterion("recent_file_path not between", value1, value2, "recentFilePath");
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

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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