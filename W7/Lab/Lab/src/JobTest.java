import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void testFromData() {
        String addressString = "Roland; 123; 2354D; Delft";
        Address address = new Address("Roland", 123, "2354D", "Delft");
        String description = "You need to destroy some concrete";
        String requiredEquipments = "JackHammer, A hardened chisel; ConcreteMixer, None;";
        List<Equipment> list = new ArrayList<>();
        list.add(new JackHammer("A hardened chisel"));
        list.add(new ConcreteMixer("None"));
        String plannedDate = "23-10-2024";
        Job job1 = Job.fromData(addressString, description, requiredEquipments, plannedDate);
        Job job2 = new Job(0, address, description, list, new Date(23, 10, 2024));

        assertEquals(job2, job1);
    }

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
        // Here Job Total must be adjusted because it is a static field which is updated
        // every Job creation and we do not know in what order the tests are going to run
        assertEquals(
                "Job 1:\n" +
                        "Location: Roland, 100, 2354D, Delft\n" +
                        "Description: You need to destroy some concrete\n" +
                        "This JackHammer requires: Strength\nPowerSupply: Air Compressor\n" +
                        "Planned Date: 1/1/2000\n" +
                        "Job Total: 2",
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