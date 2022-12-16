package worldcup.model.features;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private final String name;
    private final List<Team> teams = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeams(List<Team> teams) {
        this.teams.addAll(teams);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", teams=" + teams +
                '}';
    }
}
