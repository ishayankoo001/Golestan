package ir.ac.kntu;
enum BreakfastOptions{
    NONPANIR, KAREASAL, NIMROO, KALAPCH;
}

public class Breakfast {
    BreakfastOptions breakfastType;
    int price;

    public Breakfast(BreakfastOptions breakfastType) {
        this.breakfastType = breakfastType;
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
