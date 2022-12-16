package worldcup.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import worldcup.view.InputView;
import worldcup.view.OutputView;

public class InitializingController implements Controllable {


    private final InputView inputView;
    private final OutputView outputView;

    public InitializingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        try {
            File matchResults = new File("src/main/resources/MatchResult.txt");
            BufferedReader matchResultsReader = new BufferedReader(new FileReader(matchResults));

            String matchResult;
            while ((matchResult = matchResultsReader.readLine()) != null) {
                System.out.println(Arrays.toString(matchResult.split(" ")));
            }
            System.out.println();

        } catch (IOException exception) {
            outputView.printExceptionMessage(exception);
            throw new RuntimeException(exception);
        }
    }
}
