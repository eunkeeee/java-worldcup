package worldcup.controller;

import java.util.EnumMap;
import java.util.Map;
import worldcup.controller.subcontroller.AllMatchResultsController;
import worldcup.controller.subcontroller.Controllable;
import worldcup.controller.subcontroller.GroupMatchResultsController;
import worldcup.controller.subcontroller.InitializingController;
import worldcup.controller.subcontroller.TeamResultController;
import worldcup.controller.subcontroller.TournamentTeamsController;
import worldcup.model.MainOption;
import worldcup.view.InputView;
import worldcup.view.OutputView;

public class MainController {
    private final Map<MainOption, Controllable> controllers;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controllers = new EnumMap<>(MainOption.class);
        initializeControllers();
    }

    private void initializeControllers() {
        controllers.put(MainOption.PRINT_ALL_MATCH_RESULTS, new AllMatchResultsController(inputView, outputView));
        controllers.put(MainOption.PRINT_GROUP_MATCH_RESULTS, new GroupMatchResultsController(inputView, outputView));
        controllers.put(MainOption.PRINT_TEAM_RESULT, new TeamResultController(inputView, outputView));
        controllers.put(MainOption.PRINT_TOURNAMENT_TEAMS, new TournamentTeamsController(inputView, outputView));
    }

    public void play() {
        new InitializingController(inputView,outputView).process();
        MainOption mainOption;
        do {
            mainOption = inputView.readMainOption();
            process(mainOption);
        } while (mainOption.isPlayable());
    }

    public void process(MainOption mainOption) {
        try {
            controllers.get(mainOption).process();
        } catch (NullPointerException ignored) {
        }
    }
}