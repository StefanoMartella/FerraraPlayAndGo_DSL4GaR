package rules;

import it.univaq.gamification.dsl.builders.lhs.PackageDescr;
import it.univaq.gamification.utils.DrlDumper;
import org.drools.core.io.impl.ByteArrayResource;
import org.drools.verifier.Verifier;
import org.drools.verifier.VerifierError;
import org.drools.verifier.builder.VerifierBuilder;
import org.drools.verifier.builder.VerifierBuilderFactory;
import org.junit.Assert;
import org.kie.api.io.ResourceType;

public class RuleHelper {

    private final static DrlDumper drlDumper = new DrlDumper();

    public static void verifyRule(PackageDescr packageDescr) {
        VerifierBuilder verifierBuilder = VerifierBuilderFactory.newVerifierBuilder();
        Verifier verifier = verifierBuilder.newVerifier();
        String rule = drlDumper.dump(packageDescr);
        System.out.println(rule);
        verifier.addResourcesToVerify(new ByteArrayResource(rule.getBytes()), ResourceType.DRL);
        try {
            Assert.assertTrue("The rule has some error", verifier.getErrors().isEmpty());
        } catch (AssertionError e) {
            for (VerifierError error : verifier.getErrors()) {
                System.out.println(error.getMessage());
            }
            throw e;
        }
    }

}
