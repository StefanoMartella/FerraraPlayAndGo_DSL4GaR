package game.rules;

import game.concepts.Badge;
import game.concepts.BadgeCollection;
import game.concepts.Classification;
import game.rules.templates.ClassificationRuleTemplate;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;

public class ClassificationRules {

    // Green final classification
    public static PackageDescr getFinalClassificationBronzeBadgeGreenRule() {
        return ClassificationRuleTemplate.getClassificationPositionRuleTemplate(
                -1000,
                "final classification bronze badge green",
                Classification.FINAL_CLASSIFICATION_GREEN,
                BadgeCollection.GREEN_LEAVES,
                Badge.BRONZE_MEDAL_GREEN,
                3
        );
    }

    public static PackageDescr getFinalClassificationSilverBadgeGreenRule() {
        return ClassificationRuleTemplate.getClassificationPositionRuleTemplate(
                -1000,
                "final classification silver badge green",
                Classification.FINAL_CLASSIFICATION_GREEN,
                BadgeCollection.GREEN_LEAVES,
                Badge.SILVER_MEDAL_GREEN,
                2
        );
    }

    public static PackageDescr getFinalClassificationGoldBadgeGreenD1Rule() {
        return ClassificationRuleTemplate.getClassificationRuleTemplate(
                -1000,
                "final classification gold badge green d1",
                Classification.FINAL_CLASSIFICATION_GREEN,
                BadgeCollection.GREEN_LEAVES,
                Badge.GOLD_GREEN_MEDAL_1,
                1
        );
    }

    public static PackageDescr getFinalClassificationGoldBadgeGreenD2Rule() {
        return ClassificationRuleTemplate.getClassificationRuleTemplate(
                -1000,
                "final classification gold badge green d2",
                Classification.FINAL_CLASSIFICATION_GREEN,
                BadgeCollection.GREEN_LEAVES,
                Badge.GOLD_GREEN_MEDAL_2,
                2
        );
    }

    public static PackageDescr getFinalClassificationGoldBadgeGreenD3Rule() {
        return ClassificationRuleTemplate.getClassificationRuleTemplate(
                -1000,
                "final classification gold badge green d3",
                Classification.FINAL_CLASSIFICATION_GREEN,
                BadgeCollection.GREEN_LEAVES,
                Badge.GOLD_GREEN_MEDAL_3,
                3
        );
    }

    // Health final classification

    public static PackageDescr getFinalClassificationBronzeBadgeHealth() {
        return ClassificationRuleTemplate.getClassificationPositionRuleTemplate(
                -1000,
                "final classification bronze badge health",
                Classification.FINAL_CLASSIFICATION_HEALTH,
                BadgeCollection.HEALTH,
                Badge.BRONZE_MEDAL_HEALTH,
                3
        );
    }

    public static PackageDescr getFinalClassificationSilverBadgeHealth() {
        return ClassificationRuleTemplate.getClassificationPositionRuleTemplate(
                -1000,
                "final classification silver badge health",
                Classification.FINAL_CLASSIFICATION_HEALTH,
                BadgeCollection.HEALTH,
                Badge.SILVER_MEDAL_HEALTH,
                2
        );
    }

    public static PackageDescr getFinalClassificationGoldBadgeHealth() {
        return ClassificationRuleTemplate.getClassificationPositionRuleTemplate(
                -1000,
                "final classification gold badge health",
                Classification.FINAL_CLASSIFICATION_HEALTH,
                BadgeCollection.HEALTH,
                Badge.GOLD_MEDAL_HEALTH,
                1
        );
    }

    // P+R final classification

    public static PackageDescr getFinalClassificationBronzeBadgePplusR() {
        return ClassificationRuleTemplate.getClassificationPositionRuleTemplate(
                -1000,
                "final classification gold badge p+r",
                Classification.FINAL_CLASSIFICATION_P_PLUS_R,
                BadgeCollection.P_PLUS_R,
                Badge.BRONZE_MEDAL_P_PLUS_R,
                3
        );
    }

    public static PackageDescr getFinalClassificationSilverBadgePplusR() {
        return ClassificationRuleTemplate.getClassificationPositionRuleTemplate(
                -1000,
                "final classification silver badge p+r",
                Classification.FINAL_CLASSIFICATION_P_PLUS_R,
                BadgeCollection.P_PLUS_R,
                Badge.SILVER_MEDAL_P_PLUS_R,
                2
        );
    }

    public static PackageDescr getFinalClassificationGoldBadgePplusR() {
        return ClassificationRuleTemplate.getClassificationPositionRuleTemplate(
                -1000,
                "final classification silver gold p+r",
                Classification.FINAL_CLASSIFICATION_P_PLUS_R,
                BadgeCollection.P_PLUS_R,
                Badge.GOLD_MEDAL_P_PLUS_R,
                1
        );
    }
}
