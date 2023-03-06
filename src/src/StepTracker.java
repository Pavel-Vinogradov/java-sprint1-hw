import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    private static final int IDX = 1;
    Converter converter = new Converter();

    int goalByStepsPerDay = 10000; // цель по количеству шагов в день

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца от 1 до 12 включительно");
        int month = scanner.nextInt();
        if (checkMonth(month)) {
            System.out.println("Неверный номер месяца");
            return;
        }
        System.out.println("Введите номер дня от 1 до 30 включительно");
        int day = scanner.nextInt();
        if (checkDay(day)) {
            System.out.println("Неверный номер дня");
            return;
        }
        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (checkSteps(steps)) {
            System.out.println("Неверное количество шагов");
            return;
        }
        MonthData monthData = monthToData[month - IDX];
        monthData.days[day - IDX] = steps;
    }


    public void changeStepGoal() {
        System.out.println("Введите новое количество шагов");
        int steps = scanner.nextInt();
        if (checkSteps(steps)) {
            System.out.println("Неверное количество шагов");
            return;
        }
        goalByStepsPerDay = steps;
    }


    public void printStatistic() throws IOException {
        System.out.println("Введите номер месяца от 1 до 12 включительно");
        int month = scanner.nextInt();
        if (checkMonth(month)) {
            System.out.println("Неверный номер месяца");
            return;
        }
        MonthData monthData = monthToData[month - IDX];
        monthData.printDaysAndStepsFromMonth(monthData.days); // количество пройденных шагов по дням;
        System.out.println(monthData.sumStepsFromMonth(monthData.days) + " - общее количество шагов за месяц");
        System.out.println(monthData.maxSteps(monthData.days) + " - максимальное пройденное количество шагов в месяце");
        System.out.println((monthData.sumStepsFromMonth(monthData.days) / 30) + " - среднее количество шагов");
        System.out.println(converter.convertToKm(monthData.sumStepsFromMonth(monthData.days)) + " - пройденная дистанция (в км)");
        System.out.println(converter.convertStepsToKilocalories(monthData.sumStepsFromMonth(monthData.days)) + " - количество сожжённых килокалорий");
        System.out.println(monthData.bestSeries(monthData.days, goalByStepsPerDay) + " - лучшая серия");
    }

    private boolean checkMonth(int value) {
        return value < 1 || value > 12;

    }

    private boolean checkDay(int value) {
        return value < 1 || value > 30;
    }

    private boolean checkSteps(int value) {
        return value <= 0;
    }





}
