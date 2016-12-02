package solution2;

public class PairNumberDegree {
    private final int number;
    private int degree;

    PairNumberDegree(int num, int deg){
        number = num; degree = deg;
    }

    int getNumber(){
        return  number;
    }
    
    int getDegree(){
        return degree;
    }
    
    void incrementDegree(){
        ++degree;
    }
}
