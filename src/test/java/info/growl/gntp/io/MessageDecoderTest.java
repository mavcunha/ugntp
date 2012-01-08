package info.growl.gntp.io;

import info.growl.gntp.message.ErrorResponse;
import info.growl.gntp.message.OkResponse;
import org.jboss.netty.buffer.ChannelBuffer;
import org.junit.Before;
import org.junit.Test;

import static info.growl.gntp.Delimiter.EOL;
import static info.growl.gntp.Delimiter.EOM;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MessageDecoderTest {

    private ChannelBuffer buffer;

    @Before
    public void setUp() {
        buffer = mock(ChannelBuffer.class);
    }

    @Test
    public void shouldReturnAnErrorMessageIfHeaderIsError() throws Exception {
        MessageDecoder decoder = new MessageDecoder();

        String receivedMessage = "GNTP/1.0 -ERROR" + EOL + "More Information" + EOM;

        when(buffer.array()).thenReturn(receivedMessage.getBytes());

        assertThat(decoder.decode(null, null, buffer), is(instanceOf(ErrorResponse.class)));
    }

    @Test
    public void shouldReturnAnErrorMessageIfHeaderIsUnknown() throws Exception {
        MessageDecoder decoder = new MessageDecoder();
        
        String receivedHeader = "GNTP/1.0 -NOTDEFINED" + EOL + "More Information" + EOM;

        when(buffer.array()).thenReturn(receivedHeader.getBytes());

        assertThat(decoder.decode(null, null, buffer), is(instanceOf(ErrorResponse.class)));
    }

    @Test
    public void shouldReturnOkMessageIfHeaderIsOk() throws Exception {
        MessageDecoder decoder = new MessageDecoder();

        String receivedHeader = "GNTP/1.0 -OK" + EOL + "More Information" + EOM;

        when(buffer.array()).thenReturn(receivedHeader.getBytes());

        assertThat(decoder.decode(null, null, buffer), is(instanceOf(OkResponse.class)));
    }
}
