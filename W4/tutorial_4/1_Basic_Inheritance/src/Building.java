public class Building {
    private String street;
    private int value;

    public Building(String street, int value) {
        this.street = street;
        this.value = value;
    }

    public String getStreet() {
        return street;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}