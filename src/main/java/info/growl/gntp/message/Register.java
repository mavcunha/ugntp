package info.growl.gntp.message;

import info.growl.Application;
import info.growl.Notifications;

import static info.growl.gntp.Delimiter.EOL;
import static info.growl.gntp.Delimiter.EOM;

public class Register extends Message {

    private static final String MESSAGE_TYPE = "REGISTER";
    private final Application application;
    private final Notifications notifications;

    public Register(Application application, Notifications notifications) {
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
