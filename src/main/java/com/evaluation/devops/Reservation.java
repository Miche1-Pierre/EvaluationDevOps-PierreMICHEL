package com.evaluation.devops;

public class Reservation {

    private final User madeBy;

    public Reservation(User madeBy) {
        this.madeBy = madeBy;
    }

    public User getMadeBy() {
        return madeBy;
    }

    public boolean canBeCancelledBy(User user) {
        return user.isAdmin() || madeBy.equals(user);
    }
}
