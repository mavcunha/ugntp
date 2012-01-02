package info.growl.gntp;

import info.growl.Application;
import info.growl.Configuration;
import info.growl.Notification;
import info.growl.Notifications;
import info.growl.gntp.message.Message;
import info.growl.gntp.message.Notify;
import info.growl.gntp.message.Register;
import org.hamcrest.Matcher;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

import java.net.SocketAddress;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

public class GNTPClientTest {

    private ClientBootstrap clientBootstrap;
    private Configuration config;
    private Channel channel;
    private ChannelFuture channelFuture;

    @Before
    public void setUp() {
        this.channel = mock(Channel.class);
        this.clientBootstrap = mock(ClientBootstrap.class);
        this.channelFuture = mock(ChannelFuture.class);
        this.config = new Configuration();

        when(clientBootstrap.connect(any(SocketAddress.class))).thenReturn(channelFuture);
        when(channelFuture.isSuccess()).thenReturn(true);
        when(channelFuture.getChannel()).thenReturn(channel);
    }

    @Test
    public void shouldSendMessage() {
        Application application = new Application("my app");
        Notifications notifications = new Notifications(new Notification("my notification"));

        GNTPClient client = new GNTPClient(config, clientBootstrap);

        client.register(application, notifications);

        Message registerMessage = new Register(application, notifications);
        verify(channel).write(argThat(messageMatcher(registerMessage)));
    }

    @Test
    public void shouldSendNotifyMessage() {
        Application application = new Application("my app");
        Notification notification = new Notification("my notification");

        GNTPClient client = new GNTPClient(config, clientBootstrap);
        
        client.notify(application, notification);

        Notify notifyMessage = new Notify(application, notification);
        verify(channel).write(argThat(messageMatcher(notifyMessage)));
    }

    @Test
    public void shouldGetCauseIfCannotConnect() {
        when(channelFuture.isSuccess()).thenReturn(false);
        when(channelFuture.getCause()).thenReturn(new RuntimeException());

        GNTPClient client = new GNTPClient(config, clientBootstrap);
        client.notify(new Application("app"), new Notification("notification"));

        verify(channelFuture).getCause();
    }

    private Matcher<Message> messageMatcher(final Message message) {
        return new ArgumentMatcher<Message>(){
            @Override
            public boolean matches(Object o) {
                return message.render().equals(((Message)o).render());
            }
        };
    }
}
