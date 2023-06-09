package hello;

import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class MyHandlerTest {
    @Mock
    RoutingContext event;

    @Mock
    HttpServerRequest request;

    @Mock
    HttpServerResponse response;

    @BeforeEach
    public void setup() {
        doReturn(this.request).when(this.event).getRequest();
    }

    @Test
    public void shouldSetStatusTo200whenNoError() {
        // arrange
        doReturn(SOME_VALID_BODY).when(this.request).getBody();
        // act
        new MyHandler().handle(this.event);
        // assert
        Mockito.verify(this.response).setStatusCode(200);
    }
}