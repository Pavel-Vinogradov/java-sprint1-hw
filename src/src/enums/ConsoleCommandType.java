package enums;

public enum ConsoleCommandType {
    EXIT(0, "Выйти из приложения"),
    STEP_OF_THE_DAY(1, "Ввести количество шагов за определённый день"),
    CHANGE_STEP_OF_THE_DAY(2, "Изменить количество шагов за определён"),
    STATISTIC(3, "Напечатать статистику за определённый месяц"),
    ;
    private final int value;
    public final String description;

    ConsoleCommandType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return description;
    }

}
