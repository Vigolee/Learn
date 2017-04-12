package learn.refactoring.refactor;

/**
 * Created by Vigo on 17/1/9.
 */
public abstract class Price {
    abstract int getPriceCode();

    /**
     * 计算租用单部电影价格
     * @param daysRented
     * @return
     */
    public abstract double getCharge(int daysRented);


    public int getFrequentRenterPoints(int daysRented){
        
        return 1;
    }
}
