
public class Inventory {
  int partNumber;
  String partDiscription;
  Float price;

  public Inventory(int partNumber, String partDiscriptioString, Float price) {

    this.partDiscription = partDiscriptioString;
    this.partNumber = partNumber;
    this.price = price;
  };

  public Inventory() {
    
  }
  
  // setter functions
  public void setPartNumber(int partNumber) {
    this.partNumber = partNumber;
  }

  public void setpartDiscription(String partDiscriptionumber) {
    this.partDiscription = partDiscriptionumber;
  }

  public void setPrice(Float price) {
    this.price = price;
  }
  // getter functions
  public int getPartNumber() {
    return partNumber;
  }

  public String getPartDescription() {
    return partDiscription;
  }

  public Float getPrice() {
    return price;
  }

  public Boolean inputValidatePartDiscription(String PartDiscription) {
    Boolean isValidate = false;
    int length = 26;
    try {
      int count = 0;
      for (int i = 0; i < PartDiscription.length(); i++) {
        if (Character.isLetter(PartDiscription.charAt(i))) {
          count++;
        }
        ;
      }
      ;
      if (count <= length) {
        isValidate = true;
      } else {
        isValidate = false;
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Please input a correct part discription");
    }
    return isValidate;
  }

  public Boolean inputValidatePartNumber(int partNumber) {
    int maxLength = 10;
    Boolean isValidate = true;

    try {
      int count = 0;
      int tempNumber = partNumber;

      while (tempNumber != 0) {
        tempNumber /= 10;
        count++;
      }

      if (count > maxLength) {
        isValidate = false;
      }

        //add this to the main menu
      // // Additional validation for presence of characters
      // if (String.valueOf(partNumber).matches(".*[a-zA-Z].*")) {
      //   isValidate = false;
      // }

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Please input a correct part number");
      isValidate = false;
    }

    return isValidate;
  }

  public static void main(String[] args) {
  System.out.println("hei");
  Inventory inv = new Inventory(0, null, null);

  System.out.println(inv.inputValidatePartNumber(12000312));
  System.out.println(inv.inputValidatePartDiscription(""));
  };
};
