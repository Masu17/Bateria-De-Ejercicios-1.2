package com.example.bateriaejerciciodos.controllers;

import com.example.bateriaejerciciodos.Exception.ExcepcionPersonalizada;
import com.example.bateriaejerciciodos.models.PiscinaQuimica;
import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class MainController {
    @FXML
    public TextArea PoolInfoPanel;
    @FXML
    public ProgressBar filledUpPool;
    @FXML
    public ListView<String> poolCapacity;

    public void initialize() {
        for (double i = 1.0; i < 2.1; i += 0.1) {
            poolCapacity.getItems().add(String.format("%.1f", i));
        }
    }

    @FXML
    public void simulation() {
        PoolInfoPanel.clear();
        PiscinaQuimica.setActualCapacity(0);
        PiscinaQuimica.simulateTotalCapacity(Double.parseDouble(poolCapacity.getSelectionModel().getSelectedItem()));
        PoolInfoPanel.setText(String.format("Se simulo una piscina de %d litros", PiscinaQuimica.getTotalCapacity()));
        filledUpPool.setProgress(0);
    }

    @FXML
    public void fillPool() {
        try {
            filledUpPool.setProgress(PiscinaQuimica.fillPool());
            PoolInfoPanel.appendText(String.format("\nSe lleno la piscina en: %d, valor actual: %d", (PiscinaQuimica.getRandomFill()), PiscinaQuimica.getActualCapacity()));
        } catch (ExcepcionPersonalizada e) {
            PoolInfoPanel.appendText(e.getMessage());
        }
    }

    @FXML
    public void emptyPool() {
        try {
            filledUpPool.setProgress(PiscinaQuimica.emptyPool());
            PoolInfoPanel.appendText(String.format("\nSe lleno la piscina en: %d, valor actual: %d", (PiscinaQuimica.getRandomFill()), PiscinaQuimica.getActualCapacity()));
        } catch (ExcepcionPersonalizada e) {
            PoolInfoPanel.appendText(e.getMessage());
        }
    }


}