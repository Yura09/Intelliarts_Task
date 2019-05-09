import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        List<Purchase> purchases = new ArrayList<>();
        int i=0;
        Scanner scanner = new Scanner(System.in);

        String s=scanner.next();
        while (s.equals("purchase")) {

            purchases.add(new Purchase(scanner.next(), scanner.nextInt(), scanner.next(), scanner.next()));
            i++;
            System.out.println("element has been added");

            if(!s.equals("purchase"))
                break;
            s=scanner.next();
        }
        while (scanner.hasNextLine() && !s.equals("end")) {
            if (s.equals("all")) {
                purchases.sort(Comparator.comparing(Purchase::getDate));
                if(purchases.size()==0)
                {
                    System.out.println("purchases are absent");
                    break;
                }
                System.out.println(purchases.get(0).getDateS());
                System.out.println(purchases.get(0));
                for (int j = 1; j < purchases.size(); j++) {
                    if (purchases.get(j).getDateS().equals(purchases.get(j - 1).getDateS())) {
                        System.out.println(purchases.get(j));
                    } else {
                        System.out.println();
                        System.out.println(purchases.get(j).getDateS());
                        System.out.println(purchases.get(j));
                    }
                }
                s=scanner.next();

            } else if (s.equals("clear")) {
                String del = scanner.next();

                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


                Iterator<Purchase> purchaseIteratorDel = purchases.iterator();
                while (purchaseIteratorDel.hasNext()) {

                    Purchase nextpurchase = purchaseIteratorDel.next();
                    if (nextpurchase.getDate().equals(sdf.parse(del))) {
                        purchaseIteratorDel.remove();
                        System.out.println("deleted");

                    }
                }

                s=scanner.next();

            }

        }
    }

}
