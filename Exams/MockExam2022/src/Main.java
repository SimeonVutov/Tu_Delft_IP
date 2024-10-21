import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Player player = new Player();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file which will be used: ");
        String fileName = sc.nextLine();
        List<Card> cards = readFromFile(fileName);

        CardManager cardManager = new CardManager(cards);

        int choice = 0;

        while(choice != 5){
            System.out.println("1 – Show all known cards");
            System.out.println("2 – Show user’s card collection and gold");
            System.out.println("3 – Open a pack of cards");
            System.out.println("4 – Save collection to file");
            System.out.println("5 – Quit the application");
            System.out.println("Enter a number");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Card card : cardManager.getAllCards()) {
                        System.out.println(card.toString());
                    }
                    break;
                case 2:
                    System.out.printf(String.format("You have %d gold and own %d cards.\n",
                            player.getGold(),
                            player.getCardCollection().size()
                    ));
                    break;
                case 3:
                    player.processUnpackedCards(cardManager.unpackCardPack());
                    break;
                case 4:
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream("Player.txt");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        objectOutputStream.writeObject(player);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    quit();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        quit();
    }

    private static void quit() {
        System.out.printf("Quitting application");
    }

    private static List<Card> readFromFile(String filename) throws FileNotFoundException {
        List<Card> cards = new ArrayList<>();
        Scanner sc = new Scanner(new File(filename));

        while (sc.hasNextLine()) {
            Scanner typeScanner = new Scanner(sc.nextLine());

            Card card = CardFactory.createCard(typeScanner.next(), sc);
            cards.add(card);
        }

        return cards;
    }
}