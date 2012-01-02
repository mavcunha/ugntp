package info.growl;

import info.growl.gntp.GNTPClient;
import info.growl.gntp.Configuration;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GrowlTest {

    private GNTPClient client;

    @Before
    public void setUp() {
        client = mock(GNTPClient.class);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptNullAsApplication() {
        new Growl(null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptNullAsConfiguration() {
        new Growl(new Application("app"), null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptNullAsClient() {
        new Growl(new Application("app"), new Configuration(), null);
    }

    @Test
    public void shouldCallRegisterOnClient() {
        Application app = new Application("app");
        Notifications notifications = new Notifications(new Notification("my notification"));

        Growl growl = new Growl(app, new Configuration(), client);
        growl.register(notifications);

        verify(client).register(app, notifications);
    }

    @Test
    public void shouldCallNotifyOnClient() {
        Application app = new Application("app");
        Notification notification = new Notification("my notification");

        Growl growl = new Growl(app, new Configuration(), client);
        growl.notify(notification);
        
        verify(client).notify(app,notification);
    }
}
