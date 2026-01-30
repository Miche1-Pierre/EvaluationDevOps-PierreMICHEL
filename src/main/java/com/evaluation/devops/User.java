package com.evaluation.devops;

import java.util.Objects;

public class User {

    private boolean isAdmin;

    public User() {
        this.isAdmin = false;
    }

    public User(boolean isAdmin) {
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
        return isAdmin == user.isAdmin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAdmin);
    }
}
