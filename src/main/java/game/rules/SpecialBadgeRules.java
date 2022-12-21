package game.rules;

import eu.trentorise.game.model.*;
import eu.trentorise.game.notification.BadgeNotification;
import game.concepts.Badge;
import game.concepts.BadgeCollection;
import it.univaq.gamification.dsl.binders.BadgeCollectionBind;
import it.univaq.gamification.dsl.binders.Bind;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;
import it.univaq.gamification.dsl.builders.impl.PackageDescrBuilderImpl;

import static it.univaq.gamification.dsl.builders.lhs.ConstraintType.EQ;
import static it.univaq.gamification.dsl.builders.lhs.ConstraintType.NEQ;

public class SpecialBadgeRules {

    public static PackageDescr getEMotionBadgeRule() {
        final Bind GAME_ID_BIND = new Bind("gameId");
        final Bind PLAYER_ID_BIND = new Bind("playerId");
        final BadgeCollectionBind BADGE_COLLECTION_BIND = new BadgeCollectionBind("bc");

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(InputData.class.getName()).end()
                .newImport(Game.class.getName()).end()
                .newImport(Player.class.getName()).end()
                .newImport(BadgeCollectionConcept.class.getName()).end()
                .newImport(BadgeNotification.class.getName()).end()
                .newRule()
                .name("e-motion badge")
                .attribute("salience", "-1000")
                    .when()
                        .inputData()
                            .fromData(EQ, "bikesharing", true)
                        .end()
                        .badgeCollection(BADGE_COLLECTION_BIND)
                            .name(EQ, BadgeCollection.SPECIAL)
                            .badgeEarnedNotContains(Badge.E_MOTION)
                        .end()
                        .game().bindId(GAME_ID_BIND).end()
                        .player().bindId(PLAYER_ID_BIND).end()
                    .end()
                    .then()
                        .addBadgeWithNotification(BADGE_COLLECTION_BIND, GAME_ID_BIND, PLAYER_ID_BIND, Badge.E_MOTION)
                    .end()
                .end()
                .getDescr();
    }

    public static PackageDescr getParkBadgeRule() {
        final Bind GAME_ID_BIND = new Bind("gameId");
        final Bind PLAYER_ID_BIND = new Bind("playerId");
        final BadgeCollectionBind BADGE_COLLECTION_BIND = new BadgeCollectionBind("bc");
        final Bind PARK_BIND = new Bind("park");
        final Bind BADGE_NAME_BIND = new Bind("badge");

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(InputData.class.getName()).end()
                .newImport(Game.class.getName()).end()
                .newImport(Player.class.getName()).end()
                .newImport(BadgeCollectionConcept.class.getName()).end()
                .newImport(BadgeNotification.class.getName()).end()
                .newRule()
                .name("park badge")
                .attribute("salience", "-1000")
                    .when()
                        .inputData()
                            .fromData(NEQ, "park", null, PARK_BIND)
                        .end()
                        .badgeCollection(BADGE_COLLECTION_BIND)
                            .name(EQ, BadgeCollection.SPECIAL)
                            .constraint(String.format("%s: %s+'%s'", BADGE_NAME_BIND, PARK_BIND, Badge.PARK_SUFFIX))
                            .badgeEarnedNotContains(BADGE_NAME_BIND)
                        .end()
                        .game().bindId(GAME_ID_BIND).end()
                        .player().bindId(PLAYER_ID_BIND).end()
                    .end()
                    .then()
                        .addBadgeWithNotification(BADGE_COLLECTION_BIND, GAME_ID_BIND, PLAYER_ID_BIND, BADGE_NAME_BIND)
                    .end()
                .end()
                .getDescr();
    }

    public static PackageDescr getZeroImpactBadgeRule() {
        final Bind GAME_ID_BIND = new Bind("gameId");
        final Bind PLAYER_ID_BIND = new Bind("playerId");
        final BadgeCollectionBind BADGE_COLLECTION_BIND = new BadgeCollectionBind("bc");

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(InputData.class.getName()).end()
                .newImport(Game.class.getName()).end()
                .newImport(Player.class.getName()).end()
                .newImport(BadgeCollectionConcept.class.getName()).end()
                .newImport(BadgeNotification.class.getName()).end()
                .newRule()
                .name("zero impact badge")
                .attribute("salience", "-1000")
                    .when()
                        .inputData()
                            // Complex constraint handled with string
                            .constraint("(data['walkDistance'] != null || data['bikeDistance'] != null) && ((data['busDistance'] == null || data['busDistance'] == 0) &&  (data['carDistance'] == null || data['carDistance'] == 0))")
                        .end()
                        .badgeCollection(BADGE_COLLECTION_BIND)
                            .name(EQ, BadgeCollection.SPECIAL)
                            .badgeEarnedNotContains(Badge.ZERO_IMPACT)
                        .end()
                        .game().bindId(GAME_ID_BIND).end()
                        .player().bindId(PLAYER_ID_BIND).end()
                    .end()
                    .then()
                        .addBadgeWithNotification(BADGE_COLLECTION_BIND, GAME_ID_BIND, PLAYER_ID_BIND, Badge.ZERO_IMPACT)
                    .end()
                .end()
                .getDescr();
    }

}
