import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MonthData {
    int[] days = new int[30];

    public void printDaysAndStepsFromMonth(int @NotNull [] days) {
        for (int i = 0; i < days.length; i++) {
            System.out.println("День " + (i + 1) + " количество шагов " + days[i]);
        }
    }

    public int sumStepsFromMonth(int @NotNull [] days) {
        int sumSteps = 0;
        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    public int maxSteps(int @NotNull [] days) {
        int stepsMax = 0;
        for (int day : days) {
            if (day > stepsMax) {
                stepsMax = day;
            }
        }
        return stepsMax;
    }

    public int bestSeries(int @NotNull [] days, int goalByStepsPerDay) {
        int maxLen = 0;
        int maxSteps = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                maxLen++;
                if (maxLen > maxSteps) {
                    maxSteps = maxLen;
                }
            } else {
                maxLen = 0;
            }
        }
        return maxSteps;
    }

}
