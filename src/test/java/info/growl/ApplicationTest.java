package info.growl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationTest {
    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptANullName() {
        new Application(null);
    }

    @Test
    public void shouldHaveAName() {
        Application application = new Application("my application");
        assertThat(application.name(), is("my application"));
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotAcceptAnEmptyName() {
        new Application("");
    }
}
