package info.growl.gntp;

import info.growl.Application;
import info.growl.Notification;
import info.growl.Notifications;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFuture;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

public class GNTPClient {

    private final SocketAddress socketAddress;
    private final ClientBootstrap bootstrap;

    public GNTPClient(Configuration configuration, ClientBootstrap bootstrap) {
        this.bootstrap = bootstrap;
        this.socketAddress = new InetSocketAddress(configuration.host(), configuration.port());
    }

    public void register(Application application, Notifications notifications) {
        send(new RegisterMessage(application, notifications));
    }

    private void send(Message message) {
        ChannelFuture channelFuture = bootstrap.connect(socketAddress);
        channelFuture.awaitUninterruptibly(2, TimeUnit.SECONDS);
        if (channelFuture.isSuccess()) {
            channelFuture.getChannel().write(message);
        } else {
            channelFuture.getCause().printStackTrace();
        }
    }

    public void notify(Application application, Notification notification) {
        send(new NotifyMessage(application, notification));
    }
}
