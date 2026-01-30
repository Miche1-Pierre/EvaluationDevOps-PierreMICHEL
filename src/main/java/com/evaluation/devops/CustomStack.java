package com.evaluation.devops;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {

    private final List<Integer> list = new ArrayList<>();

    public int count() {
        return list.size();
    }

    public void push(int value) {
        list.add(value);
    }

    public int pop() {
        if (count() == 0) {
            throw new StackEmptyException("Cannot call pop on an empty stack.");
        }

        int lastIndex = list.size() - 1;
        int poppedValue = list.get(lastIndex);
        list.remove(lastIndex);

        return poppedValue;
    }

    public static class StackEmptyException extends RuntimeException {
        public StackEmptyException(String message) {
            super(message);
        }
    }
}
