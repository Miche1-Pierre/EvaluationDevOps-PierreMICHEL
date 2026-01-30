package com.evaluation.devops;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {

    private final List<Integer> list = new ArrayList<>();

    public int count() {
        return list.size(); // Chemin d'exécution 1
    }

    public void push(int value) {
        list.add(value); // Chemin d'exécution 2
    }

    public int pop() {
        if (count() == 0) {
            throw new StackEmptyException("Cannot call pop on an empty stack."); // Chemin d'exécution 3
        }

        int lastIndex = list.size() - 1;
        int poppedValue = list.get(lastIndex);
        list.remove(lastIndex); // Cheemin d'exécution 4

        return poppedValue; // Chemin d'exécution 5
    }

    public static class StackEmptyException extends RuntimeException {
        public StackEmptyException(String message) {
            super(message); // Chemin d'exécution 6
        }
    }
}
