import evento.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManagerImpl();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            System.out.println("Event Management System");
            System.out.println("1. Add Event");
            System.out.println("2. Remove Event");
            System.out.println("3. List Events by Category");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter event name:");
                    String eventName = scanner.nextLine();
                    System.out.println("Enter event date and time (dd/MM/yyyy HH:mm):");
                    String eventDateTime = scanner.nextLine();
                    LocalDateTime dateTime = LocalDateTime.parse(eventDateTime, formatter);

                    System.out.println("Choose event category:");

                    for (EventCategory category : EventCategory.values()) {
                        System.out.println((category.ordinal() + 1) + ". " + category);
                    }

                    int chosenCategoryIndex = scanner.nextInt();
                    scanner.nextLine();
                    EventCategory category = EventCategory.values()[chosenCategoryIndex - 1];

                    EventImpl event = new EventImpl(eventName, dateTime, category);
                    eventManager.addEvent(event);
                    System.out.println("Event added successfully.");
                    break;

                case 3:
                    System.out.println("Choose category to list events:");
                    for (EventCategory cat : EventCategory.values()) {
                        System.out.println((cat.ordinal() + 1) + ". " + cat);
                    }
                    int chosenCategoryForListing = scanner.nextInt();
                    scanner.nextLine();
                    EventCategory categoryForListing = EventCategory.values()[chosenCategoryForListing - 1];
                    List<Event> eventsByCategory = eventManager.listEventsByCategory(categoryForListing);
                    System.out.println("Events by category: " + eventsByCategory);
                    for (Event e : eventsByCategory) {
                        System.out.println("Event: " + e);
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}