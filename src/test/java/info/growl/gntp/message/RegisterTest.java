package info.growl.gntp.message;

import info.growl.Application;
import info.growl.Notification;
import info.growl.Notifications;
import org.junit.Before;
import org.junit.Test;

import static info.growl.gntp.Delimiter.EOL;
import static info.growl.gntp.Delimiter.EOM;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegisterTest extends MessageTest {

    private Application application;
    private Notifications notifications;

    @Before
    public void setUp() {
        application = new Application("My Application");
        notifications = new Notifications(
                new Notification("1 notification"),
                new Notification("2 notification")
        );
    }

    @Test
    public void shouldReturnItSelfFormatted() {
        Message message = new Register(application, notifications);
        assertThat(message.render(), is(equalTo(registerMessageAsString(message))));
    }

    private String registerMessageAsString(Message message) {
        return
            message.header() +
            "Application-Name: My Application" + EOL +
            "Notifications-Count: 2" + EOL +
            EOL +
            "Notification-Name: 1 notification" + EOL +
            "Notification-Enabled: True" + EOL +
            EOL +
            "Notification-Name: 2 notification" + EOL +
            "Notification-Enabled: True" + EOL +
            EOM;
    }

    @Override
    Message getConcrete() {
        return new Register(application, notifications);
    }
}
