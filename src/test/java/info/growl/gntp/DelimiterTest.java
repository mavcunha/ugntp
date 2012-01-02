package info.growl.gntp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DelimiterTest {

    @Test
    public void eolShouldBeCRLF() {
        assertThat(Delimiter.EOL.toString(), is("\r\n"));
    }

    @Test
    public void eomShouldBeCRLFCRLF() {
        assertThat(Delimiter.EOM.toString(), is("\r\n\r\n"));
    }
}
