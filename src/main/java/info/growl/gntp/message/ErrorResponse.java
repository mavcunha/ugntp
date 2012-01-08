package info.growl.gntp.message;

import java.util.List;

public class ErrorResponse extends Response {

    private final String code;
    private final String description;

    public ErrorResponse(List<String> response) {
        this.code = find("Error-Code: (\\d+)", response);
        this.description = find("Error-Description: (.+)", response);
    }

    public String code() {
        return this.code;
    }
    
    public String description() {
        return this.description;
    }
}
