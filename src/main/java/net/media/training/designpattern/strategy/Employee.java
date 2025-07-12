package net.media.training.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:31:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Employee extends GenericEmployee {
    private int maxAllowedLeaves;
    private final List<StrategyItem> maxAllowedLeavesValidations;

    Employee() {
        super();
        maxAllowedLeavesValidations = new ArrayList<>();
        maxAllowedLeavesValidations.add(new AtLeast(1));
    }

    public void setMaxAllowedLeaves(int leaves) {
        validate(maxAllowedLeavesValidations, leaves);
        this.maxAllowedLeaves = leaves;
    }
}

