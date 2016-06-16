package learn.design_pattern.builder.multi_params;

/**
 * Created by Vigo on 16/6/16.
 */
public class Product {

    private String name;

    private String type;

    private String price;

    private String color;

    private String shape;

    public Product(ProductBuilder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.price = builder.price;
        this.color = builder.color;
        this.shape = builder.shape;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", color='" + color + '\'' +
                ", shape='" + shape + '\'' +
                '}';
    }

    /**
     * build class
     */
    static class ProductBuilder {

        private String name;

        private String type;

        private String price;

        private String color;

        private String shape;

        public ProductBuilder(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public ProductBuilder setPrice(String price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public ProductBuilder setShape(String shape) {
            this.shape = shape;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
