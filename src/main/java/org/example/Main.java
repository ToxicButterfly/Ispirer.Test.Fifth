package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ComplexCalculatorApp app = new ComplexCalculatorApp();
            app.setVisible(true);
        });
    }
}