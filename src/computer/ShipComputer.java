package computer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShipComputer {

    String rawProgram;
    int[] program;
    List<Instruction> executionHistory = new ArrayList<>(64);
    List<List<Instruction>> executionHistoryHistory = new ArrayList<>(100);

    public ShipComputer(String rawProgram) {
        loadProgram(rawProgram);
    }

    public void loadProgram(String rawProgram){
        this.rawProgram = rawProgram;
        reloadProgram();
    }

    public void reloadProgram(){
        this.program = Arrays.stream(rawProgram.split(",")).mapToInt(Integer::valueOf).toArray();
        if (!executionHistory.isEmpty()){
            executionHistoryHistory.add(new ArrayList<>(executionHistory));
            executionHistory.clear();
        }
    }

    public int compute(int noun, int verb){
        setInputFlags(noun, verb);

        int pc = 0;
        Instruction current = read(0);

        while (current.op != Opcode.TERMINATE) {
            int result = current.compute();
            program[current.target] = result;
            pc += 4;
            current = read(pc);
        }

        return program[0];
    }

    private Instruction read(int position){
        Instruction next = new Instruction(position);
        executionHistory.add(next);
        return next;
    }

    private void setInputFlags(int pos1, int pos2) {
        program[1] = pos1;
        program[2] = pos2;
    }

    class Instruction {
        static final int length = 4;

        final int startPosition;
        final Opcode op;
        final int addr1;
        final int addr2;
        final int target;

        int result;

        public Instruction(int position) {
            startPosition = position;
            op = Opcode.op(program[position]);
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
