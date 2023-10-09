import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Adauga locatie");
            System.out.println("2. Sterge locatie");
            System.out.println("3. Afiseaza fisiere multimedia");
            System.out.println("4. Iesire");
            System.out.print("Alege o optiune: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Introdu locatia: ");
                    String locationToAdd = scanner.nextLine();
                    fileManager.addLocation(locationToAdd);
                    break;
                case 2:
                    System.out.print("Introdu locatia de sters: ");
                    String locationToRemove = scanner.nextLine();
                    fileManager.removeLocation(locationToRemove);
                    break;
                case 3:
                    for (String location : fileManager.getLocations()) {
                        System.out.println("Fisiere multimedia in " + location + ":");
                        for (String file : MultimediaFileScanner.scanDirectory(location)) {
                            System.out.println("\t" + file);
                        }
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Optiune invalida.");
            }
        }
        scanner.close();
    }
}
