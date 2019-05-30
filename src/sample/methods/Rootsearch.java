package sample.methods;

import javafx.scene.control.Alert;
import java.util.ArrayList;
import java.util.Collections;


public class Rootsearch {
    private String poly;
    private ArrayList<Double> lefty, righty, centery, centerx, leftx, rightx;
    double a,b,x,ya,yb,yx, o;
    private Horner horner;

    public Rootsearch(String poly, Double a, Double b, Double o) {
        this.poly = poly;
        this.a = a;
        this.b = b;
        this.o = o;
        horner = new Horner();
    }
    private void init(){
    leftx = new ArrayList<>();
    rightx = new ArrayList<>();
    centerx = new ArrayList<>();
    centery = new ArrayList<>();
    lefty = new ArrayList<>();
    lefty = new ArrayList<>();
    }
//    private double calcsubresult(Double x0){
//        int selected = tabx.indexOf(x0);
//        Collections.reverse(tabx);
//        Collections.reverse(taby);
//        ArrayList<ArrayList<Double>> subresult = new ArrayList<>();
//        for(int i = 0; i < n-1 ; i++){
//            subresult.add(new ArrayList<>());
//            if(i==0){
//                for(int j = 0; j < n-1-i; j++){
//                    subresult.get(i).add(taby.get(j) - taby.get(j+1));
//                }
//            }else{
//                for(int j = 0; j < n-1-i ; j++) {
//                    subresult.get(i).add(subresult.get(i - 1).get(j) - subresult.get(i - 1).get(j+1));
//                }
//            }
//
//        }
//        ArrayList<Double> templist = new ArrayList<>();
//        for(int i = 0; i < subresult.size()-1; i++){
//            if(subresult.get(i).size() > selected) {
//                templist.add(subresult.get(i).get(selected));
//            }
//        }
//        Double tempresult = 0.0;
//
//        for(int i = 0; i < templist.size(); i++){
//            if(i==0){
//                tempresult = tempresult + (templist.get(i));
//            }else{
//                    tempresult = tempresult + ((1.0 / (i + 1.0)) * templist.get(i));
//                 }
//            }
//        Collections.reverse(tabx);
//        Collections.reverse(taby);
//        return tempresult;
//    }
    public double calculate(){
        try{
//            leftx.get(0)=a;
//            rightx.get(0)=b;
//            while() {
//                centerx.get(i) = (lefx.get(i) + rightx.get(i)) / 2;
//                lefty = horner.Calculate(poly, leftx);
//                righty = horner.Calculate(poly, rightx);
//            }
            while(yx != 0+o || yx != 0-o) {
                x = (a + b) / 2;
                ya = horner.Calculate(poly, a);
                yb = horner.Calculate(poly, b);
                yx = horner.Calculate(poly, x);
                if (yx == 0 ){
                    break;
                    } else{
                    if (yx * ya > 0) {
                    a = x;
                     } else {
                    b = x;
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd metody bisekcji");
            alert.setHeaderText(null);
            alert.setContentText("Błędnie uzupełnione pola");
            alert.showAndWait();
        }
        return x;
    }
}
