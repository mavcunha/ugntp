package info.growl.gntp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConfigurationTest {

    @Test
    public void shouldHaveDefaultPortNumber() {
        assertThat(new Configuration().port(), is(Configuration.DEFAULT_PORT));
    }

    @Test
    public void shouldAcceptANewPortNumber() {
        Configuration configuration = new Configuration("new-hostname",1010);
        assertThat(configuration.port(), is(1010));
    }

    @Test
    public void shouldHaveDefaultHost() {
        assertThat(new Configuration().host(), is(Configuration.DEFAULT_HOSTNAME));
    }

    @Test
    public void shouldAcceptANewHost() {
        Configuration configuration = new Configuration("new-hostname");
        assertThat(configuration.host(), is("new-hostname"));
    }
}
