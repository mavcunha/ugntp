package info.growl.gntp;

import info.growl.Application;
import info.growl.Notifications;

import static info.growl.gntp.Delimiter.*;

public class RegisterMessage extends Message {

    private static final String MESSAGE_TYPE = "REGISTER";
    private final Application application;
    private final Notifications notifications;

    public RegisterMessage(Application application, Notifications notifications) {
        this.application = application;
        this.notifications = notifications;
    }

    @Override
    public String render() {
        return
            header() +
            this.application.toString() +
            "Notifications-Count: " + this.notifications.size() + EOL +
            EOL +
            this.notifications.toString() +
            EOM;
    }

    @Override
    public String type() {
        return MESSAGE_TYPE;
    }
}
