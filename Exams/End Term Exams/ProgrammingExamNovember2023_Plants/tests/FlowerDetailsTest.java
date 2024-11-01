import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerDetailsTest {

    @Test
    void read() {
        String data = "FLOWER DETAILS: yellow; small; 4 petals";
        FlowerDetails fd = FlowerDetails.read(data);
        FlowerDetails fd2 = new FlowerDetails("yellow", FlowerSize.small, 4);

        assertEquals(fd, fd2);
    }
}