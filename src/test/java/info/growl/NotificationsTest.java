package info.growl;

import info.growl.gntp.Delimiter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NotificationsTest {
    
    @Test
    public void shouldReportZeroNotificationsWhenCreated() {
        assertThat(new Notifications().size(), is(0));
    }
    
    @Test
    public void shouldReportTheNumberOfNotificationsItHolds() {
        Notifications notifications = new Notifications();
        notifications.add(new Notification("my notification"));
        assertThat(notifications.size(), is(1));
        notifications.add(new Notification("another notification"));
        assertThat(notifications.size(), is(2));
    }

    @Test
    public void shouldAcceptNotificationsOnConstructor() {
        assertThat(new Notifications(new Notification("1")).size(), is(1));
        assertThat(new Notifications(new Notification("1"), new Notification("2")).size(), is(2));
    }

    @Test
    public void shouldReturnItsCollectionGNTPFormatted() {
        Notification first = new Notification("first");
        Notification second = new Notification("second");

        Notifications notifications = new Notifications(first,second);
        assertThat(notifications.toString(), is(equalTo(
                first.name() + first.enabled() + Delimiter.EOL +
                second.name() + second.enabled()
        )));
    }
}
