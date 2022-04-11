import java.util.Scanner;

public class BankingSystemSim {
  public static void main(String[] args) {
    headerMessage();
    transaction();
  }

  private static void transaction() {
    // Request Input from User
    Scanner scan = new Scanner(System.in);

    System.out.print("Please Enter Your Name: ");
    String name = scan.nextLine();
    System.out.print("Please Choose from the Options: ");
    byte choice = scan.nextByte();
    double currentFunds = 10000;
    String currency = "php";
    
    while(choice != 0){
      currentFunds = selectTransaction(name, currency, currentFunds, choice);
      System.out.println("Please Enter 0 to exit or Continue Transaction by Entering an Option");
      choice = scan.nextByte();
    }
    scan.close();

    System.out.println("Mr./Ms." + name.toUpperCase() + "\nCurrent Funds: " + currentFunds + "\nCurrency: " + currency.toUpperCase());
  }

  private static double selectTransaction(String name, String currency, double currentFunds, byte choice){

    switch(choice){
      case 1: 
        System.out.println("Mr./Ms." + name.toUpperCase() + "\nCurrent Funds: " + currentFunds + "\nCurrency: " + currency.toUpperCase());
        break;
      case 2: 
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter amount to add to your fundings");
        double amt = scan2.nextDouble();
        while(amt < 500 || currentFunds == 0){
          System.out.println("Invalid Amount! Please Try Again");
          amt = scan2.nextDouble();
        }
        currentFunds = addFunds(amt, currentFunds);
        System.out.println("Mr./Ms." + name.toUpperCase() + "\nCurrent Funds: " + currentFunds + "\nCurrency: " + currency.toUpperCase());
        return currentFunds;
      case 3:
        Scanner scan3 = new Scanner(System.in);
        double amt3 = scan3.nextDouble();
        while(amt3 < 500 || currentFunds == 0){
          System.out.println("Invalid Amount! Please Try Again");
          amt3 = scan3.nextDouble();
        }
        currentFunds = withdrawFunds(amt3, currentFunds);
        System.out.println("Mr./Ms." + name.toUpperCase() + "\nCurrent Funds: " + currentFunds + "\nCurrency: " + currency.toUpperCase());
        return currentFunds;
      case 4:
        Scanner scan4 = new Scanner(System.in);
        System.out.println("Please Enter Currency You Want To Convert Your Funds");
        currency = scan4.next().toUpperCase();

        switch(currency){
          case "JPY": 
            double jpy = 2.41;
            currentFunds = Math.round(converter(currentFunds , jpy));
            System.out.println("Mr./Ms." + name.toUpperCase() + "\nCurrent Funds: " + currentFunds + "\nCurrency: " + currency.toUpperCase());
            break;
          case "CAD": 
            double cad = 0.024;
            currentFunds = Math.round(converter(currentFunds , cad));
            System.out.println("Mr./Ms." + name.toUpperCase() + "\nCurrent Funds: " + currentFunds + "\nCurrency: " + currency.toUpperCase());
            break;
          case "USD": 
            double usd = 0.019;
            currentFunds = Math.round(converter(currentFunds , usd));
            System.out.println("Mr./Ms." + name.toUpperCase() + "\nCurrent Funds: " + currentFunds + "\nCurrency: " + currency.toUpperCase());
            break;
          default:
            System.out.println("Not a valid currency! please try again");
            currency = scan4.next().toUpperCase();
        }
    }
    
    return currentFunds;
  }
  private static double converter(double funds, double cur){
    return funds * cur;
  }
  private static double withdrawFunds(double amt , double currentFunds){
    return amt - currentFunds;
  }
  private static double addFunds(double amt , double currentFunds){
    return amt + currentFunds;
  }
  private static void headerMessage() {
    System.out.println();
    System.out.println("<--------------------- Welcome to Sim Banking System ---------------------->");
    System.out.println("<--------------------------------- OPTIONS -------------------------------->");
    System.out.println("0 - Exit Transcation");
    System.out.println("1 - Display Information");
    System.out.println("2 - Add Bank Funds");
    System.out.println("3 - Withdraw Bank Funds");
    System.out.println("4 - Convert Funds");
    System.out.println("   - JPY Japanese Yen");
    System.out.println("   - CAD Canadian Dollar");
    System.out.println("   - USD US Dollar");
    System.out.println("5 - Add User Account");
    System.out.println("<--------------------------------- OPTIONS -------------------------------->");
    System.out.println();
  }
}
