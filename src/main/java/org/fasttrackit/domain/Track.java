package org.fasttrackit.domain;

public class Track {

    private String name;
    private int lenght;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", lenght=" + lenght +
                '}';
    }
}
