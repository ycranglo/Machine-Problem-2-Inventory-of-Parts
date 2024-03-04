
/*
 *ikaw nalang mag tuloy nito kent di ko alam yung format eh
 * name:Escobañas, Kent Cedric F.
 * name:Yocor, Angelo T.
 *
 */
import java.io.IOException;
import java.util.Scanner;

public class Main {
  static String partNum =" ";
  static String input = " ";
  static String PartDescription =" ";
  static String price = " ";
  static long findPartNum;
  static long ParkNum2;

  public static void main(String[] args) throws IOException {
    // this are the instance of the objects of Inventory and Transaction class
    Inventory inv = new Inventory();
    Transaction transact = new Transaction();
    // creating a instance of scanner
    Scanner scanner = new Scanner(System.in);

    System.out.println("Machine Problem#2-Inventory of Parts");
    spaces(2);

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
        ParkNum2 = Long.parseLong(partNum);
        System.out.println();
        // Additional validation for presence of characters
        while (inv.inputValidatePartNumber(partNum) || transact.findPartNum(ParkNum2)) {
          displayErrorPartNum();
          System.out.print(">>");
          partNum = scanner.nextLine();
          ParkNum2 = Long.parseLong(partNum);
          System.out.println();
        }
        spaces(2);
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
        spaces(2);
        System.out.println("Price must only contain numbers");
        System.out.println("Enter a Price :");
        System.out.print(">>");
        price = scanner.nextLine();
        System.out.println();

        while (inv.inputValidatePrice(price)) {
          displayErrorPrice();
          System.out.print(">>");
          price = scanner.nextLine();
          System.out.println();
        }
        float Price = Float.parseFloat(price);
        Long ParkNum = Long.parseLong(partNum);
        transact.createInventoryArray(ParkNum, PartDescription, Price, false);
        System.out.println("Record successfully created!!");
        System.out.println();
        System.out.println(transact.CountRecords);
        transact.displayAllRecords();
        System.out.println();
      } else if (input.equalsIgnoreCase("c")) {
        System.out.println("Part Number must only contain 10 digits");
        System.out.println("Enter a Part Number :");
        System.out.print(">>");
        partNum = scanner.nextLine();
        System.out.println();
        // Additional validation for presence of characters
        while (inv.inputValidatePartNumber(partNum)) {
          displayErrorPartNum();
          System.out.print(">>");
          partNum = scanner.nextLine();
          System.out.println();
        }
        findPartNum = Long.parseLong(partNum);
        if (transact.findPartNum(findPartNum)) {
          System.out.println("part Number found!");
          System.out.println();
        } else {
          while (!transact.findPartNum(findPartNum)) {
            System.out.println("Part number cant find, try again");
            System.out.print(">>");
            partNum = scanner.nextLine();
            findPartNum = Long.parseLong(partNum);
            System.out.println();
          }
          System.out.println("part Number found!");
        }
        System.out.println("What do you want to change?");
        System.out.println("P-Price");
        System.out.println("D-Description");
        String choice = scanner.nextLine();
        System.out.println();
        while (checkChoice(input)) {
          System.out.println("Please Enter a Valid input :");
          System.out.print(">>");
          input = scanner.nextLine();
          System.out.println();
        }
        if (choice.equalsIgnoreCase("p")) {
          System.out.println("Price must only contain numbers");
          System.out.println("Enter a new Price :");
          System.out.print(">>");
          price = scanner.nextLine();
          System.out.println();
          while (inv.inputValidatePrice(price)) {
            displayErrorPrice();
            System.out.print(">>");
            price = scanner.nextLine();
            System.out.println();
          }
          float Price = Float.parseFloat(price);
          if (transact.updateRecordPrice(findPartNum, Price)) {
            System.out.println("Price updated successfully");
            transact.displayAllRecords();
          } else {
            System.out.println("something went wrong...");
          }
          System.out.println();

        } else if (choice.equalsIgnoreCase("d")) {
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
          if (transact.updateRecordDescription(findPartNum, PartDescription)) {
            System.out.println("Price updated successfully");
            transact.displayAllRecords();
          } else {
            System.out.println("something went wrong...");
          }
        }
        System.out.println();
      } else {
        System.out.println("Part Number must only contain 10 digits");
        System.out.println("Enter a Part Number :");
        System.out.print(">>");
        partNum = scanner.nextLine();
        System.out.println();
        // Additional validation for presence of characters
        while (inv.inputValidatePartNumber(partNum)) {
          displayErrorPartNum();
          System.out.print(">>");
          partNum = scanner.nextLine();
          System.out.println();
        }
        findPartNum = Long.parseLong(partNum);
        if (transact.findPartNum(findPartNum)) {
          System.out.println("part Number found!");
          System.out.println();
        } else {
          while (!transact.findPartNum(findPartNum)) {
            System.out.println("Part number cant find, try again");
            System.out.print(">>");
            partNum = scanner.nextLine();
            findPartNum = Long.parseLong(partNum);
            System.out.println();
          }
          System.out.println("part Number found!");
        }
        if (transact.Delete(findPartNum)) {
          System.out.println("successfully deleted part Number :" + findPartNum);
          transact.displayAllRecords();
        } else {
          System.out.println("something went wrong...");
        }
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

  public static Boolean checkChoiceChange(String input) {
    Boolean isValid = true;
    if (input.equalsIgnoreCase("p") || input
        .equalsIgnoreCase("d")) {
      isValid = false;
    }
    return isValid;
  }

  public static void displayErrorPartNum() {
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

  public static void spaces(int HowManyLines) {
    for (int a = 0; a < HowManyLines; a++) {
      System.out.println();
    }
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