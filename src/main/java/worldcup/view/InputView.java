package worldcup.view;

import camp.nextstep.edu.missionutils.Console;
import worldcup.model.MainOption;
import worldcup.util.Util;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public MainOption readMainOption() {
        System.out.println(Message.INPUT_MAIN_OPTION.message);
        return MainOption.from(Util.removeSpace(Console.readLine()));
    }


    private enum Message {
        INPUT_MAIN_OPTION("카타르 월드컵 조별리그 결과\n"
                + "\n"
                + "1. 경기 결과 출력\n"
                + "2. 조별 결과 출력\n"
                + "3. 국가 경기 및 순위 결과 출력\n"
                + "4. 16강 진출 국가 출력\n"
                + "5. 종료\n"
                + "\n"
                + "출력할 내용을 입력하세요. (1 ~ 5)");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
