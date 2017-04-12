package learn.refactoring.refactor;

/**
 * Created by Vigo on 17/1/9.
 */
public class Movie {
    /**
     * 电影类型：儿童片、新片、普通片
     */
    public static final int  CHILDRENS = 2;
    public static final int  NEW_RELEASE = 1;
    public static final int  REGULAR = 0;

    private String _title;
    private Price _price;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        set_priceCode(_priceCode);
    }

    public int get_priceCode() {
        return _price.getPriceCode();
    }

    public String get_title() {
        return _title;
    }

    public void set_priceCode(int arg) {
        switch (arg){
            case Movie.CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case Movie.NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            case Movie.REGULAR:
                _price = new RegularPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    /**
     * 计算租用单部电影价格
     * @param daysRented
     * @return
     */
    public double getCharge(int daysRented){

        return _price.getCharge(daysRented);
    }


    public int getFrequentRenterPoints(int daysRented){
        if ((get_priceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1) return 2;
        else
            return 1;
    }
}
