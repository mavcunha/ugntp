package info.growl;

import info.growl.gntp.*;
import info.growl.gntp.io.MessageHandler;
import info.growl.gntp.io.PipelineFactory;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.util.concurrent.Executors;

public class Growl {

    private Configuration config = new Configuration();
    private GNTPClient client;
    private final Application application;

    public Growl(Application application) {
        if(application == null)
            throw new RuntimeException("Application must be not null.");
        this.application = application;
    }

    public Growl(Application application, Configuration configuration) {
        this(application);
        if(configuration == null)
            throw new RuntimeException("Configuration must be not null");
        this.config = configuration;
    }
    
    public Growl(Application application, Configuration configuration, GNTPClient gntpClient) {
        this(application, configuration);
        if(gntpClient == null)
            throw new RuntimeException("GNTPClient must be not null");
        this.client = gntpClient;
    }

    public void register(Notifications notifications) {
        client().register(application, notifications);
    }

    private GNTPClient client() {
        if(this.client == null)
            this.client = new GNTPClient(config, bootstrapFromDefaults());
        return this.client;
    }


    private ClientBootstrap bootstrapFromDefaults() {
        ChannelFactory factory =
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool());
        ClientBootstrap bootstrap = new ClientBootstrap(factory);
        bootstrap.setPipelineFactory(new PipelineFactory(new MessageHandler()));
        return bootstrap;
    }

    public void notify(Notification notification) {
        client().notify(application, notification);
    }
}
