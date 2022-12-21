package game.rules;

import eu.trentorise.game.model.InputData;
import eu.trentorise.game.model.PointConcept;
import game.concepts.Global;
import game.concepts.Point;
import it.univaq.gamification.dsl.binders.PointBind;
import it.univaq.gamification.dsl.builders.impl.PackageDescrBuilderImpl;
import it.univaq.gamification.dsl.builders.lhs.PackageDescr;

import static it.univaq.gamification.dsl.builders.lhs.ConstraintType.EQ;

public class PPlusRPointsRules {

    public static PackageDescr getGreenSustainableBonusRule() {
        final PointBind POINT_BIND = new PointBind("pc");

        // rule "update p+r points"
        // when
        // InputData(data['p+r'] == true)
        // $pc : PointConcept(name == "p+r")
        // then
        // utils.log("apply \'update p+r points\'");
        //
        // $pc.setScore($pc.getScore() + pr_points);
        // update($pc);
        // end

        return new PackageDescrBuilderImpl()
                .name("eu.trentorise.game.model")
                .newImport(InputData.class.getName()).end()
                .newImport(PointConcept.class.getName()).end()
                .newRule()
                .name("update p+r points")
                    .when()
                        .inputData().fromData(EQ, "p+r", true).end()
                        .point(POINT_BIND).name(EQ, Point.P_PLUS_R).end()
                    .end()
                    .then()
                        .increaseScore(POINT_BIND, Global.PR_POINTS)
                    .end()
                .end()
                .getDescr();
    }

}
