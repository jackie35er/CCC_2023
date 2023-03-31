package org.jackie35er.domain;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequiredArgsConstructor
public class Tournament {

    private List<RPS> participants;

    private final Map<RPS, Integer> registered;

    public static List<RPS> calculateFinalists(List<RPS> participants, int depth) {
        if (depth == 0) {
            return participants;
        }

        List<RPS> winners = new ArrayList<>();
        
        for (int i = 0; i < participants.size(); i+=2) {
            RPS first = participants.get(i);
            RPS second = participants.get(i+1);
            winners.add(Fight.whoWins(first, second));
        }


        int a = depth - 1;
        return calculateFinalists(winners, a);
    }

    public void calculateLineup() {
        int numOfScissors = registered.get(RPS.SCISSORS);

        boolean minOneScissor = false;

        while (numOfScissors >= 4) {
            participants.add(RPS.SCISSORS);
            participants.add(RPS.SCISSORS);
            participants.add(RPS.SCISSORS);
            participants.add(RPS.SCISSORS);
            registered.put(RPS.SCISSORS, numOfScissors - 4);
            numOfScissors = registered.get(RPS.SCISSORS);
            minOneScissor = true;
        }

        while (numOfScissors >= 2) {
            if (registered.get(RPS.ROCK) > 0) {
                participants.add(RPS.SCISSORS);
                participants.add(RPS.SCISSORS);
                participants.add(RPS.ROCK);
                participants.add(RPS.PAPER);
                registered.put(RPS.SCISSORS, numOfScissors - 2);
                registered.put(RPS.ROCK, registered.get(RPS.ROCK) - 1);
                registered.put(RPS.PAPER, registered.get(RPS.PAPER) - 1);
            } else if (registered.get(RPS.PAPER) >= 2){
                participants.add(RPS.SCISSORS);
                participants.add(RPS.SCISSORS);
                participants.add(RPS.PAPER);
                participants.add(RPS.PAPER);
                registered.put(RPS.SCISSORS, numOfScissors - 2);
                registered.put(RPS.PAPER, registered.get(RPS.PAPER) - 2);
            } else {
                participants.add(RPS.SCISSORS);
                participants.add(RPS.SCISSORS);
                participants.add(RPS.SCISSORS);
                participants.add(RPS.PAPER);
                registered.put(RPS.SCISSORS, numOfScissors - 3);
                registered.put(RPS.PAPER, registered.get(RPS.PAPER) - 1);
            }
            numOfScissors = registered.get(RPS.SCISSORS);
            minOneScissor = true;
        }

        if (numOfScissors == 1) {
            participants.add(RPS.SCISSORS);


        }

        if (registered.get(RPS.PAPER) >= 1) {
            participants.add(RPS.SCISSORS);
            participants.add(RPS.PAPER);
        }



    }

    @Override
    public String toString() {

        var part = calculateFinalists(participants, 2);


        return part.stream().map(RPS::getName).collect(Collectors.joining());
    }
}
