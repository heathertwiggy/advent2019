package days;

import computer.ShipComputer;
import util.Input;
import util.Pair;

public class Day2 implements Dayable {

    @Override
    public String day() {
        return "2";
    }

    @Override
    public String computeOne() {
        return String.valueOf(new ShipComputer(Input.list(2).get(0)).compute(12, 2));
    }

    @Override
    public String computeTwo() {
        // brute force I guess?
        ShipComputer computer = new ShipComputer(Input.list(2).get(0));
        int target = 19690720;
        Pair<Integer, Integer> params = bruteforce(computer, target);

        return String.valueOf(100 * params.left + params.right);
    }

    private Pair<Integer, Integer> bruteforce(ShipComputer computer, int target){
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                int result = computer.compute(i, j);
                if (result == target){
                    return Pair.of(i,j);
                }
                computer.reloadProgram();
            }
        }

        throw new IllegalArgumentException("Impossible problem :(");
    }

    @Override
    public String correctResultOne() {
        return "4690667";
    }

    @Override
    public String correctResultTwo() {
        return "6255";
    }

}
