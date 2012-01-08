package info.growl.gntp.io;

import info.growl.gntp.message.Response;
import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class MessageHandler extends SimpleChannelHandler {

    private final Logger logger;
    private Response response;

    public MessageHandler(Logger logger) {
        this.logger = logger;
    }

    public MessageHandler() {
        this(Logger.getLogger(MessageHandler.class));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        logger.error("An error occurred:", e.getCause());
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        response = (Response) e.getMessage();
        logger.info("Message Received: " + response);
    }

    public Response response() {
        return response;
    }
}
