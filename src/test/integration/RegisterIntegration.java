import info.growl.Application;
import info.growl.Growl;
import info.growl.Notification;
import info.growl.Notifications;
import info.growl.gntp.Configuration;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RegisterIntegration {

    @Test
    public void shouldRegisterApplication() {

        Application application = new Application("My Application");
        Notifications nots = new Notifications(new Notification("My Notification"));

        Growl growl = new Growl(application, new Configuration(Configuration.DEFAULT_HOSTNAME, 6666));

        growl.register(nots);

        assertThat(new Growl(application).isRegistered(), is(true));
    }

}