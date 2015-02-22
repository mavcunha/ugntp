package info.growl.gntp.message;

import info.growl.gntp.Delimiter;

public class NotificationCallback {

    private final String context;
    private final String type;

    public NotificationCallback(String context, String type) {
        this.context = context;
        this.type = type;
    }

    public String context() {
        return String.format("Notification-Callback-Context: %s%s", this.context, Delimiter.EOL);
    }
}
