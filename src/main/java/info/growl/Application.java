package info.growl;

import info.growl.gntp.Delimiter;

import java.net.URI;

public class Application {

    private final String name;
    private URI iconURL;

    public Application(String name) {
        if(name == null || name.isEmpty())
            throw new RuntimeException("Application name must be not null or empty.");
        this.name = name;
    }

    public String name() {
        return "Application-Name: " + this.name + Delimiter.EOL;
    }

    public void icon(URI icon) {
        this.iconURL = icon;
    }

    public String icon() {
        if (this.iconURL != null) {
            return "Application-Icon: " + this.iconURL.toASCIIString() + Delimiter.EOL;
        } else {
            return "";
        }
    }
}
