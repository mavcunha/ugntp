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
    }

    @Test
    public void shouldSendMessage() {

        Application application     = new Application("my app");
        Notifications notifications = new Notifications(new Notification("my notification"));

        Client client = new Client(config, clientBootstrap);

        when(clientBootstrap.connect(any(SocketAddress.class))).thenReturn(channelFuture);
        when(channelFuture.isSuccess()).thenReturn(true);
        when(channelFuture.getChannel()).thenReturn(channel);

        client.register(application, notifications);
        
        verify(channel).write(argThat(registerMessageMatcher(application, notifications)));
    }

    private Matcher<Message> registerMessageMatcher(final Application application, final Notifications notifications) {
        return new ArgumentMatcher<Message>(){
            Message message = new RegisterMessage(application, notifications);
            @Override
            public boolean matches(Object o) {
                return message.render().equals(((Message)o).render());
            }
        };
    }

}
