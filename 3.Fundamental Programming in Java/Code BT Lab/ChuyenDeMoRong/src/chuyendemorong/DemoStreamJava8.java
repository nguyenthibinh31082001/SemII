/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuyendemorong;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class DemoStreamJava8 {
    List<String> listStr = Arrays.asList("Tao", "", "Le", "Buoi", "Mang cau", "","Nho");
    
    private void streamsFilter() {
        // Lấy về stream và lọc dữ liệu rỗng
        Predicate<String> pre = (str) -> {
            return !str.isEmpty();
        };
        // Lấy về stream và lọc dữ liệu str > 3 ký tự
        Predicate<String> pre2 = (str) -> str.length() > 3;
        List<String> filter = listStr.stream().filter(pre).collect(Collectors.toList());
        System.out.println(filter);
    }
    private void streamsForeach() {
        Random random = new Random();
        // random.ints().limit(2).forEach(System.out::println); // Method Reference
        // Full code
        // IntConsumer ic = (value) -> {
        // value = value * 2;
        // System.out.println("#" + value);
        // };
        // random.ints().limit(3).forEach(ic);
        // Short code 1
        // random.ints().limit(3).forEach((val) -> System.out.println("@" + val));
        // Short code 2
        random.ints().limit(3).forEach((val) -> {
            System.out.println("(.)(.)");
            System.out.println("val = " + val);
        });
    }
    private void streamsMap() {
        List<Integer> numbers = Arrays.asList(3, 9, 3, 0);
        // Function<Integer, Integer> f = new Function<Integer, Integer>() {
        // @Override
        // public Integer apply(Integer t) {
        // return (t * t);
        // }
        // };
        List<Integer> squareList = numbers.stream().map((t) -> t *t).distinct().collect(Collectors.toList());
        System.out.println("List: " + squareList.toString());
    }
    private void streamsSort() {
            Random random = new Random();
            random.ints().limit(5).sorted().forEach(System.out::println);
        }
        //Tận dụng phần cứng đa lõi (core) xử lý trên nhiều luồng
    private void streamsParallelProcessing() {
        long count = listStr.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("Số phần tử rỗng: " + count);
    }
    private void streamCollector() {
        List<String> list3Char = listStr.stream().filter(str -> str.length() > 3).collect(Collectors.toList());
        String str3Char = listStr.stream().filter(str -> str.length() > 3).collect(Collectors.joining(" - "));
        System.out.println("List 3 character: " + list3Char);
        System.out.println("String of 3 character: " + str3Char);
    }
    private void streamStatictics() {
        List<Integer> lstNumber = Arrays.asList(3, 5, 9, 2, 0, 4, 6);
        IntSummaryStatistics iss = lstNumber.stream().mapToInt(n -> n).summaryStatistics();
        System.out.println("Max: " + iss.getMax());
        System.out.println("Min: " + iss.getMin());
        System.out.println("Average: " + iss.getAverage());
        System.out.println("Sum: " + iss.getSum());
        System.out.println("Count: " + iss.getCount());
    }
    private void streamStaticticsPerson() {
        List<Person> lstPerson = Arrays.asList(new Person("Minh", 25), new Person("Tuấn", 19), new Person("Vũ", 30));
        ToIntFunction<Person> tifPer = (Person per) -> per.age;
        IntSummaryStatistics iss =
        lstPerson.parallelStream().mapToInt(tifPer).summaryStatistics();
        System.out.println(".:Person:.");
        System.out.println("Max: " + iss.getMax());
        System.out.println("Min: " + iss.getMin());
        System.out.println("Average: " + iss.getAverage());
        System.out.println("Sum: " + iss.getSum());
        System.out.println("Count: " + iss.getCount());
    }
    class Person {
        String name;
        int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        DemoStreamJava8 dmStream = new DemoStreamJava8();
        dmStream.streamsFilter();
        dmStream.streamsForeach();
        dmStream.streamsMap();
        dmStream.streamsSort();
        dmStream.streamsParallelProcessing();
        dmStream.streamCollector();
        dmStream.streamStatictics();
        dmStream.streamStaticticsPerson();
    }
}
