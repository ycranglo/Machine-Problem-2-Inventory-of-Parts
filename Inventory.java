
public class Inventory {
  // thsis are the variables that is used in Inventory class
  int partNumber;
  String partDiscription;
  Float price;

  // this is the constructor for Inventory class
  public Inventory(int partNumber, String partDiscriptioString, Float price) {
    this.partDiscription = partDiscriptioString;
    this.partNumber = partNumber;
    this.price = price;
  };

  // this is the default constructor for Inventory class
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

  // this is the function for checking the Part Description
  public Boolean inputValidatePartDiscription(String PartDiscription) {
    Boolean isValidate = false;
    // this is the lenght require in the Part Description
    int maxLength = 26;

    if (PartDiscription.length() > maxLength) {
      isValidate = true;
    }
    // returning the validation
    return isValidate;
  }

  public boolean inputValidatePartNumber(String partNumber) {
    int maxLength = 10;
    boolean isValidate = false;

    if (partNumber.length() != maxLength || partNumber.matches(".*[a-zA-Z].*")) {
      isValidate = true;
    }

    return isValidate;
  }
  
  public boolean inputValidatePrice(String price) {
    boolean isValidate = false;

    if (price.matches(".*[a-zA-Z].*")) {
      isValidate = true;
    }

    return isValidate;
  }
}
