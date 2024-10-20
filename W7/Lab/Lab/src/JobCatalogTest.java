import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JobCatalogTest {
    @Test
    public void testConstructor() {
        JobCatalog jc = new JobCatalog();
        assertNotNull(jc.getJobs());
        assertTrue(jc.getJobs().isEmpty());
    }

    @Test
    public void testToString() {
        JobCatalog jc = new JobCatalog();
        assertEquals("", jc.toString());
    }

    @Test
    public void testEquals() {
        JobCatalog jc = new JobCatalog();
        JobCatalog jc1 = new JobCatalog();

        assertEquals(jc, jc1);
    }

    @Test
    public void testAddJob() {
        JobCatalog jc = new JobCatalog();
        Job job = new Job(
                1,
                new Address("test", 1, "test", "test"),
                "Description",
                new ArrayList<Equipment>(),
                new Date(1, 1, 2000)
        );
        jc.addJob(job);

        assertEquals(1, jc.getJobs().size());
    }

}