package info.growl.gntp.io;

import info.growl.gntp.message.ErrorResponse;
import org.apache.log4j.Logger;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MessageHandlerTest {

    private Logger logger;
    private ExceptionEvent exceptionEvent;
    private MessageEvent messageEvent;

    @Before
    public void setUp() {
        logger = mock(Logger.class);
        exceptionEvent = mock(ExceptionEvent.class);
        messageEvent = mock(MessageEvent.class);
    }

    @Test
    public void shouldLogIfExceptionOccurred() throws Exception {
        MessageHandler handler = new MessageHandler(logger);

        RuntimeException exception = new RuntimeException("Error occurred");

        when(exceptionEvent.getCause()).thenReturn(exception);
        
        handler.exceptionCaught(null, exceptionEvent);

        verify(logger).error(anyString(), eq(exception));
    }

    @Test
    public void shouldSetResponseWhenMessageReceived() throws Exception {
        MessageHandler handler = new MessageHandler(logger);

        ErrorResponse errorResponse = new ErrorResponse(Collections.<String>emptyList());

        when(messageEvent.getMessage()).thenReturn(errorResponse);
        
        handler.messageReceived(null,messageEvent);

        assertThat(handler.response(), is(instanceOf(ErrorResponse.class)));
    }
}
