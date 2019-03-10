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
    public void testSetGrundstellung()
    {
        Walze rotor=new Walze("I");
        
        rotor.setGrundStellung(0);
        assertEquals('A', rotor.getGrundStellung());

        rotor.setGrundStellung(1);
        assertEquals('A', rotor.getGrundStellung());

        rotor.setGrundStellung(26);
        assertEquals('Z', rotor.getGrundStellung());

        rotor.setGrundStellung(27);
        assertEquals('A', rotor.getGrundStellung());

        rotor.setGrundStellung('P');
        assertEquals('P', rotor.getGrundStellung());
    
    }
    
    @Test
    public void testAdvance()
    {
        Walze rotor=new Walze("I");
        
        rotor.setGrundStellung(5);
        rotor.advance();
        assertEquals('F', rotor.getGrundStellung());

        rotor.setGrundStellung('G');
        rotor.advance();
        assertEquals('H', rotor.getGrundStellung());
    
    }
    
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
    public void testIsNotch()
    {
        int value;
        Walze rotor=new Walze("I");
        
        rotor.setGrundStellung('Y');
        assertEquals(false, rotor.isNotch());

        rotor.setGrundStellung('Q');
        assertEquals(true, rotor.isNotch());
        
        rotor=new Walze("VI");
        rotor.setGrundStellung('A');
        assertEquals(false, rotor.isNotch());
        rotor.setGrundStellung('Y');
        assertEquals(false, rotor.isNotch());
        rotor.setGrundStellung('Z');
        assertEquals(true, rotor.isNotch());
        rotor.setGrundStellung('L');
        assertEquals(false, rotor.isNotch());
        rotor.setGrundStellung('N');
        assertEquals(false, rotor.isNotch());
        rotor.setGrundStellung('M');
        assertEquals(true, rotor.isNotch());
        
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
