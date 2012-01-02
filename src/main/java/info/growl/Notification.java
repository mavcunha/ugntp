package info.growl;

import info.growl.gntp.Delimiter;

public class Notification {

    private final String name;
    private boolean enabled = true;

    public Notification(String name) {
        if(name == null || name.isEmpty())
            throw new RuntimeException("Notification name cannot be empty or null");

        this.name = name;
    }

    public Notification(String name, boolean enable) {
        this(name);
        enabled = enable;
    }

    public String name() {
        return "Notification-Name: " + this.name + Delimiter.EOL;
    }

    public String enabled() {
        return "Notification-Enabled: " + (enabled ? "True" : "False") + Delimiter.EOL;
    }
}
