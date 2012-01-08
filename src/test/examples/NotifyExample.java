import info.growl.Application;
import info.growl.Growl;
import info.growl.Notification;
import info.growl.Notifications;
import org.junit.Test;

public class NotifyExample {
    @Test
    public void shouldRegisterAndNotify() throws InterruptedException {
        Application application = new Application("My Application");
        Notification notification = new Notification("My Notification","My Notification Text");
        Notifications notifications = new Notifications(notification);

        Growl growl = new Growl(application);
        growl.register(notifications);
        growl.notify(notification);
        
        Thread.sleep(2000);
    }
}
