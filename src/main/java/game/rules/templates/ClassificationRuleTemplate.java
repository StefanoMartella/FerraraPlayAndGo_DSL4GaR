package game.rules.templates;

import eu.trentorise.game.model.BadgeCollectionConcept;
import eu.trentorise.game.model.Game;
import eu.trentorise.game.model.Player;
import eu.trentorise.game.notification.BadgeNotification;
import eu.trentorise.game.task.Classification;
import it.univaq.gamification.dsl.binders.BadgeCollectionBind;
import it.univaq.gamification.dsl.binders.Bind;
import it.univaq.gamification.dsl.builders.impl.PackageDescrBuilderImpl;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;

import static it.univaq.gamification.dsl.builders.lhs.ConstraintType.EQ;

public class ClassificationRuleTemplate {

    public static PackageDescr getClassificationRuleTemplate(
            Integer salience,
            String ruleName,
            String classificationName,
            String badgeCollectionName,
            String badgeName,
            Integer classificationRunNumber
    ) {
        final Bind GAME_ID_BIND = new Bind("gameId");
        final Bind PLAYER_ID_BIND = new Bind("playerId");
        final BadgeCollectionBind BADGE_COLLECTION_BIND = new BadgeCollectionBind("bc");

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(Classification.class).end()
                .newImport(Game.class).end()
                .newImport(Player.class).end()
                .newImport(BadgeCollectionConcept.class).end()
                .newImport(BadgeNotification.class).end()
                .newRule()
                    .name(ruleName)
                    .attribute("salience", String.valueOf(salience))
                    .when()
                        .classification()
                            .name(EQ, classificationName)
                            .position(EQ,1)
                            .classificationRunNumber(EQ, classificationRunNumber)
                        .end()
                        .game().bindId(GAME_ID_BIND).end()
                        .player().bindId(PLAYER_ID_BIND).end()
                        .badgeCollection(BADGE_COLLECTION_BIND)
                            .name(EQ, badgeCollectionName)
                            .badgeEarnedNotContains(badgeName)
                        .end()
                    .end()
                    .then()
                        .addBadgeWithNotification(BADGE_COLLECTION_BIND, GAME_ID_BIND, PLAYER_ID_BIND, badgeName)
                    .end()
                .end()
                .getDescr();
    }

    public static PackageDescr getClassificationPositionRuleTemplate(
            Integer salience,
            String ruleName,
            String classificationName,
            String badgeCollectionName,
            String badgeName,
            Integer position
    ) {
        final Bind GAME_ID_BIND = new Bind("gameId");
        final Bind PLAYER_ID_BIND = new Bind("playerId");
        final BadgeCollectionBind BADGE_COLLECTION_BIND = new BadgeCollectionBind("bc");

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(Classification.class).end()
                .newImport(Game.class).end()
                .newImport(Player.class).end()
                .newImport(BadgeCollectionConcept.class).end()
                .newImport(BadgeNotification.class).end()
                .newRule()
                    .name(ruleName)
                    .attribute("salience", String.valueOf(salience))
                    .when()
                        .classification()
                            .name(EQ, classificationName)
                            .position(EQ, position)
                        .end()
                        .game().bindId(GAME_ID_BIND).end()
                        .player().bindId(PLAYER_ID_BIND).end()
                        .badgeCollection(BADGE_COLLECTION_BIND)
                            .name(EQ, badgeCollectionName)
                            .badgeEarnedNotContains(badgeName)
                        .end()
                    .end()
                    .then()
                        .addBadgeWithNotification(BADGE_COLLECTION_BIND, GAME_ID_BIND, PLAYER_ID_BIND, badgeName)
                    .end()
                .end()
                .getDescr();
    }
}
