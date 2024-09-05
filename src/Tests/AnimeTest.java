package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Dominio.Anime;
import Dominio.Producer;

public class AnimeTest {

    @Test
    public void testAnimeCreation() {
        Producer producer = new Producer("Studio Ghibli", 1);
        Anime anime = new Anime("My Neighbor Totoro", producer);
        assertNotNull(anime);
        assertEquals("My Neighbor Totoro", anime.getName());
        assertEquals(producer, anime.getProducer());
    }
}

