import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws IOException {
    Inventory inv = new Inventory();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Machine Problem#2-Inventory of Parts");
    System.out.println();
    
    do {
      System.out.println("Select an operation :");
      System.out.println("A-add");
      System.out.println("C-Update");
      System.out.println("D-Delete");
      System.out.println("X-Exit");
      String input = reader.readLine();

      if (input == "A" || input == "a") {
        System.out.println("Enter a Part Number");

      }
    } while (true);
  }
}
