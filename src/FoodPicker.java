
public class FoodPicker {

    public Food getFood(String keywords) {
        if ((keywords.contains("meat")) && !keywords.contains("fish")) {
            return new Burger(keywords);
        } else if (keywords.contains("fish")) {
            return new Sushi(keywords);
        } else if ((keywords.contains("tomato") || keywords.contains("circular")) && !keywords.contains("fish")) {
            return new Pizza(keywords);
        } else {
            return null;
        }
    }
}
