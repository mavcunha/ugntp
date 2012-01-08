package info.growl.gntp.message;

import info.growl.Application;
import info.growl.Notification;
import info.growl.gntp.Delimiter;

public class Notify extends OutgoingMessage {

    private final Application application;
    private final Notification notification;

    public Notify(Application application, Notification notification) {
        this.application = application;
        this.notification = notification;
    }

    @Override
    public String render() {
        return header() +
                application.name() +
                notification.name() +
                notification.title() +
                notification.text() + Delimiter.EOM;
    }

    @Override
    public String type() {
        return "NOTIFY";
    }
}
