package Services;

import java.util.List;

import Dominio.Anime;
import Repository.AnimeRepository;

public class AnimeService {

    public static void save(Anime anime) {
        if (anime == null || anime.getName() == null || anime.getName().trim().isEmpty() || anime.getProducer() == null || anime.getProducer().getId() == null) {
            throw new IllegalArgumentException("Dados inválidos para salvar o anime.");
        }
        AnimeRepository.save(anime);
    }

    public static void delete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        AnimeRepository.delete(id);
    }

    public static void update(Anime anime) {
        if (anime == null || anime.getId() == null || anime.getId() <= 0 || anime.getName() == null || anime.getName().trim().isEmpty() || anime.getProducer() == null || anime.getProducer().getId() == null) {
            throw new IllegalArgumentException("Dados inválidos para atualizar o anime.");
        }
        AnimeRepository.update(anime);
    }

    public static List<Anime> findAll() {
        return AnimeRepository.findAll();
    }

    public static List<Anime> findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        return AnimeRepository.findByName(name);
    }
}
