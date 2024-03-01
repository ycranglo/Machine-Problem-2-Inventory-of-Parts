
public class Inventory {
  //thsis are the variables that is used in Inventory class
  int partNumber;
  String partDiscription;
  Float price;

  //this is the constructor for Inventory class
  public Inventory(int partNumber, String partDiscriptioString, Float price) {
    this.partDiscription = partDiscriptioString;
    this.partNumber = partNumber;
    this.price = price;
  };
  //this is the default constructor for Inventory class
  public Inventory() {}
  
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

  //this is the function for checking the Part Description
  public Boolean inputValidatePartDiscription(String PartDiscription) {
    Boolean isValidate = false;
    //this is the lenght require in the Part Description
    int length = 26;
    try {
      int count = 0;
      // this for loop will count the characters in part Description
      for (int i = 0; i < PartDiscription.length(); i++) {
        if (Character.isLetter(PartDiscription.charAt(i))) {
          count++;
        }
        ;
      }
      /*
       * checking if the Park Description is valid
       * 
       */
      if (count <= length) {
        isValidate = true;
      } else {
        isValidate = false;
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Please input a correct part discription");
    }
    //returning the validation
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

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Please input a correct part number");
      isValidate = false;
    }

    return isValidate;
  }
};
