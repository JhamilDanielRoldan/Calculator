/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.Calculado;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jhamildanielrl
 */
public class CalculatorTest {
    

    /**
     * Test of resultado method, of class Calculator.
     */
    @org.junit.jupiter.api.Test
    public void testResul() {
        System.out.println("resultado");
        String entrada = "cos(5^(9*9+8/-cos(9)))+(8+9)";
        double expResult = 17.800681868238527;
        double result = Calculator.resul(entrada);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
