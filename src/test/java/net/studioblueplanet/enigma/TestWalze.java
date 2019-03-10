/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.studioblueplanet.enigma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * @author jorgen
 */
public class TestWalze
{
    @Test
    public void testLeftToRight()
    {
        int value;
        Walze rotor=new Walze("I");
        
        rotor.setGrundStellung('Y');
        rotor.setRingStellung(6);   // 06 or F
        value=rotor.leftToRight('W');
        assertEquals('A', value);
        
        
    }
    
    @Test
    public void testRightToLeft()
    {
        int value;
        Walze rotor=new Walze("I");
        
        rotor.setGrundStellung('A');
        rotor.setRingStellung(1);   // 01 or A
        value=rotor.rightToLeft('A');
        assertEquals('E', value);

        rotor.setGrundStellung('B');
        rotor.setRingStellung(1);   // 01 or A
        value=rotor.rightToLeft('A');
        assertEquals('J', value);
    
        rotor.setGrundStellung('Z');
        rotor.setRingStellung(1);   // 01 or A
        value=rotor.rightToLeft('B');
        assertEquals('F', value);
    
        rotor.setGrundStellung('B');
        rotor.setRingStellung(1);   // 01 or A
        value=rotor.rightToLeft('Z');
        assertEquals('D', value);
    
        rotor.setGrundStellung('Y');
        rotor.setRingStellung(6);   // 06 or F
        value=rotor.rightToLeft('A');
        assertEquals('W', value);
    }
    
    
}
