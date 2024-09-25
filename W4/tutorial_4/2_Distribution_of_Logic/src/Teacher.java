public class Teacher {

    private String name;
    private double height;
    private int amountOfCourses;

    /**
     * Creates a new teacher.
     *
     * @param name The name of the teacher
     * @param height The height of the teacher
     * @param amountOfCourses The amount of courses the teacher teaches
     */
    public Teacher(String name, double height, int amountOfCourses) {
        this.name = name;
        this.height = height;
        this.amountOfCourses = amountOfCourses;
    }

    /**
     * Gets the name of the teacher.
     *
     * @return This teacher's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the height of the teacher.
     *
     * @return This teacher's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the teacher.
     *
     * @param height The new height for this teacher
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the amount of courses the teacher teaches.
     *
     * @return The amount of courses this teacher teaches
     */
    public int getAmountOfCourses() {
        return amountOfCourses;
    }

    /**
     * Sets the amount of courses the teacher teaches.
     *
     * @param amountOfCourses The new amount of courses this teacher teaches
     */
    public void setAmountOfCourses(int amountOfCourses) {
        this.amountOfCourses = amountOfCourses;
    }

}
