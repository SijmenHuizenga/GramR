package it.sijmen.gramr.test.pojo;

import it.sijmen.gramr.common.pojo.ExamplePojo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Sijmen on 6-4-2016.
 */
public class ExamplePojoTest {

    @Test
    public void testId() throws Exception {
        ExamplePojo pojo = new ExamplePojo(1, "a");
        pojo.setId(100);
        assertEquals(100, pojo.getId());
    }


    @Test
    public void testData() throws Exception {
        ExamplePojo pojo = new ExamplePojo(1, "a");
        pojo.setData("b");
        assertEquals("b", pojo.getData());
    }

    @Test
    public void testConstructor() throws Exception {
        ExamplePojo pojo = new ExamplePojo(1, "a");
        assertEquals("a", pojo.getData());
        assertEquals(1, pojo.getId());
    }
}