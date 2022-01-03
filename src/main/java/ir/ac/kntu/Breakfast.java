package ir.ac.kntu;

/**
 * enum choosing the type of breakfast that user wants
 */
enum BreakfastOptions{
    NONPANIR, KAREASAL, NIMROO, KALAPCH;
}

/**
 * enum that lets the user choose where they would want to receive their food.
 */
enum PlaceToReceive{
    UNIVERSITY,
    DORMITORY;
}

/**
 * Breakfast class handles breakfasts
 */
public class Breakfast extends Meals {
    BreakfastOptions breakfastType;

    /**
     * Constructor of breakfast class
     * @param breakfastType
     * @param placeToReceiveBreakfast
     */
    public Breakfast(BreakfastOptions breakfastType, PlaceToReceive placeToReceiveBreakfast) {
        this.breakfastType = breakfastType;
        this.placeToReceiveEdible = placeToReceiveBreakfast;
        switch (this.breakfastType){
            case KAREASAL: this.price = 10000;
            break;
            case NONPANIR: this.price = 8000;
            break;
            case NIMROO: this.price = 10000;
            break;
            case KALAPCH: this.price = 20000;
            break;
        }
    }
}
