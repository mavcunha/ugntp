package info.growl;

import org.junit.Test;

import static info.growl.gntp.Delimiter.EOL;
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
        assertThat(notifications.toString(), is(equalTo(notificationsListAsString())));
    }

    @Test
    public void shouldEmptyListOfNotificationsIfClearIsCalled() {
        Notification n1 = new Notification("1");
        Notification n2 = new Notification("2");
        Notifications notifications = new Notifications(n1, n2);
        assertThat(notifications.size(), is(2));
        notifications.clear();
        assertThat(notifications.size(), is(0));
    }

    private String notificationsListAsString() {
        return
        "Notification-Name: first" + EOL +
        "Notification-Enabled: True" + EOL +
        EOL +
        "Notification-Name: second" + EOL +
        "Notification-Enabled: True" + EOL;
    }
}
