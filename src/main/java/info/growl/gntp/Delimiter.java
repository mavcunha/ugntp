package info.growl.gntp;

public enum Delimiter {
    EOL("\r\n"),
    EOM("\r\n" + "\r\n");

    private final String delimiter;

    Delimiter(String del) {
        delimiter = del;
    }

    @Override
    public String toString() {
        return this.delimiter;
    }
}
