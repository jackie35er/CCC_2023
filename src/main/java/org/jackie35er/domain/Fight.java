package org.jackie35er.domain;

public class Fight {

    public RPS first;
    public RPS second;

    public Fight(RPS first, RPS second) {
        this.first = first;
        this.second = second;
    }

    public String level1() {
        return whoWins(first,second).getName();
    }
    
    public static RPS whoWins(RPS a, RPS b) {
        if(a.doIBeat(b))
            return a;
        return b;
    }

}
