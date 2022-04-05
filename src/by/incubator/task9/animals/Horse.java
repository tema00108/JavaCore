package by.incubator.task9.animals;

public class Horse extends Animal{

    public Horse() {
        super();
    }

    public Horse(String animalName, int footNumber, boolean hasMustache) {

        super(animalName, footNumber, hasMustache);
    }

    public void voice() {
        System.out.println("I-go-go");
    }

    public void move() {
        System.out.println("top-top");
    }

    public void isHungry() {
        System.out.println("I want hay");
    }
}
