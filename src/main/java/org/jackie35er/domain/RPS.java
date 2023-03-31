package org.jackie35er.domain;

public enum RPS {

    ROCK(1,3, "R"),
    PAPER(2,1, "P"),
    SCISSORS(3,2, "S");

    private final int id;
    private final int beats;

    private final String name;

    RPS (int id, int beats, String string) {
        this.id = id;
        this.beats = beats;
        this.name = string;
    }
    
    public boolean doIBeat(RPS rps) {
        if(this.id == rps.id)
            return true;

        return this.beats == rps.id;
    }

    public static RPS of(String s){
        if("R".equalsIgnoreCase(s)) {
            return ROCK;
        }

        if ("P".equalsIgnoreCase(s)) {
            return PAPER;
        }

        if ("S".equalsIgnoreCase(s)) {
            return SCISSORS;
        }

        throw new RuntimeException("RPS OF failed: "+s);
    }

    public String getName() {
        return name;
    }
}
