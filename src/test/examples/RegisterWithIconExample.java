import info.growl.Application;
import info.growl.Growl;
import info.growl.Notification;
import info.growl.Notifications;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class RegisterWithIconExample {
    @Test
    public void shouldRegisterApplicationWithIcon() throws URISyntaxException {
        Application application = new Application("My Application");
        application.icon(new URI(applicationIconPath()));

        Notification notification = new Notification("Show shiny icon", "Can you see your shiny icon?");
        Notifications notifications = new Notifications(notification);

        Growl growl = new Growl(application);
        growl.register(notifications);

        growl.notify(notification);
    }

    private String applicationIconPath() {
        return "file://" + System.getProperty("user.dir") + "/src/test/resources/app-icon.png";
    }
}
