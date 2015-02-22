package info.growl.gntp.message;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NotificationCallbackTest {
    @Test
    public void shouldHaveContext() {
        NotificationCallback callback = new NotificationCallback("Some Context", null);
        assertTrue(callback.context().contains("Notification-Callback-Context: Some Context"));
    }
}
