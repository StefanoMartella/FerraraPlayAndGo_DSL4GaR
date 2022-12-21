package game.rules;

import game.concepts.Badge;
import game.concepts.BadgeCollection;
import game.concepts.Point;
import game.rules.templates.GenericBadgeRuleTemplate;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;

public class HealthBadgeRules {

    public static PackageDescr getHealthBadge10Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "10 point health badge",
                Point.HEALTH,
                BadgeCollection.HEALTH,
                Badge.HEALTH_10_POINTS,
                10.0
        );
    }

    public static PackageDescr getHealthBadge25Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "25 point health badge",
                Point.HEALTH,
                BadgeCollection.HEALTH,
                Badge.HEALTH_25_POINTS,
                25.0
        );
    }

    public static PackageDescr getHealthBadge50Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "50 point health badge",
                Point.HEALTH,
                BadgeCollection.HEALTH,
                Badge.HEALTH_50_POINTS,
                50.0
        );
    }

    public static PackageDescr getHealthBadge100Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "100 point health badge",
                Point.HEALTH,
                BadgeCollection.HEALTH,
                Badge.HEALTH_100_POINTS,
                100.0
        );
    }

    public static PackageDescr getHealthBadge200Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "200 point health badge",
                Point.HEALTH,
                BadgeCollection.HEALTH,
                Badge.HEALTH_200_POINTS,
                200.0
        );
    }

}
