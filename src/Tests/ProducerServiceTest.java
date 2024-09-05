package Tests;

import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Dominio.Producer;
import Services.ProducerService;

public class ProducerServiceTest {

    @Test
    public void testSaveProducer() {
        Producer producer = new Producer("Studio Ghibli");
        ProducerService.save(producer);
    }

    @Test
    public void testDeleteProducerWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            ProducerService.delete(-1);
        });
    }
}

