package by.incubator.task9.animals;

import by.incubator.task9.mixins.Movable;
import by.incubator.task9.mixins.Starveble;
import by.incubator.task9.mixins.Voiceable;

public abstract class Animal implements Starveble, Movable, Voiceable {
    private String animalName;
    private int footNumber;
    private boolean hasMustache;

    public Animal(){ }

    public Animal(String animalName, int footNumber, boolean hasMustache) {
        this.animalName = animalName;
        this.footNumber = footNumber;
        this.hasMustache = hasMustache;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getFootNumber() {
        return footNumber;
    }

    public void setFootNumber(int footNumber) {
        if (footNumber >= 0) {
            this.footNumber = footNumber;
        }
    }

    public boolean isHasMustache() {
        return hasMustache;
    }

    public void setHasMustache(boolean hasMustache) {
        this.hasMustache = hasMustache;
    }
}

