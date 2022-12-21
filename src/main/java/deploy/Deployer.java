package deploy;

import it.univaq.gamification.deployment.services.DeploymentService;
import it.univaq.gamification.deployment.services.impl.DeploymentServiceImpl;

public class Deployer {

    private static DeploymentService deployer;

    public static DeploymentService getInstance() {
        if (deployer == null) {
            deployer = DeploymentServiceImpl
                    .builder()
                    .protocol("http")
                    .domain("localhost")
                    .port(8010)
                    .username("admin")
                    .password("password")
                    .build();
        }
        return deployer;
    }

}
