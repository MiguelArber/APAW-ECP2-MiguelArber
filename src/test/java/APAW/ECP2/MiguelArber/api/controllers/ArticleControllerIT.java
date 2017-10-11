package APAW.ECP2.MiguelArber.api.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import APAW.ECP2.MiguelArber.api.daos.DaoFactory;
import APAW.ECP2.MiguelArber.api.daos.memory.DaoMemoryFactory;

public class ArticleControllerIT {

    private ArticleController articleController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        articleController = new ArticleController();
    }

    @Test
    public void test() {
    	
    }
}
