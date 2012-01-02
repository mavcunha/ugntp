package info.growl.gntp;

import info.growl.Application;
import info.growl.Notification;
import info.growl.Notifications;
import org.junit.Test;

import static info.growl.gntp.Delimiter.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegisterMessageTest {

    @Test
    public void shouldReturnItSelfFormatted() {
        Application application = new Application("My Application");
        Notifications notifications = new Notifications(
                new Notification("1 notification"),
                new Notification("2 notification")
        );

        RegisterMessage registerMessage = new RegisterMessage(application, notifications);

        assertThat(registerMessage.toString(), is(equalTo(registerMessageBody())));
    }

    private String registerMessageBody() {
        return
                "Application-Name: My Application" + EOL +
                "Notifications-Count: 2" + EOL +
                EOL +
                "Notification-Name: 1 notification" + EOL +
                EOL +
                "Notification-Name: 2 notification" + EOL +
                EOM;
    }
}
