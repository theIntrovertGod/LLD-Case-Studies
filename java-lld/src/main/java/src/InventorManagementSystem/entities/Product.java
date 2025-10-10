package src.InventorManagementSystem.entities;

public class Product {
    private final String productId;
    private final String productName;
    private final String productDescription;

    private Product(ProductBuilder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.productDescription = builder.productDescription;
    }

    public String getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }

    public String getProductDescription(){
        return productDescription;
    }


    public static class ProductBuilder {
        private String productId;
        private String productName;
        private String productDescription;

        public ProductBuilder (String productId) {
            this.productId = productId;
        }

        public ProductBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder productDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Product build() {
            if(productName == null || productName.trim().isEmpty()){
                throw new IllegalArgumentException("product name cannot be empty");
            }
            return new Product(this);
        }
    }
}
