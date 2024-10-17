public class Student extends Person implements HasToStudy {
    private boolean livesInDelft;
    private int timesStudyed;
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
        this.timesStudyed = 0;
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

    public int getTimesStudyed() {
        return timesStudyed;
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

    @Override
    public void study() {
        timesStudyed++;
    }

    @Override
    public boolean willPassExam() {
        return timesStudyed >= 5;
    }

    public int hashCode() {
        int hash = super.hashCode();
        hash = hash + 31 * timesStudyed;
        hash = hash * 31 + (livesInDelft ? 1 : 0);

        return hash;
    }
}
