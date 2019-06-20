package sample.methods;

import java.util.ArrayList;

public class FuncArg {

    public Double calc(int r, Double arg, ArrayList<Double> tab) {
        Double result = 0.0;
        for(int i=0; i<=r; i++)
            result += Math.pow(arg,i)*tab.get(i);

        return result;
    }
}
