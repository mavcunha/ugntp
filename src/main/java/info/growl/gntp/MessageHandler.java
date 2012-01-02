package info.growl.gntp;

import org.jboss.netty.channel.*;

public class MessageHandler extends SimpleChannelHandler {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        System.out.println("e = " + e);
        System.out.println("ctx = " + ctx);
    }
}
