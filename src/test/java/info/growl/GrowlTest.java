package info.growl;

import info.growl.gntp.Configuration;
import org.junit.Test;

public class GrowlTest {

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptNullAsApplication() {
        new Growl(null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptNullAsConfiguration() {
        new Growl(new Application("app"), null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptNullAsClient() {
        new Growl(new Application("app"), new Configuration(), null);
    }
}
