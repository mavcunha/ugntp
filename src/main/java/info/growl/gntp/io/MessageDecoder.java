package info.growl.gntp.io;

import info.growl.gntp.Delimiter;
import info.growl.gntp.Protocol;
import info.growl.gntp.message.ErrorResponse;
import info.growl.gntp.message.OkResponse;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.jboss.netty.util.CharsetUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageDecoder extends OneToOneDecoder {

    @Override
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object o) throws Exception {
        String message = new String(((ChannelBuffer) o).array(), CharsetUtil.UTF_8);

        return buildMessage(new ArrayList<String>(
                Arrays.asList(
                        message.split(Delimiter.EOL.toString())
                )
        ));
    }

    private Object buildMessage(List<String> strings) {
        String header = strings.remove(0);
        if (header.matches("^" + Protocol.GNTP_1_0 + "\\s-OK.*")) {
            return new OkResponse(strings);
        } else {
            return new ErrorResponse(strings);
        }
    }
}
