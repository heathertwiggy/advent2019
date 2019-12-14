package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {

    private static final String base = "c://src/advent2019/resources/d%d.txt";

    public static Stream<String> stream(int day){
        try {
            return Files.lines(Paths.get(String.format(base, day)));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("well we're boned reading file on day " + day);
        }

        return Stream.empty();
    }

    public static List<String> list(int day){
        return stream(day).collect(Collectors.toList());
    }
}
