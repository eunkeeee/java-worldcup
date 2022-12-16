package worldcup;

import worldcup.controller.MainController;
import worldcup.view.InputView;
import worldcup.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(InputView.getInstance(), OutputView.getInstance());
        mainController.play();
    }
}