import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Currency;
import java.util.Date;

public class Purchase {
    private  Date date;
    private  int money;
    private Currency currency;
    private String nameOfProduct;
    Purchase(String date, int money, String currency, String nameOfProduct) throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // String dateInString = "31-08-1982 10:20:56";

        this.date = sdf.parse(date);

        //this.date = new Date("yyyy-MM-dd");
        this.money = money;
        this.currency = Currency.getInstance(currency);
        this.nameOfProduct = nameOfProduct;
    }

    public Date getDate() {
        return date;
    }

    Purchase()
    {

    }

    public int getMoney() {
        return money;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setDate(String date) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // String dateInString = "31-08-1982 10:20:56";

        try {
            this.date = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public  String getDateS()
    {SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(this.date);
        return date;

    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(this.date);

        return  nameOfProduct+ " "+ money+" " + currency;
    }

}

