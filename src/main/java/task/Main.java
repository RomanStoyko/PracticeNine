package task;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Integer[] intArr = new Integer[10];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = (int)(Math.random() * 50);
        }

        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("renf");
        list.add("танко");
        list.add("ergh");

        for (Integer i:intArr) {
            System.out.print(i + " ");
        }
        Arrays.sort(intArr, (a,b) -> -(a-b));
        System.out.println();
        for (Integer i:intArr) {
            System.out.print(i + " ");
        }

        Predicate<Integer> predicate = x -> x%2 == 0;
        System.out.println();
        System.out.println(sumByCondition(intArr,predicate));

        System.out.println(list);
        Collections.sort(list, (a,b) -> - a.compareTo(b));
        System.out.println(list);

        Predicate<String> predicateString = x -> x.startsWith("r");
        System.out.println(startByLetter(list,predicateString));

        System.out.println(ConvertString.isExist("sad"));


        ConvertString<String, String> convertString = String::toUpperCase;
        for (String str:list) {
            System.out.println(convertString.convert(str));
        }
    }


    private static Integer sumByCondition(Integer[] arr, Predicate<Integer> predicate){
        return Arrays.stream(arr).filter(predicate).reduce((Integer a,Integer b) -> a + b).orElse(0);
    }

    private static List<String> startByLetter( List<String> list, Predicate<String> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
