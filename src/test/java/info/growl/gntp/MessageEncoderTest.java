package info.growl.gntp;

import info.growl.Application;
import info.growl.Notification;
import info.growl.Notifications;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.util.CharsetUtil;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class MessageEncoderTest {

    private Channel channel;

    @Before
    public void setUp() {
        channel = mock(Channel.class);
    }

    @Test
    public void shouldWriteIntoChannelAMessageAsBytes() throws Exception {
        MessageEncoder encoder = new MessageEncoder();

        RegisterMessage registerMessage = new RegisterMessage(
                new Application("my app"),
                new Notifications(new Notification("notification")));

        ChannelBuffer actualEncode = (ChannelBuffer) encoder.encode(null, channel, registerMessage);

        assertThat(actualEncode.array(), is(registerMessage.toString().getBytes(CharsetUtil.UTF_8)));
    }
}
