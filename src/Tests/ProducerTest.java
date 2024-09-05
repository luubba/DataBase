package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Dominio.Producer;

public class ProducerTest {

    @Test
    public void testProducerCreation() {
        Producer producer = new Producer("Studio Ghibli", 1);
        assertNotNull(producer);
        assertEquals("Studio Ghibli", producer.getName());
        assertEquals(Integer.valueOf(1), producer.getId());
    }

    @Test
    public void testProducerEquals() {
        Producer producer1 = new Producer("Studio Ghibli", 1);
        Producer producer2 = new Producer("Studio Ghibli", 1);
        assertEquals(producer1, producer2);
    }
}

