import deploy.Deployer;
import game.rules.ClassificationRules;
import game.rules.GreenBadgeRules;
import game.rules.GreenPointsRules;
import org.junit.Test;

import java.io.IOException;

public class DeployTest {

    @Test
    public void deployRules() throws IOException {
        Deployer.getInstance().upsert(
                "62df8ddc0055b0275113d374",
                GreenPointsRules.getGreenSustainableBonusRule(),
                GreenBadgeRules.getGreenBadge10Rule(),
                GreenBadgeRules.getGreenBadge50Rule()
        );
    }

    @Test
    public void deleteRules() throws IOException {
        Deployer.getInstance().delete(
                "62df8ddc0055b0275113d374",
                GreenPointsRules.getGreenSustainableBonusRule(),
                GreenBadgeRules.getGreenBadge10Rule(),
                GreenBadgeRules.getGreenBadge50Rule()
        );
    }

}
