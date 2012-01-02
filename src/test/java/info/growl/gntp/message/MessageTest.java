package info.growl.gntp.message;

import info.growl.gntp.Delimiter;
import info.growl.gntp.Protocol;
import info.growl.gntp.message.Message;
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
