package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.methods.NewtonsTangent;

import java.util.ArrayList;

public class Controller {
@FXML private TextArea resultout;
@FXML private TextField startpoint;
@FXML private TextField endpoint;
@FXML private TextField polynom;
@FXML private TextField tol;
private ArrayList<Double> coeffs;
private Double result;
        public void calculate() {
                try {
                        /*
                         * Z pola tekstowego rozdzielam wielomian na współczynniki
                         * dzięki temu w tablicy dynamicznej mam wspolczynniki
                         * i znam rzad wielomianu z liczby wspołczyników
                         */
                        String poly = polynom.getText();
                        String[] parts = poly.split("x\\^\\d+\\+?");
                        coeffs = new ArrayList<>();
                        for (int i = 0; i < parts.length; i++) coeffs.add(Double.parseDouble(parts[i]));
                        /*
                         * Obliczam i wyswietlam w polu tekstowym
                         */
                        NewtonsTangent newtonsTangent = new NewtonsTangent(coeffs, Double.parseDouble(startpoint.getText()), Double.parseDouble(endpoint.getText()), Double.parseDouble(tol.getText()));
                        result = newtonsTangent.calculate();
                        if (result != null) {
                                resultout.appendText("Obliczenia dla F(x)" + polynom.getText() + ", a=" + startpoint.getText() + ", b=" + endpoint.getText() + "\n");
                                resultout.appendText("x0= " + result + "\n");
                        } else {
                                resultout.appendText("Funkcja F(x)" + polynom.getText() + " niema pierwiastków lub posiada wiecej niz jeden w zadanym przedziale [" + startpoint.getText() + "," + endpoint.getText() + "]\n");
                        }
                }catch(Exception e){
                        e.printStackTrace();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Błąd kalkulatora");
                        alert.setHeaderText(null);
                        alert.setContentText("Proszę uzupełnić prawidłowo pola");
                        alert.showAndWait();
        }
        }
}




