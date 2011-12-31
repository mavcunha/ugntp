package info.growl;

import org.junit.Test;

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
}
