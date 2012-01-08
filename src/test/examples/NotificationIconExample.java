import info.growl.Application;
import info.growl.Growl;
import info.growl.Notification;
import info.growl.Notifications;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class NotificationIconExample {
    @Test
    public void showsDifferentIconsForNotifications() throws URISyntaxException {
        Application application = new Application("My Application");
        application.icon(uriForIcon("app-icon.png"));
        
        Notification ok = new Notification("Special Ok Icon", "This notification has an ok icon");
        ok.icon(uriForIcon("ok-icon.png"));

        Notification error = new Notification("Special Error Icon", "This notification has an error icon");
        error.icon(uriForIcon("bell-icon.png"));

        Notifications notifications = new Notifications(ok, error);

        Growl growl = new Growl(application);
        growl.register(notifications);
        
        growl.notify(ok);
        growl.notify(error);
    }

    private URI uriForIcon(String icon) throws URISyntaxException {
        return new URI("file://" + System.getProperty("user.dir") + "/src/test/resources/" + icon);
    }
}
