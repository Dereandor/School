public class CurrencyExchange
{
   private double dollar;
    private double euro, pound, taka, yen, rupees;
    private double currency;

    private static final double EURO = 0.7650;
    private static final double POUND = 0.6370;
    private static final double TAKA = 79.0000;
    private static final double YEN = 78.0000;
    private static final double RUPEES = 52.2500;

    public CurrencyExchange()
    {
       dollar = 0;
    }

    public CurrencyExchange(double dollars)
    {
       dollar = dollars;
    }

    public void setEuro (double dollars)
    {
       euro = dollars * EURO;
    }

    public double getEuro()
    {
       return euro;
    }

    public void setPound (double dollars)
    {
       pound = dollars * POUND;
    }

    public double getPound()
    {
       return pound;
    }

    public void setTaka (double dollars)
    {
       taka = dollars * TAKA;
    }

    public double getTaka()
    {
       return taka;
    }

    public void setYen  (double dollars)
    {
       yen = dollars * YEN;
    }

    public double getYen()
    {
       return yen;
    }

    public void setRupees (double dollars)
    {
       rupees = dollars * RUPEES;
    }

    public double getRupees()
    {
       return rupees;
    }

    public double getCurrency()
    {
       return currency;
    }
  }