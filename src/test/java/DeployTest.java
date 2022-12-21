import deploy.Deployer;
import game.rules.ClassificationRules;
import org.junit.Test;

import java.io.IOException;

public class DeployTest {

    @Test
    public void deployRules() throws IOException {
        Deployer.getInstance().upsert(
                "62df8ddc0055b0275113d374",
                ClassificationRules.getFinalClassificationGoldBadgeGreenD1Rule(),
                ClassificationRules.getFinalClassificationGoldBadgeGreenD2Rule(),
                ClassificationRules.getFinalClassificationGoldBadgeGreenD3Rule(),
                ClassificationRules.getFinalClassificationBronzeBadgeGreenRule(),
                ClassificationRules.getFinalClassificationSilverBadgeGreenRule(),
                // Health final classification
                ClassificationRules.getFinalClassificationBronzeBadgeHealth(),
                ClassificationRules.getFinalClassificationSilverBadgeHealth(),
                ClassificationRules.getFinalClassificationGoldBadgeHealth(),
                // P+R final classification
                ClassificationRules.getFinalClassificationBronzeBadgePplusR(),
                ClassificationRules.getFinalClassificationSilverBadgePplusR(),
                ClassificationRules.getFinalClassificationGoldBadgePplusR()
        );
    }

    @Test
    public void deleteRules() throws IOException {
        Deployer.getInstance().delete(
                "62df8ddc0055b0275113d374",
                ClassificationRules.getFinalClassificationGoldBadgeGreenD1Rule(),
                ClassificationRules.getFinalClassificationGoldBadgeGreenD2Rule(),
                ClassificationRules.getFinalClassificationGoldBadgeGreenD3Rule(),
                ClassificationRules.getFinalClassificationBronzeBadgeGreenRule(),
                ClassificationRules.getFinalClassificationSilverBadgeGreenRule(),
                // Health final classification
                ClassificationRules.getFinalClassificationBronzeBadgeHealth(),
                ClassificationRules.getFinalClassificationSilverBadgeHealth(),
                ClassificationRules.getFinalClassificationGoldBadgeHealth(),
                // P+R final classification
                ClassificationRules.getFinalClassificationBronzeBadgePplusR(),
                ClassificationRules.getFinalClassificationSilverBadgePplusR(),
                ClassificationRules.getFinalClassificationGoldBadgePplusR()
        );
    }

}
