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

    protected final List<StrategyItem> salaryValidations;
    protected final List<StrategyItem> managerNameValidations;
    protected final List<StrategyItem> monthsSpentValidations;

    public CompanyMember() {
        salaryValidations = new ArrayList<>(List.of(new AtLeast(1)));
        managerNameValidations = new ArrayList<>(List.of(new ValidateLength(50)));
        monthsSpentValidations = new ArrayList<>();
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
        validate(salaryValidations, salary);
        this.salary = salary;
    }

    public void setManagerName(String name) {
        validate(managerNameValidations, name);
        this.mgrName = name;
    }

    public void setMonthsSpent(int months) {
        validate(monthsSpentValidations, months);
        this.monthsSpent = months;
    }
}
