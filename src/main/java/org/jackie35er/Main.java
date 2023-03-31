package org.jackie35er;

import org.apache.commons.lang3.StringUtils;
import org.jackie35er.domain.Fight;
import org.jackie35er.domain.Tournament;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        int level_num = 3;
        example(level_num);
        level(level_num);
    }

    private static void level(int level_num) {
        for (int i = 1; i <= 5; i++) {
            String path = "src/main/resources/level" + level_num + "/level" + level_num + "_" + i;
            Path input = Path.of(path + ".in");
            Path output = Path.of(path + ".out");

            var tournaments = Reader.parse(input);

//            tournaments.stream().map(Tournament::toString)
//                    .forEach(fight -> Writer.append(output, fight));
        }
    }

    public static void example(int level_num) {
        String pathexample = "src/main/resources/level" + level_num + "/level" + level_num + "_example.in";
        var example = Reader.parse(Path.of(pathexample));

//        example.stream().map(Tournament::toString)
//                .forEach(fight -> System.out.println(fight));
    }

    public static long countSubString(String source, String target) {
        return StringUtils.countMatches(source, target);
    }
}