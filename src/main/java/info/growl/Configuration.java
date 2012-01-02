package info.growl;

public class Configuration {

    public static final int DEFAULT_PORT = 23053;
    public static final String DEFAULT_HOSTNAME = "localhost";

    private int port;
    private final String hostname;

    public Configuration() {
        this(DEFAULT_HOSTNAME, DEFAULT_PORT);
    }

    public Configuration(String hostname) {
        this(hostname, DEFAULT_PORT);
    }

    public Configuration(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public int port() {
        return this.port;
    }

    public String host() {
        return this.hostname;
    }

}
