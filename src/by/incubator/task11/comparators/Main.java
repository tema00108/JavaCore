package by.incubator.task11.comparators;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Person[] persons = initPersons();
        print(persons);

        Arrays.sort(persons, Comparator.comparingInt(Person::getAge));
        print(persons);

        Arrays.sort(persons);
        print(persons);
    }

    public static Person[] initPersons() {
        Person[] persons = new Person[5];
        persons[0] = new Person("Artyom", 21);
        persons[1] = new Person("Vlad", 20);
        persons[2] = new Person("Lenya", 20);
        persons[3] = new Person("Lesha", 20);
        persons[4] = new Person("Daniil", 22);

        return persons;
    }

    public static void print(Person[] persons) {
        System.out.println();
        for(Person person : persons) {
            System.out.println(person);
        }
    }

}
