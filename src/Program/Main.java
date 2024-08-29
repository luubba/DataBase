package Program;

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
			
			System.out.println(
					"O que deseja fazer:"
					+ "\n1.Adcionar produtor"
					+ "\n2.Adicionar anime"
					+ "\n3.Remover produtor"
					+ "\n4.Remover anime");
			
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
					
					System.out.println("Digite o nome do Produtor do anime:");
					String animeName = sc.nextLine();
					
					Anime anime = new Anime(animeName);
//					ProducerRepository.save(anime);
					break;
					
				case 3:
					
					System.out.println("Digite o nome do ID do Produtor do anime:");
					int producerId = sc.nextInt();
					sc.nextLine();
			
					ProducerRepository.delete(producerId);
					break;
			
			
			}
			
		}while (option == 4);
		sc.close();
	}

}
