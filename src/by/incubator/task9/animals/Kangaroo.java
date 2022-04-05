package by.incubator.task9.animals;

public class Kangaroo extends Animal {
    public Kangaroo() {
        super();
    }

    public Kangaroo(String animalName, int footNUmber, boolean hasMustache) {

        super(animalName, footNUmber, hasMustache);
    }

    public void voice() {
        System.out.println("Khe-khe");
    }

    public void move() {
        System.out.println("jump-jump");
    }

    public void isHungry() {
        System.out.println("I want berries");
    }
}
