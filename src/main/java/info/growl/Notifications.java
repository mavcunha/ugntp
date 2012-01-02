package info.growl;

import com.google.common.base.Joiner;
import info.growl.gntp.Delimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Notifications {

    private final List<Notification> notifications = new ArrayList<Notification>();

    public Notifications(Notification... notifications) {
        this.notifications.addAll(Arrays.asList(notifications));
    }

    public Notifications add(Notification notification) {
        this.notifications.add(notification);
        return this;
    }

    public int size() {
        return this.notifications.size();
    }

    @Override
    public String toString() {
        return Joiner.on(Delimiter.EOL.toString()).join(notifications);
    }
}
