package org.gfarm.entity;

import java.util.ArrayList;
import java.util.List;

public class GfComradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GfComradeExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("member_id like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("member_id not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andDiscordNameIsNull() {
            addCriterion("discord_name is null");
            return (Criteria) this;
        }

        public Criteria andDiscordNameIsNotNull() {
            addCriterion("discord_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiscordNameEqualTo(String value) {
            addCriterion("discord_name =", value, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameNotEqualTo(String value) {
            addCriterion("discord_name <>", value, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameGreaterThan(String value) {
            addCriterion("discord_name >", value, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameGreaterThanOrEqualTo(String value) {
            addCriterion("discord_name >=", value, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameLessThan(String value) {
            addCriterion("discord_name <", value, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameLessThanOrEqualTo(String value) {
            addCriterion("discord_name <=", value, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameLike(String value) {
            addCriterion("discord_name like", value, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameNotLike(String value) {
            addCriterion("discord_name not like", value, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameIn(List<String> values) {
            addCriterion("discord_name in", values, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameNotIn(List<String> values) {
            addCriterion("discord_name not in", values, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameBetween(String value1, String value2) {
            addCriterion("discord_name between", value1, value2, "discordName");
            return (Criteria) this;
        }

        public Criteria andDiscordNameNotBetween(String value1, String value2) {
            addCriterion("discord_name not between", value1, value2, "discordName");
            return (Criteria) this;
        }

        public Criteria andRuleDonateIsNull() {
            addCriterion("rule_donate is null");
            return (Criteria) this;
        }

        public Criteria andRuleDonateIsNotNull() {
            addCriterion("rule_donate is not null");
            return (Criteria) this;
        }

        public Criteria andRuleDonateEqualTo(Long value) {
            addCriterion("rule_donate =", value, "ruleDonate");
            return (Criteria) this;
        }

        public Criteria andRuleDonateNotEqualTo(Long value) {
            addCriterion("rule_donate <>", value, "ruleDonate");
            return (Criteria) this;
        }

        public Criteria andRuleDonateGreaterThan(Long value) {
            addCriterion("rule_donate >", value, "ruleDonate");
            return (Criteria) this;
        }

        public Criteria andRuleDonateGreaterThanOrEqualTo(Long value) {
            addCriterion("rule_donate >=", value, "ruleDonate");
            return (Criteria) this;
        }

        public Criteria andRuleDonateLessThan(Long value) {
            addCriterion("rule_donate <", value, "ruleDonate");
            return (Criteria) this;
        }

        public Criteria andRuleDonateLessThanOrEqualTo(Long value) {
            addCriterion("rule_donate <=", value, "ruleDonate");
            return (Criteria) this;
        }

        public Criteria andRuleDonateIn(List<Long> values) {
            addCriterion("rule_donate in", values, "ruleDonate");
            return (Criteria) this;
        }

        public Criteria andRuleDonateNotIn(List<Long> values) {
            addCriterion("rule_donate not in", values, "ruleDonate");
            return (Criteria) this;
        }

        public Criteria andRuleDonateBetween(Long value1, Long value2) {
            addCriterion("rule_donate between", value1, value2, "ruleDonate");
            return (Criteria) this;
        }

        public Criteria andRuleDonateNotBetween(Long value1, Long value2) {
            addCriterion("rule_donate not between", value1, value2, "ruleDonate");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairIsNull() {
            addCriterion("peculiar_chair is null");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairIsNotNull() {
            addCriterion("peculiar_chair is not null");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairEqualTo(Byte value) {
            addCriterion("peculiar_chair =", value, "peculiarChair");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairNotEqualTo(Byte value) {
            addCriterion("peculiar_chair <>", value, "peculiarChair");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairGreaterThan(Byte value) {
            addCriterion("peculiar_chair >", value, "peculiarChair");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairGreaterThanOrEqualTo(Byte value) {
            addCriterion("peculiar_chair >=", value, "peculiarChair");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairLessThan(Byte value) {
            addCriterion("peculiar_chair <", value, "peculiarChair");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairLessThanOrEqualTo(Byte value) {
            addCriterion("peculiar_chair <=", value, "peculiarChair");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairIn(List<Byte> values) {
            addCriterion("peculiar_chair in", values, "peculiarChair");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairNotIn(List<Byte> values) {
            addCriterion("peculiar_chair not in", values, "peculiarChair");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairBetween(Byte value1, Byte value2) {
            addCriterion("peculiar_chair between", value1, value2, "peculiarChair");
            return (Criteria) this;
        }

        public Criteria andPeculiarChairNotBetween(Byte value1, Byte value2) {
            addCriterion("peculiar_chair not between", value1, value2, "peculiarChair");
            return (Criteria) this;
        }

        public Criteria andVogInvestorIsNull() {
            addCriterion("vog_investor is null");
            return (Criteria) this;
        }

        public Criteria andVogInvestorIsNotNull() {
            addCriterion("vog_investor is not null");
            return (Criteria) this;
        }

        public Criteria andVogInvestorEqualTo(Long value) {
            addCriterion("vog_investor =", value, "vogInvestor");
            return (Criteria) this;
        }

        public Criteria andVogInvestorNotEqualTo(Long value) {
            addCriterion("vog_investor <>", value, "vogInvestor");
            return (Criteria) this;
        }

        public Criteria andVogInvestorGreaterThan(Long value) {
            addCriterion("vog_investor >", value, "vogInvestor");
            return (Criteria) this;
        }

        public Criteria andVogInvestorGreaterThanOrEqualTo(Long value) {
            addCriterion("vog_investor >=", value, "vogInvestor");
            return (Criteria) this;
        }

        public Criteria andVogInvestorLessThan(Long value) {
            addCriterion("vog_investor <", value, "vogInvestor");
            return (Criteria) this;
        }

        public Criteria andVogInvestorLessThanOrEqualTo(Long value) {
            addCriterion("vog_investor <=", value, "vogInvestor");
            return (Criteria) this;
        }

        public Criteria andVogInvestorIn(List<Long> values) {
            addCriterion("vog_investor in", values, "vogInvestor");
            return (Criteria) this;
        }

        public Criteria andVogInvestorNotIn(List<Long> values) {
            addCriterion("vog_investor not in", values, "vogInvestor");
            return (Criteria) this;
        }

        public Criteria andVogInvestorBetween(Long value1, Long value2) {
            addCriterion("vog_investor between", value1, value2, "vogInvestor");
            return (Criteria) this;
        }

        public Criteria andVogInvestorNotBetween(Long value1, Long value2) {
            addCriterion("vog_investor not between", value1, value2, "vogInvestor");
            return (Criteria) this;
        }

        public Criteria andLoanerIsNull() {
            addCriterion("loaner is null");
            return (Criteria) this;
        }

        public Criteria andLoanerIsNotNull() {
            addCriterion("loaner is not null");
            return (Criteria) this;
        }

        public Criteria andLoanerEqualTo(Long value) {
            addCriterion("loaner =", value, "loaner");
            return (Criteria) this;
        }

        public Criteria andLoanerNotEqualTo(Long value) {
            addCriterion("loaner <>", value, "loaner");
            return (Criteria) this;
        }

        public Criteria andLoanerGreaterThan(Long value) {
            addCriterion("loaner >", value, "loaner");
            return (Criteria) this;
        }

        public Criteria andLoanerGreaterThanOrEqualTo(Long value) {
            addCriterion("loaner >=", value, "loaner");
            return (Criteria) this;
        }

        public Criteria andLoanerLessThan(Long value) {
            addCriterion("loaner <", value, "loaner");
            return (Criteria) this;
        }

        public Criteria andLoanerLessThanOrEqualTo(Long value) {
            addCriterion("loaner <=", value, "loaner");
            return (Criteria) this;
        }

        public Criteria andLoanerIn(List<Long> values) {
            addCriterion("loaner in", values, "loaner");
            return (Criteria) this;
        }

        public Criteria andLoanerNotIn(List<Long> values) {
            addCriterion("loaner not in", values, "loaner");
            return (Criteria) this;
        }

        public Criteria andLoanerBetween(Long value1, Long value2) {
            addCriterion("loaner between", value1, value2, "loaner");
            return (Criteria) this;
        }

        public Criteria andLoanerNotBetween(Long value1, Long value2) {
            addCriterion("loaner not between", value1, value2, "loaner");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorIsNull() {
            addCriterion("gdollar_investor is null");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorIsNotNull() {
            addCriterion("gdollar_investor is not null");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorEqualTo(Long value) {
            addCriterion("gdollar_investor =", value, "gdollarInvestor");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorNotEqualTo(Long value) {
            addCriterion("gdollar_investor <>", value, "gdollarInvestor");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorGreaterThan(Long value) {
            addCriterion("gdollar_investor >", value, "gdollarInvestor");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorGreaterThanOrEqualTo(Long value) {
            addCriterion("gdollar_investor >=", value, "gdollarInvestor");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorLessThan(Long value) {
            addCriterion("gdollar_investor <", value, "gdollarInvestor");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorLessThanOrEqualTo(Long value) {
            addCriterion("gdollar_investor <=", value, "gdollarInvestor");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorIn(List<Long> values) {
            addCriterion("gdollar_investor in", values, "gdollarInvestor");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorNotIn(List<Long> values) {
            addCriterion("gdollar_investor not in", values, "gdollarInvestor");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorBetween(Long value1, Long value2) {
            addCriterion("gdollar_investor between", value1, value2, "gdollarInvestor");
            return (Criteria) this;
        }

        public Criteria andGdollarInvestorNotBetween(Long value1, Long value2) {
            addCriterion("gdollar_investor not between", value1, value2, "gdollarInvestor");
            return (Criteria) this;
        }

        public Criteria andG1InvestorIsNull() {
            addCriterion("g1_investor is null");
            return (Criteria) this;
        }

        public Criteria andG1InvestorIsNotNull() {
            addCriterion("g1_investor is not null");
            return (Criteria) this;
        }

        public Criteria andG1InvestorEqualTo(Long value) {
            addCriterion("g1_investor =", value, "g1Investor");
            return (Criteria) this;
        }

        public Criteria andG1InvestorNotEqualTo(Long value) {
            addCriterion("g1_investor <>", value, "g1Investor");
            return (Criteria) this;
        }

        public Criteria andG1InvestorGreaterThan(Long value) {
            addCriterion("g1_investor >", value, "g1Investor");
            return (Criteria) this;
        }

        public Criteria andG1InvestorGreaterThanOrEqualTo(Long value) {
            addCriterion("g1_investor >=", value, "g1Investor");
            return (Criteria) this;
        }

        public Criteria andG1InvestorLessThan(Long value) {
            addCriterion("g1_investor <", value, "g1Investor");
            return (Criteria) this;
        }

        public Criteria andG1InvestorLessThanOrEqualTo(Long value) {
            addCriterion("g1_investor <=", value, "g1Investor");
            return (Criteria) this;
        }

        public Criteria andG1InvestorIn(List<Long> values) {
            addCriterion("g1_investor in", values, "g1Investor");
            return (Criteria) this;
        }

        public Criteria andG1InvestorNotIn(List<Long> values) {
            addCriterion("g1_investor not in", values, "g1Investor");
            return (Criteria) this;
        }

        public Criteria andG1InvestorBetween(Long value1, Long value2) {
            addCriterion("g1_investor between", value1, value2, "g1Investor");
            return (Criteria) this;
        }

        public Criteria andG1InvestorNotBetween(Long value1, Long value2) {
            addCriterion("g1_investor not between", value1, value2, "g1Investor");
            return (Criteria) this;
        }

        public Criteria andParadeIsNull() {
            addCriterion("parade is null");
            return (Criteria) this;
        }

        public Criteria andParadeIsNotNull() {
            addCriterion("parade is not null");
            return (Criteria) this;
        }

        public Criteria andParadeEqualTo(Byte value) {
            addCriterion("parade =", value, "parade");
            return (Criteria) this;
        }

        public Criteria andParadeNotEqualTo(Byte value) {
            addCriterion("parade <>", value, "parade");
            return (Criteria) this;
        }

        public Criteria andParadeGreaterThan(Byte value) {
            addCriterion("parade >", value, "parade");
            return (Criteria) this;
        }

        public Criteria andParadeGreaterThanOrEqualTo(Byte value) {
            addCriterion("parade >=", value, "parade");
            return (Criteria) this;
        }

        public Criteria andParadeLessThan(Byte value) {
            addCriterion("parade <", value, "parade");
            return (Criteria) this;
        }

        public Criteria andParadeLessThanOrEqualTo(Byte value) {
            addCriterion("parade <=", value, "parade");
            return (Criteria) this;
        }

        public Criteria andParadeIn(List<Byte> values) {
            addCriterion("parade in", values, "parade");
            return (Criteria) this;
        }

        public Criteria andParadeNotIn(List<Byte> values) {
            addCriterion("parade not in", values, "parade");
            return (Criteria) this;
        }

        public Criteria andParadeBetween(Byte value1, Byte value2) {
            addCriterion("parade between", value1, value2, "parade");
            return (Criteria) this;
        }

        public Criteria andParadeNotBetween(Byte value1, Byte value2) {
            addCriterion("parade not between", value1, value2, "parade");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaIsNull() {
            addCriterion("drink_tea is null");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaIsNotNull() {
            addCriterion("drink_tea is not null");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaEqualTo(Byte value) {
            addCriterion("drink_tea =", value, "drinkTea");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaNotEqualTo(Byte value) {
            addCriterion("drink_tea <>", value, "drinkTea");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaGreaterThan(Byte value) {
            addCriterion("drink_tea >", value, "drinkTea");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaGreaterThanOrEqualTo(Byte value) {
            addCriterion("drink_tea >=", value, "drinkTea");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaLessThan(Byte value) {
            addCriterion("drink_tea <", value, "drinkTea");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaLessThanOrEqualTo(Byte value) {
            addCriterion("drink_tea <=", value, "drinkTea");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaIn(List<Byte> values) {
            addCriterion("drink_tea in", values, "drinkTea");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaNotIn(List<Byte> values) {
            addCriterion("drink_tea not in", values, "drinkTea");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaBetween(Byte value1, Byte value2) {
            addCriterion("drink_tea between", value1, value2, "drinkTea");
            return (Criteria) this;
        }

        public Criteria andDrinkTeaNotBetween(Byte value1, Byte value2) {
            addCriterion("drink_tea not between", value1, value2, "drinkTea");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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