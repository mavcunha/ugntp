package info.growl.gntp.message;

import info.growl.Application;
import info.growl.Notification;
import info.growl.Notifications;
import org.junit.Before;
import org.junit.Test;

import static info.growl.gntp.Delimiter.*;
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
        assertThat(message.render(), is(equalTo(registerMessageBody(message))));
    }

    private String registerMessageBody(Message message) {
        return
                message.header() +
                application.toString() +
                "Notifications-Count: " + notifications.size() + EOL +
                EOL +
                notifications.toString() +
                EOM;
    }

    @Override
    Message getConcrete() {
        return new Register(application, notifications);
    }
}
