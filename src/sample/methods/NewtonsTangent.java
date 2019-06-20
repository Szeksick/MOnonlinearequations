package sample.methods;

import javafx.scene.control.Alert;
import java.util.ArrayList;
import java.util.Collections;


public class NewtonsTangent {
    private ArrayList<Double> coeffs;
    private Double a, b, x, y, y1a, y1z, y2z, tol, z;
    private int rank;
    private FirstDeriv deriv = new FirstDeriv();
    private SecondDeriv deriv2 = new SecondDeriv();
    private FuncArg funcArg = new FuncArg();


    public NewtonsTangent(ArrayList<Double> coeffs, Double a, Double b, Double o) {
        this.a = a;
        this.b = b;
        this.tol = o;
        this.coeffs = new ArrayList<Double>(coeffs);
        this.rank = coeffs.size()-1;
    }

    public Double calculate() {
        Collections.reverse(coeffs);
        z = (a + b) / 2;


        y1z = deriv.calc(rank, z, coeffs);
        y2z = deriv2.calc(rank, z, coeffs);


        y = funcArg.calc(rank, a, coeffs);
        y1a = deriv.calc(rank, a, coeffs);

        x = a;
        if (y1z * y2z < 0) {
            while (Math.abs(y) > tol) {
                x = x - y / y1a;
                y = funcArg.calc(rank, x, coeffs);
                y1a = deriv.calc(rank, x, coeffs);
            }
            return x;
        } else {
            return null;
        }
    }
}

