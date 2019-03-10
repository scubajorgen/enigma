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
public class TestUmkehrWalze
{
    @Test
    public void testReflect()
    {
        UmkehrWalze reflector;
        
        reflector=new UmkehrWalze("UKW C");
        assertEquals('I', reflector.reflect('E'));
    }
}
