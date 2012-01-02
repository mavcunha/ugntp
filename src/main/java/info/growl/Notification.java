package info.growl;

import info.growl.gntp.Delimiter;

public class Notification {

    private final String name;

    public Notification(String name) {
        if(name == null || name.isEmpty())
            throw new RuntimeException("Notification name cannot be empty or null");

        this.name = name;
    }

    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Notification-Name: " + this.name + Delimiter.EOL;
    }
}
