package by.incubator.task16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<String> list = new ArrayList<>();
    private static List<People> persons = new ArrayList<>();

    public static void main(String[] args) {
        initList();

        countA1();
        firstElem();
        thirdElem();
        twoElem();
        findA1();
        containsA1();
        notContainsA7();
        getNumbers();
        getAsSingleRow();
        sortElems();

        initPeople();

        findMilitary();
        getAverageManAge();
        getAbleToWorkMen();
        getMinAgePersons();
        sortPeople();
    }

    private static void sortPeople() {
        List<People> sortedPeople = persons.stream().sorted(Comparator.comparing(People::getSex)
                .thenComparing(People::getAge)).collect(Collectors.toList());
        System.out.println(sortedPeople);
    }

    private static void getMinAgePersons() {
        People minAge = persons.stream().reduce((p1, p2) -> (p1.getAge() < p2.getAge()) ? p1 : p2).get();
        System.out.println(minAge);
    }

    private static void getAbleToWorkMen() {
        long ableToWorkMen = persons.stream()
                .filter(person -> person.getAge() >= 18 && ((person.getSex() == Sex.MAN && person.getAge() <= 60) || (person.getSex() == Sex.WOMAN && person.getAge() <= 55)))
                .count();
        System.out.println(ableToWorkMen);
    }

    private static void getAverageManAge() {
        long averageManAge = (int) persons.stream()
                .filter(person -> person.getSex() == Sex.MAN).mapToInt(People::getAge)
                .average().getAsDouble();
        System.out.println(averageManAge);
    }

    private static void findMilitary() {
        List<People> military = persons.stream()
                .filter(person -> person.getSex() == Sex.MAN && person.getAge() >= 18 && person.getAge() <= 27)
                .collect(Collectors.toList());
        System.out.println(military);
    }


    private static void initPeople() {
        persons.add(new People("Basil", 16, Sex.MAN));
        persons.add(new People("Peter", 23, Sex.MAN));
        persons.add(new People("Helen", 42, Sex.WOMAN));
        persons.add(new People("Ivan", 69, Sex.MAN));
    }

    private static void countA1() {
        long num = list.stream().filter("a1"::equals).count();
        System.out.println(num);
    }

    private static void firstElem() {
        String first = list.stream().findFirst().orElse("0");
        System.out.println(first);
    }

    private static void thirdElem() {
        String third = list.stream().skip(list.size() - 2).findFirst().get();
        System.out.println(third);
    }

    private static void twoElem() {
        List<String> twoElem = list.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println(twoElem);
    }

    private static void findA1() {
        List<String> a1s = list.stream().filter("a1"::contains).collect(Collectors.toList());
        System.out.println(a1s);
    }

    private static void containsA1() {
        boolean hasA1 = list.stream().anyMatch("a1"::contains);
        System.out.println(hasA1);
    }

    private static void notContainsA7() {
        boolean notContainsA7 = list.stream().noneMatch("a7"::contains);
        System.out.println(notContainsA7);
    }

    private static void getNumbers() {
        int[] nums = list.stream().mapToInt(elem -> Integer.parseInt(elem.substring(1))).toArray();
        System.out.println(Arrays.toString(nums));
    }

    private static void getAsSingleRow() {
        String row = list.stream().reduce((s1,s2) -> s1 + s2).get();
        System.out.println(row);
    }

    private static void sortElems() {
        List<String> elems = list.stream().sorted().collect(Collectors.toList());
        System.out.println(elems);
    }

    private static void initList() {
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a1");
    }
}
