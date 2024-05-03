package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplexCalculatorApp extends JFrame {

    private JTextField realField1;
    private JTextField imaginaryField1;
    private JTextField realField2;
    private JTextField imaginaryField2;
    private JTextField powField;
    private JTextArea resultArea;

    public ComplexCalculatorApp() {
        setTitle("Комплексный калькулятор");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(2, 3));
        inputPanel.add(new JLabel("Комплексное число 1:"));
        realField1 = new JTextField();
        inputPanel.add(realField1);
        imaginaryField1 = new JTextField();
        inputPanel.add(imaginaryField1);

        inputPanel.add(new JLabel("Комплексное число 2:"));
        realField2 = new JTextField();
        inputPanel.add(realField2);
        imaginaryField2 = new JTextField();
        inputPanel.add(imaginaryField2);


        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Сложение");
        addButton.addActionListener(e -> calculate("+"));
        buttonPanel.add(addButton);

        JButton subtractButton = new JButton("Вычитание");
        subtractButton.addActionListener(e -> calculate("-"));
        buttonPanel.add(subtractButton);

        JButton multiplyButton = new JButton("Умножение");
        multiplyButton.addActionListener(e -> calculate("*"));
        buttonPanel.add(multiplyButton);

        JButton divideButton = new JButton("Деление");
        divideButton.addActionListener(e -> calculate("/"));
        buttonPanel.add(divideButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(new JScrollPane(resultArea), BorderLayout.SOUTH);
    }

    private void calculate(String operation) {
        try {
            double real1 = Double.parseDouble(realField1.getText());
            double imaginary1 = Double.parseDouble(imaginaryField1.getText());
            double real2 = Double.parseDouble(realField2.getText());
            double imaginary2 = Double.parseDouble(imaginaryField2.getText());

            Complex number1 = new Complex(real1, imaginary1);
            Complex number2 = new Complex(real2, imaginary2);
            Complex result;

            switch (operation) {
                case "+":
                    result = number1.add(number2);
                    break;
                case "-":
                    result = number1.sub(number2);
                    break;
                case "*":
                    result = number1.mul(number2);
                    break;
                case "/":
                    result = number1.div(number2);
                    break;
                default:
                    throw new IllegalArgumentException("Неверная операция: " + operation);
            }

            resultArea.setText("Результат: " + result);
        } catch (NumberFormatException ex) {
            resultArea.setText("Ошибка: Некорректный формат чисел");
        } catch (IllegalArgumentException ex) {
            resultArea.setText("Ошибка: " + ex.getMessage());
        }
    }
}