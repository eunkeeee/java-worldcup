package worldcup.controller.subcontroller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import worldcup.model.features.Group;
import worldcup.model.repository.Groups;
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

        try {
            File matchResults = new File("src/main/resources/MatchResult.txt");
            BufferedReader matchResultsReader = new BufferedReader(new FileReader(matchResults));

            String matchResult;
            while ((matchResult = matchResultsReader.readLine()) != null) {
                List<String> result = List.of(matchResult.split(" "));
                System.out.println(result);
                Group group = Groups.findGroupByName(result.get(GROUP_INDEX));
            }
            System.out.println();

        } catch (IOException exception) {
            outputView.printExceptionMessage(exception);
            throw new RuntimeException(exception);
        }
    }

    private static void initializeGroups() {
        List<String> groups = List.of("A조", "B조", "C조", "D조", "E조", "F조", "G조");
        groups.stream().map(Group::new).forEach(Groups::addGroup);
    }
}
