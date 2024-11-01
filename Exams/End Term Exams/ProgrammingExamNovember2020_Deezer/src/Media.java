import java.util.Objects;

public abstract class Media {
    private Duration duration;
    private String name;

    public Media(Duration duration, String name) {
        this.duration = duration;
        this.name = name;
    }

    /**
     * Returns the duration object
     * @return duration object
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Returns the name of the Media
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the specified object is equal to this
     * @param o the object we will check
     * @return true or false based on whether the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Objects.equals(duration, media.duration) && Objects.equals(name, media.name);
    }

    /**
     * Creates a hash code based on class data
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(duration, name);
    }
}
