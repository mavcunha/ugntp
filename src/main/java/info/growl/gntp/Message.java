package info.growl.gntp;

public abstract class Message {
    public abstract String render();
    public abstract String type();

    public String header() {
        return Protocol.GNTP_1_0 + " " + type() + " NONE" + Delimiter.EOL;
    }
}
