package inf112.skeleton.app.networking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void clientPingShouldRecivePong() {
        Client client = new Client("localhost", 5009);
        Host host = new Host("localhost");

        String result = client.getPing();
        assertEquals("pong",result);
    }

    @Test
    void name() {

    }
}