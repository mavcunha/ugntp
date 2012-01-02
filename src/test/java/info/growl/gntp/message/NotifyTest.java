package info.growl.gntp.message;

import info.growl.Application;
import info.growl.Notification;
import info.growl.gntp.Delimiter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NotifyTest extends MessageTest {

    private Application application;
    private Notification notification;

    @Test
    public void shouldRenderAsGNTPFormatted() {
        Notify notifyMessage = new Notify(application, notification);
        assertThat(notifyMessage.render(), is(
                notifyMessage.header() +
                        application.name() +
                        notification.name() +
                        notification.title() + Delimiter.EOM
        ));
    }

    @Before
    public void setUp() {
        application = new Application("my application");
        notification = new Notification("my notification");
    }

    @Override
    Message getConcrete() {
        return new Notify(application, notification);
    }
}
