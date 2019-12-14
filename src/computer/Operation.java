package computer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operation {
    ADD(1){
        @Override
        Integer operation(Integer a, Integer b) {
            return a + b;
        }
    },
    MULTIPLY(2) {
        @Override
        Integer operation(Integer a, Integer b) {
            return a * b;
        }
    },
    TERMINATE(99) {
        @Override
        Integer operation(Integer a, Integer b) {
            return null;
        }
    };

    private static Map<Integer, Operation> ops = Arrays.stream(values())
            .collect(Collectors.toMap(Operation::getOpCode, Function.identity()));

    private int opCode;

    abstract Integer operation(Integer a, Integer b);

    Operation(int opCode) {
        this.opCode = opCode;
    }

    public int getOpCode() {
        return opCode;
    }

    public static Operation op(Integer i){
        return ops.getOrDefault(i, TERMINATE);
    }
}
