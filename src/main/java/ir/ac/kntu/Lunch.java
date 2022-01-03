package ir.ac.kntu;

enum mainCourse {
    KEBAB, FISHANDCHIPS, BURGER, PIZZA;
}

enum salad {
    CAESAR, CABBAGE, SHIRAZI;
}

enum drink {
    SODA, WATER,
}

public class Lunch extends Meals {
    mainCourse mainCourseType;
    salad saladType;
    drink drinkType;

    public Lunch(mainCourse mainCourseType, salad saladType, drink drinkType, PlaceToReceive placeToReceiveLunch) {
        this.mainCourseType = mainCourseType;
        this.saladType = saladType;
        this.drinkType = drinkType;
        this.placeToReceiveEdible = placeToReceiveLunch;
        switch (this.mainCourseType) {
            case KEBAB:
                this.price += 30000;
                break;
            case FISHANDCHIPS:
                this.price += 30000;
                break;
            case BURGER:
                this.price += 20000;
                break;
            case PIZZA:
                this.price += 30000;
                break;
        }
        switch (this.drinkType) {
            case SODA:
                this.price += 8000;
                break;
            case WATER:
                this.price += 5000;
                break;
        }
        switch (this.saladType) {
            case CAESAR:
                this.price += 40000;
                break;
            case CABBAGE:
                this.price += 10000;
                break;
            case SHIRAZI:
                this.price += 8000;
                break;
        }
    }
}
