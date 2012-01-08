package info.growl.gntp.message;

import info.growl.Application;
import info.growl.Notification;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static info.growl.gntp.Delimiter.EOL;
import static info.growl.gntp.Delimiter.EOM;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class NotifyTest extends OutgoingMessageTest {

    private Application application;
    private Notification notification;

    @Before
    public void setUp() {
        application = new Application("my application");
        notification = new Notification("my notification","my notification text");
    }

    @Test
    public void shouldRenderAsGNTPFormatted() {
        Notify notifyMessage = new Notify(application, notification);
        assertThat(notifyMessage.render(), is(notifyMessageAsString(notifyMessage)));
    }

    private String notifyMessageAsString(Notify message) {
        return
            message.header() +
            "Application-Name: my application" + EOL +
            "Notification-Name: my notification" + EOL +
            "Notification-Title: my notification" + EOL + 
            "Notification-Text: my notification text" + EOL + EOM;
    }

    @Test
    public void shouldSendNotificationIconIfDefined() throws URISyntaxException {
        Notification notif = new Notification("notification");
        notif.icon(new URI("file:///some-icon.png"));
        Notify message = new Notify(new Application("app"), notif);
        assertTrue(message.render().contains("Notification-Icon: file:///some-icon.png"));
    }

    @Override
    OutgoingMessage getConcrete() {
        return new Notify(application, notification);
    }
}
