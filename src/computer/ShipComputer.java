package computer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShipComputer {

    String rawProgram;
    int[] program;
    List<Chunk> executionHistory = new ArrayList<>(64);

    public ShipComputer(String rawProgram) {
        this.rawProgram = rawProgram;
        this.program = Arrays.stream(rawProgram.split(",")).mapToInt(Integer::valueOf).toArray();
    }

    public int compute(){
        confabulate();

        int position = 0;
        Chunk current = read(0);

        while (current.op != Operation.TERMINATE) {
            int result = current.compute();
            program[current.target] = result;
            position += 4;
            current = read(position);
        }

        return program[0];
    }

    private Chunk read(int position){
        Chunk next = new Chunk(position);
        executionHistory.add(next);
        return next;
    }

    private void confabulate() {
        program[1] = 12;
        program[2] = 2;
    }

    class Chunk {
        static final int length = 4;

        final int startPosition;
        final Operation op;
        final int addr1;
        final int addr2;
        final int target;

        int result;

        public Chunk(int position) {
            startPosition = position;
            op = Operation.op(program[position]);
            addr1 = program[position+1];
            addr2 = program[position+2];
            target = program[position+3];
        }

        public int compute(){
            result = op.operation(program[addr1], program[addr2]);
            return result;
        }
    }
}
