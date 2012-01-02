package info.growl;

import info.growl.gntp.Delimiter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NotificationTest {

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptANullName() {
        new Notification(null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptAEmptyName() {
        new Notification("");
    }

    @Test
    public void shouldReturnItsNameGNTPFormatted() {
        Notification notification = new Notification("My Notification");
        assertThat(notification.name(), is(equalTo("Notification-Name: My Notification" + Delimiter.EOL)));
    }

    @Test
    public void shouldNotificationTitleDefaultToItsName() {
        Notification notification = new Notification("My Notification");
        assertThat(notification.title(), is("Notification-Title: My Notification" + Delimiter.EOL));
    }

    @Test
    public void newNotificationIsEnableByDefault() {
        Notification notification = new Notification("My Notification");
        assertThat(notification.enabled(), is("Notification-Enabled: True" + Delimiter.EOL));
    }

    @Test
    public void notificationCanBeCreatedDisabled() {
        Notification notification = new Notification("My Notification", false);
        assertThat(notification.enabled(), is("Notification-Enabled: False" + Delimiter.EOL));
    }
}
