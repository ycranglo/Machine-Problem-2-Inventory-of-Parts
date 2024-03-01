import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int partNum;
  public static void main(String[] args) throws IOException {
    //this are the instance of the objects of Inventory and Transaction class
    Inventory inv = new Inventory();
    Transaction transacs = new Transaction();
    //creating a intance of BufferedReader
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Machine Problem#2-Inventory of Parts");
    System.out.println();
    System.out.println();


    do {
      ///displaying the records of Inventory
      transacs.displayAllRecords();
      System.out.println();
      //displaying the menu for the user
      System.out.println("Select an operation :");
      System.out.println("A-add");
      System.out.println("C-Update");
      System.out.println("D-Delete");
      System.out.println("X-Exit");
      String input = reader.readLine();

      //a 
      if (input == "A" || input == "a") {
        Boolean isValidate = false;
        System.out.println("Enter a Part Number");
        partNum = Integer.parseInt(reader.readLine());
        /*
         * creating a variable that holds the result boolean in functions call
         * calling the function in Inventory class to check if the part number that the user
         * inputted is exceed to 10
         */
        Boolean isValid =inv.inputValidatePartNumber(partNum);
        /*
         * Additional validation for presence of characters
         * Checking the input user if it has a character
         */
        if (String.valueOf(partNum).matches(".*[a-zA-Z].*") || isValid) {
          isValidate = true;
        } else {
          isValidate = false;
        }
        /*
         * if the if statement is satisfied, the while block will work until  certain condition
         * satisfied0
         */
        while (isValidate) {
          System.out.println("Enter a Part Number");
          partNum = Integer.parseInt(reader.readLine());
          // we use a regex to check the inout
          if (String.valueOf(partNum).matches(".*[a-zA-Z].*") || isValid) {
            isValidate = true;
          } else {
            isValidate = false;
          }
        }
      }
    } while (true);
  }
}