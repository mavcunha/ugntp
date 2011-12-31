package info.growl;

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
}
