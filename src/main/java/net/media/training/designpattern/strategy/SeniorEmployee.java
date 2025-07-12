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
    private final List<StrategyItem> maxBonusValidations;

    SeniorEmployee() {
        super();
        maxBonusValidations = new ArrayList<>();
        maxBonusValidations.add(new AtLeast(1));
        salaryValidations.add(new AtLeast(200));
        monthsSpentValidations.add(new AtLeast(60));
    }

    public void setMaxBonus(int bonus) {
        validate(maxBonusValidations, bonus);
        this.maxBonus = bonus;
    }
}
