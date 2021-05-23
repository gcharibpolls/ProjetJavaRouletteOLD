
import java.util.Calendar;

public abstract class Food implements Strategy {

    public abstract int getPrice();

    public abstract String getName();

    public abstract String toString();

    @Override
    public int getPromo(int price, int orderNumber) {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:
                break;
            case Calendar.MONDAY:
                break;
            case Calendar.TUESDAY:
                price /= 2;
                break;
            case Calendar.WEDNESDAY:
                if ((orderNumber + 1) % 10 == 0) {
                    price = (int) (price - (price * 0.1));
                }
                break;
            case Calendar.THURSDAY:
                break;
            case Calendar.FRIDAY:
                price /= 2;
                break;
            case Calendar.SATURDAY:
                if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) % 2 == 0) {
                    price /= 2;
                }
                break;
        }
        return price;
    }
}
