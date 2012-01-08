package info.growl.gntp.message;

import java.util.List;

public class OkResponse extends Response {

    private final String action;

    public OkResponse(List<String> response) {
        this.action = find("Response-Action: (\\w+)", response);
    }

    public String action() {
        return this.action;
    }
}
