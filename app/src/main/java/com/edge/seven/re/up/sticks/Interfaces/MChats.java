package com.edge.seven.re.up.sticks.Interfaces;

public class MChats {
    public String message;
    public String name;
    public String location;
    public int time;

    public MChats(String message, String name, String location, int time) {
        this.message = message;
        this.name = name;
        this.location = location;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
