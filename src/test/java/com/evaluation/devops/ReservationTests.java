package com.evaluation.devops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe Reservation
 */
public class ReservationTests {

    // Test pour le constructeur et getMadeBy()
    @Test
    @DisplayName("Le constructeur assigne correctement l'utilisateur")
    void Reservation_Constructor_AssignsUserCorrectly() {
        User user = new User(false);

        Reservation reservation = new Reservation(user);

        assertEquals(user, reservation.getMadeBy());
    }

    // Test pour getMadeBy()
    @Test
    @DisplayName("getMadeBy retourne l'utilisateur qui a créé la réservation")
    void Reservation_GetMadeBy_ReturnsCorrectUser() {
        User creator = new User(false);
        Reservation reservation = new Reservation(creator);

        User result = reservation.getMadeBy();

        assertSame(creator, result);
    }

    // Test pour canBeCancelledBy() - cas créateur
    @Test
    @DisplayName("canBeCancelledBy retourne TRUE si l'utilisateur est le créateur")
    void Reservation_CanBeCancelledBy_Creator_ReturnsTrue() {
        User creator = new User(false); // Pas admin
        Reservation reservation = new Reservation(creator);

        boolean result = reservation.canBeCancelledBy(creator);

        assertTrue(result, "Le créateur devrait pouvoir annuler sa propre réservation");
    }

    // Test pour canBeCancelledBy() - cas admin
    @Test
    @DisplayName("canBeCancelledBy retourne TRUE si l'utilisateur est admin")
    void Reservation_CanBeCancelledBy_Admin_ReturnsTrue() {
        User creator = new User(false);
        User admin = new User(true);
        Reservation reservation = new Reservation(creator);

        boolean result = reservation.canBeCancelledBy(admin);

        assertTrue(result, "Un admin devrait pouvoir annuler n'importe quelle réservation");
    }

    // Test pour canBeCancelledBy() - cas admin et créateur
    @Test
    @DisplayName("canBeCancelledBy retourne TRUE si l'utilisateur est admin ET créateur")
    void Reservation_CanBeCancelledBy_AdminAndCreator_ReturnsTrue() {
        User adminCreator = new User(true);
        Reservation reservation = new Reservation(adminCreator);

        boolean result = reservation.canBeCancelledBy(adminCreator);

        assertTrue(result, "Un admin qui est aussi créateur devrait pouvoir annuler");
    }

    // Test pour canBeCancelledBy() - cas autre utilisateur
    @Test
    @DisplayName("canBeCancelledBy retourne FALSE si l'utilisateur n'est ni admin ni créateur")
    void Reservation_CanBeCancelledBy_OtherUser_ReturnsFalse() {
        User creator = new User(false);
        User otherUser = new User(false);
        Reservation reservation = new Reservation(creator);

        boolean result = reservation.canBeCancelledBy(otherUser);

        assertFalse(result, "Un utilisateur lambda ne devrait pas pouvoir annuler la réservation d'un autre");
    }
}
