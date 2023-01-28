package game.rules;

import eu.trentorise.game.model.*;
import game.concepts.Global;
import game.concepts.Point;
import game.declared.PRItinerary;
import it.univaq.gamification.dsl.binders.PointBind;
import it.univaq.gamification.dsl.builders.impl.PackageDescrBuilderImpl;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;

import static it.univaq.gamification.dsl.builders.lhs.ConstraintType.EQ;

public class GreenPointsRules {

    public static PackageDescr getGreenSustainableBonusRule() {
        final PointBind POINT_BIND = new PointBind("pc");

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(InputData.class).end()
                .newImport(PointConcept.class).end()
                .newDeclare().type().name(PRItinerary.class).end()
                .newRule()
                .name("green sustainable bonus")
                    .attribute("salience", "1")
                    .when()
                        .inputData().fromData(EQ, "sustainable", true).end()
                        .not()
                            .pattern(PRItinerary.class.getSimpleName()).end()
                        .end()
                        .point(POINT_BIND).name(EQ, Point.GREEN_LEAVES).end()
                    .end()
                    .then()
                        .increaseScore(POINT_BIND, 60.0)
                    .end()
                .end()
                .getDescr();
    }

    public static PackageDescr getPRBonusRule() {
        final PointBind POINT_BIND = new PointBind("pc");

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(InputData.class).end()
                .newImport(PointConcept.class).end()
                .newDeclare().type().name(PRItinerary.class).end()
                .newRule()
                .name("green sustainable bonus")
                    .when()
                        .inputData().fromData(EQ, "p+r", true).end()
                        .point(POINT_BIND).name(EQ, Point.GREEN_LEAVES).end()
                    .end()
                    .then()
                        .increaseScore(POINT_BIND, Global.GREEN_PR_BONUS)
                        .insert(PRItinerary.class)
                    .end()
                .end()
                .getDescr();
    }

}
