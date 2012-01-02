package info.growl.gntp;

import info.growl.Application;
import info.growl.Notifications;

import static info.growl.gntp.Delimiter.*;

public class RegisterMessage {

    private final Application application;
    private final Notifications notifications;

    public RegisterMessage(Application application, Notifications notifications) {
        this.application = application;
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return
            this.application.toString() +
            "Notifications-Count: " + this.notifications.size() + EOL +
            EOL +
            this.notifications.toString() +
            EOM;
    }
}
