package Program;

import java.util.Scanner;

import Dominio.Producer;
import Repository.ProducerRepository;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o nome do Produtor do anime:");
		String name = sc.nextLine();
		
		Producer producer = new Producer(name);
		ProducerRepository.save(null);
	}

}
