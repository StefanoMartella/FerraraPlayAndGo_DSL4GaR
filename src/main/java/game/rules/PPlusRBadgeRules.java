package game.rules;

import game.concepts.Badge;
import game.concepts.BadgeCollection;
import game.concepts.Point;
import game.rules.templates.GenericBadgeRuleTemplate;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;

public class PPlusRBadgeRules {

    public static PackageDescr getPRBadge10Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "10 point pr badge",
                Point.P_PLUS_R,
                BadgeCollection.P_PLUS_R,
                Badge.PR_10_POINTS,
                10.0
        );
    }

    public static PackageDescr getPRBadge25Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "25 point pr badge",
                Point.P_PLUS_R,
                BadgeCollection.P_PLUS_R,
                Badge.PR_25_POINTS,
                25.0
        );
    }

    public static PackageDescr getPRBadge50Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "50 point pr badge",
                Point.P_PLUS_R,
                BadgeCollection.P_PLUS_R,
                Badge.PR_50_POINTS,
                50.0
        );
    }

    public static PackageDescr getPRBadge100Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "100 point pr badge",
                Point.P_PLUS_R,
                BadgeCollection.P_PLUS_R,
                Badge.PR_100_POINTS,
                100.0
        );
    }

    public static PackageDescr getPRBadge200Rule() {
        return GenericBadgeRuleTemplate.getBadgeTemplate(
                -1000,
                "200 point pr badge",
                Point.P_PLUS_R,
                BadgeCollection.P_PLUS_R,
                Badge.PR_200_POINTS,
                200.0
        );
    }

}
