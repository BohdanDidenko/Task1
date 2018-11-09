package com.epam.task7.task7_6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public void run(){
        //part1
        List<Integer> list = Stream.iterate(10, n -> n+10)
                .limit(10)
                .map(n -> n/2)
                .collect(Collectors.toList());
        System.out.println("List: " + list);
        System.out.println("====================================================");

        //part2
        List<Person> listPerson = createListPerson();
        System.out.println("Before:");
        listPerson.stream().forEach(System.out::println);
        listPerson.stream().filter(obj -> obj.getSex() == Person.Sex.MALE)
                .filter(person -> person.getAge() > 17 && person.getAge() < 57)
                .forEach(System.out::println);

        double averageAgeFemale = listPerson.stream()
                .filter(person -> person.getSex() == Person.Sex.FEMALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println("Average age of women = " + averageAgeFemale);
    }

    private List<Person> createListPerson(){
        return Arrays.asList(new Person("Mike", 25, Person.Sex.MALE),
                new Person("Jhon", 16, Person.Sex.MALE),
                new Person("Anna", 30, Person.Sex.FEMALE),
                new Person("Kate", 9, Person.Sex.FEMALE),
                new Person("Artur", 18, Person.Sex.MALE),
                new Person("Natali", 22, Person.Sex.FEMALE),
                new Person("Mike", 15, Person.Sex.MALE));
    }
}
