package com.evaluation.devops;

import java.util.ArrayList;
import java.util.List;

public class MathOperations {

    public int add(int numberOne, int numberTwo) {
        return numberOne + numberTwo; // Chemin d'exécution 1
    }

    public float divide(int numberOne, int numberTwo) {
        if (numberTwo == 0) {
            throw new IllegalArgumentException("Second parameter cannot be equal to zero"); // Chemin d'exécution 2
        }

        return (float) numberOne / numberTwo; // Chemin d'exécution 3
    }

    public List<Integer> getOddNumbers(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit argument cannot be negative"); // Chemin d'exécution 4
        }

        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i <= limit; i++) {
            if (i % 2 != 0) {
                numberList.add(i);
            }
        }

        return numberList; // Chemin d'exécution 5
    }
}
