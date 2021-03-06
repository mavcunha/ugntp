package info.growl.gntp.io;

import info.growl.gntp.message.OutgoingMessage;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.jboss.netty.util.CharsetUtil;

public class MessageEncoder extends OneToOneEncoder {
    @Override
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object o) throws Exception {
        return ChannelBuffers.wrappedBuffer(((OutgoingMessage) o).render().getBytes(CharsetUtil.UTF_8));
    }
}
