package info.growl.gntp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProtocolTest {
    @Test
    public void protocolVersion1_0() {
        assertThat(Protocol.GNTP_1_0.toString(), is("GNTP/1.0"));
    }
}
