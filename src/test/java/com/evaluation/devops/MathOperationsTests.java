package com.evaluation.devops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe MathOperations
 */
public class MathOperationsTests {

    // Test pour add()
    @ParameterizedTest
    @CsvSource({
        "5, 7, 12",
        "10, 20, 30",
        "-5, -3, -8",
        "5, -3, 2",
        "-10, 5, -5",
        "0, 0, 0",
        "0, 5, 5",
        "100, -100, 0"
    })
    @DisplayName("Addition de deux nombres avec différents cas")
    void MathOperations_Add_VariousNumbers_ReturnsCorrectSum(int a, int b, int expected) {
        MathOperations mathOps = new MathOperations();

        int result = mathOps.add(a, b);

        assertEquals(expected, result);
    }

    // Test pour la méthode divide()
    @Test
    @DisplayName("Division par zéro lance une IllegalArgumentException")
    void MathOperations_Divide_ByZero_ThrowsException() {
        MathOperations mathOps = new MathOperations();

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> mathOps.divide(10, 0)
        );

        assertEquals("Second parameter cannot be equal to zero", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "10, 2, 5.0",
        "20, 4, 5.0",
        "9, 3, 3.0",
        "10, 3, 3.333333",
        "7, 2, 3.5",
        "-10, 2, -5.0",
        "10, -2, -5.0",
        "-10, -2, 5.0",
        "0, 5, 0.0"
    })
    @DisplayName("Division de deux nombres avec différents cas")
    void MathOperations_Divide_VariousNumbers_ReturnsCorrectQuotient(int a, int b, float expected) {
        MathOperations mathOps = new MathOperations();

        float result = mathOps.divide(a, b);

        assertEquals(expected, result, 0.0001f, "La division devrait retourner le bon résultat");
    }

    // Test pour la méthode getOddNumbers()
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10, -100})
    @DisplayName("getOddNumbers avec une limite négative lance une IllegalArgumentException")
    void MathOperations_GetOddNumbers_NegativeLimit_ThrowsException(int negativeLimit) {
        MathOperations mathOps = new MathOperations();

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> mathOps.getOddNumbers(negativeLimit)
        );

        assertEquals("Limit argument cannot be negative", exception.getMessage());
    }

    @Test
    @DisplayName("getOddNumbers avec limite 0 retourne une liste vide")
    void MathOperations_GetOddNumbers_ZeroLimit_ReturnsEmptyList() {
        MathOperations mathOps = new MathOperations();

        List<Integer> result = mathOps.getOddNumbers(0);

        assertTrue(result.isEmpty(), "La liste devrait être vide pour limite 0");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 15, 20})
    @DisplayName("getOddNumbers retourne uniquement des nombres impairs")
    void MathOperations_GetOddNumbers_ValidLimit_ReturnsOnlyOddNumbers(int limit) {
        MathOperations mathOps = new MathOperations();

        List<Integer> result = mathOps.getOddNumbers(limit);

        for (int number : result) {
            assertTrue(number % 2 != 0, "Tous les nombres doivent être impairs");
        }
    }

    @Test
    @DisplayName("getOddNumbers(10) retourne [1,3,5,7,9]")
    void MathOperations_GetOddNumbers_Limit10_ReturnsCorrectList() {
        MathOperations mathOps = new MathOperations();
        int limit = 10;
        List<Integer> expected = List.of(1, 3, 5, 7, 9);

        List<Integer> result = mathOps.getOddNumbers(limit);

        assertEquals(expected.size(), result.size(), "La taille doit être correcte");
        assertEquals(expected, result, "La liste doit contenir exactement [1,3,5,7,9]");
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "5, 3",
        "10, 5",
        "15, 8",
        "20, 10"
    })
    @DisplayName("getOddNumbers retourne le bon nombre d'éléments")
    void MathOperations_GetOddNumbers_VariousLimits_ReturnsCorrectCount(int limit, int expectedCount) {
        MathOperations mathOps = new MathOperations();

        List<Integer> result = mathOps.getOddNumbers(limit);

        assertEquals(expectedCount, result.size(),
            "Pour la limite " + limit + ", on devrait avoir " + expectedCount + " nombres impairs");
    }
}
