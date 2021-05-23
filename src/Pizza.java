
public class Pizza extends Food {

    private String sauceType;
    private int amountSauce;
    private int mozza;
    private int price;

    public Pizza(String sauceType, int amountSauce, int mozza, int price) {
        this.sauceType = sauceType;
        this.amountSauce = amountSauce;
        this.mozza = mozza;
        this.price = price;
    }

    public Pizza(String keywords) {
        if (keywords.contains("spicy") || keywords.contains("strong")) {
            sauceType = "BBQ";
            amountSauce = 120;
            mozza = 70;
            price = 11;
        } else if (keywords.contains("consistent") || keywords.contains("surprise") || keywords.contains("refined")) {
            sauceType = "Tomato";
            amountSauce = 70;
            mozza = 100;
            price = 12;
        } else {
            sauceType = "Tomato";
            amountSauce = 50;
            mozza = 120;
            price = 14;
        }
    }

    public String getSauceType() {
        return sauceType;
    }

    public int getAmountSauce() {
        return amountSauce;
    }

    public int getMozza() {
        return mozza;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return "Pizza";
    }

    @Override
    public String toString() {
        return "Name: " + getName();
    }

}
