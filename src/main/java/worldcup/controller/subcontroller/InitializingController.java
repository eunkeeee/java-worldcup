package worldcup.controller.subcontroller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import worldcup.model.features.Group;
import worldcup.model.features.Team;
import worldcup.model.repository.Groups;
import worldcup.model.repository.Teams;
import worldcup.view.InputView;
import worldcup.view.OutputView;

public class InitializingController implements Controllable {


    public static final int GROUP_INDEX = 0;
    private final InputView inputView;
    private final OutputView outputView;

    public InitializingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {

        initializeGroups();
        initializeTeams();

        try {
            File matchResults = new File("src/main/resources/MatchResult.txt");
            BufferedReader matchResultsReader = new BufferedReader(new FileReader(matchResults));

            String matchResult;
            while ((matchResult = matchResultsReader.readLine()) != null) {
                List<String> result = List.of(matchResult.split(" "));

                Group group = Groups.findGroupByName(result.get(GROUP_INDEX));
                Team team1 = Teams.findTeamByName(result.get(1));
                Team team2 = Teams.findTeamByName(result.get(3));

                Map<Team, Integer> score = new HashMap<>();
                score.put(team1, Integer.parseInt(result.get(4)));
                score.put(team2, Integer.parseInt(result.get(6)));

                team1.addGoals(score.get(team1));
                team2.addGoals(score.get(team2));

                team1.addGoalDifference(score.get(team1) - score.get(team2));
                team2.addGoalDifference(score.get(team2) - score.get(team1));

                if (score.get(team1) > score.get(team2)) {
                    team1.addWinningPoints(3);
                }
                if (score.get(team1) < score.get(team2)) {
                    team2.addWinningPoints(3);
                }
                if (score.get(team1) == score.get(team2)) {
                    team1.addWinningPoints(1);
                    team2.addWinningPoints(1);
                }

            }

        } catch (IOException exception) {
            outputView.printExceptionMessage(exception);
            throw new RuntimeException(exception);
        }
    }

    private static void initializeTeams() {
        List<String> teams = List.of("카타르", "에콰도르", "세네갈", "네덜란드",
                "잉글랜드", "이란", " 미국", "웨일스",
                "아르헨티나", "사우디아라비아", "멕시코", "폴란드",
                "덴마크", "튀니지", "프랑스", "호주",
                "독일", "일본", "스페인", "코스타리카",
                "모로코", "크로아티아", "벨기에", "캐나다",
                "스위스", "카메룬", "브라질", "세르비아",
                "포르투갈", "가나", "우루과이", "대한민국");
        teams.stream().map(Team::new).forEach(Teams::addTeam);
        initializeGroupsWithTeams(teams);
    }

    private static void initializeGroupsWithTeams(List<String> teams) {
        for (int index = 0; index < teams.size() - 4; index += 4) {
            Groups.groups().get(index / 4).setTeams(teams.subList(index, index + 4).stream()
                    .map(Teams::findTeamByName)
                    .collect(Collectors.toList()));
        }
    }

    private static void initializeGroups() {
        List<String> groups = List.of("A조", "B조", "C조", "D조", "E조", "F조", "G조");
        groups.stream().map(Group::new).forEach(Groups::addGroup);
    }
}
