public class MonthData {
    int[] days = new int[30];

    public void printDaysAndStepsFromMonth() {
        for (int i = 0; i < this.days.length; i++) {
            System.out.println("День " + (i + 1) + " количество шагов " + days[i]);
        }
    }

    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day : this.days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    public int maxSteps() {
        int stepsMax = 0;
        for (int day : this.days) {
            if (day > stepsMax) {
                stepsMax = day;
            }
        }
        return stepsMax;
    }

    public int bestSeries( int goalByStepsPerDay) {
        int maxLen = 0;
        int maxSteps = 0;
        for (int day : this.days) {
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
