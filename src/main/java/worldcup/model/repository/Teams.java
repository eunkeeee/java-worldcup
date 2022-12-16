package worldcup.model.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import worldcup.model.features.Team;
import worldcup.util.ExceptionMessage;

public class Teams {
    private static final List<Team> teams = new ArrayList<>();

    public static List<Team> groups() {
        return Collections.unmodifiableList(teams);
    }

    public static void addTeam(Team team) {
        teams.add(team);
    }

    public static void deleteAll() {
        teams.clear();
    }

    public static Team findTeamByName(String name) {
        return teams.stream()
                .filter(team -> team.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_TEAM.getMessage()));
    }
}
