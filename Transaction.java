public class Transaction extends Inventory {
  int CountRecords;
  Inventory[] records;

  public Transaction(int partNumber, String partDiscriptioString, Float price) {
    super(partNumber, partDiscriptioString, price);
    createInventoryArray(partNumber, partDiscriptioString, price);
  }

  public Transaction() {
    
  }

  // creating a record
  public void createInventoryArray(int partNumber, String partDiscriptioString, Float price) {
    records = new Inventory[1000];
    records[CountRecords] = new Inventory(partNumber, partDiscriptioString, price);
    CountRecords++;
  }

  // updating the inventory
  public void updateRecordPrice(int partNumber, Float newPrice) {
    try {
      // looping tru the records
      for (int i = 0; i < CountRecords; i++) {
        // if the partnumber is find, it will be update
        if (records[i].getPartNumber() == partNumber) {
          records[i].setPrice(newPrice);
          System.out.println("Record updated successfully.");
          return;
        }
      }
      // if not it will trow and error message
      System.out.println("Record not found for partNumber: " + partNumber);
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("wrong input park number please try again");
    }
  }
  
  public void updateRecordPrice(int partNumber, String NewpartDiscription) {
    try {
      // looping tru the records
      for (int i = 0; i < CountRecords; i++) {
        // if the partnumber is find, it will be update
        if (records[i].getPartNumber() == partNumber) {
          records[i].setpartDiscription(NewpartDiscription);
          System.out.println("Record updated successfully.");
          return;
        }
      }
      // if not it will trow and error message
      System.out.println("Record not found for partNumber: " + partNumber);
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("wrong input park number please try again");
    }
  }

  public void displayAllRecords() {
    for (int i = 0; i < CountRecords; i++) {
      
      System.out.println("PartNumber     | Description     | Price     |");
      System.out.println(records[i].partNumber+"   "+ records[i].partDiscription+"     "+ records[i].price);
    }
  }
}
