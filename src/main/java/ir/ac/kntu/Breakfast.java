package ir.ac.kntu;
enum BreakfastOptions{
    NONPANIR, KAREASAL, NIMROO, KALAPCH;
}
enum PlaceToReceive{
    UNIVERSITY,
    DORMITORY;
}

public class Breakfast extends Meals {
    BreakfastOptions breakfastType;

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
