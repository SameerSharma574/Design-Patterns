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
    private final Strategy<Integer> maxAllowedLeavesValidations;

    Employee() {
        super();
        maxAllowedLeavesValidations = new Strategy<>();
        maxAllowedLeavesValidations.addStrategyItem(new AtLeast(1));
    }

    public void setMaxAllowedLeaves(int leaves) {
        maxAllowedLeavesValidations.check(leaves);
        this.maxAllowedLeaves = leaves;
    }
}

