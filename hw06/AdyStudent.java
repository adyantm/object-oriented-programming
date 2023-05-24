package hw06;

public abstract class AdyStudent implements Summarizable {

    public String summarize () {
        return "x";
    }

    public int compareTo(){
        return 0;
    };
}

/*
If an abstract class extends an interface, all the methods can be defined or
at least one has to be defined and the rest can be abstract
 */