public class Request {

    private String question;
    private String room;

    /**
     * Creates a request.
     *
     * @param question The question the student is asking
     * @param room The room the student is in
     */
    public Request(String question, String room) {
        this.setQuestion(question);
        this.room = room;
    }

    /**
     * Gets the question.
     *
     * @return The question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the question.
     *
     * @param question The new question
     * @throws IllegalArgumentException If the question is shorter than 15 characters
     */
    public void setQuestion(String question) {
        if (question.length() < 15) {
            throw new IllegalArgumentException("Question needs to be 15 character or longer");
        }
        this.question = question;
    }

    /**
     * Gets the room.
     *
     * @return The room
     */
    public String getRoom() {
        return room;
    }

    /**
     * Sets the room.
     *
     * @param room The new room
     */
    public void setRoom(String room) {
        this.room = room;
    }

}
