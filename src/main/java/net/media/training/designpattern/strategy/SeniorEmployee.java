package net.media.training.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:35:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeniorEmployee extends GenericEmployee {
    private int maxBonus;
    private final Strategy<Integer> maxBonusValidations;

    SeniorEmployee() {
        super();
        maxBonusValidations = new Strategy<>();
        maxBonusValidations.addStrategyItem(new AtLeast(1));
        salaryValidations.addStrategyItem(new AtLeast(200));
        monthsSpentValidations.addStrategyItem(new AtLeast(60));
    }

    public void setMaxBonus(int bonus) {
        maxBonusValidations.check(bonus);
        this.maxBonus = bonus;
    }
}
