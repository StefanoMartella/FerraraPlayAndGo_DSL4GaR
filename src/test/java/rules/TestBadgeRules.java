package rules;

import game.rules.*;
import org.junit.Test;

public class TestBadgeRules {

    @Test
    public void testClassificationRules() {
        // Green final classification
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationGoldBadgeGreenD1Rule());
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationGoldBadgeGreenD2Rule());
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationGoldBadgeGreenD3Rule());
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationBronzeBadgeGreenRule());
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationSilverBadgeGreenRule());
        // Health final classification
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationBronzeBadgeHealth());
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationSilverBadgeHealth());
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationGoldBadgeHealth());
        // P+R final classification
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationBronzeBadgePplusR());
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationSilverBadgePplusR());
        RuleHelper.verifyRule(ClassificationRules.getFinalClassificationGoldBadgePplusR());
    }

    @Test
    public void testGreenBadgeRules() {
        RuleHelper.verifyRule(GreenBadgeRules.getGreenBadge10Rule());
        RuleHelper.verifyRule(GreenBadgeRules.getGreenBadge50Rule());
        RuleHelper.verifyRule(GreenBadgeRules.getGreenBadge100Rule());
        RuleHelper.verifyRule(GreenBadgeRules.getGreenBadge250Rule());
        RuleHelper.verifyRule(GreenBadgeRules.getGreenBadge500Rule());
        RuleHelper.verifyRule(GreenBadgeRules.getGreenBadge1000Rule());
    }

    @Test
    public void testHealthBadgeRules() {
        RuleHelper.verifyRule(HealthBadgeRules.getHealthBadge10Rule());
        RuleHelper.verifyRule(HealthBadgeRules.getHealthBadge25Rule());
        RuleHelper.verifyRule(HealthBadgeRules.getHealthBadge50Rule());
        RuleHelper.verifyRule(HealthBadgeRules.getHealthBadge100Rule());
        RuleHelper.verifyRule(HealthBadgeRules.getHealthBadge200Rule());
    }

    @Test
    public void testPRBadgeRules() {
        RuleHelper.verifyRule(PPlusRBadgeRules.getPRBadge10Rule());
        RuleHelper.verifyRule(PPlusRBadgeRules.getPRBadge25Rule());
        RuleHelper.verifyRule(PPlusRBadgeRules.getPRBadge50Rule());
        RuleHelper.verifyRule(PPlusRBadgeRules.getPRBadge100Rule());
        RuleHelper.verifyRule(PPlusRBadgeRules.getPRBadge200Rule());
    }

    @Test
    public void testSpecialRules() {
        RuleHelper.verifyRule(SpecialBadgeRules.getEMotionBadgeRule());
        RuleHelper.verifyRule(SpecialBadgeRules.getParkBadgeRule());
        RuleHelper.verifyRule(ChallengeGameRules.getGreenSustainableBonusRule());
    }

}
