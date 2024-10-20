import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class JobCatalog {
    /** This is a list of all the jobs */
    private List<Job> jobs;

    /**
     * Creates a new instance of JobCatalog with new jobs list
     */
    public JobCatalog() {
        this.jobs = new ArrayList<>();
    }

    /**
     * Gets the list of jobs in the catalog
     * @return  the actual list of jobs
     */
    public List<Job> getJobs() {
        return jobs;
    }

    /**
     * Adds the specified job to the list of jobs
     * @param job the job that will be added
     */
    public void addJob(Job job) {
        this.jobs.add(job);
    }

    /**
     * Creates new JobCatalog using a passed scanner from which we will be able to access all the input stream
     * @param sc the scanner used as input stream
     * @return new JobCatalog
     */
    public static JobCatalog fromData(Scanner sc) {
        JobCatalog catalog = new JobCatalog();

        while(sc.hasNextLine()) {
            String addressString = sc.nextLine();
            String description = sc.nextLine();
            String equipmentList = sc.nextLine();
            if(equipmentList.equals("")) {
                equipmentList = null;
            }
            String date = sc.nextLine();

            Job job = Job.fromData(addressString, description, equipmentList, date);
            catalog.addJob(job);
        }

        return catalog;
    }

    /**
     * Creates a human-friendly text representation of the object
     * @return string containing human-friendly text representation of the object
     */
    @Override
    public String toString() {
        String result = "";

        for (Job j : jobs) {
            result += j.toString() + "\n";
        }

        return result;
    }

    /**
     * Checks if specified object is equal to this
     * @param o other object
     * @return  true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobCatalog that = (JobCatalog) o;
        return Objects.equals(jobs, that.jobs);
    }
}
