package Services;

import java.util.IllegalFormatWidthException;

import Dominio.Producer;
import Repository.ProducerRepository;

public class ProducerService {

	public static void save(Producer producer) {
		ProducerRepository.save(producer);
	}
	
	public static void delete(int id) {
		if (id <=0) {
			throw new IllegalArgumentException("ID inválido");
		}
		ProducerRepository.delete(id);
	}
}
