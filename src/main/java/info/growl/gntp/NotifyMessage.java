package info.growl.gntp;

import info.growl.Application;
import info.growl.Notification;

public class NotifyMessage extends Message {

    private final Application application;
    private final Notification notification;

    public NotifyMessage(Application application, Notification notification) {
        this.application = application;
        this.notification = notification;
    }

    @Override
    public String render() {
        return header() +
                application.name() +
                notification.name() +
                notification.title() + Delimiter.EOM;
    }

    @Override
    public String type() {
        return "NOTIFY";
    }
}
