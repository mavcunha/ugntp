package info.growl;

import info.growl.gntp.Delimiter;

public class Application {

    private final String name;

    public Application(String name) {
        if(name == null || name.isEmpty())
            throw new RuntimeException("Application name must be not null or empty.");
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Application-Name: " + this.name + Delimiter.EOL;
    }
}
