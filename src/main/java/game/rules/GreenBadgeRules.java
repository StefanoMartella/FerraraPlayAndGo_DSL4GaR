package game.rules;

import game.concepts.Badge;
import game.concepts.BadgeCollection;
import game.concepts.Point;
import game.rules.templates.GenericBadgeRuleTemplate;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;

public class GreenBadgeRules {

    public static PackageDescr getGreenBadge10Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "10 point green badge",
                Point.GREEN_LEAVES,
                BadgeCollection.GREEN_LEAVES,
                Badge.GREEN_10_POINTS,
                10.0
        );
    }

    public static PackageDescr getGreenBadge50Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "50 point green badge",
                Point.GREEN_LEAVES,
                BadgeCollection.GREEN_LEAVES,
                Badge.GREEN_50_POINTS,
                50.0
        );
    }

    public static PackageDescr getGreenBadge100Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "100 point green badge",
                Point.GREEN_LEAVES,
                BadgeCollection.GREEN_LEAVES,
                Badge.GREEN_100_POINTS,
                100.0
        );
    }

    public static PackageDescr getGreenBadge250Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "250 point green badge",
                Point.GREEN_LEAVES,
                BadgeCollection.GREEN_LEAVES,
                Badge.GREEN_250_POINTS,
                250.0
        );
    }

    public static PackageDescr getGreenBadge500Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "500 point green badge",
                Point.GREEN_LEAVES,
                BadgeCollection.GREEN_LEAVES,
                Badge.GREEN_500_POINTS,
                500.0
        );
    }

    public static PackageDescr getGreenBadge1000Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "1000 point green badge",
                Point.GREEN_LEAVES,
                BadgeCollection.GREEN_LEAVES,
                Badge.GREEN_1000_POINTS,
                1000.0
        );
    }

}
