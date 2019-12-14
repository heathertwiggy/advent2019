package computer;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Opcode {
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

    private static Map<Integer, Opcode> ops = Arrays.stream(values())
            .collect(Collectors.toMap(Opcode::getOpCode, Function.identity()));

    private int opCode;

    abstract Integer operation(Integer a, Integer b);

    Opcode(int opCode) {
        this.opCode = opCode;
    }

    public int getOpCode() {
        return opCode;
    }

    public static Opcode op(Integer i){
        return ops.getOrDefault(i, TERMINATE);
    }
}
