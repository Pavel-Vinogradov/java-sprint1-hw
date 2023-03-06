public class Converter {
    private static final int STEP = 75;
    private static final int CENTIMETER_IN_KILOMETER = 100000;
    private static final int STEP_KILO_CALORIES = 50;
    private static final int CALORIES_IN_KILOGRAM = 1000;


    int convertToKm(int steps) {
        return steps * STEP / CENTIMETER_IN_KILOMETER;

    }

    int convertStepsToKilocalories(int steps) {
        return steps * STEP_KILO_CALORIES / CALORIES_IN_KILOGRAM;
    }

}
