package Dominio;

import java.util.Objects;

public class Anime {
    private Integer id;
    private String name;
    private Producer producer;

    // Construtor
    public Anime(String name, Producer producer) {
        this.name = name;
        this.producer = producer;
    }


    // Getters e Setters
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

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, producer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Anime other = (Anime) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(producer, other.producer);
    }

    @Override
    public String toString() {
        return "Anime:" +
               "\nId = " + id +
               "\nName = " + name +
               "\nProducer = " + producer;
    }
}
