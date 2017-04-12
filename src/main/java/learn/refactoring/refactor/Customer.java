package learn.refactoring.refactor;

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
        String result = "Rental Record for " + get_name() + "\n";
        Iterator<Rental> rentals = _rentals.iterator();
        while (rentals.hasNext()){
            Rental each = rentals.next();

            result += "\t" + each.get_movie().get_title() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + "\n";
        return result;
    }

    /**
     * 总费用
     * @return
     */
    private double getTotalCharge(){
        double result = 0;
        Iterator<Rental> rentals = _rentals.iterator();
        while (rentals.hasNext()){
            Rental each = rentals.next();
            result += each.getCharge();
        }
        return result;
    }

    /**
     * 总积分
     * @return
     */
    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Iterator<Rental> rentals = _rentals.iterator();
        while (rentals.hasNext()){
            Rental each = rentals.next();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
