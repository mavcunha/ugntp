package info.growl.gntp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public abstract class MessageTest {

    abstract Message getConcrete();
    
    @Test
    public void shouldReturnUnencryptedHeader() {
        assertThat(getConcrete().header(), is(unencryptedHeader()));
    }

    private String unencryptedHeader() {
        return Protocol.GNTP_1_0.toString() + " " + getConcrete().type() + " NONE" + Delimiter.EOL;
    }
}
