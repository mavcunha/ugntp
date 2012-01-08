package info.growl.gntp.message;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Response {

    String find(String regex, List<String> response) {
        Pattern pattern = Pattern.compile(regex);
        for (String line : response) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return "";
    }

}
