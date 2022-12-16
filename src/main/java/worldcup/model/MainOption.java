package worldcup.model;

import java.util.Arrays;
import worldcup.util.ExceptionMessage;

public enum MainOption {

    PRINT_ALL_MATCH_RESULTS("1"),
    PRINT_GROUP_MATCH_RESULTS("2"),
    PRINT_TEAM_RESULT("3"),
    PRINT_TOURNAMENT_ADVANCED_TEAMS("4"),
    APPLICATION_EXIT("5");

    private final String command;

    MainOption(String command) {
        this.command = command;
    }

    public boolean isPlayable() {
        return this != APPLICATION_EXIT;
    }

    public static MainOption from(String command) {
        return Arrays.stream(MainOption.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_MAIN_OPTION.getMessage()));
    }

    //

}