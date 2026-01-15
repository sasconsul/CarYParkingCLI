package net.sasconsul.caryparking.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Engine {
    private Double horsepower;
    private Double mpg;

    public Engine() {}

    public Engine(Double horsepower, Double mpg) {
        this.horsepower = horsepower;
        this.mpg = mpg;
    }

    public Double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Double horsepower) {
        this.horsepower = horsepower;
    }

    public Double getMpg() {
        return mpg;
    }

    public void setMpg(Double mpg) {
        this.mpg = mpg;
    }
}
