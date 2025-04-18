// SuperStore Exercise: Access Modifiers & Object Modeling Focus

// TODO: Define a class called Product with:
class Product{
    // - A protected String field called name
    protected String name;
    // - A protected double field called price
    protected double price;
    // - A private final int productId
    private final int productId;

    // - A public static int nextId to help generate unique IDs
    public static int nextId = 1001;

    // - A constructor that sets name, price, and assigns a unique ID
    public Product(String name, double price){
        this.name = name;
        this.price = price;
        productId = nextId++;
    }

    // - Public getters for all fields
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public int getProductId(){
        return this.productId;
    }

    // - Override toString() to return formatted product details
    @Override
    public String toString(){
        return "Product Name: " + this.name + "\nPrice: " + this.price + "\nProduct ID: " + this.productId;
    }

    // - Override equals(Object o) to compare name and productId
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Product)){
            return false;
        }
        if(this == o){
            return true;
        }
        Product product = (Product) o;
        if (name.equals(product.name) && productId == product.productId){
            return true;
        }
        else{
            return false;
        }
    }
}


// TODO: Define a subclass Electronics that extends Product
class Electronics extends Product {
    // - Add a private String field called brand
    private String brand;

    // - Add a private boolean field called hasBattery
    private boolean hasBattery;

    // - Constructor takes all fields and uses super for shared ones
    public Electronics(String name, double price, String brand, boolean hasBattery) {
        super(name, price);
        this.brand = brand;
        this.hasBattery = hasBattery;
    }

    // - Override toString() to include brand and battery status
    @Override
    public String toString() {
        return "Product Name: " + this.name + "\nPrice: " + this.price + "\nBrand: " + this.brand + "\nBattery Status: " + this.hasBattery;
    }

    // 3. Add a method to Electronics called warrantyInfo() and mark it final
    public static final void warrantyInfo(){

    }
}


// TODO: Define a subclass Grocery that extends Product
class Grocery extends Product{
    // - Add a private double field called weight (in kg)
    private double weight;

    // - Add a private boolean field called isPerishable
    private boolean isPerishable;

    // - Constructor takes all fields and uses super for shared ones
    public Grocery(String name, double price, double weight, boolean isPerishable){
        super(name, price);
        this.weight = weight;
        this.isPerishable = isPerishable;
    }

    // - Override toString() to include weight and perishability
    @Override
    public String toString() {
        return "Product Name: " + this.name + "\nPrice: " + this.price + "\nWeight: " + this.weight + "kg\nPerishability: " + this.isPerishable;
    }
}


// TODO: Define a final class Toy that extends Product
final class Toy extends Product{
    // - Add a private int field called minAge
    private int minAge;
    // - Constructor takes all fields and uses super for shared ones
    public Toy(String name, double price, int minAge){
        super(name, price);
        this.minAge = minAge;
    }
    // - Override toString() to include minAge
    @Override
    public String toString() {
        return "Product Name: " + this.name + "\nPrice: " + this.price + "\nMinimum Age: " + this.minAge;
    }
}


// TODO: Define class SuperStoreTest with a main method
class SuperStoreTest{
    public static void main(String[] args) {
        // - Create at least one instance of each subclass
        Product product = new Product("Eggs", 100);
        Electronics electronic = new Electronics("Laptop", 10000, "Windows", true);
        Grocery grocery = new Grocery("Eggs", 100, 3.4,true);
        Toy toy = new Toy("ball", 2.00, 4);
        // - Store them in a Product[] array
        String[] Product = new String[4];
        Product[0] = product.toString();
        Product[1] = electronic.toString();
        Product[2] = grocery.toString();
        Product[3] = toy.toString();

        // - Loop through and print each item
        for (int i=0; i < Product.length; i ++){
            System.out.println(Product[i] + "\n");
        }
        // - Call equals() to compare two products with the same ID and name
        Product p1 = new Product("Thing", 3.00);
        System.out.println(p1.equals(p1));

        // Make a class Coupon with a final discountRate and apply it to a Product
        Coupon item = new Coupon("Item Name", 10.00, 0.50);
        System.out.println("Discounted price: $" + (item.price - (item.price * item.discountRate)));
    }
}


// Additional TODOs:
// 1. Try to extend Toy — what happens and why?
// The error displayed: Cannot inherit from final 'Toy'
// Toy is a final class, which means it can't be inherited from.

// 2. Make a class Coupon with a final discountRate and apply it to a Product
class Coupon extends Product{
    final double discountRate;

    public Coupon(String name, double price, double discountRate){
        super(name, price);
        this.discountRate = discountRate;
    }
}
// 3. Add a method to Electronics called warrantyInfo() and mark it final
// 4. Use access modifiers appropriately and explain your choices in comments

// Protected access modifier keeps the variable/method/constructor within the file
// private access modifier keeps the variable/method/constructor within the class
// public access modifier means the variable/method/constructor can be used anywhere


