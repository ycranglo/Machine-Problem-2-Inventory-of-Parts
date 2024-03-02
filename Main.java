
/*
 *ikaw nalang mag tuloy nito kent di ko alam yung format eh
 * name:Escobañas, Kent Cedric F.
 * name:Yocor, Angelo T.
 *
 */
import java.io.IOException;
import java.util.Scanner;

public class Main {
  static String partNum;
  static String input;
  static String PartDescription;
  static String price;

  public static void main(String[] args) throws IOException {
    // this are the instance of the objects of Inventory and Transaction class
    Inventory inv = new Inventory();
    Transaction transact = new Transaction();
    // creating a instance of scanner
    Scanner scanner = new Scanner(System.in);

    System.out.println("Machine Problem#2-Inventory of Parts");
    System.out.println();
    System.out.println();

    do {
      displayMenu();
      System.out.print(">>");
      input = scanner.nextLine();
      System.out.println();
      while (checkChoice(input)) {
        System.out.println("Please Enter a Valid input :");
        System.out.print(">>");
        input = scanner.nextLine();
        System.out.println();
      }

      if (input.equalsIgnoreCase("A")) {
        System.out.println("Part Number must only contain 10 digits");
        System.out.println("Enter a Part Number :");
        System.out.print(">>");
        partNum = scanner.nextLine();
        System.out.println();
          // Additional validation for presence of characters
          while (inv.inputValidatePartNumber(partNum)) {
            displayErrorParkNum();
            System.out.print(">>");
            partNum = scanner.nextLine();
            System.out.println();
          }
          System.out.println();
          System.out.println();
          System.out.println("Part Description must only contain 26 character");
          System.out.println("Enter a Part Description :");
          System.out.print(">>");
          PartDescription = scanner.nextLine();
          System.out.println();
          
          while (inv.inputValidatePartDiscription(PartDescription)) {
            displayErrorParkDescription();
            System.out.print(">>");
            PartDescription = scanner.nextLine();
            System.out.println();
          }
          System.out.println();
          System.out.println();
          System.out.println("Price must only contain numbers");
          System.out.println("Enter a Part Description :");
          System.out.print(">>");
          price = scanner.nextLine();
          System.out.println();

          while (inv.inputValidatePrice(price)) {
            displayErrorParkDescription();
            System.out.print(">>");
            price = scanner.nextLine();
            System.out.println();
          }
          float Price = Float.parseFloat(price);
          int ParkNum = Integer.parseInt(partNum);
          transact.createInventoryArray(ParkNum, PartDescription, Price);
          System.out.println("Record successfully created!!");
          System.out.println();
          transact.displayAllRecords();
          System.out.println();
      }else if(input.equalsIgnoreCase("c")){
        
      }

    } while (!input.equalsIgnoreCase("X"));
    System.out.println("EXITED THE PROGRAM...");
    System.out.println("THANK YOU FOR USING...");
  }

  public static Boolean checkChoice(String input) {
    Boolean isValid = true;
    if (input.equalsIgnoreCase("a") || input.equalsIgnoreCase("c") || input.equalsIgnoreCase("d") || input
        .equalsIgnoreCase("x")) {
      isValid = false;
    }
    return isValid;
  }

  public static void displayErrorParkNum() {
    System.out.println("Error Message: Invalid input. Enter a valid Part Number ");
    System.out.println("Part Number must only contain 10 digits");
    System.out.println("Enter again a Part Number :");
  }

  public static void displayErrorParkDescription() {
    System.out.println("Error Message: Invalid input. Enter a valid Part Description");
    System.out.println("Part Description must only contain 26 character");
    System.out.println("Enter a Part Description :");
  }
  
  public static void displayErrorPrice() {
    System.out.println("Error Message: Invalid input. Enter a valid Price");
    System.out.println("Price must only contain numbers");
    System.out.println("Enter a Price :");
  }

  public static void displayMenu() {
    System.out.println();
    System.out.println("Select an operation :");
    System.out.println("A-add");
    System.out.println("C-Change");
    System.out.println("D-Delete");
    System.out.println("X-Exit");
  }
}