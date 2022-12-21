package game.rules;

import eu.trentorise.game.model.ChallengeConcept;
import eu.trentorise.game.model.PointConcept;
import game.concepts.Challenge;
import game.concepts.Point;
import it.univaq.gamification.dsl.binders.ChallengeBind;
import it.univaq.gamification.dsl.binders.PointBind;
import it.univaq.gamification.dsl.builders.impl.PackageDescrBuilderImpl;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;

import static it.univaq.gamification.dsl.builders.lhs.ConstraintType.EQ;

public class ChallengeGameRules {

    public static PackageDescr getGreenSustainableBonusRule() {
        final ChallengeBind CHALLENGE_BIND = new ChallengeBind("challenge");
        final PointBind POINT_BIND = new PointBind("pc");

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(ChallengeConcept.class.getName()).end()
                .newImport(PointConcept.class.getName()).end()
                .newImport(PointConcept.class.getName()).end()
                .newRule()
                .name("challenge")
                    .attribute("lock-on-active", "true")
                    .when()
                        .challenge(CHALLENGE_BIND).modelName(EQ, Challenge.PRIZE).end()
                        .point(POINT_BIND).name(EQ, Point.GREEN_LEAVES).end()
                    .end()
                    .then()
                        .completeChallenge(CHALLENGE_BIND)
                        .incrementScore(POINT_BIND, 100d)
                    .end()
                .end()
                .getDescr();
    }

}
