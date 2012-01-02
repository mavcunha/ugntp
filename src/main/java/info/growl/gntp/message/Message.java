package info.growl.gntp.message;

import info.growl.gntp.Delimiter;
import info.growl.gntp.Protocol;

public abstract class Message {
    public abstract String render();
    public abstract String type();

    public String header() {
        return Protocol.GNTP_1_0 + " " + type() + " NONE" + Delimiter.EOL;
    }
}
