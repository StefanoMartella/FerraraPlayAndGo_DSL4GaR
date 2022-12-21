package rules;

import game.rules.GroupChallengeRules;
import org.junit.Test;

public class TestGroupChallengeRules {

    @Test
    public void testGroupChallenge() {
        RuleHelper.verifyRule(GroupChallengeRules.getGreenSustainableBonusRule());
    }

}
