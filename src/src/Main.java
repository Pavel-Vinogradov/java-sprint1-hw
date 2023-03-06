import Enums.ConsoleCommandType;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            System.out.println("Что вы хотите сделать? ");
            Arrays.stream(ConsoleCommandType.values()).forEach(commandType -> System.out.println(commandType.getValue() + " - " + commandType.getLabel()));
            int i = scanner.nextInt();
            if (i == ConsoleCommandType.EXIT.getValue()) {
                System.out.println("Выход из приложения");
                break;
            } else if (i == ConsoleCommandType.STEP_OF_THE_DAY.getValue()) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == ConsoleCommandType.CHANGE_STEP_OF_THE_DAY.getValue()) {
                stepTracker.changeStepGoal();
            } else if (i == ConsoleCommandType.STATISTIC.getValue()) {
                stepTracker.printStatistic();
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }
}