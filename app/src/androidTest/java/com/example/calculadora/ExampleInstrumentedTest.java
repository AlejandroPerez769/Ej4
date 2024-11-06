package com.example.calculadora;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.calculadora", appContext.getPackageName());
    }

    /**
     * Verifica estas pruebas si la calculadora funciona correctamente realizando pruebas.
     */

    @Test
    public void  testAdd2Operands() {

        int total = Calculator.calculate("5+3");

        assertEquals("X + Y operations not working correctly",8,total);
    }
    @Test
    public void  testAdd1Operands() {

        int total = Calculator.calculate("4+3+1");

        assertEquals("+X operations not working correctly",8,total);

    }
    @Test
    public void  testMult2Operands() {

        int total = Calculator.calculate("4*2");

        assertEquals("4*X operations not working correctly",8,total);


    }
    @Test
    public void  testMult1Operands() {

        int total = Calculator.calculate("2*2*8");

        assertEquals("*X operations not working correctly",32,total);

    }
    @Test
    public void  testMult3Operands() {

        int total = Calculator.calculate("3+2*2");

        assertEquals("3+X*X operations not working correctly",7,total);


    }

}