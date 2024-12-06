
// import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JDBCExample db = new JDBCExample();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose a table to manipulate:");
            System.out.println("1. Users");
            System.out.println("2. Events");
            System.out.println("3. Reservations");
            System.out.println("4. Salles");
            System.out.println("5. Terrains");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int tableChoice = scanner.nextInt();

            switch (tableChoice) {
                case 1 -> manipulateUsers(db, scanner);
                case 2 -> manipulateEvents(db, scanner);
                case 3 -> manipulateReservations(db, scanner);
                case 4 -> manipulateSalles(db, scanner);
                case 5 -> manipulateTerrains(db, scanner);
                case 6 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void manipulateUsers(JDBCExample jdbcExample, Scanner scanner) {
        while (true) {
            System.out.println("===Users Table===");
            System.out.println("1. Select Users");
            System.out.println("2. Insert User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation (Enter number): ");
            int operationChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (operationChoice) {
                case 1: 
                    jdbcExample.selectUser();
                    break;
                case 2: 
                    System.out.println("Enter user details:");
                    System.out.print("Nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Prenom: ");
                    String prenom = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Type: ");
                    String type = scanner.nextLine();
                    jdbcExample.insertUser(nom, prenom, email, type);
                    break;
                case 3: 
                    System.out.println("Enter new user details to update:");
                    System.out.print("Nom: ");
                    String newNom = scanner.nextLine();
                    System.out.print("Prenom: ");
                    String newPrenom = scanner.nextLine();
                    System.out.print("Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Type: ");
                    String newType = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    jdbcExample.updateUser(id,newNom, newPrenom, newEmail, newType);
                    break;
                case 4:
                    System.out.print("Enter ID of the user to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); 
                    jdbcExample.deleteUser(idToDelete);
                    break;
                case 0: 
                    return; 
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }

    private static void manipulateEvents(JDBCExample jdbcExample, Scanner scanner) {
        while (true) {
            System.out.println("===Event Table===");
            System.out.println("1. Select Event");
            System.out.println("2. Insert Event");
            System.out.println("3. Update Event");
            System.out.println("4. Delete Event");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation (Enter number): ");
            int operationChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (operationChoice) {
                case 1: 
                    jdbcExample.selectEvents();
                    break;
                case 2: 
                    System.out.println("Enter Event details:");
                    System.out.print("Nom_Event: ");
                    String nomEvent = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("ID_USER: ");
                    int id = scanner.nextInt();
                    jdbcExample.insertEvent(nomEvent, description, id);
                    break;
                case 3: 
                    System.out.println("Enter new user details to update:");
                    System.out.print("ID_Event: ");
                    int idEvent = scanner.nextInt();
                    System.out.print("Nom_Event: ");
                    String newNom = scanner.nextLine();
                    System.out.print("Description: ");
                    String Description = scanner.nextLine();
                    System.out.print("ID_USER: ");
                    int iduser = scanner.nextInt();
                    jdbcExample.updateEvent(idEvent,newNom, Description, iduser);
                    break;
                case 4:
                    System.out.print("Enter ID of the Event to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); 
                    jdbcExample.deleteEvent(idToDelete);
                    break;
                case 0: 
                    return; 
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }

    private static void manipulateReservations(JDBCExample jdbcExample, Scanner scanner) {
        while (true) {
            System.out.println("===Reservation Table===");
            System.out.println("1. Select Reservation");
            System.out.println("2. Insert Reservation");
            System.out.println("3. Update Reservation");
            System.out.println("4. Delete Reservation");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation (Enter number): ");
            int operationChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (operationChoice) {
                case 1: 
                    jdbcExample.selectReservations();
                    break;
                case 2: 
                    System.out.println("Enter Reservation details:");
                    
                    System.out.print("ID_USER: ");
                    int idUser = scanner.nextInt();
                    System.out.print("ID_Event: ");
                    int idEvent = scanner.nextInt();
                    System.out.print("ID_Salle: ");
                    int idSalle = scanner.nextInt();
                    System.out.print("ID_Terrain: ");
                    int idTerrain = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("entrer la date : ");
                    String date = scanner.nextLine();
                    

                    jdbcExample.insertReservation(idUser,idEvent,idSalle,idTerrain,date);
                    break;
                case 3: 
                    System.out.println("Enter new user details to update:");
                    System.out.print("ID_Reservation: ");
                    int idReservation = scanner.nextInt();
                    System.out.print("ID_USER: ");
                    int iduser = scanner.nextInt();
                    System.out.print("ID_Event: ");
                    int idevent = scanner.nextInt();
                    System.out.print("ID_Salle: ");
                    int idsalle = scanner.nextInt();
                    System.out.print("ID_Terrain: ");
                    int idterrain = scanner.nextInt();
                    jdbcExample.updateReservation(idReservation,iduser,idevent,idsalle,idterrain);
                    break;
                case 4:
                    System.out.print("Enter ID of the Reservation to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); 
                    jdbcExample.deleteReservation(idToDelete);
                    break;
                case 0: 
                    return; 
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }

    private static void manipulateSalles(JDBCExample jdbcExample, Scanner scanner) {
        while (true) {
            System.out.println("===Salle Table===");
            System.out.println("1. Select Salle");
            System.out.println("2. Insert Salle");
            System.out.println("3. Update Salle");
            System.out.println("4. Delete Salle");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation (Enter number): ");
            int operationChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (operationChoice) {
                case 1: 
                    jdbcExample.selectSalles();
                    break;
                case 2: 
                    System.out.println("Enter Salle details:");
                    
                    System.out.print("Enter Salle name : ");
                    String nom = scanner.nextLine();
                    System.out.print("Capacite : ");
                    int capacite = scanner.nextInt();

                    jdbcExample.insertSalle(nom,capacite);
                    break;
                case 3: 
                    System.out.println("Enter new Salle details to update:");
                    System.out.println("ID Salle : ");
                    int idSalle = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new Salle name : ");
                    String newNom = scanner.nextLine();
                    System.out.println("New Capacite : ");
                    int newCapacite = scanner.nextInt();
                    jdbcExample.updateSalle(idSalle,newNom,newCapacite);
                    break;
                case 4:
                    System.out.print("Enter ID of the Salle to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); 
                    jdbcExample.deleteSalle(idToDelete);
                    break;
                case 0: 
                    return; 
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }

    private static void manipulateTerrains(JDBCExample jdbcExample, Scanner scanner) {
        while (true) {
            System.out.println("===Terrain Table===");
            System.out.println("1. Select Terrain");
            System.out.println("2. Insert Terrain");
            System.out.println("3. Update Terrain");
            System.out.println("4. Delete Terrain");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an operation (Enter number): ");
            int operationChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (operationChoice) {
                case 1: 
                    jdbcExample.selectTerrains();
                    break;
                case 2: 
                    System.out.println("Enter Terrain details:");
                    
                    System.out.println("Enter Terrain name : ");
                    String nom = scanner.nextLine();
                    System.out.println("Type : ");
                    String type = scanner.nextLine();

                    jdbcExample.insertTerrain(nom,type);
                    break;
                case 3: 
                    System.out.println("Enter new Terrain details to update:");
                    System.out.println("ID Terrain : ");
                    int idTerrain = scanner.nextInt();
                    System.out.println("Enter new Terrain name : ");
                    String newNom = scanner.nextLine();
                    System.out.println("New Type : ");
                    String newType = scanner.nextLine();
                    jdbcExample.updateTerrain(idTerrain,newNom,newType);
                    break;
                case 4:
                    System.out.println("Enter ID of the Terrain to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); 
                    jdbcExample.deleteTerrain(idToDelete);
                    break;
                case 0: 
                    return; 
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }
        }
    }
}
