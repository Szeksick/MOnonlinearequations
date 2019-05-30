package sample.methods;

import javafx.scene.control.Alert;


public class Horner {

    public Double Calculate(String polynom, Double inx) {
        if (inx == null || polynom == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd kalkulatora");
            alert.setHeaderText(null);
            alert.setContentText("Proszę upewnić się, że pola są uzupełnione");
            alert.showAndWait();
        }else {
            try {
                //wielomian rozdzielany do tablicy z wyrażenia regularnego
                String[] parts = polynom.split("x\\^\\d+\\+?");
                //Obliczenia metodą Hornera
                Double result;
                result = Double.parseDouble(parts[0]);
                for (int i = 1; i < parts.length; i++) {
                    System.out.println(result);
                    result = result * inx + Double.parseDouble(parts[i]);
                }
                return result;
            }
            catch (Exception exept) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Błąd kalkulatora");
                alert.setHeaderText(null);
                alert.setContentText("Proszę upewnić się, że pola są uzupełnione właściwie");
                alert.showAndWait();
            }
        }
        return 0.0;
    }
}
