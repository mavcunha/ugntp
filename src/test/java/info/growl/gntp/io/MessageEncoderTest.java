package info.growl.gntp.io;

import info.growl.Application;
import info.growl.Notification;
import info.growl.Notifications;
import info.growl.gntp.message.Message;
import info.growl.gntp.message.Register;
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

        Message message = new Register(
                new Application("my app"),
                new Notifications(new Notification("notification")));

        ChannelBuffer actualEncode = (ChannelBuffer) encoder.encode(null, channel, message);

        assertThat(actualEncode.array(), is(message.render().getBytes(CharsetUtil.UTF_8)));
    }
}
