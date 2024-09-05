package Tests;

import static org.junit.Assert.assertThrows;

import org.junit.Test;

import Dominio.Anime;
import Dominio.Producer;
import Services.AnimeService;

public class AnimeServiceTest {

    @Test
    public void testSaveAnime() {
        Producer producer = new Producer("Studio Ghibli", 1);
        Anime anime = new Anime("My Neighbor Totoro", producer);
        AnimeService.save(anime);
    }

    @Test
    public void testDeleteAnimeWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            AnimeService.delete(-1);
        });
    }
}

