import java.util.List;
import java.util.Objects;

public class Job {
    /** The number of the job*/
    private int jobNumber;
    /** The location of the job*/
    private Address location;
    /** The description of the job*/
    private String description;
    /** The required equipment for the job*/
    private List<Equipment> requiredEquipment;
    /** The planned date for the job*/
    private Date plannedDate;
    /** The number of jobs in total*/
    private static int jobTotal = 0;

    /**
     * Creates a new Job with the specified jobNumber, location, description, requiredEquipment and plannedDate
     * @param jobNumber number of the job
     * @param location  location of the job
     * @param description description of the job
     * @param requiredEquipment required equipment to do the job
     * @param plannedDate the date that is planned for the job
     */
    public Job(int jobNumber, Address location, String description, List<Equipment> requiredEquipment, Date plannedDate) {
        this.jobNumber = jobNumber;
        this.location = location;
        this.description = description;
        this.requiredEquipment = requiredEquipment;
        this.plannedDate = plannedDate;

        jobTotal++;
    }

    /**
     * Gets the job number
     * @return job number
     */
    public int getJobNumber() {
        return jobNumber;
    }

    /**
     * Gets the location of the job
     * @return location of the job
     */
    public Address getLocation() {
        return location;
    }

    /**
     * Gets the description of the job
     * @return  description
     */
    public String getDescription() {
        return description;
    }

    /**
     * A list of the required equipment
     * @return  a list of the required equipment
     */
    public List<Equipment> getRequiredEquipment() {
        return requiredEquipment;
    }

    /**
     * Gets the planned date of the job
     * @return planned date
     */
    public Date getPlannedDate() {
        return plannedDate;
    }

    /**
     * Gets the number of jobs in total
     * @return job total
     */
    public static int getJobTotal() {
        return jobTotal;
    }

    /**
     * Creates a human-readable string of the Job object
     * @return  A string of the Job
     */
    @Override
    public String toString() {
        String list = "";
        for (int i = 0; i < requiredEquipment.size() - 1; i++) {
            list += requiredEquipment.get(i).toString() + ", ";
        }
        list += requiredEquipment.getLast().toString();
        String result = String.format(
                "Job %d:\nLocation: %s\nDescription: %s\n%s\nPlanned Date: %s\nJob Total: %d",
                jobNumber,
                location,
                description,
                list,
                plannedDate,
                jobTotal
        );

        return result;
    }

    /**
     * Checks if given object is equal with this
     * @param o     other object
     * @return      true if the two objects are equal, false if they are not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return jobNumber == job.jobNumber && Objects.equals(location, job.location) && Objects.equals(description, job.description) && Objects.equals(requiredEquipment, job.requiredEquipment) && Objects.equals(plannedDate, job.plannedDate);
    }
}
