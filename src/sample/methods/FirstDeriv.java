package sample.methods;

import java.util.ArrayList;

public class FirstDeriv {

    public Double calc(int r, Double arg, ArrayList<Double> tab){
        Double result = 0.0;
        for(int i = 1; i <= r;i++) result += Math.pow(arg,i-1)*tab.get(i)*i;
        return result;
    }
}