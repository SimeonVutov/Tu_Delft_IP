/**
 * This factory class is used to create equipments based on data input
 */
public class EquipmentFactory {
    /**
     * Creates new Equipment based on the data String
     * @param data the data String from which we will determine the type of the equipment and create the correct one
     * @return  Equipment object
     */
    public static Equipment createEquipment(String data) {
        String[] parts = data.split(",");
        String type = parts[0].strip();
        String description = "None";
        if(parts.length > 1)
            description = parts[1].strip();

        switch (type) {
            case "JackHammer":
                return new JackHammer(description);
            case "ConcreteMixer":
                return new ConcreteMixer(description);
            case "Torch":
                return new Torch(description);
            case "Scaffolding":
                return new ScaffoldingTower(description);
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}
