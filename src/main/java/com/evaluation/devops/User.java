package com.evaluation.devops;

import java.util.Objects;

public class User {

    private static int nextId = 0;
    private final int id;
    private boolean isAdmin;

    public User() {
        this.id = nextId++;
        this.isAdmin = false;
    }

    public User(boolean isAdmin) {
        this.id = nextId++;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
