package worldcup.controller;

import java.util.EnumMap;
import java.util.Map;
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
    }

    public void play() {
        new InitializingController().process();
        MainOption mainOption;
        do {
            mainOption = inputView.readMainOption();
            process(mainOption);
        } while (mainOption.isPlayable());
    }

    public void process(MainOption mainOption) {
        try {
            controllers.get(mainOption).process();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}