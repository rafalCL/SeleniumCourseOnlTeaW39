package pl.coderslab.seleniumcourseonlteaw39.examples;

import java.util.ArrayList;
import java.util.List;

public class ListAndStringExample {
    public static void main(String[] args) {
        String name = "Ala";
        String nameLowerCase = name.toLowerCase();

        int[] ints = {1,2,3};
        ints[0] = 42;

        List<Integer> integers = new ArrayList<>();
        System.out.println(integers.size()); // 0
        integers.add(42);
        System.out.println(integers.size()); // 1
        integers.add(17);
        System.out.println(integers.size()); // 2
    }
}
