package racing;

public class RunningRacingGame {
    public static void main(String[] args) {
        //사용자 입력값
        UserInputValueObject inputValueObject = RacingGameInputView.takeUserInput();
        //레이싱게임 초기화
        RacingGame racingGame = new RacingGame(inputValueObject.getInputCarTime(),
                inputValueObject.getInputCarNames());

        //게임시작
        GameRule gameRule = new CarGameRuleUseRandomNumber();
        RacingGameResult racingGameResult = racingGame.runRacingGame(gameRule);

        //결과출력
        RacingGameResultView.raceResultView(racingGameResult);
    }
}
