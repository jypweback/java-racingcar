package racing;

import java.util.List;
import java.util.ArrayList;

public class RacingGame {
    private static final int SECOND_ROUND_NUM = 2;
    // 운행횟수
    private int time;
    // Car 컬렉션
    private List<Car> cars;
    // 라운드별 결과
    private List<RacingGameRoundResult> racingGameRoundResult;

    RacingGame(final int time, List<String> carNames) {
        this.time = time;
        this.cars = new ArrayList<Car>();
        this.racingGameRoundResult = new ArrayList<RacingGameRoundResult>();

        List carRoundResult = new ArrayList();
        for (String carName : carNames) {
            Car car = new Car(carName, 1);
            cars.add(car);
            carRoundResult.add(new CarRoundResult(car.getCarName(), car.getMovePosition()));
        }
        // 첫번째 라운드저장
        racingGameRoundResult.add(new RacingGameRoundResult(carRoundResult));
    }

    // 운행횟수
    public RacingGameResult runRacingGame(GameRule gameRule) {
        for (int round = SECOND_ROUND_NUM; round <= time; round++) {
            moveCarPositionByGameRule(round, gameRule);
        }
        return new RacingGameResult(racingGameRoundResult, time);
    }

    public void moveCarPositionByGameRule(int time, GameRule gameRule) {
        List carRoundResult = new ArrayList();
        for (Car car : cars) {
            if (gameRule.moveRacingGameRule()) {
                car.move();
            }
            carRoundResult.add(new CarRoundResult(car.getCarName(), car.getMovePosition()));
        }
        racingGameRoundResult.add(new RacingGameRoundResult(carRoundResult));
    }
}