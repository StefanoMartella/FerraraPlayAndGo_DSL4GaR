import game.concepts.Badge;
import game.concepts.BadgeCollection;
import game.concepts.Classification;
import game.concepts.Point;
import game.rules.ClassificationRules;
import game.rules.GreenBadgeRules;
import game.rules.GreenPointsRules;
import it.univaq.gamification.simulation.builders.CheckExpectationLambda;
import it.univaq.gamification.simulation.builders.impl.SimulationBuilderImpl;
import it.univaq.gamification.simulation.builders.impl.fact.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class SimulatorTest {

    @Test
    public void testRule() {
        // rule "final classification gold badge health"
        //     salience -1000
        // when
        //     Classification( name == position == 1"final classification health",  )
        //     Game( $gameId : id )
        //     Player( $playerId : id )
        //     $bc : BadgeCollectionConcept( name == "health", badgeEarned not contains "gold-medal-health" )
        // then
        //     $bc.getBadgeEarned().add("gold-medal-health");
        //             insert(new BadgeNotification($gameId, $playerId, "gold-medal-health"));
        //     update( $bc );
        // end

        final ClassificationFactBuilderImpl classificationFact = ClassificationFactBuilderImpl.builder()
                .name(Classification.FINAL_CLASSIFICATION_HEALTH)
                .position(1)
                .build();
        final GameFactBuilderImpl gameFact = GameFactBuilderImpl.builder().id("game1").build();
        final PlayerFactBuilderImpl playerFact = PlayerFactBuilderImpl.builder().id("player1").build();
        final BadgeCollectionFactBuilderImpl badgeCollectionFact = BadgeCollectionFactBuilderImpl.builder()
                .name(BadgeCollection.HEALTH)
                .build();

        // Expectations
        CheckExpectationLambda doesNotHaveGoldMedalBadge = () -> Assert.assertFalse(badgeCollectionFact.getBadgeEarned().contains(Badge.GOLD_MEDAL_HEALTH));
        CheckExpectationLambda hasGoldMedalBadge = () -> Assert.assertTrue(badgeCollectionFact.getBadgeEarned().contains(Badge.GOLD_MEDAL_HEALTH));

        new SimulationBuilderImpl()
                .addFacts(classificationFact, gameFact, playerFact)
                .addRules(ClassificationRules.getFinalClassificationGoldBadgeHealth())
                .addExpectations(doesNotHaveGoldMedalBadge)
                .simulate()
                .addFacts(badgeCollectionFact)
                .addExpectations(hasGoldMedalBadge)
                .simulateAndClose();
    }

    @Test
    public void testRule2() {
        final PointFactBuilderImpl pointFact = PointFactBuilderImpl.builder().name(Point.GREEN_LEAVES).score(10.0).build();
        final GameFactBuilderImpl gameFact = GameFactBuilderImpl.builder().id("game1").build();
        final PlayerFactBuilderImpl playerFact = PlayerFactBuilderImpl.builder().id("player1").build();
        final BadgeCollectionFactBuilderImpl badgeCollectionFact = BadgeCollectionFactBuilderImpl.builder()
                .name(BadgeCollection.GREEN_LEAVES)
                .build();
        final InputDataFactBuilderImpl inputDataFact = InputDataFactBuilderImpl.builder()
                .data(new HashMap<>() {{ put("sustainable", true); }})
                .build();
        final ClassificationFactBuilderImpl classificationFact = ClassificationFactBuilderImpl.builder()
                .name(Classification.FINAL_CLASSIFICATION_GREEN)
                .position(3)
                .build();

        // Expectations
        CheckExpectationLambda doesContain10PointGreenBadge = () -> Assert.assertTrue(
                "The '10-point-green' badge has been assigned", badgeCollectionFact.getBadgeEarned().contains(Badge.GREEN_10_POINTS));
        CheckExpectationLambda has70Points = () -> Assert.assertEquals("Has 70 points", 70.0, pointFact.getScore(), 0.0);
        CheckExpectationLambda doesContain50PointGreenBadge = () -> Assert.assertTrue(
                "The '50-point-green' badge has been assigned", badgeCollectionFact.getBadgeEarned().contains(Badge.GREEN_50_POINTS));

        new SimulationBuilderImpl()
                .addFacts(pointFact, gameFact, playerFact, badgeCollectionFact, classificationFact, inputDataFact)
                .addRules(GreenPointsRules.getGreenSustainableBonusRule(), GreenBadgeRules.getGreenBadge10Rule(), GreenBadgeRules.getGreenBadge50Rule())
                .addExpectations(has70Points, doesContain10PointGreenBadge, doesContain50PointGreenBadge)
                .simulateAndClose();
    }

}
