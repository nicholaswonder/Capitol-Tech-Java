package com.captech.graphicuserinterface;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConverterController {
    @FXML
    private TextField MilesTF;

    @FXML
    private TextField KmTF;

    @FXML
    private Label ErrorLBL;

    @FXML
    protected void onMilesKeyTyped() {
        try{
            double km = Double.parseDouble(MilesTF.getText()) * 1.609;
            KmTF.setText(String.valueOf(km));
            ErrorLBL.setText("");
        } catch (NumberFormatException e) {
            ErrorLBL.setText("Invalid values in Miles Text-Field!");
        }
    }

    @FXML
    protected void onKmKeyTyped() {
        try{
            double miles = Double.parseDouble(KmTF.getText()) / 1.609;
            MilesTF.setText(String.valueOf(miles));
            ErrorLBL.setText("");
        } catch (NumberFormatException e) {
            ErrorLBL.setText("Invalid values in Kilometers Text-Field!");
        }
    }
}