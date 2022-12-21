package rules;

import game.rules.ChallengeGameRules;
import org.junit.Test;

public class TestChallegeGameRules {

    @Test
    public void testHealthBadgeRules() {
        RuleHelper.verifyRule(ChallengeGameRules.getGreenSustainableBonusRule());
    }

}
