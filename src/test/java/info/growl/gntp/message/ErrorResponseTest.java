package info.growl.gntp.message;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ErrorResponseTest {

    @Test
    public void shouldBuildItselfResponseList() throws Exception {

        List<String> response = new ArrayList<String>();
        response.add("Error-Code: 100");
        response.add("Error-Description: Some Error Occurred");

        ErrorResponse errorResponse = new ErrorResponse(response);

        assertThat(errorResponse.code(), is("100"));
        assertThat(errorResponse.description(), is(equalTo("Some Error Occurred")));
    }

}
