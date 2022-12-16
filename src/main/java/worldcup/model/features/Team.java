package worldcup.model.features;

import java.util.Objects;

public class Team {
    private final String name;
    private int winningPoints;
    private int goalDifference;
    private int goals;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addWinningPoints(int winningPoint) {
        this.winningPoints += winningPoint;
    }

    public void addGoalDifference(int goalDifference) {
        this.goalDifference += goalDifference;
    }

    public void addGoals(int goal) {
        this.goals += goal;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Team team = (Team) o;
        return winningPoints == team.winningPoints && goalDifference == team.goalDifference && goals == team.goals
                && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, winningPoints, goalDifference, goals);
    }
}
