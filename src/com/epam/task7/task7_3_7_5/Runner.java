package com.epam.task7.task7_3_7_5;

import com.sun.javafx.css.Combinator;

import java.util.*;
import java.util.function.Predicate;

import static com.sun.org.apache.bcel.internal.classfile.Utility.convertString;

public class Runner {
    public void run(){
//        7.3
        Integer[] arrayInt = createArrayInt(12);
        System.out.println("Array: " + Arrays.toString(arrayInt));
//        Arrays.sort(arrayInt, (o1, o2) -> o2.compareTo(o1));
        Arrays.sort(arrayInt, Comparator.reverseOrder());
        System.out.println("Sort: " + Arrays.toString(arrayInt));

        List<String> list = createListString();
        System.out.println("List: " + list);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("Sort: " + list);
        System.out.println("=================================================");

        //7.4
        System.out.println("sum=" + sum(arrayInt, x -> x%2 == 0));
        System.out.println("sum=" + sum(arrayInt, x -> x>10 && x%3 == 0));
        System.out.println("Select=" + selectStrings(list, s -> s.startsWith("c") || s.startsWith("k")) );
        System.out.println("=================================================");

        //7.5
        listToUpperCase(list, x -> x.toUpperCase());
        System.out.println("ConvertString=" + list);
        List<String> listStr = Arrays.asList("", null, "   ", " assa");
        listToUpperCase(listStr, String::toUpperCase);
        System.out.println(listStr);
    }

    private Integer[] createArrayInt(int size){
        Integer[] result = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(100);
        }
        return result;
    }

    private List<String> createListString(){
        List<String> result = new LinkedList<>();
        Random random = new Random();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            result.add("" + ch + ch);
        }
        Collections.shuffle(result);
        return result;
    }

    private int sum(Integer[] array, Predicate<Integer> filter){
        int result = 0;
        for (Integer value: array) {
            if(filter.test(value)){
                result += value;
            }
        }
        return result;
    }

    private List<String> selectStrings(List<String> list, Predicate<String> filter){
        List<String> result = new LinkedList<>();
        for (String str : result) {
            if(filter.test(str)) {
                result.add(str);
            }
        }
        return result;
    }

    private void listToUpperCase(List<String> list, ConvertString convertString){
        for (int i = 0; i < list.size(); i++) {
            if(!convertString.isNull(list.get(i))) {
                list.set(i, convertString.convert(list.get(i)));
            }
        }
    }
}
