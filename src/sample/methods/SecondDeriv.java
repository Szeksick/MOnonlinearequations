package sample.methods;

import java.util.ArrayList;

public class SecondDeriv {

    public double calc(int r, Double arg, ArrayList<Double> tab){
        Double result = 0.0;
        for(int i = 2; i <= r;i++) result += Math.pow(arg,i-2)*tab.get(i)*i*(i-1);
        return result;
    }
}
