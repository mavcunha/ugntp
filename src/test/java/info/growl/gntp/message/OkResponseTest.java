package info.growl.gntp.message;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OkResponseTest {

    @Test
    public void shouldSetResponseAction() {
        List<String> receivedMessage = new ArrayList<String>();
        receivedMessage.add("Response-Action: REGISTER");

        OkResponse response = new OkResponse(receivedMessage);

        assertThat(response.action(), is("REGISTER"));
    }
}
