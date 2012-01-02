package info.growl.gntp;

public enum Protocol {
    GNTP_1_0("GNTP/1.0");

    private final String representation;

    Protocol(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}
