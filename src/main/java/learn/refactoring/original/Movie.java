package learn.refactoring.original;

/**
 * Created by Vigo on 17/1/9.
 */
public class Movie {
    /**
     * 电影类型：儿童片、新片、普通片
     */
    public static final int  CHILDRENS = 2;
    public static final int  NEW_RELEEASE = 1;
    public static final int  REGULAR = 0;

    private String _title;
    private  int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public String get_title() {
        return _title;
    }

    public Movie set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
        return this;
    }
}
