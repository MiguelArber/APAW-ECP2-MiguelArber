package APAW.ECP2.MiguelArber.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import APAW.ECP2.MiguelArber.api.controllers.AllShoppingCartApiControllersTests;
import APAW.ECP2.MiguelArber.api.daos.memory.AllShoppingCartApiDaosMemoryTests;
import APAW.ECP2.MiguelArber.api.entities.AllShoppingCartApiEntitiesTests;

@RunWith(Suite.class)
@SuiteClasses ({
    AllShoppingCartApiControllersTests.class,
    AllShoppingCartApiEntitiesTests.class,
    AllShoppingCartApiDaosMemoryTests.class
})
public class AllShoppingCartApiTests {

}
