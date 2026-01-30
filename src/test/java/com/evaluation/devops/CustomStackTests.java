package com.evaluation.devops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe CustomStack
 */
public class CustomStackTests {

    // Test pour la méthode count()
    // Test 1 : Vérifier que count fonctionne
    @Test
    @DisplayName("Count sur une stack vide retourne zéro")
    void CustomStack_Count_OnNewStack_ReturnsZero() {
        CustomStack stack = new CustomStack();

        assertEquals(0, stack.count());
    }


    // Test pour la méthode push()
    // Test 1 : Vérifier que push ajoute bien un élément (count augmente)
    @Test
    @DisplayName("Push sur une stack vide augmente le count à 1")
    void CustomStack_Push_OnEmptyStack_IncreasesCountToOne() {
        CustomStack stack = new CustomStack();

        stack.push(42);

        assertEquals(1, stack.count());
    }

    // Test 2 : Vérifier que push permet de récupérer la valeur correcte
    @ParameterizedTest
    @ValueSource(ints = {10, -5, 0, 999, Integer.MAX_VALUE, Integer.MIN_VALUE})
    @DisplayName("Push puis Pop retourne la valeur correcte")
    void CustomStack_Push_StoresCorrectValue(int valueToPush) {
        CustomStack stack = new CustomStack();

        stack.push(valueToPush);
        int result = stack.pop();

        assertEquals(valueToPush, result);
    }

    // Test 3 : Vérifier que push sur une stack déjà remplie augmente le count
    @Test
    @DisplayName("Push sur une stack non vide augmente le count")
    void CustomStack_Push_OnNonEmptyStack_IncreasesCount() {
        CustomStack stack = new CustomStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        int initialCount = stack.count();

        stack.push(99);

        assertEquals(initialCount + 1, stack.count());
    }


    // Test pour la méthode pop()
    // Test 1 : Vérifier que pop sur une stack vide lance une exception
    @Test
    @DisplayName("Pop sur une stack vide lance StackEmptyException")
    void CustomStack_Pop_OnEmptyStack_ThrowsException() {
        CustomStack stack = new CustomStack();
        assertThrows(CustomStack.StackEmptyException.class, stack::pop);
    }

    // Test 2 : Vérifier que pop retire et retourne le dernier élément ajouté
    @Test
    @DisplayName("Pop retire et retourne le dernier élément")
    void CustomStack_Pop_RemovesAndReturnsLastElement() {
        CustomStack stack = new CustomStack();

        stack.push(42);
        int poppedValue = stack.pop();

        assertEquals(42, poppedValue);
        assertEquals(0, stack.count());
    }
}
