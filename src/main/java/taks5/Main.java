package taks5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.iterate(10,x -> x + 10);
        List<Integer> integerList = integerStream.limit(10)
                                        .map(x -> x / 2)
                                        .collect(Collectors.toList());
        System.out.println(integerList);


        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Roman", Sex.MALE, 33));
        personList.add(new Person("Petro", Sex.MALE, 12));
        personList.add(new Person("Kirill", Sex.MALE, 18));
        personList.add(new Person("Den", Sex.MALE, 65));
        personList.add(new Person("Vasia", Sex.MALE, 24));
        personList.add(new Person("Tania", Sex.FEMALE, 35));
        personList.add(new Person("Ira", Sex.FEMALE, 12));
        personList.add(new Person("Lena", Sex.FEMALE, 48));
        personList.add(new Person("Sveta", Sex.FEMALE, 25));

        List<Person> armyMan = personList.stream().filter(x -> x.getSex() == Sex.MALE)
                                                    .filter(x -> x.getAge() >= 18 & x.getAge() < 28)
                                                    .collect(Collectors.toList());

        System.out.println(armyMan);

        double avaregeAgeFimale = personList.stream().filter(x -> x.getSex() == Sex.FEMALE)
                                            .mapToInt(Person::getAge)
                                            .average().orElse(0);

        System.out.println(avaregeAgeFimale);
    }
}
