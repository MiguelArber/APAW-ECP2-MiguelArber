package APAW.ECP2.MiguelArber.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import APAW.ECP2.MiguelArber.api.controllers.AllArticleApiControllersTests;
import APAW.ECP2.MiguelArber.api.daos.memory.AllArticleApiDaosMemoryTests;
import APAW.ECP2.MiguelArber.api.entities.AllArticleApiEntitiesTests;

@RunWith(Suite.class)
@SuiteClasses ({
    AllArticleApiControllersTests.class,
    AllArticleApiEntitiesTests.class,
    AllArticleApiDaosMemoryTests.class
})
public class AllArticleApiTests {

}
