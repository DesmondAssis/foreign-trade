package com.desmond.foreigntrade.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InquireExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InquireExample() {
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

        public Criteria andGuestNameIsNull() {
            addCriterion("guest_name is null");
            return (Criteria) this;
        }

        public Criteria andGuestNameIsNotNull() {
            addCriterion("guest_name is not null");
            return (Criteria) this;
        }

        public Criteria andGuestNameEqualTo(String value) {
            addCriterion("guest_name =", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameNotEqualTo(String value) {
            addCriterion("guest_name <>", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameGreaterThan(String value) {
            addCriterion("guest_name >", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameGreaterThanOrEqualTo(String value) {
            addCriterion("guest_name >=", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameLessThan(String value) {
            addCriterion("guest_name <", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameLessThanOrEqualTo(String value) {
            addCriterion("guest_name <=", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameLike(String value) {
            addCriterion("guest_name like", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameNotLike(String value) {
            addCriterion("guest_name not like", value, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameIn(List<String> values) {
            addCriterion("guest_name in", values, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameNotIn(List<String> values) {
            addCriterion("guest_name not in", values, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameBetween(String value1, String value2) {
            addCriterion("guest_name between", value1, value2, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestNameNotBetween(String value1, String value2) {
            addCriterion("guest_name not between", value1, value2, "guestName");
            return (Criteria) this;
        }

        public Criteria andGuestEmailIsNull() {
            addCriterion("guest_email is null");
            return (Criteria) this;
        }

        public Criteria andGuestEmailIsNotNull() {
            addCriterion("guest_email is not null");
            return (Criteria) this;
        }

        public Criteria andGuestEmailEqualTo(String value) {
            addCriterion("guest_email =", value, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailNotEqualTo(String value) {
            addCriterion("guest_email <>", value, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailGreaterThan(String value) {
            addCriterion("guest_email >", value, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailGreaterThanOrEqualTo(String value) {
            addCriterion("guest_email >=", value, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailLessThan(String value) {
            addCriterion("guest_email <", value, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailLessThanOrEqualTo(String value) {
            addCriterion("guest_email <=", value, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailLike(String value) {
            addCriterion("guest_email like", value, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailNotLike(String value) {
            addCriterion("guest_email not like", value, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailIn(List<String> values) {
            addCriterion("guest_email in", values, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailNotIn(List<String> values) {
            addCriterion("guest_email not in", values, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailBetween(String value1, String value2) {
            addCriterion("guest_email between", value1, value2, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestEmailNotBetween(String value1, String value2) {
            addCriterion("guest_email not between", value1, value2, "guestEmail");
            return (Criteria) this;
        }

        public Criteria andGuestMessageIsNull() {
            addCriterion("guest_message is null");
            return (Criteria) this;
        }

        public Criteria andGuestMessageIsNotNull() {
            addCriterion("guest_message is not null");
            return (Criteria) this;
        }

        public Criteria andGuestMessageEqualTo(String value) {
            addCriterion("guest_message =", value, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageNotEqualTo(String value) {
            addCriterion("guest_message <>", value, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageGreaterThan(String value) {
            addCriterion("guest_message >", value, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageGreaterThanOrEqualTo(String value) {
            addCriterion("guest_message >=", value, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageLessThan(String value) {
            addCriterion("guest_message <", value, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageLessThanOrEqualTo(String value) {
            addCriterion("guest_message <=", value, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageLike(String value) {
            addCriterion("guest_message like", value, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageNotLike(String value) {
            addCriterion("guest_message not like", value, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageIn(List<String> values) {
            addCriterion("guest_message in", values, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageNotIn(List<String> values) {
            addCriterion("guest_message not in", values, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageBetween(String value1, String value2) {
            addCriterion("guest_message between", value1, value2, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andGuestMessageNotBetween(String value1, String value2) {
            addCriterion("guest_message not between", value1, value2, "guestMessage");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyIsNull() {
            addCriterion("guest_company is null");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyIsNotNull() {
            addCriterion("guest_company is not null");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyEqualTo(String value) {
            addCriterion("guest_company =", value, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyNotEqualTo(String value) {
            addCriterion("guest_company <>", value, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyGreaterThan(String value) {
            addCriterion("guest_company >", value, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("guest_company >=", value, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyLessThan(String value) {
            addCriterion("guest_company <", value, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyLessThanOrEqualTo(String value) {
            addCriterion("guest_company <=", value, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyLike(String value) {
            addCriterion("guest_company like", value, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyNotLike(String value) {
            addCriterion("guest_company not like", value, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyIn(List<String> values) {
            addCriterion("guest_company in", values, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyNotIn(List<String> values) {
            addCriterion("guest_company not in", values, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyBetween(String value1, String value2) {
            addCriterion("guest_company between", value1, value2, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andGuestCompanyNotBetween(String value1, String value2) {
            addCriterion("guest_company not between", value1, value2, "guestCompany");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeIsNull() {
            addCriterion("phone_country_code is null");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeIsNotNull() {
            addCriterion("phone_country_code is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeEqualTo(String value) {
            addCriterion("phone_country_code =", value, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeNotEqualTo(String value) {
            addCriterion("phone_country_code <>", value, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeGreaterThan(String value) {
            addCriterion("phone_country_code >", value, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("phone_country_code >=", value, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeLessThan(String value) {
            addCriterion("phone_country_code <", value, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeLessThanOrEqualTo(String value) {
            addCriterion("phone_country_code <=", value, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeLike(String value) {
            addCriterion("phone_country_code like", value, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeNotLike(String value) {
            addCriterion("phone_country_code not like", value, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeIn(List<String> values) {
            addCriterion("phone_country_code in", values, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeNotIn(List<String> values) {
            addCriterion("phone_country_code not in", values, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeBetween(String value1, String value2) {
            addCriterion("phone_country_code between", value1, value2, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneCountryCodeNotBetween(String value1, String value2) {
            addCriterion("phone_country_code not between", value1, value2, "phoneCountryCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeIsNull() {
            addCriterion("phone_area_code is null");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeIsNotNull() {
            addCriterion("phone_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeEqualTo(String value) {
            addCriterion("phone_area_code =", value, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeNotEqualTo(String value) {
            addCriterion("phone_area_code <>", value, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeGreaterThan(String value) {
            addCriterion("phone_area_code >", value, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("phone_area_code >=", value, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeLessThan(String value) {
            addCriterion("phone_area_code <", value, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("phone_area_code <=", value, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeLike(String value) {
            addCriterion("phone_area_code like", value, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeNotLike(String value) {
            addCriterion("phone_area_code not like", value, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeIn(List<String> values) {
            addCriterion("phone_area_code in", values, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeNotIn(List<String> values) {
            addCriterion("phone_area_code not in", values, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeBetween(String value1, String value2) {
            addCriterion("phone_area_code between", value1, value2, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneAreaCodeNotBetween(String value1, String value2) {
            addCriterion("phone_area_code not between", value1, value2, "phoneAreaCode");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumIsNull() {
            addCriterion("phone_tel_num is null");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumIsNotNull() {
            addCriterion("phone_tel_num is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumEqualTo(String value) {
            addCriterion("phone_tel_num =", value, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumNotEqualTo(String value) {
            addCriterion("phone_tel_num <>", value, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumGreaterThan(String value) {
            addCriterion("phone_tel_num >", value, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumGreaterThanOrEqualTo(String value) {
            addCriterion("phone_tel_num >=", value, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumLessThan(String value) {
            addCriterion("phone_tel_num <", value, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumLessThanOrEqualTo(String value) {
            addCriterion("phone_tel_num <=", value, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumLike(String value) {
            addCriterion("phone_tel_num like", value, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumNotLike(String value) {
            addCriterion("phone_tel_num not like", value, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumIn(List<String> values) {
            addCriterion("phone_tel_num in", values, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumNotIn(List<String> values) {
            addCriterion("phone_tel_num not in", values, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumBetween(String value1, String value2) {
            addCriterion("phone_tel_num between", value1, value2, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andPhoneTelNumNotBetween(String value1, String value2) {
            addCriterion("phone_tel_num not between", value1, value2, "phoneTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeIsNull() {
            addCriterion("fax_country_code is null");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeIsNotNull() {
            addCriterion("fax_country_code is not null");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeEqualTo(String value) {
            addCriterion("fax_country_code =", value, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeNotEqualTo(String value) {
            addCriterion("fax_country_code <>", value, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeGreaterThan(String value) {
            addCriterion("fax_country_code >", value, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fax_country_code >=", value, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeLessThan(String value) {
            addCriterion("fax_country_code <", value, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeLessThanOrEqualTo(String value) {
            addCriterion("fax_country_code <=", value, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeLike(String value) {
            addCriterion("fax_country_code like", value, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeNotLike(String value) {
            addCriterion("fax_country_code not like", value, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeIn(List<String> values) {
            addCriterion("fax_country_code in", values, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeNotIn(List<String> values) {
            addCriterion("fax_country_code not in", values, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeBetween(String value1, String value2) {
            addCriterion("fax_country_code between", value1, value2, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxCountryCodeNotBetween(String value1, String value2) {
            addCriterion("fax_country_code not between", value1, value2, "faxCountryCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeIsNull() {
            addCriterion("fax_area_code is null");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeIsNotNull() {
            addCriterion("fax_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeEqualTo(String value) {
            addCriterion("fax_area_code =", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeNotEqualTo(String value) {
            addCriterion("fax_area_code <>", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeGreaterThan(String value) {
            addCriterion("fax_area_code >", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fax_area_code >=", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeLessThan(String value) {
            addCriterion("fax_area_code <", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("fax_area_code <=", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeLike(String value) {
            addCriterion("fax_area_code like", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeNotLike(String value) {
            addCriterion("fax_area_code not like", value, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeIn(List<String> values) {
            addCriterion("fax_area_code in", values, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeNotIn(List<String> values) {
            addCriterion("fax_area_code not in", values, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeBetween(String value1, String value2) {
            addCriterion("fax_area_code between", value1, value2, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxAreaCodeNotBetween(String value1, String value2) {
            addCriterion("fax_area_code not between", value1, value2, "faxAreaCode");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumIsNull() {
            addCriterion("fax_tel_num is null");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumIsNotNull() {
            addCriterion("fax_tel_num is not null");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumEqualTo(String value) {
            addCriterion("fax_tel_num =", value, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumNotEqualTo(String value) {
            addCriterion("fax_tel_num <>", value, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumGreaterThan(String value) {
            addCriterion("fax_tel_num >", value, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumGreaterThanOrEqualTo(String value) {
            addCriterion("fax_tel_num >=", value, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumLessThan(String value) {
            addCriterion("fax_tel_num <", value, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumLessThanOrEqualTo(String value) {
            addCriterion("fax_tel_num <=", value, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumLike(String value) {
            addCriterion("fax_tel_num like", value, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumNotLike(String value) {
            addCriterion("fax_tel_num not like", value, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumIn(List<String> values) {
            addCriterion("fax_tel_num in", values, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumNotIn(List<String> values) {
            addCriterion("fax_tel_num not in", values, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumBetween(String value1, String value2) {
            addCriterion("fax_tel_num between", value1, value2, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andFaxTelNumNotBetween(String value1, String value2) {
            addCriterion("fax_tel_num not between", value1, value2, "faxTelNum");
            return (Criteria) this;
        }

        public Criteria andSendMailIsNull() {
            addCriterion("send_mail is null");
            return (Criteria) this;
        }

        public Criteria andSendMailIsNotNull() {
            addCriterion("send_mail is not null");
            return (Criteria) this;
        }

        public Criteria andSendMailEqualTo(Boolean value) {
            addCriterion("send_mail =", value, "sendMail");
            return (Criteria) this;
        }

        public Criteria andSendMailNotEqualTo(Boolean value) {
            addCriterion("send_mail <>", value, "sendMail");
            return (Criteria) this;
        }

        public Criteria andSendMailGreaterThan(Boolean value) {
            addCriterion("send_mail >", value, "sendMail");
            return (Criteria) this;
        }

        public Criteria andSendMailGreaterThanOrEqualTo(Boolean value) {
            addCriterion("send_mail >=", value, "sendMail");
            return (Criteria) this;
        }

        public Criteria andSendMailLessThan(Boolean value) {
            addCriterion("send_mail <", value, "sendMail");
            return (Criteria) this;
        }

        public Criteria andSendMailLessThanOrEqualTo(Boolean value) {
            addCriterion("send_mail <=", value, "sendMail");
            return (Criteria) this;
        }

        public Criteria andSendMailIn(List<Boolean> values) {
            addCriterion("send_mail in", values, "sendMail");
            return (Criteria) this;
        }

        public Criteria andSendMailNotIn(List<Boolean> values) {
            addCriterion("send_mail not in", values, "sendMail");
            return (Criteria) this;
        }

        public Criteria andSendMailBetween(Boolean value1, Boolean value2) {
            addCriterion("send_mail between", value1, value2, "sendMail");
            return (Criteria) this;
        }

        public Criteria andSendMailNotBetween(Boolean value1, Boolean value2) {
            addCriterion("send_mail not between", value1, value2, "sendMail");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
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