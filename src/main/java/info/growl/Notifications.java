package info.growl;

import info.growl.gntp.Delimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Notifications {

    private final List<Notification> notifications = new ArrayList<Notification>();

    public Notifications(Notification... notifications) {
        this.notifications.addAll(Arrays.asList(notifications));
    }

    public void add(Notification notification) {
        this.notifications.add(notification);
    }

    public int size() {
        return this.notifications.size();
    }

    @Override
    public String toString() {
        String response = "";
        for (Iterator<Notification> iterator = notifications.iterator(); iterator.hasNext(); ) {
            Notification notification = iterator.next();
            response += registerInfo(notification);
            if(iterator.hasNext())
                response += Delimiter.EOL;
        }
        return response;
    }

    private String registerInfo(Notification notification) {
        return notification.name() + notification.enabled();
    }

    public void clear() {
        this.notifications.clear();
    }
}
