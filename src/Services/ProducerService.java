package Services;


import java.util.List;

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
	
	public static void update(Producer producer) {
		if (producer.getId() <=0 || producer.getId() == null) {
			throw new IllegalArgumentException("ID inválido");
		}
		ProducerRepository.update(producer);
	}
	
	public static List<Producer> findAll() {
		return ProducerRepository.findAll();
	}
	
	public static List<Producer> findByName(String name) {
		return ProducerRepository.findByName(name);
	}

	
	
}
