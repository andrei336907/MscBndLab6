package org.andrea.io;


import org.andrea.exceptions.InvalidDataException;

public class Question<T> {
    private Askable<T> askable;
    private T answer;

    public Question(String m, Askable<T> askable) {
        this.askable = askable;
        while (true) {
            try {
                System.out.println(m + " ");
                T ans = this.askable.ask();
                answer = ans;
                break;
            } catch (InvalidDataException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    public T getAnswer() {
        return answer;
    }
}
