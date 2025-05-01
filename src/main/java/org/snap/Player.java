package org.snap;

public class Player {

    private String name;
    private boolean isComputer = false;

    public Player(){};

    public Player(String name, boolean isComputer) {
        setName(name);
        this.isComputer = isComputer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Player name must not be empty");
        }

        this.name = name;
    }
}
