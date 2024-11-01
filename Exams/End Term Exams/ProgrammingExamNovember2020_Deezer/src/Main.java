import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        List<Album> albums = new ArrayList<Album>();
        List<Ad> ads = new ArrayList<>();
        String inputPrompt = """
                    1 – Print all albums & songs
                    2 – Add a new advertisement
                    3 – Enable shuffling of songs
                    4 – Add track to front of playlist
                    5 – Write to file
                    6 – Calculate commercial value
                    7 – Stop the program
                """.stripIndent();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter fileName: ");
        String fileName = sc.nextLine();

        Scanner fileScanner = new Scanner(new File(fileName));
        fileScanner.useDelimiter("ADS");
        String albumsString = fileScanner.next();
        String adsString = fileScanner.next();

        albumsString = albumsString.substring(albumsString.indexOf("\n") + 1);

        String[] albumArray = albumsString.split("ALBUM ");
        for(int i = 1; i < albumArray.length; i++) {
            albums.add(Album.read(albumArray[i]));
        }

        String[] adsArray = adsString.split("\n");
        for(int i = 1; i < adsArray.length; i++) {
            ads.add(Ad.read(adsArray[i]));
        }

        Catalogue catalogue = new Catalogue(albums, ads);
        catalogue.createPlaylist();

        int choice = 0;
        do {
            System.out.println(inputPrompt);
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    printAlbums(albums);
                    break;
                case 2:
                    ads.add(addNewAd(sc));
                    break;
                case 3:
                    catalogue.createPlaylist();
                    break;
                case 4:
                    addNewTrack(sc, catalogue);
                    break;
                case 5:
                    FileWriter fileWriter = new FileWriter(new File(fileName));
                    fileWriter.write(catalogue.toSaveString());
                    fileWriter.close();
                    break;
                case 6:
                    printCommercialPrice(catalogue);
                    break;
            }
        } while(choice != 7);
    }

    public static void printAlbums(List<Album> albums) {
        for (int i = 0; i < albums.size(); i++) {
            System.out.println(String.valueOf(i + 1) + "\n");
            System.out.println(albums.get(i).toString());
        }
    }

    public static Ad addNewAd(Scanner inputSc) {
        System.out.println("Enter the information for a new add:");
        System.out.println("     The name of the company of the ad: ");
        String name = inputSc.nextLine();
        System.out.println("     The duration of the add:");
        System.out.println("         Enter minutes: ");
        int minutes = inputSc.nextInt();
        System.out.println("         Enter seconds: ");
        int seconds = inputSc.nextInt();
        System.out.println("     Enter the commercial price: ");
        double commercialPrice = inputSc.nextDouble();

        return new Ad(new Duration(minutes, seconds), name, commercialPrice);
    }

    public static void addNewTrack(Scanner inputSc, Catalogue catalogue) {
        System.out.println("Enter the name of the of track: ");
        String name = inputSc.nextLine();
        Track track = catalogue.getTrackByName(name);
        if(track == null) {
            System.out.println("Invalid name");
        }
        else {
            try {
                catalogue.addTrackToPlaylist(track);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void printCommercialPrice(Catalogue catalogue) {
        System.out.println(catalogue.calculatePrice() + " euros");
    }
}