package Dominio;

import java.util.Objects;

public class Producer {
	private Integer id;
	private String name;
	
	
	//constructor
	public Producer(String name) {
		this.name = name;
	}
	
	
	public Producer(String name, int id) {
		super();
		this.name = name;
		this.id = id;	
	}

	

	//hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producer other = (Producer) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	
	
	@Override
	public String toString() {
		return "Producer:"
				+ "\nId = " + id 
				+ "\nName=" + name;
	}


	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	
	
}
