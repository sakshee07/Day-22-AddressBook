package com.adressbook.bl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class AddressBook {

      ArrayList<Contacts> list = new ArrayList<Contacts>();

     void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter firstname to Delete Contact: ");
        String name = scanner.nextLine();
        for (Contacts nameTodelete : list) {
            if (name.equalsIgnoreCase(nameTodelete.getFirstName())) {
                System.out.println("Entered name found in the Address Book, deleting contact");
                list.remove(nameTodelete);
            } else {
                System.out.println("Entered name not found in the Address Book");
            }
        }
    }

     
     void searchByCity( ) {
    	 Scanner scanner = new Scanner(System.in);
    	 System.out.println("Enter city name :");
    	 String searchCity = scanner.next();
    	 list.stream()
    	 .filter(a ->a.getCity()
    	.equals(searchCity))
    	 .forEach(a->System.out.println(a.getFirstName()));
     }
     
     
     void seachByState() {
    	 Scanner scanner = new Scanner(System.in);
    	 System.out.println("Enter state name :");
    	 String searchState = scanner.next();
    	 list.stream()
    	 .filter(a->a.getState()
    			 .equals(searchState))
    	 .forEach(a->System.out.println(a));
     }
   
     void editContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter firstname to edit contact: ");
        String name = sc.nextLine();
        for (Contacts searchName : list) {
            if (name.equalsIgnoreCase(searchName.getFirstName())) {
                System.out.println("Entered name found in the Contacts");
                System.out.println("Enter the updated first name");
                String firstName = sc.next();
                searchName.setFirstName(firstName);
                System.out.println("Enter the updated last name");
                String lastName = sc.next();
                searchName.setLastName(lastName);
                System.out.println("Enter the updated address");
                String address = sc.next();
                searchName.setAddress(address);
                System.out.println("Enter the updated city");
                String city = sc.next();
                searchName.setCity(city);
                System.out.println("Enter the updated state");
                String state = sc.next();
                searchName.setState(state);
                System.out.println("Enter the updated zipcode");
                int zip = sc.nextInt();
                searchName.setZip(zip);
                System.out.println("Enter the updated phoneNumber");
                long phoneNumber = sc.nextInt();
                searchName.setPhoneNumber(phoneNumber);
                System.out.println("Enter the updated emailID");
                String email = sc.next();
                searchName.setEmail(email);
                searchName.toString();
            } else {
                System.out.println("Entered name not found in the AddressBook");
            }
        }
    }
     
    

    public void AddContactsDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("First Name : ");
        String firstName = sc.nextLine();
        System.out.println("Last Name : ");
        String lastName = sc.nextLine();
        System.out.println("Address : ");
        String address = sc.nextLine();
        System.out.println("City : ");
        String city = sc.nextLine();
        System.out.println("State : ");
        String state = sc.nextLine();
        System.out.println("Zip Code  ");
        int zip = sc.nextInt();
        System.out.println("Phone Number :" );
        long phoneNumber = sc.nextLong();
        System.out.println("Email : ");
        String email = sc.nextLine();
        Contacts person = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
        list.add(person);
        
        person.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, AddressBook> addressBooks = new HashMap<>();
        AddressBook addressBook1 = new AddressBook();
        AddressBook addressBook2 = new AddressBook();
        AddressBook addressBook3 = new AddressBook();
        addressBooks.put("AddressBook1", addressBook1);
        addressBooks.put("AddressBook2", addressBook2);
        addressBooks.put("AddressBook3", addressBook3);
        System.out.println("Choose Address Book");
        System.out.println("1. AddressBook 1");
        System.out.println("2. AddressBook 2");
        System.out.println("3. AddressBook 3");
        int chooseAddressBook = scanner.nextInt();
        System.out.println("Choose What to do in this Address Book");
        while (chooseAddressBook >= 1) {
            System.out.println(" ");
            System.out.println("1. Add Contacts 2. Edit Contacts"
            		+ " 3. Delete Contacts 4. Search by city 5. Search by state ");
            System.out.println("Enter Your Choice");
            int choice = scanner.nextInt();
            switch (chooseAddressBook) {
                case 1:
                    if (choice == 1) {
                        addressBook1.AddContactsDetails();
                    } else if (choice == 2) {
                        addressBook1.editContact();
                    } else if (choice == 3) {
                        addressBook1.deleteContact();
                    } else if (choice == 4) {
                    	addressBook1.searchByCity();
                    	
                    }else if(choice == 5) {
                    	addressBook1.seachByState();
                    }
                    break;
                case 2:
                    if (choice == 1) {
                        addressBook2.AddContactsDetails();
                    } else if (choice == 2) {
                        addressBook2.editContact();
                    } else if (choice == 3) {
                        addressBook2.deleteContact();
                    }else if(choice == 4) {
                    	addressBook2.searchByCity();
                    }else if(choice == 5) {
                    	addressBook2.seachByState();
                    }
                    break;
                case 3:
                    if (choice == 1) {
                        addressBook3.AddContactsDetails();
                    } else if (choice == 2) {
                        addressBook3.editContact();
                    } else if (choice == 3) {
                        addressBook3.deleteContact();
                    } else if (choice == 4) {
                    	addressBook3.searchByCity();
                    } else if(choice == 5) {
                    	addressBook3.seachByState();
                    }
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
                    
                
                	
            }
            System.out.println("1. AddressBook 1");
            System.out.println("2. AddressBook 2");
            System.out.println("3. AddressBook 3");
            System.out.println("0. Exit");
            chooseAddressBook = scanner.nextInt();

        }
        System.out.println("Thank you for using addressbook");
    }

}

