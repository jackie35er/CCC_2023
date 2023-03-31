package org.jackie35er;

import org.jackie35er.domain.Fight;
import org.jackie35er.domain.RPS;
import org.jackie35er.domain.Riged;
import org.jackie35er.domain.Tournament;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {


    public static String read(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Riged> parse(Path path) {
        var string = read(path);
        var lines = new ArrayList<>(List.of(string.split("\r\n")));
        lines.remove(0);

        var rigeds = new ArrayList<Riged>();

        for(int i = 0; i < lines.size(); i++) {
            var splits = lines.get(i).split(" ");
            var numbers = new ArrayList<Integer>();
            Arrays.stream(splits).map(str -> str.substring(str.length()-2)).map(Integer::parseInt).forEach(numbers::add);
            rigeds.add( new Riged(numbers.get(0),numbers.get(1),numbers.get(2)));
        }

        return rigeds;
    }



    public static Fight mapToFight(String str) {
        var str1 = str.substring(0,1);
        var str2 = str.substring(1);

        var rps1 = RPS.of(str1);
        var rps2 = RPS.of(str2);

        return new Fight(rps1,rps2);
    }

}
