package by.incubator.task9.animals;

public class Dragonfly extends Animal {
    public Dragonfly() {
        super();
    }

    public Dragonfly(String animalName, int footNUmber, boolean hasMustache) {

        super(animalName, footNUmber, hasMustache);
    }

    public void voice() {
        System.out.println("bj-w-w");
    }

    public void move() {
        System.out.println("flight");
    }

    public void isHungry() {
        System.out.println("I want insects");
    }
}
