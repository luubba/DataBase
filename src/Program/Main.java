package Program;

import java.util.List;
import java.util.Scanner;

import Dominio.Anime;
import Dominio.Producer;
import Repository.ProducerRepository;
import Services.ProducerService;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int option = 0;

		do {

			System.out.println("O que deseja fazer:" + "\n1.Adicionar produtor" + "\n2.Adicionar anime"
					+ "\n3.Atualizar produtor" + "\n4.Atualizar anime" + "\n5.Remover anime" + "\n6.Remover anime");

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

				Anime anime = new Anime(animeName);
//					ProducerRepository.save(anime);
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
					String newProducer = sc.nextLine();
					for (Producer produ : producers) {
						ProducerRepository.updateByName(produ.getId(), newProducer);
					}
				}
				break;

			case 4:

				System.out.println("Digite o nome do Anime a ser atualizado:");
				
				break;
				
			case 5:

				System.out.println("Digite o nome do Produtor a ser deletado:");
				
				break;
				
			case 6:

				System.out.println("Digite o nome do Anime a ser deletadpo:");
				
				break;

			}

		} while (option == 0);
		sc.close();
	}

}
