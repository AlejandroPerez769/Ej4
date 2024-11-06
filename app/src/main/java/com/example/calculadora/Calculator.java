package com.example.calculadora;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Calulator se encarga de dar funcionalidades a la calculadora
 * para poder realizar operaciones aritméticas.
 *
 * @author Alejandro
 * @version 1.0
 * @since 2024-11-05
 */

public class Calculator {

    static TextView barra;

    /**
     *
     * @param barra es el TextView donde se muestran las operaciones
     * de la calculadora.
     */

    public static void setBarra(TextView barra) {
        Calculator.barra = barra;
    }

    /**
     * Calcula el resultado de la operacion aritmética.
     */
    public static void resultado() {
        String expression = barra.getText().toString();
        int result = calculate(expression);
        actualizarBarra(result);
    }

    /**
     * Se encarga de borrar todos los numeros u operadores del TextView barra.
     */

    public static void borrarDatos() {
        if (barra != null) barra.setText("");  // Verificación de null antes de setText
    }

    /**
     * Añade el número seleccionado de los botones al TextView barra
     * @param view se encarga de obtener el número u operador
     *             del botón seleccionado.
     */
    public static void anyadirNumeros(View view) {
        Button button = (Button) view;
        String number = button.getText().toString();
        barra.append(number);
    }

    /**
     *
     * @param nums Por aqui pasamos la operación aritmética completa para validar que siga el formato correcto.
     * @return Devuelve un booleano si esta correcta o no.
     */
    public static boolean esValido(String nums) {
        if (nums.isEmpty()) {
            return false;
        }

        String regex = "^[-]?[0-9]+([+\\-*][-]?[0-9]+)*$";
        return nums.matches(regex);
    }

    /**
     * Calcula el resultado de la operación aritmética
     * @param nums Es el parámetro por donde se le pasa la operación aritmética para ser validada
     * @return Devuelve el resultado si la operación es correcta. Si no lo es devuelve -1.
     */

    public static int calculate(String nums) {

       if (nums.isEmpty()) {
           return 0;
       }
       else if (!esValido(nums)) {
            if (barra != null) barra.setText("-1");  // Evitar NullPointerException
            return -1;
        }

        if (nums.contains("+")) {
            String[] sumaPartes = nums.split("\\+");
            int sumResult = 0;

            for (String part : sumaPartes) {
                sumResult += calculate(part.trim());
            }

            if (barra != null) barra.setText(String.valueOf(sumResult));  // Evitar NullPointerException
            return sumResult;
        }

        if (nums.contains("*")) {
            String[] multiPartes = nums.split("\\*"); //-6*-8 //-6, -8
            int multResult = 1;

            for (String part : multiPartes) {
                multResult *= calculate(part.trim());
            }

            if (barra != null) barra.setText(String.valueOf(multResult));  // Evitar NullPointerException
            return multResult;
        }

        if (nums.contains("-")) {

            String[] restaPartes = nums.split("-");

            int restaResult = calculate(restaPartes[0].trim());

            for (int i = 1; i < restaPartes.length; i++) {
                restaResult -= calculate(restaPartes[i].trim());
            }

            if (barra != null) barra.setText(String.valueOf(restaResult));

            return restaResult;
        }




        return Integer.parseInt(nums.trim());
    }

    /**
     * Actualiza el resultado en la pantalla
     * @param resultado de la operacion en la barra
     */
    public static void actualizarBarra(int resultado) {
        if (barra != null) barra.setText(String.valueOf(resultado));
    }
}
