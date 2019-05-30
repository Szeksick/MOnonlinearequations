package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.methods.Rootsearch;

public class Controller {
@FXML private TextArea resultout;
@FXML private Label filename;
@FXML private AnchorPane ap;
@FXML private TextField startpoint;
@FXML private TextField endpoint;
@FXML private TextField polynom;
@FXML private TextField tol;
        public void calculate() {
                Rootsearch rootsearch = new Rootsearch(polynom.getText(), Double.parseDouble(startpoint.getText()), Double.parseDouble(endpoint.getText()), Double.parseDouble(tol.getText()));
                resultout.appendText("Obliczenia dla F(x)"+polynom.getText()+", a="+startpoint.getText()+", b="+endpoint.getText()+"\n");
                resultout.appendText("x0= " + rootsearch.calculate()+ "\n");
                }
            }




