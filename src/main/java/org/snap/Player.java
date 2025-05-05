package org.snap;

public class Player {

    private String name;
    private boolean isComputer = false;
    private int score = 0;

    public Player(){};

    public Player(String name, boolean isComputer) {
        setName(name);
        this.isComputer = isComputer;
    }

    public String getName() {
        return name;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void incrementScore(){
        score++;
    }
}
