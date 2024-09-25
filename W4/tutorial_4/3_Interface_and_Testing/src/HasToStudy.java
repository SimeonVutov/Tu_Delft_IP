public interface HasToStudy {

    /**
     * Studies for the upcoming exam.
     */
    void study();

    /**
     * Gets whether the next exam will be passed.
     *
     * @return True iff the next exam will be passed
     */
    boolean willPassExam();

}
