package worldcup.controller.subcontroller;

import worldcup.view.InputView;
import worldcup.view.OutputView;

public class AllMatchResultsController implements Controllable {

    private final InputView inputView;
    private final OutputView outputView;

    public AllMatchResultsController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
    }
}
