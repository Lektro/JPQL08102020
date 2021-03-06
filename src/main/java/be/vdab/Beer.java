package be.vdab;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "beers")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float alcohol;
    private float price;

    public Beer(int id, String name, float alcohol, float price) {
        this.id = id;
        this.name = name;
        this.alcohol = alcohol;
        this.price = price;
    }

    public Beer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beer)) return false;
        Beer beer = (Beer) o;
        return getId() == beer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", alcohol= " + alcohol +
                ", price= " + price +
                '}';
    }
}
