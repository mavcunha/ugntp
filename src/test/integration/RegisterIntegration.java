import info.growl.Application;
import info.growl.Growl;
import info.growl.Notification;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RegisterIntegration {

    @Test
    public void shouldRegisterApplication() {
        Application application = new Application("My Application");

        Notification notification = new Notification("My Notification");

        Growl growl = new Growl(application);

        growl.register(notification);

        assertThat(new Growl(application).isRegistered(), is(true));
    }

}