package info.growl;

import info.growl.gntp.Delimiter;
import org.junit.Test;

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
        assertThat(application.name(), is(equalTo("Application-Name: My Application" + Delimiter.EOL)));
    }
}
