package info.growl;

import info.growl.gntp.Delimiter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NotificationTest {

    @Test
    public void shouldHaveAName() {
        Notification notification = new Notification("a notification");
        assertThat(notification.name(), is("a notification"));
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptANullName() {
        new Notification(null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptAEmptyName() {
        new Notification("");
    }

    @Test
    public void shouldReturnItSelfGNTPFormatted() {
        Notification notification = new Notification("My Notification");
        assertThat(notification.toString(), is(equalTo(
                "Notification-Name: My Notification" + Delimiter.EOL +
                "Notification-Enabled: True" + Delimiter.EOL
        )));
    }

    @Test
    public void newNotificationIsEnableByDefault() {
        Notification notification = new Notification("My Notification");
        assertThat(notification.isEnabled(), is(true));
    }

    @Test
    public void notificationCanBeCreatedDisabled() {
        Notification notification = new Notification("My Notification", false);
        assertThat(notification.isEnabled(), is(false));
    }
}
