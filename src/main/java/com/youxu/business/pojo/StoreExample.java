package com.youxu.business.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreExample() {
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

        public Criteria andStoreAddressIsNull() {
            addCriterion("store_address is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNotNull() {
            addCriterion("store_address is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressEqualTo(String value) {
            addCriterion("store_address =", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotEqualTo(String value) {
            addCriterion("store_address <>", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThan(String value) {
            addCriterion("store_address >", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThanOrEqualTo(String value) {
            addCriterion("store_address >=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThan(String value) {
            addCriterion("store_address <", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThanOrEqualTo(String value) {
            addCriterion("store_address <=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLike(String value) {
            addCriterion("store_address like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotLike(String value) {
            addCriterion("store_address not like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIn(List<String> values) {
            addCriterion("store_address in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotIn(List<String> values) {
            addCriterion("store_address not in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressBetween(String value1, String value2) {
            addCriterion("store_address between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotBetween(String value1, String value2) {
            addCriterion("store_address not between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIsNull() {
            addCriterion("store_phone is null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIsNotNull() {
            addCriterion("store_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStorePhoneEqualTo(String value) {
            addCriterion("store_phone =", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotEqualTo(String value) {
            addCriterion("store_phone <>", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneGreaterThan(String value) {
            addCriterion("store_phone >", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("store_phone >=", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLessThan(String value) {
            addCriterion("store_phone <", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLessThanOrEqualTo(String value) {
            addCriterion("store_phone <=", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneLike(String value) {
            addCriterion("store_phone like", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotLike(String value) {
            addCriterion("store_phone not like", value, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneIn(List<String> values) {
            addCriterion("store_phone in", values, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotIn(List<String> values) {
            addCriterion("store_phone not in", values, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneBetween(String value1, String value2) {
            addCriterion("store_phone between", value1, value2, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStorePhoneNotBetween(String value1, String value2) {
            addCriterion("store_phone not between", value1, value2, "storePhone");
            return (Criteria) this;
        }

        public Criteria andStoreTimeIsNull() {
            addCriterion("store_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreTimeIsNotNull() {
            addCriterion("store_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTimeEqualTo(String value) {
            addCriterion("store_time =", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeNotEqualTo(String value) {
            addCriterion("store_time <>", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeGreaterThan(String value) {
            addCriterion("store_time >", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeGreaterThanOrEqualTo(String value) {
            addCriterion("store_time >=", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeLessThan(String value) {
            addCriterion("store_time <", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeLessThanOrEqualTo(String value) {
            addCriterion("store_time <=", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeLike(String value) {
            addCriterion("store_time like", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeNotLike(String value) {
            addCriterion("store_time not like", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeIn(List<String> values) {
            addCriterion("store_time in", values, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeNotIn(List<String> values) {
            addCriterion("store_time not in", values, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeBetween(String value1, String value2) {
            addCriterion("store_time between", value1, value2, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeNotBetween(String value1, String value2) {
            addCriterion("store_time not between", value1, value2, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutIsNull() {
            addCriterion("store_open_for_out is null");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutIsNotNull() {
            addCriterion("store_open_for_out is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutEqualTo(Byte value) {
            addCriterion("store_open_for_out =", value, "storeOpenForOut");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutNotEqualTo(Byte value) {
            addCriterion("store_open_for_out <>", value, "storeOpenForOut");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutGreaterThan(Byte value) {
            addCriterion("store_open_for_out >", value, "storeOpenForOut");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutGreaterThanOrEqualTo(Byte value) {
            addCriterion("store_open_for_out >=", value, "storeOpenForOut");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutLessThan(Byte value) {
            addCriterion("store_open_for_out <", value, "storeOpenForOut");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutLessThanOrEqualTo(Byte value) {
            addCriterion("store_open_for_out <=", value, "storeOpenForOut");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutIn(List<Byte> values) {
            addCriterion("store_open_for_out in", values, "storeOpenForOut");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutNotIn(List<Byte> values) {
            addCriterion("store_open_for_out not in", values, "storeOpenForOut");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutBetween(Byte value1, Byte value2) {
            addCriterion("store_open_for_out between", value1, value2, "storeOpenForOut");
            return (Criteria) this;
        }

        public Criteria andStoreOpenForOutNotBetween(Byte value1, Byte value2) {
            addCriterion("store_open_for_out not between", value1, value2, "storeOpenForOut");
            return (Criteria) this;
        }

        public Criteria andOutputSizeIsNull() {
            addCriterion("output_size is null");
            return (Criteria) this;
        }

        public Criteria andOutputSizeIsNotNull() {
            addCriterion("output_size is not null");
            return (Criteria) this;
        }

        public Criteria andOutputSizeEqualTo(String value) {
            addCriterion("output_size =", value, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeNotEqualTo(String value) {
            addCriterion("output_size <>", value, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeGreaterThan(String value) {
            addCriterion("output_size >", value, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeGreaterThanOrEqualTo(String value) {
            addCriterion("output_size >=", value, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeLessThan(String value) {
            addCriterion("output_size <", value, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeLessThanOrEqualTo(String value) {
            addCriterion("output_size <=", value, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeLike(String value) {
            addCriterion("output_size like", value, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeNotLike(String value) {
            addCriterion("output_size not like", value, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeIn(List<String> values) {
            addCriterion("output_size in", values, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeNotIn(List<String> values) {
            addCriterion("output_size not in", values, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeBetween(String value1, String value2) {
            addCriterion("output_size between", value1, value2, "outputSize");
            return (Criteria) this;
        }

        public Criteria andOutputSizeNotBetween(String value1, String value2) {
            addCriterion("output_size not between", value1, value2, "outputSize");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourIsNull() {
            addCriterion("store_output_colour is null");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourIsNotNull() {
            addCriterion("store_output_colour is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourEqualTo(String value) {
            addCriterion("store_output_colour =", value, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourNotEqualTo(String value) {
            addCriterion("store_output_colour <>", value, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourGreaterThan(String value) {
            addCriterion("store_output_colour >", value, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourGreaterThanOrEqualTo(String value) {
            addCriterion("store_output_colour >=", value, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourLessThan(String value) {
            addCriterion("store_output_colour <", value, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourLessThanOrEqualTo(String value) {
            addCriterion("store_output_colour <=", value, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourLike(String value) {
            addCriterion("store_output_colour like", value, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourNotLike(String value) {
            addCriterion("store_output_colour not like", value, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourIn(List<String> values) {
            addCriterion("store_output_colour in", values, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourNotIn(List<String> values) {
            addCriterion("store_output_colour not in", values, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourBetween(String value1, String value2) {
            addCriterion("store_output_colour between", value1, value2, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreOutputColourNotBetween(String value1, String value2) {
            addCriterion("store_output_colour not between", value1, value2, "storeOutputColour");
            return (Criteria) this;
        }

        public Criteria andStoreQualityIsNull() {
            addCriterion("store_quality is null");
            return (Criteria) this;
        }

        public Criteria andStoreQualityIsNotNull() {
            addCriterion("store_quality is not null");
            return (Criteria) this;
        }

        public Criteria andStoreQualityEqualTo(String value) {
            addCriterion("store_quality =", value, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityNotEqualTo(String value) {
            addCriterion("store_quality <>", value, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityGreaterThan(String value) {
            addCriterion("store_quality >", value, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityGreaterThanOrEqualTo(String value) {
            addCriterion("store_quality >=", value, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityLessThan(String value) {
            addCriterion("store_quality <", value, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityLessThanOrEqualTo(String value) {
            addCriterion("store_quality <=", value, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityLike(String value) {
            addCriterion("store_quality like", value, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityNotLike(String value) {
            addCriterion("store_quality not like", value, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityIn(List<String> values) {
            addCriterion("store_quality in", values, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityNotIn(List<String> values) {
            addCriterion("store_quality not in", values, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityBetween(String value1, String value2) {
            addCriterion("store_quality between", value1, value2, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreQualityNotBetween(String value1, String value2) {
            addCriterion("store_quality not between", value1, value2, "storeQuality");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeIsNull() {
            addCriterion("store_latitude is null");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeIsNotNull() {
            addCriterion("store_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeEqualTo(Double value) {
            addCriterion("store_latitude =", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotEqualTo(Double value) {
            addCriterion("store_latitude <>", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeGreaterThan(Double value) {
            addCriterion("store_latitude >", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("store_latitude >=", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeLessThan(Double value) {
            addCriterion("store_latitude <", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("store_latitude <=", value, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeIn(List<Double> values) {
            addCriterion("store_latitude in", values, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotIn(List<Double> values) {
            addCriterion("store_latitude not in", values, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeBetween(Double value1, Double value2) {
            addCriterion("store_latitude between", value1, value2, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("store_latitude not between", value1, value2, "storeLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeIsNull() {
            addCriterion("store_longitude is null");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeIsNotNull() {
            addCriterion("store_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeEqualTo(Double value) {
            addCriterion("store_longitude =", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotEqualTo(Double value) {
            addCriterion("store_longitude <>", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeGreaterThan(Double value) {
            addCriterion("store_longitude >", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("store_longitude >=", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeLessThan(Double value) {
            addCriterion("store_longitude <", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("store_longitude <=", value, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeIn(List<Double> values) {
            addCriterion("store_longitude in", values, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotIn(List<Double> values) {
            addCriterion("store_longitude not in", values, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeBetween(Double value1, Double value2) {
            addCriterion("store_longitude between", value1, value2, "storeLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("store_longitude not between", value1, value2, "storeLongitude");
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