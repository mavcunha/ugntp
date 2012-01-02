package info.growl.gntp;

import info.growl.Application;
import info.growl.Notification;
import info.growl.Notifications;
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

public class ClientTest {

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

        Client client = new Client(config, clientBootstrap);

        client.register(application, notifications);

        Message registerMessage = new RegisterMessage(application, notifications);
        verify(channel).write(argThat(messageMatcher(registerMessage)));
    }

    @Test
    public void shouldSendNotifyMessage() {
        Application application = new Application("my app");
        Notification notification = new Notification("my notification");

        Client client = new Client(config, clientBootstrap);
        
        client.notify(application, notification);

        NotifyMessage notifyMessage = new NotifyMessage(application, notification);
        verify(channel).write(argThat(messageMatcher(notifyMessage)));
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
