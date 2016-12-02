package solution2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Calculator {    
    
    private List<Integer> listDivisors;
    
    public Calculator(){
        listDivisors = new ArrayList<>();
    }
    
    public List<Integer> calculate(int value){        
        findAllDivisorsOfNumder(value);
        Collections.sort(listDivisors);        
        return listDivisors;
    }
    
    private void findAllDivisorsOfNumder(int number){
        List<PairNumberDegree> pairNumberDegreeList = getNumberInCanonicalForm(number);
        ArrayList<Integer> degrees = new ArrayList<>();
        for(int i = 0; i < pairNumberDegreeList.size(); ++i){
            degrees.add(pairNumberDegreeList.get(i).getDegree());
        }
        bustAllDegreesAndCalculateDevisors(degrees, pairNumberDegreeList, 0 );
    }


    private void bustAllDegreesAndCalculateDevisors(ArrayList<Integer> degrees, List<PairNumberDegree> pairNumberDegreeList, int currentChangedDegree ){
        for (int i = 0; i <= degrees.get(currentChangedDegree); ++i){
            ArrayList<Integer> newDegrees = (ArrayList) degrees.clone();
            newDegrees.set(currentChangedDegree, i);
            if(currentChangedDegree + 1 < degrees.size()){
                bustAllDegreesAndCalculateDevisors(newDegrees,pairNumberDegreeList,currentChangedDegree + 1);
            }else{
                listDivisors.add(multiplicationToGetDivisor(newDegrees, pairNumberDegreeList));
            }
        }
    }


    private int multiplicationToGetDivisor(ArrayList<Integer> degrees, List<PairNumberDegree> pairNumberDegreeList){
        int divisor = 1;

        for (int i = 0; i < pairNumberDegreeList.size(); ++ i){
            int numInDeg = (int) Math.pow(pairNumberDegreeList.get(i).getNumber(),degrees.get(i));
            divisor *= numInDeg;
        }

        return divisor;
    }


    private List<PairNumberDegree> getNumberInCanonicalForm(int num){

        List<PairNumberDegree> pairNumberDegreeList = new ArrayList<>();
        int p = 2;

        while (num != 1 ){
            if(num % p == 0){
                if(pairNumberDegreeList.size() == 0){
                    pairNumberDegreeList.add(new PairNumberDegree(p,1));
                }else{
                    if (pairNumberDegreeList.get(pairNumberDegreeList.size()-1).getNumber() == p){
                        pairNumberDegreeList.get(pairNumberDegreeList.size()-1).incrementDegree();
                    }else{
                        pairNumberDegreeList.add(new PairNumberDegree(p,1));
                    }
                }

                num = num / p;
            }
            else{
                ++p;
            }
        }

        return pairNumberDegreeList;
    }
}
