package edu.umss.storeservice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import edu.umss.storeservice.model.Buy;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StoredProcedureLiveTest {
    private static EntityManagerFactory factory = null;
    private static EntityManager entityManager = null;

    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        entityManager = factory.createEntityManager();
    }

    @Before
    public void setup() {
    }



    @Test
    public void findAllProduct() {
        final StoredProcedureQuery findByYearProcedure = entityManager.createNamedStoredProcedureQuery("sp_GetAll_Product");
        //final StoredProcedureQuery storedProcedure = findByYearProcedure.setParameter("p_year", "2015");
        findByYearProcedure.getResultList()
                .forEach(c -> Assert.assertEquals("2015", ((Buy) c).getCode()));
    }

   @AfterClass
    public static void destroy() {

        if (entityManager != null) {
            entityManager.close();
        }
        if (factory != null) {
            factory.close();
        }
    }
}
