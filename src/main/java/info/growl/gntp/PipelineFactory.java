package info.growl.gntp;

import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.util.CharsetUtil;

public class PipelineFactory implements ChannelPipelineFactory {

    private final MessageHandler messageHandler;

    public PipelineFactory(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Override
    public ChannelPipeline getPipeline() {
        ChannelPipeline pipeline = Channels.pipeline();
        pipeline.addLast("frame-decoder", new DelimiterBasedFrameDecoder(Integer.MAX_VALUE,
                ChannelBuffers.wrappedBuffer(Delimiter.EOM.toString().getBytes())));
        pipeline.addLast("message-decoder", new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast("message-encoder", new MessageEncoder());
        pipeline.addLast("handler", messageHandler);
        return pipeline;
    }
}