package net.media.training.designpattern.strategy;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:27:08 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class GenericEmployee extends CompanyMember {

    GenericEmployee() {
        salaryValidations.addStrategyItem(new AtMost(1000));
        managerNameValidations.addStrategyItem(new NotEmpty());
        monthsSpentValidations.addStrategyItem(new AtLeast(0));
    }
}
