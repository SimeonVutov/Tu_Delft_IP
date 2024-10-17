public class Student extends Person {
    private boolean livesInDelft;

    /**
     * Creates a student.
     *
     * @param name The name of the student
     * @param height The height of the student
     * @param livesInDelft Whether the student lives in Delft
     */
    public Student(String name, double height, boolean livesInDelft) {
        super(name, height);
        this.livesInDelft = livesInDelft;
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
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || this.getClass() == obj.getClass())
            return false;

        Student that = (Student) obj;

        if(super.equals(that) && this.livesInDelft == that.livesInDelft)
            return true;

        return false;
    }

    @Override
    public String toString() {
        if(livesInDelft) {
            return super.toString() + " and lives in Delft";
        }
        return super.toString();
    }
}
