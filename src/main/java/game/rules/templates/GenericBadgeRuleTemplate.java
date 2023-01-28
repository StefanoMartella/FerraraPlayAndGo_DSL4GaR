package game.rules.templates;

import eu.trentorise.game.model.BadgeCollectionConcept;
import eu.trentorise.game.model.Game;
import eu.trentorise.game.model.Player;
import eu.trentorise.game.model.PointConcept;
import eu.trentorise.game.notification.BadgeNotification;
import it.univaq.gamification.dsl.binders.BadgeCollectionBind;
import it.univaq.gamification.dsl.binders.Bind;
import it.univaq.gamification.dsl.builders.impl.PackageDescrBuilderImpl;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;

import static it.univaq.gamification.dsl.builders.lhs.ConstraintType.EQ;
import static it.univaq.gamification.dsl.builders.lhs.ConstraintType.GTE;

public class GenericBadgeRuleTemplate {

    public static PackageDescr getBadgeTemplate(
            Integer salience,
            String ruleName,
            String pointName,
            String badgeCollectionName,
            String badgeName,
            Double scoreThreshold
    ) {
        final Bind GAME_ID_BIND = new Bind("gameId");
        final Bind PLAYER_ID_BIND = new Bind("playerId");
        final BadgeCollectionBind BADGE_COLLECTION_BIND = new BadgeCollectionBind("bc");

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(PointConcept.class).end()
                .newImport(Game.class).end()
                .newImport(Player.class).end()
                .newImport(BadgeCollectionConcept.class).end()
                .newImport(BadgeNotification.class).end()
                .newRule()
                    .name(ruleName)
                    .attribute("salience", String.valueOf(salience))
                    .when()
                        .point()
                            .name(EQ, pointName)
                            .score(GTE, scoreThreshold)
                        .end()
                        .badgeCollection(BADGE_COLLECTION_BIND)
                            .name(EQ, badgeCollectionName)
                            .badgeEarnedNotContains(badgeName)
                        .end()
                        .game().bindId(GAME_ID_BIND).end()
                        .player().bindId(PLAYER_ID_BIND).end()
                    .end()
                    .then()
                        .addBadgeWithNotification(BADGE_COLLECTION_BIND, GAME_ID_BIND, PLAYER_ID_BIND, badgeName)
                    .end()
                .end()
                .getDescr();
    }

}
