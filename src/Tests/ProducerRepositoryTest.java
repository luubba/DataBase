package Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

import Dominio.Producer;
import Repository.ProducerRepository;

public class ProducerRepositoryTest {

    @Test
    public void testSave() {
        Producer producer = new Producer("Studio Ghibli");
        ProducerRepository.save(producer);
        List<Producer> producers = ProducerRepository.findByName("Studio Ghibli");
        assertFalse(producers.isEmpty());
    }

    @Test
    public void testFindAll() {
        List<Producer> producers = ProducerRepository.findAll();
        assertTrue(producers.size() > 0);
    }

    @Test
    public void testDelete() {
        Producer producer = new Producer("Studio Ghibli");
        ProducerRepository.save(producer);
        ProducerRepository.delete(producer.getId());
        List<Producer> producers = ProducerRepository.findByName("Studio Ghibli");
        assertTrue(producers.isEmpty());
    }
}
