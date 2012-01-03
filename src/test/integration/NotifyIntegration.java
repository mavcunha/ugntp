import info.growl.Application;
import info.growl.Growl;
import info.growl.Notification;
import info.growl.Notifications;
import org.junit.Test;

public class NotifyIntegration {
    @Test
    public void shouldRegisterAndNotify() {
        Application application = new Application("My Application");
        Notification notification = new Notification("My Notification");
        Notifications notifications = new Notifications(notification);

        Growl growl = new Growl(application);
        growl.register(notifications);
        growl.notify(notification);
    }
}
