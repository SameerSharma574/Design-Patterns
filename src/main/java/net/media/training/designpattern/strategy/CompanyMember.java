package net.media.training.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:14:31 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CompanyMember {
    private String name;
    protected String mgrName;
    protected int salary;
    protected int monthsSpent;

    protected final Strategy<Integer> salaryValidations;
    protected final Strategy<String> managerNameValidations;
    protected final Strategy<Integer> monthsSpentValidations;

    public CompanyMember() {
        salaryValidations = new Strategy<>();
        managerNameValidations = new Strategy<>();
        monthsSpentValidations = new Strategy<>();
        salaryValidations.addStrategyItem(new AtLeast(1));
        managerNameValidations.addStrategyItem(new ValidateLength(50));
    }

    protected void validateLength(String val, int allowedLength) {
        if (val.length() > allowedLength)
            throw new RuntimeException("Invalid length:" + allowedLength);
    }

    protected void notEmpty(String val) {
        if (val == null || val.length() == 0)
            throw new RuntimeException("not empty check failed for value:" + val);
    }

    protected void atLeast(int val, int min) {
        if (val < min)
            throw new RuntimeException("at least check failed:" + val);
    }

    protected void atMost(int val, int max) {
        if (val > max)
            throw new RuntimeException("at least check failed:" + val);
    }

    public <T> void validate (List<StrategyItem> validations, T val) {
        validations.forEach(strategy -> strategy.check(val));
    }

    public void setName(String name) {
        validateLength(name, 50);
        this.name = name;
    }


    public void setSalary(int salary) {
        salaryValidations.check(salary);
        this.salary = salary;
    }

    public void setManagerName(String name) {
        managerNameValidations.check(name);
        this.mgrName = name;
    }

    public void setMonthsSpent(int months) {
        monthsSpentValidations.check(months);
        this.monthsSpent = months;
    }
}
