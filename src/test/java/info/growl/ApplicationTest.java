package info.growl;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static info.growl.gntp.Delimiter.EOL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationTest {
    
    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptANullName() {
        new Application(null);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptAnEmptyName() {
        new Application("");
    }

    @Test
    public void shouldReturnNameGNTPFormatted() {
        Application application = new Application("My Application");
        assertThat(application.name(), is(equalTo("Application-Name: My Application" + EOL)));
    }

    @Test
    public void shouldReturnIconURLInformation() throws URISyntaxException {
        Application application = new Application("My Application");
        application.icon(new URI("file:///tmp/icon.png"));
        assertThat(application.icon(), is(equalTo("Application-Icon: file:///tmp/icon.png" + EOL)));
    }
}
