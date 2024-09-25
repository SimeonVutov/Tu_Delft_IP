public class House extends Building {
    private int number;

    public House(String street, int value, int number) {
        super(street, value);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getString() {
        super.getString();
    }

}
