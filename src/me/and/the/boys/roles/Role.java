package me.and.the.boys.roles;

import java.util.Objects;

public abstract class Role implements Comparable<Role>{

    private String name;
    private String description;
    private int points;
    private int priority;
    private boolean isRecurring;
    private boolean hasTurns;

    public Role(String name, String description, int points, int priority, boolean isRecurring, boolean hasTurns) {
        this.name = name;
        this.description = description;
        this.points = points;
        this.priority = priority;
        this.isRecurring = isRecurring;
        this.hasTurns = hasTurns;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Role o) {
        return Integer.compare(this.priority, o.getPriority());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return priority == role.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority);
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public boolean isHasTurns() {
        return hasTurns;
    }

    public void setHasTurns(boolean hasTurns) {
        this.hasTurns = hasTurns;
    }
}
