package main;

import days.Day1;
import days.Day2;
import days.Day3;

import java.util.stream.Stream;

public class Runner {

    public static void main(String[] args) {
        Stream.of(
                new Day3(),
                new Day2(),
                new Day1()
        ).forEach(it -> {
            long start1 = System.currentTimeMillis();
            System.out.println("#Day" + it.day());
            String actualOne = it.computeOne();
            long end1 = System.currentTimeMillis();
            String expectedOne = it.correctResultOne();
            System.out.println("Task 1: Got " + actualOne + ", expected: " + expectedOne +
                    ", good? " + (actualOne.equals(expectedOne) ? "good." : "<--------  this guy right here officer"));

            long start2 = System.currentTimeMillis();
            String actualTwo = it.computeTwo();
            long end2 = System.currentTimeMillis();
            String expectedTwo = it.correctResultTwo();
            System.out.println("Task 2: Got " + actualTwo + ", expected: " + expectedTwo +
                    ", good? " + (actualTwo.equals(expectedTwo) ? "good." : "<--------  this guy right here officer"));
            System.out.println("Took " + (end1-start1) + "ms / " + (end2-start2) + "ms" );
            System.out.println("=========");
        });
    }
}
