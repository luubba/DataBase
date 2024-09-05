package Program;

import java.util.List;
import java.util.Scanner;

import Dominio.Anime;
import Dominio.Producer;
import Services.AnimeService;
import Services.ProducerService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("O que deseja fazer:" + 
                               "\n1.Adicionar produtor" + 
                               "\n2.Adicionar anime" + 
                               "\n3.Atualizar produtor" + 
                               "\n4.Atualizar anime" + 
                               "\n5.Remover produtor" + 
                               "\n6.Remover anime" + 
                               "\n7.Listar produtores" +
                               "\n8.Listar animes" +
                               "\n0.Sair da aplicação");

            option = sc.nextInt();
            sc.nextLine();
            switch (option) {

            case 1:
                System.out.println("Digite o nome do Produtor do anime:");
                String producerName = sc.nextLine();
                Producer producer = new Producer(producerName);
                ProducerService.save(producer);
                break;

            case 2:
                System.out.println("Digite o nome do anime:");
                String animeName = sc.nextLine();
                
                System.out.println("Digite o ID do Produtor do anime:");
                int producerId = sc.nextInt();
                sc.nextLine(); // Limpar o buffer

                Producer animeProducer = ProducerService.findAll().stream()
                    .filter(p -> p.getId().equals(producerId))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Produtor não encontrado"));

                Anime anime = new Anime(animeName, animeProducer);
                AnimeService.save(anime);
                break;

            case 3:
                System.out.println("Digite o nome do Produtor a ser atualizado:");
                String producerNameUpdate = sc.nextLine();
                List<Producer> producers = ProducerService.findByName(producerNameUpdate);
                System.out.println(producers);

                if (producers.isEmpty()) {
                    System.out.println("Nenhum produtor encontrado com esse nome.");
                } else {
                    System.out.println("Digite o novo nome do Produtor:");
                    String newProducerName = sc.nextLine();
                    for (Producer produ : producers) {
                        ProducerService.update(new Producer(newProducerName, produ.getId()));
                    }
                }
                break;

            case 4:
                System.out.println("Digite o nome do Anime a ser atualizado:");
                String animeNameUpdate = sc.nextLine();
                List<Anime> animes = AnimeService.findByName(animeNameUpdate);
                System.out.println(animes);

                if (animes.isEmpty()) {
                    System.out.println("Nenhum anime encontrado com esse nome.");
                } else {
                    System.out.println("Digite o novo nome do Anime:");
                    String newAnimeName = sc.nextLine();

                    System.out.println("Digite o ID do novo Produtor do anime:");
                    int newProducerId = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer

                    Producer newProducer = ProducerService.findAll().stream()
                        .filter(p -> p.getId().equals(newProducerId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Produtor não encontrado"));

                    for (Anime animeToUpdate : animes) {
                        AnimeService.update(new Anime(newAnimeName, newProducer));
                    }
                }
                break;

            case 5:
                System.out.println("Digite o nome do Produtor a ser deletado:");
                String deleteProducer = sc.nextLine();
                List<Producer> deleteProducers = ProducerService.findByName(deleteProducer);
                System.out.println(deleteProducers);

                if (deleteProducers.isEmpty()) {
                    System.out.println("Nenhum produtor encontrado com esse nome.");
                } else {
                    for (Producer produ : deleteProducers) {
                        ProducerService.delete(produ.getId());
                    }
                }
                break;

            case 6:
                System.out.println("Digite o nome do Anime a ser deletado:");
                String deleteAnime = sc.nextLine();
                List<Anime> deleteAnimes = AnimeService.findByName(deleteAnime);
                System.out.println(deleteAnimes);

                if (deleteAnimes.isEmpty()) {
                    System.out.println("Nenhum anime encontrado com esse nome.");
                } else {
                    for (Anime animeToDelete : deleteAnimes) {
                        AnimeService.delete(animeToDelete.getId());
                    }
                }
                break;

            case 7:
                List<Producer> producersList = ProducerService.findAll();
                System.out.println("Lista de Produtores:");
                producersList.forEach(System.out::println);
                break;

            case 8:
                List<Anime> animesList = AnimeService.findAll();
                System.out.println("Lista de Animes:");
                animesList.forEach(System.out::println);
                break;

            case 0:
                System.out.println("Saindo da aplicação...");
                break;

            default:
                System.out.println("Opção inválida, tente novamente.");
            }

        } while (option != 0);

        sc.close();
    }
}
