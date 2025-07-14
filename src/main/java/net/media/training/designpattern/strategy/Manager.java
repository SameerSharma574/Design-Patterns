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
    private final Strategy<String> managementBandValidations;

    Manager() {
        super();
        managementBandValidations = new Strategy<>();
        managementBandValidations.addStrategyItem(new NotEmpty());
        monthsSpentValidations.empty();
    }

    public void setManagementBand(String managementBand) {
        managementBandValidations.check(managementBand);
        this.managementBand = managementBand;
    }
}
