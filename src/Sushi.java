
public class Sushi extends Food {

    private String fishType;
    private int amountRice;
    private int price;

    public Sushi(String fishType, int amountRice, int price) {
        this.fishType = fishType;
        this.amountRice = amountRice;
        this.price = price;
    }

    public Sushi(String keywords) {
        if (keywords.contains("spicy") || keywords.contains("strong")) {
            fishType = "Tuna";
            amountRice = 50;
            price = 9;
        } else if (keywords.contains("consistent") || keywords.contains("sweet")) {
            fishType = "Salmon";
            amountRice = 70;
            price = 10;
        } else {
            fishType = "Tuna";
            amountRice = 100;
            price = 11;
        }
    }

    public String getFishType() {
        return fishType;
    }

    public int getAmountRice() {
        return amountRice;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return "Sushi";
    }

    @Override
    public String toString() {
        return "Name: " + getName();
    }

}
