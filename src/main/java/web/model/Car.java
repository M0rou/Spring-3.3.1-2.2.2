package web.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    private Long id;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(int number, String model, String color) {
        this.number = number;
        this.model = model;
        this.color = color;
    }

    public Car() {
        this.number = 0;
        this.model = "Unknown model";
        this.color = "Unknown color";
    }
    private String model;
    private String color;
    private int number;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
