import info.growl.Application;
import info.growl.Growl;
import info.growl.Notification;
import info.growl.Notifications;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RegisterIntegration {

    @Test
    public void shouldRegisterApplication() {

        Application application = new Application("My Application");
        Notifications nots = new Notifications(new Notification("My Notification"));

        Growl growl = new Growl(application);

        growl.register(nots);

        assertThat(new Growl(application).isRegistered(), is(true));
    }

}