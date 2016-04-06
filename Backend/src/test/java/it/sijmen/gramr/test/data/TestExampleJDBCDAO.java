package it.sijmen.gramr.test.data;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import it.sijmen.gramr.common.data.jdbc.JdbcDatabaseConnectionFactory;
import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.data.daos.ExampleJDBCDAO;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestExampleJDBCDAO {

    /**
     * Test of de klasse {@link it.sijmen.gramr.example.data.daos.ExampleJDBCDAO}
     * goed zijn werk doet.
     * In de tabel ExampleTable moet de volgende data staan:
     *        # id  data
     *          1   Hello World!
     *          2   Hallo wereld!
     *          3   Alut le Monde!
     */
    @Test
    public void testExampleJDBCDAO() throws IOException {
        Injector injector = Guice.createInjector(new MockGuiceModule());
        ExampleJDBCDAO dao = injector.getInstance(ExampleJDBCDAO.class);
        ArrayList<ExamplePojo> pojos = dao.getAllPojos();

        assertArrayEquals(pojos.toArray(), new ExamplePojo[]{
                new ExamplePojo(1, "Hello World!"),
                new ExamplePojo(2, "Hallo wereld!"),
                new ExamplePojo(3, "Alut le Monde!")
        });
    }

    class MockGuiceModule extends AbstractModule {

        @Override
        protected void configure() {
            bind(String.class).annotatedWith(Names.named("Jdbc Driver Class String")).toInstance("com.mysql.jdbc.Driver");
            bind(String.class).annotatedWith(Names.named("Jdbc Connection String")).toInstance("jdbc:mysql://localhost:3306/GramR");
            bind(String.class).annotatedWith(Names.named("Jdbc Connection Username String")).toInstance("GramRUser");
            bind(String.class).annotatedWith(Names.named("Jdbc Connection Password String")).toInstance("somerandompasswordnobodyknows");

            bind(Connection.class).toProvider(JdbcDatabaseConnectionFactory.class);
        }
    }


}
