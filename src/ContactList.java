/** ContactList.java
 * Stefan Perkovic January, 20 2023
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 */
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class ContactList
{
    public static final int FIRST_NAME = 0;
    public static final int LAST_NAME = 1;
    public static final int PHONE_NUMBER = 2;
    public static final int STUDENT = 1;
    public static final int PRISONER = 2;
    public static final int NEW_CONTACT = 1;
    public static final int LIST_FIRST_NAME = 2;
    public static final int LIST_LAST_NAME = 3;
    public static final int LIST_PHONE_NUMBER = 4;
    public static final int LIST_STUDENTS = 5;
    public static final int SEARCH_FIRST_NAME = 6;
    public static final int SEARCH_LAST_NAME = 7;
    public static final int SEARCH_PHONE_NUMBER = 8;
    public static final int EXIT = 8;

    ArrayList<Person> contacts;


    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     * Checks if their a student or person
     */
    public void addContact() {
        System.out.println("Select a type of contact to add");
        System.out.println("1. Student");
        System.out.println("2. Prisoner");
        Scanner input = new Scanner(System.in);
        int type = input.nextInt();
        System.out.println("Please fill in the following information");
        System.out.println("First Name:");
        String fName = input.next();
        System.out.println("Last Name:");
        String lName = input.next();
        System.out.println("Phone Number:");
        String phoneNumber = input.next();
        if (type == STUDENT){
            System.out.println("Grade");
            int grade = input.nextInt();
            Student s = new Student(fName, lName, phoneNumber, grade);
            contacts.add(s);
        }
        else if (type == PRISONER){
            System.out.print("Crime:");
            System.out.println();
            String crime = input.next();
            Prisoner p = new Prisoner(fName, lName, phoneNumber, crime);
            contacts.add(p);
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        for (int i = 0; i < contacts.size(); i++){
            System.out.println(contacts.get(i));
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        int length = contacts.size() - 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (sortBy == FIRST_NAME) {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        shift(j);
                    }
                }
                else if (sortBy == LAST_NAME) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        shift(j);
                    }
                }
                else if (sortBy == PHONE_NUMBER) {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        shift(j);
                    }
                }
            }
        }
    }

    /**
     * Shifts the order of the arraylist
     * @param pos is position of shifted item
     */
    public void shift(int pos){
        Person holder = contacts.get(pos);
        contacts.set(pos, contacts.get(pos + 1));
        contacts.set(pos + 1, holder);
    }

    /**
     * Searches list for person with given first name
     * @returns Person or null
     */
    public Person searchByFirstName(String firstName){
        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i).getFirstName().equals(firstName)){
                System.out.println(contacts.get(i));
                return contacts.get(i);
            }
        }
        System.out.println(firstName + "is not in the list");
        return null;
    }

    /**
     * Searches list for person with given last name
     * @returns Person or null
     */
    public Person searchByLastName(String lastName){
        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i).getLastName().equals(lastName)){
                System.out.println(contacts.get(i));
                return contacts.get(i);
            }
        }
        System.out.println(lastName + "is not in the list");
        return null;
    }
    /**
     * Searches list for person with given phone number
     * @returns Person or null
     */
    public Person searchByPhoneNumber(String phoneNumber){
         for (int i = 0; i < contacts.size(); i++){
             if (contacts.get(i).getPhoneNumber().equals(phoneNumber)){
                 System.out.println(contacts.get(i));
                 return contacts.get(i);
             }
         }
        System.out.println(phoneNumber + "is not in the list");
         return null;
     }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i) instanceof Student){
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 0){
            printMenuOptions();
            choice = input.nextInt();
            if (choice == NEW_CONTACT){
                addContact();
            }
            else if (choice == LIST_FIRST_NAME){
                sort(0);
                for (int i = 0; i < contacts.size(); i++){
                    System.out.println(contacts.get(i).getFirstName());
                }
            }
            else if (choice == LIST_LAST_NAME) {
                sort(1);
                for (int i = 0; i < contacts.size(); i++) {
                    System.out.println(contacts.get(i).getLastName());
                }
            }
            else if (choice == LIST_PHONE_NUMBER){
                sort(2);
                for (int i = 0; i < contacts.size(); i++){
                    System.out.println(contacts.get(i).getPhoneNumber());
                }
            }
            else if (choice == LIST_STUDENTS){
                listStudents();
            }
            else if (choice == SEARCH_FIRST_NAME){
                System.out.println("Enter a name:");
                String name = input.next();
                searchByFirstName(name);
            }
            else if (choice == SEARCH_LAST_NAME){
                System.out.println("Enter a name:");
                String name = input.next();
                searchByLastName(name);
            }
            else if (choice == SEARCH_PHONE_NUMBER){
                System.out.println("Enter a phone number:");
                String number = input.next();
                searchByPhoneNumber(number);
            }
            else if (choice == EXIT){
                break;
            }
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
