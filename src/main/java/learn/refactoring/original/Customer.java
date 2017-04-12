package learn.refactoring.original;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Vigo on 17/1/9.
 */
public class Customer {
    private String _name;
    private ArrayList<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental arg){
        this._rentals.add(arg);
    }

    public String get_name() {
        return _name;
    }

    public String statement(){
        double totalAmount = 0;// 总费用
        int frequentRenterPoints = 0; // 积分
        String result = "Rental Record for " + get_name() + "\n";
        Iterator<Rental> rentals = _rentals.iterator();
        while (rentals.hasNext()){
            double thisAmount = 0;// 单部电影费用
            Rental each = rentals.next();
            /**
             * 根据电影类型，租借费用
             */
            switch (each.get_movie().get_priceCode()){
                case Movie.CHILDRENS:
                    thisAmount += 2;
                    if (each.get_daysRented() > 2)
                        thisAmount += (each.get_daysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEEASE:
                    thisAmount += each.get_daysRented() * 3;
                    break;
                case Movie.REGULAR:
                    thisAmount += 1.5;
                    if (each.get_daysRented() > 3)
                        thisAmount += (each.get_daysRented() - 3) * 1.5;
                    break;

            }

            frequentRenterPoints++;

            if ((each.get_movie().get_priceCode() == Movie.NEW_RELEEASE) &&
                    each.get_daysRented() > 1) frequentRenterPoints++;

            result += "\t" + each.get_movie().get_title() + "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + "\n";
        return result;
    }
}
