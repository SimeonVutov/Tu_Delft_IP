import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void testToString() {
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new JackHammer("Strength"));
        Job job = new Job(
                1,
                new Address("Roland", 100, "2354D", "Delft"),
                "You need to destroy some concrete",
                equipmentList,
                new Date(1, 1, 2000)
        );
        assertEquals(
                "Job 1:\n" +
                        "Location: Roland, 100, 2354D, Delft\n" +
                        "Description: You need to destroy some concrete\n" +
                        "This JackHammer requires: Strength\n" +
                        "Planned Date: 1/1/2000\n" +
                        "Job Total: 1",
                job.toString()
        );
    }

    @Test
    void testEquals() {
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new JackHammer("Strength"));
        Job job = new Job(
                1,
                new Address("Roland", 100, "2354D", "Delft"),
                "You need to destroy some concrete",
                equipmentList,
                new Date(1, 1, 2000)
        );
        equipmentList.add(new JackHammer("Strength"));
        Job job2 = new Job(
                1,
                new Address("Roland", 100, "2354D", "Delft"),
                "You need to destroy some concrete",
                equipmentList,
                new Date(1, 1, 2000)
        );
        assertEquals(job, job2);
    }
}