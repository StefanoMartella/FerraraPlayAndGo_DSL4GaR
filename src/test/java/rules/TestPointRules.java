package rules;

import game.rules.GreenPointsRules;
import game.rules.PPlusRPointsRules;
import org.junit.Test;

public class TestPointRules {

    @Test
    public void testPointRules() {
        // Green points
        RuleHelper.verifyRule(GreenPointsRules.getGreenSustainableBonusRule());
        RuleHelper.verifyRule(GreenPointsRules.getPRBonusRule());
        // PR points
        RuleHelper.verifyRule(PPlusRPointsRules.getGreenSustainableBonusRule());
    }

}
