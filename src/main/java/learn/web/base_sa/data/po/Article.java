package learn.web.base_sa.data.po;

/**
 * Created by Vigo on 17/2/23.
 */
public class Article{

    String id;

    String name;

    String type;

    public Article(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
