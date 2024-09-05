package Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;

import Dominio.Anime;
import Dominio.Producer;
import Repository.AnimeRepository;

public class AnimeRepositoryTest {

    @Test
    public void testSave() {
        Producer producer = new Producer("Studio Ghibli", 1);
        Anime anime = new Anime("My Neighbor Totoro", producer);
        AnimeRepository.save(anime);
        List<Anime> animes = AnimeRepository.findByName("My Neighbor Totoro");
        assertFalse(animes.isEmpty());
    }

    @Test
    public void testFindAll() {
        List<Anime> animes = AnimeRepository.findAll();
        assertTrue(animes.size() > 0);
    }

    @Test
    public void testDelete() {
        Producer producer = new Producer("Studio Ghibli", 1);
        Anime anime = new Anime("My Neighbor Totoro", producer);
        AnimeRepository.save(anime);
        AnimeRepository.delete(anime.getId());
        List<Anime> animes = AnimeRepository.findByName("My Neighbor Totoro");
        assertTrue(animes.isEmpty());
    }
}

