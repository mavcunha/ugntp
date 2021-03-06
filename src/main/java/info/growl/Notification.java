package info.growl;

import info.growl.gntp.Delimiter;

import java.net.URI;

public class Notification {

    private final String name;
    private boolean enabled = true;
    private String text = "";
    private URI icon;

    public Notification(String name) {
        if(name == null || name.isEmpty())
            throw new RuntimeException("Notification name cannot be empty or null");

        this.name = name;
    }

    public Notification(String name, boolean enable) {
        this(name);
        enabled = enable;
    }

    public Notification(String name, String text) {
        this(name);
        this.text = text;
    }

    public String name() {
        return "Notification-Name: " + this.name + Delimiter.EOL;
    }

    public String enabled() {
        return "Notification-Enabled: " + (enabled ? "True" : "False") + Delimiter.EOL;
    }

    public String title() {
        return "Notification-Title: " + this.name + Delimiter.EOL;
    }

    public String text() {
        return "Notification-Text: " + this.text + Delimiter.EOL;
    }

    public String icon() {
        if(this.icon != null)
            return "Notification-Icon: " + this.icon.toString() + Delimiter.EOL;
        return "";
    }

    public void icon(URI icon) {
        this.icon = icon;
    }
}
