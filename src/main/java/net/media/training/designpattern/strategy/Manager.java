package net.media.training.designpattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 1:37:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Manager extends CompanyMember {
    private String managementBand;
    private final List<StrategyItem> managementBandValidations;

    Manager() {
        super();
        managementBandValidations = new ArrayList<>();
        managementBandValidations.add(new NotEmpty());
        monthsSpentValidations.clear();
    }

    public void setManagementBand(String managementBand) {
        validate(managementBandValidations, managementBand);
        this.managementBand = managementBand;
    }
}
