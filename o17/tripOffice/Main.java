package basics.o17.tripOffice;

import basics.o17.tripOffice.serializacja.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String CLIENTS_FILE = "clients.ser";

    public static void main(String[] args) {
        // ponad to co w wymaganiach biznesowych w PDF,
        // aplikacja ma miec menu (w konsoli albo okienkach) wraz z cala funkcjonalnoscia,
        // a stan aplikacji ma byc zachowywany w plikach za pomoca serializacji

        loadClients();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Dodaj klienta zarejestrowanego");
            System.out.println("2. Dodaj klienta niezarejestrowanego");
            System.out.println("3. Usuń klienta po ID");
            System.out.println("4. Pokaż wszystkich klientów");
            System.out.println("5. Utwórz wycieczkę krajową");
            System.out.println("6. Utwórz wycieczkę zagraniczną");
            System.out.println("7. Przypisz wycieczkę zarejestrowanemu klientowi");
            System.out.println("8. Pokaż wycieczki klienta");
            System.out.println("9. Klient, który wydał najwięcej");
            System.out.println("10. Dodaj pracownika obsługi klienta");
            System.out.println("11. Dodaj menedżera");
            System.out.println("12. Dodaj przewodnika");
            System.out.println("13. Utwórz ticket");
            System.out.println("14. Przypisz ticket do pracownika obsługi klienta");
            System.out.println("15. Wyślij wiadomość od klienta");
            System.out.println("16. Wyślij wiadomość od obsługi klienta");
            System.out.println("17. Zakończ i zapisz stan");
            System.out.println("18. wiadomosci");

            System.out.print("Wybierz opcję: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // czyści enter

            switch (choice) {
                case 1 -> addRegisteredClient(scanner);
                case 2 -> addTempClient(scanner);
                case 3 -> removeClient(scanner);
                case 4 -> showAllClients();
                case 5 -> createDomesticTrip(scanner);
                case 6 -> createForeignTrip(scanner);
                case 7 -> assignTripToRegisteredClient(scanner);
                case 8 -> showClientTrips(scanner);
                case 9 -> showTopSpender();
                case 10 -> createCustomerService(scanner);
                case 11 -> createManager(scanner);
                case 12 -> createGuide(scanner);
                case 13 -> createTicket(scanner);
                case 14 -> pickupTicket(scanner);
                case 15 -> sendCustomerMessage(scanner);
                case 16 -> sendServicerMessage(scanner);
                case 18 -> displayTicketMessages(scanner);
                case 17 -> {
                    saveClients();
                    running = false;
                    System.out.println("Zapisano stan aplikacji. Do widzenia!");
                }
                default -> System.out.println("Nieprawidłowy wybór!");
            }
        }
        scanner.close();
    }

    private static void addRegisteredClient(Scanner scanner) {
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        System.out.print("Podaj email: ");
        String email = scanner.nextLine();
        System.out.print("Podaj numer telefonu: ");
        String phone = scanner.nextLine();

        RegisteredClient client = new RegisteredClient(name, phone, email, surname);
        System.out.println("Dodano klienta: " + client);
    }

    private static void addTempClient(Scanner scanner) {
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        System.out.print("Podaj email: ");
        String email = scanner.nextLine();
        System.out.print("Podaj numer telefonu: ");
        String phone = scanner.nextLine();

        TempClient client = new TempClient(name, phone, email, surname, null);
        System.out.println("Dodano klienta niezarejestrowanego: " + client);
    }

    private static void removeClient(Scanner scanner) {
        System.out.print("Podaj ID klienta do usunięcia: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Removing client... " + Client.getClientByID(id));
        Client.removeClient(id);
    }

    private static void showAllClients() {
        for (Client client : Client.getAllClientsList()) {
            System.out.println(client);
        }
    }

    private static void createDomesticTrip(Scanner scanner) {
        System.out.print("Podaj nazwę wycieczki: ");
        String tripName = scanner.nextLine();
        System.out.print("Podaj cenę wycieczki: ");
        double price = scanner.nextDouble();
        System.out.print("Podaj miasto wycieczki: ");
        String town = scanner.nextLine();
        scanner.nextLine();
        DomesticTrip domesticTrip = new DomesticTrip(tripName, price, TripTheme.SIGHTSEEING, town);

        System.out.println("Utworzono wycieczke " + domesticTrip.getTripName());
    }

    private static void createForeignTrip(Scanner scanner) {
        System.out.print("Podaj nazwę wycieczki: ");
        String tripName = scanner.nextLine();
        System.out.print("Podaj cenę wycieczki: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Podaj kraj wycieczki: ");
        String country = scanner.nextLine();
        ForeignTrip foreignTrip = new ForeignTrip(tripName, price, TripTheme.SIGHTSEEING, country, TransportMode.PLANE);

        System.out.println("Utworzono wycieczke " + foreignTrip.getTripName());
    }

    private static void assignTripToRegisteredClient(Scanner scanner) {
        System.out.print("Podaj ID klienta: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        RegisteredClient client = Client.getClientByID(id);

        System.out.print("Podaj nazwę wycieczki: ");
        String tripName = scanner.nextLine();

        Trip searchedTrip = Trip.getTripByName(tripName);
        client.bookTrip(searchedTrip);
        System.out.println("Wycieczka " + searchedTrip.getTripName() + " przypisana klientowi.");
    }

    private static void showClientTrips(Scanner scanner) {
        System.out.print("Podaj ID klienta: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        RegisteredClient client = Client.getClientByID(id);
        client.displayClientTrips();
    }

    private static void showTopSpender() {
        if (Client.getClientWhoSpentTheMost() != null) {
            System.out.println("Klient, który wydał najwięcej: " + Client.getClientWhoSpentTheMost());
        } else {
            System.out.println("Brak klientów w systemie.");
        }
    }

    private static void createCustomerService(Scanner scanner) {
        //String name, String phoneNumber, String email, String surname, Double salary, Double minSalary
        System.out.println("Podaj imie: ");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        System.out.println("Podaj numer telefonu: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Podaj email: ");
        String email = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Podaj pensje: ");
        Double salary = scanner.nextDouble();
        scanner.nextLine();

        CustomerService customerService = new CustomerService(name, phoneNumber, email, surname, salary, 4500.00);
    }

    private static void createManager(Scanner scanner) {
        //String name, String phoneNumber, String email, String surname, Double salary, Double minSalary
        System.out.println("Podaj imie: ");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        System.out.println("Podaj numer telefonu: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Podaj email: ");
        String email = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Podaj pensje: ");
        Double salary = scanner.nextDouble();
        scanner.nextLine();

        Manager customerService = new Manager(name, phoneNumber, email, surname, salary, 4500.00);
    }

    private static void createGuide(Scanner scanner) {
        //String name, String phoneNumber, String email, String surname, Double salary, Double minSalary
        System.out.println("Podaj imie: ");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        System.out.println("Podaj numer telefonu: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Podaj email: ");
        String email = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Podaj pensje: ");
        Double salary = scanner.nextDouble();
        scanner.nextLine();

        Guide guide = new Guide(name, phoneNumber, email, surname, salary, 4500.00);
    }

    private static void createTicket(Scanner scanner) {
        System.out.println("Podaj ID swojego klienta");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj tytuł ticketu:");
        String topic = scanner.nextLine();
        scanner.nextLine();


        Ticket ticket = new Ticket(Client.getClientByID(id), null, topic);
        System.out.println("Ticket" + ticket + " has been created");
    }

    private static void pickupTicket(Scanner scanner) {
        System.out.println("Podaj nazwisko pracownika obslugi klienta");
        String employeeId = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Podaj id Ticketu");
        Integer ticketId = scanner.nextInt();
        scanner.nextLine();

        Ticket ticket = Ticket.getTicketById(ticketId);
        CustomerService customerService = Employee.getCustomerServiceEmployee(employeeId);

        ticket.setCustomerService(customerService);
    }

    private static void sendCustomerMessage(Scanner scanner) {
        System.out.println("Podaj id Klienta");
        Integer clientId = scanner.nextInt();
        System.out.println("Podaj id Ticketu");
        Integer ticketId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj tekst wiadomosci");
        String text = scanner.nextLine();

        RegisteredClient client = Client.getClientByID(clientId);
        client.ticketMessage(Ticket.getTicketById(ticketId), text);

        System.out.println("Message " + text + "sent!");
    }

    private static void sendServicerMessage(Scanner scanner) {
        System.out.println("Podaj nazwisko pracownika obslugi klienta");
        String employeeId = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Podaj id Ticketu");
        Integer ticketId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj tekst wiadomosci");
        String text = scanner.nextLine();

        CustomerService customerService = Employee.getCustomerServiceEmployee(employeeId);
        customerService.ticketMessage(Ticket.getTicketById(ticketId), text);

        System.out.println("Message " + text + "sent!");
    }

    private static void displayTicketMessages(Scanner scanner){
        System.out.println("podaj ticket: ");
        Integer ticketID = scanner.nextInt();

        Ticket searchedTicket = Ticket.getTicketById(ticketID);

        searchedTicket.displayTicketMessages();
    }

    private static void saveClients() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("travel_agency.ser"))) {
            oos.writeObject(Client.extension);
            oos.writeObject(Trip.extension);
            oos.writeObject(Employee.extension);
            oos.writeObject(InfoCard.extension);
            oos.writeObject(Ticket.extension);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadClients() {
        File file = new File("travel_agency.ser");
        if (!file.exists()) {
            System.out.println("Brak zapisanego stanu, zaczynamy od pustych danych.");
            return;
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("travel_agency.ser"))) {
            List<Client> loadedClients = (List<Client>) ois.readObject();
            Client.extension.clear();
            Client.extension.addAll(loadedClients);

            List<Trip> loadedTrips = (List<Trip>) ois.readObject();
            Trip.extension.clear();
            Trip.extension.addAll(loadedTrips);

            List<Employee> loadedEmployees = (List<Employee>) ois.readObject();
            Employee.extension.clear();
            Employee.extension.addAll(loadedEmployees);

            List<InfoCard> loadedInfoCards = (List<InfoCard>) ois.readObject();
            InfoCard.extension.clear();
            InfoCard.extension.addAll(loadedInfoCards);

            List<Ticket> loadedTickets = (List<Ticket>) ois.readObject();
            Ticket.extension.clear();
            Ticket.extension.addAll(loadedTickets);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
