package game.rules;

import eu.trentorise.game.model.ChallengeConcept;
import eu.trentorise.game.model.PointConcept;
import eu.trentorise.game.model.Reward;
import it.univaq.gamification.dsl.binders.Bind;
import it.univaq.gamification.dsl.binders.ChallengeBind;
import it.univaq.gamification.dsl.binders.PointBind;
import it.univaq.gamification.dsl.binders.RewardBind;
import it.univaq.gamification.dsl.builders.impl.PackageDescrBuilderImpl;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;

import static it.univaq.gamification.dsl.builders.lhs.ConstraintType.EQ;

public class GroupChallengeRules {

    public static PackageDescr getGreenSustainableBonusRule() {
        final ChallengeBind CHALLENGE_BIND = new ChallengeBind("challenge");
        final RewardBind REWARD_BIND = new RewardBind("reward");
        final PointBind POINT_BIND = new PointBind("pcBonus");
        final Bind BONUS_SCORE = new Bind("bonusScore");
        final Bind BONUS_POINT_TYPE = new Bind("bonusPointType");

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(ChallengeConcept.class.getName()).end()
                .newImport(Reward.class.getName()).end()
                .newImport(PointConcept.class.getName()).end()
                .newRule()
                .name("reward completing first group challenge")
                    .when()
                        .challenge(CHALLENGE_BIND)
                            .modelName(EQ, "incentiveGroupChallengeReward")
                            .bindFromField(BONUS_SCORE, "bonusScore")
                            .bindFromField(BONUS_POINT_TYPE, "bonusPointType")
                            .isCompleted(false)
                        .end()
                        .reward(REWARD_BIND).end()
                        .point(POINT_BIND)
                            .constraint(String.format("name == (String) %s", BONUS_POINT_TYPE.getValue()))
                        .end()
                    .end()
                    .then()
                        .completeChallenge(CHALLENGE_BIND)
                        .increaseScore(POINT_BIND, BONUS_SCORE)
                    .end()
                .end()
                .getDescr();
    }

}
