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
        return this.name;
    }

    @Override
    public String toString() {
        return "Notification-Name: " + this.name + Delimiter.EOL +
               "Notification-Enabled: " + (enabled ? "True" : "False") + Delimiter.EOL;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
