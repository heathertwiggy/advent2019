package main;

import days.Day1;
import days.Day2;

import java.util.stream.Stream;

public class Runner {

    public static void main(String[] args) {
        Stream.of(
                new Day2(),
                new Day1()
        ).forEach(it -> {
            System.out.println("#Day" + it.day());
            String actualOne = it.computeOne();
            String expectedOne = it.correctResultOne();
            System.out.println("Task 1: Got " + actualOne + ", expected: " + expectedOne +
                    ", good? " + (actualOne.equals(expectedOne) ? "good." : "<--------  this guy right here officer"));
            String actualTwo = it.computeTwo();
            String expectedTwo = it.correctResultTwo();
            System.out.println("Task 2: Got " + actualTwo + ", expected: " + expectedTwo +
                    ", good? " + (actualTwo.equals(expectedTwo) ? "good." : "<--------  this guy right here officer"));
            System.out.println("=========");
        });
    }
}
