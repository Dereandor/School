import java.util.Scanner;

public class CurrencyExchangeClient
{
   public static void main(String[] args)
    {
       Scanner scan = new Scanner(System.in); // you should use this scanner object for getting inputs


        System.out.print("Enter a dollar amount: ");
        double dollars = scan.nextDouble();

        System.out.println("Enter the currency to convert to (1) euro, (2) pound, (3) taka, (4) yen, (5) rupees : ");
        int response = scan.nextInt();

         CurrencyExchange currencyExchange = new CurrencyExchange(dollars);



        if (response == 1 || response == 2 || response == 3  || response == 4 || response == 5)
        dollars = scan.nextDouble();

        switch (response)
        {
           case 1: //getEuro();  // modified here to get the exact results as you need.
				currencyExchange.setEuro(dollars); // this will convert the entered dollar into euros
				System.out.println(currencyExchange.getEuro());// this will display the result
				break;
            case 2: //getPound();
				currencyExhange.setPound(dollars);
				System.out.println(currencyExchange.getPound());
				break;
            case 3: //getTaka();
                currencyExchange.setTaka(dollars);
                System.out.println(currencyExchange.getPound());
                break;
            case 4: //getYen();
                currencyExchange.setYen(dollars);
                System.out.println(currencyExchange.getPound());
                break;
            case 5: //getRupees();
                currencyExchange.setRupees(dollars);
                System.out.println(currencyExchange.getRupees());
                break;

            default: System.out.println("Invalid Response");
        }

        System.out.println(getCurrency());



    }
}