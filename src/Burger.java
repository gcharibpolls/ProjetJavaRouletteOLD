
public class Burger extends Food {

    private String meatType;
    private String sauceType;
    private int sauceQuantity;
    private int price;

    public Burger(String meatType, String sauceType, int sauceQuantity, int price) {
        this.meatType = meatType;
        this.sauceType = sauceType;
        this.sauceQuantity = sauceQuantity;
        this.price = price;
    }

    
    
    public Burger(String keywords) {
        if (keywords.contains("light") || keywords.contains("sweet")) {
            sauceType = "Tomato";
            meatType = "Veggie";
            sauceQuantity = 30;
            price = 8;
        } else if (keywords.contains("strong")) {
            meatType = "Beef";
            sauceType = "Pili Pili";
            sauceQuantity = 50;
            price = 14;
        } else {
            meatType = "Chicken";
            sauceType = "Brasil";
            sauceQuantity = 40;
            price = 11;
        }
        if (keywords.contains("seasoned")) {
            sauceType = "Andalusian";
        }
    }

    public String getMeatType() {
        return meatType;
    }

    public String getSauceType() {
        return sauceType;
    }

    public int getSuaceQuantity() {
        return sauceQuantity;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return "Burger";
    }

    @Override
    public String toString() {
        return "Name: " + getName();
    }

}
