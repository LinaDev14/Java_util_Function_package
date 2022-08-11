package imperative;

import java.util.ArrayList;
import java.util.List;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

public class Main {

    public static void main(String[] args) {

        List<Person> people = List.of(

                new Person("Lina Maria", FEMALE),
                new Person("Max", MALE),
                new Person("Camilo", MALE),
                new Person("Wendy", FEMALE),
                new Person("Santiago", MALE),
                new Person("Mateo", MALE),
                new Person("Paola", FEMALE),
                new Person("Angela", FEMALE)

        );

        // imperative approach
        System.out.println("imperative approach");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        // Declarative approach
        System.out.println("Declarative approach");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .toList()
                .forEach(System.out::println);

        System.out.println("// males");
        List<Person> males = people.stream()
                .filter(person -> MALE.equals(person.gender)).toList();
        males.forEach(System.out::println);

    }


    public static class Person{

        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {

            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {

            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }

    }

    enum Gender{

        MALE,
        FEMALE
    }
}
