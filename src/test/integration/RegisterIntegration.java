import info.growl.Application;
import info.growl.Growl;
import info.growl.Notification;
import info.growl.Notifications;
import org.junit.Test;


public class RegisterIntegration {

    @Test
    public void shouldRegisterApplication() {
        Application application = new Application("My Application");
        Notifications notifications = new Notifications(new Notification("My Notification"));

        new Growl(application).register(notifications);
    }

}