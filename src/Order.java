
public class Order {

    private String keywords, arrivedAt;

    public String getArrivedAt() {
        return arrivedAt;
    }
    private int time;
    private Food food;

    public Order(String arrivedAt, Food food) {
        this.arrivedAt = arrivedAt;
        this.food = food;
    }

    public Order(String keywords, int time, String arrivedAt) {
        this.keywords = keywords;
        this.time = time;
        this.arrivedAt = arrivedAt;
        food = new FoodPicker().getFood(keywords.toLowerCase());
    }

    public Food getFood() {
        return food;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return food.toString() == null ? "Food" : food.toString();
    }

}
