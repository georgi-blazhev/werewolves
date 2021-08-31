package me.and.the.boys.players;

import me.and.the.boys.roles.Role;

public class Player implements Comparable<Player> {
    private Role role;
    private String name;
    private boolean isAlive;

    public Player(String name, Role role) {
        this.role = role;
        this.name = name;
        this.isAlive = true;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public int compareTo(Player o) {
        return role.compareTo(o.getRole());
    }

    public Role getRole() {
        return this.role;
    }

    @Override
    public String toString() {
        return "Player{" +
                "role=" + role +
                ", name='" + name + '\'' +
                ", isAlive=" + isAlive +
                '}';
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
