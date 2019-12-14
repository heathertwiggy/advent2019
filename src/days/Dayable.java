package days;

public interface Dayable {
    default String day(){
        return "0";
    }

    default String computeOne(){
        return "not yet computed 1";
    }

    default String computeTwo(){
        return "not yet computed 2";
    }

    default String correctResultOne(){
        return "dunno 1";
    };

    default String correctResultTwo(){
        return "dunno 2";
    };

}
