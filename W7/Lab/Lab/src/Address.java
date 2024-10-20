import java.util.Objects;
import java.util.Scanner;

public class Address {
    /** holds the name of the street */
    private String street;
    /** The number of the building on the street. */
    private int number;
    /** The postal code for the street */
    private String zipcode;
    /** The name of the city where the street is located */
    private String city;

    /**
     * Creates a new Address
     * @param street    The name of the street
     * @param number    The number of the building on the street
     * @param zipcode   The postal code for the street
     * @param city      The name of the city where the street is located
     */
    public Address(String street, int number, String zipcode, String city) {
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.city = city;
    }

    /**
     * Gets the name of the street
     * @return      the name of the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Gets the number of the building
     * @return      the number of the building
     */
    public int getNumber() {
        return number;
    }

    /**
     * Gets the zipcode of the address
     * @return      the zipcode of the address
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Gets the name of the city where the street is
     * @return      the name of the city where the street is
     */
    public String getCity() {
        return city;
    }

    /**
     * Creates an address object using the specified data string
     * @param data string containing the data for creation of new Address
     * @return  Address object created using the data
     */
    public static Address fromData(String data) {
        Scanner sc = new Scanner(data);
        sc.useDelimiter("; ");
        String street = sc.next();
        int number = Integer.parseInt(sc.next());
        String zipcode = sc.next();
        String city = sc.next();

        return new Address(street, number, zipcode, city);
    }

    /**
     * Creates a string containing all the information for Address
     * @return      String representation of the Address
     */
    @Override
    public String toString() {
        return street + ", " +
                + number + ", "
                + zipcode + ", "
                + city;
    }

    /**
     * Checks if two objects are the equal or not
     * @param o     the object we are comparing "this" to
     * @return      true or false based on whether the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number &&
                Objects.equals(street, address.street) &&
                Objects.equals(zipcode, address.zipcode) &&
                Objects.equals(city, address.city);
    }
}
