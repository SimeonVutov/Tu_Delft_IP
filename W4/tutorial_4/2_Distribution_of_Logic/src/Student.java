public class Student {

    private String name;
    private double height;
    private boolean livesInDelft;

    /**
     * Creates a student.
     *
     * @param name The name of the student
     * @param height The height of the student
     * @param livesInDelft Whether the student lives in Delft
     */
    public Student(String name, double height, boolean livesInDelft) {
        this.name = name;
        this.height = height;
        this.livesInDelft = livesInDelft;
    }

    /**
     * Gets the name of the student.
     *
     * @return This student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the height of the student.
     *
     * @return This student's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the student.
     *
     * @param height The new height for this student
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets whether the student lives in Delft.
     *
     * @return True iff this student lives in Delft
     */
    public boolean getLivesInDelft() {
        return livesInDelft;
    }

    /**
     * Sets whether the student lives in Delft.
     *
     * @param livesInDelft The new living status of this student
     */
    public void setLivesInDelft(boolean livesInDelft) {
        this.livesInDelft = livesInDelft;
    }

}
