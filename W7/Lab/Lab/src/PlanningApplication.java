import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlanningApplication {
    /**
     * Main method from where the program starts executing
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // Read from file
        Scanner fileScanner = new Scanner(new File("resources/joblist.txt"));
        JobCatalog jc = JobCatalog.fromData(fileScanner);

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("Hello, please select one of the options:\n");
        System.out.println("1 - Show all jobs in the catalog.\n");
        System.out.println("2 - Add a new job.\n");
        System.out.println("3-6 - To be implemented.\n");
        System.out.println("7 - Quit application.");

        while(choice != 7) {
            System.out.println("Enter new number: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("All jobs in the catalog: ");
                    System.out.println(jc.toString());
                    break;
                case 2:
                    Job job = createJob();
                    jc.addJob(job);
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                case 7:
                    FileWriter fw = new FileWriter("resources/joblist.txt");
                    for(Job currJob : jc.getJobs()) {
                        fw.write(currJob.serialize());
                    }

                    fw.close();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Prompts the user for the required information for creating a new Job
     * @return  Job object created from the user input
     */
    public static Job createJob() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the job number: ");
        int jobNumber = sc.nextInt();
        sc.nextLine();

        // Enter Address
        System.out.println("Please enter the location of the job in the format(" +
                "streetName,streetNumber,zipcode,city): ");

        Scanner addressScanner = new Scanner(sc.nextLine());
        addressScanner.useDelimiter(",");
        String streetName = addressScanner.next();
        int streetNumber = addressScanner.nextInt();
        String zipCode = addressScanner.next();
        String city = addressScanner.next();
        Address jobAddress = new Address(streetName, streetNumber, zipCode, city);

        System.out.println("Please enter the description of the job: ");
        String description = sc.nextLine();
        List<Equipment> equipmentList = enterEquipments();


        System.out.println("Enter the planned date (day, month, year):");
        Scanner dateScanner = new Scanner(sc.nextLine());
        dateScanner.useDelimiter(",");
        int day = Integer.parseInt(dateScanner.next());
        int month = Integer.parseInt(dateScanner.next());
        int year = Integer.parseInt(dateScanner.next());
        Date plannedDate = new Date(day, month, year);

        return new Job(jobNumber, jobAddress, description, equipmentList, plannedDate);
    }

    /**
     *  Prompts the user to enter which equipments are needed for a job
     * @return  a list of all the equipments needed for a job
     */
    public static List<Equipment> enterEquipments() {
        Scanner sc = new Scanner(System.in);
        List<Equipment> equipments = new ArrayList<Equipment>();
        boolean addingEquipments = true;
        int equipmentChoice = 0;


        while(addingEquipments) {
            System.out.println("Select equipment to add to the job:");
            System.out.println("1 - Concrete Mixer");
            System.out.println("2 - Jack Hammer");
            System.out.println("3 - Scaffolding Tower");
            System.out.println("4 - Torch");
            System.out.println("0 - Finish adding equipment");

            equipmentChoice = sc.nextInt();
            sc.nextLine(); //consume the new line leftover
            switch (equipmentChoice) {
                case 1:
                    System.out.println("Enter the requirements for Concrete Mixer:");
                    String concreteMixerReqs = sc.nextLine();
                    equipments.add(new ConcreteMixer(concreteMixerReqs));
                    break;
                case 2:
                    System.out.println("Enter the requirements for Jack Hammer:");
                    String jackHammerReqs = sc.nextLine();
                    equipments.add(new JackHammer(jackHammerReqs));
                    break;
                case 3:
                    System.out.println("Enter the requirements for Scaffolding Tower:");
                    String scaffoldingReqs = sc.nextLine();
                    equipments.add(new ScaffoldingTower(scaffoldingReqs));
                    break;
                case 4:
                    System.out.println("Enter the requirements for Torch:");
                    String torchReqs = sc.nextLine();
                    equipments.add(new Torch(torchReqs));
                    break;
                case 0:
                    addingEquipments = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        return equipments;
    }

}
