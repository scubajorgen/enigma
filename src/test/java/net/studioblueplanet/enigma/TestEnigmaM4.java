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
public class TestEnigmaM4
{
    @Test
    public void testEncodeDecode()
    {
        EnigmaM4 enigma;
        String      encrypted;
        String      expected;
        
        // Reference: https://cryptii.com/pipes/enigma-machine
        enigma=new EnigmaM4();
        enigma.setWalzen("Beta I II III");
        enigma.setUmkehrWalze("UKW B2");
        enigma.setSteckers("bq cr di ej kw mt os px uz gh");
        enigma.setRingStellungen("A A A A");
        enigma.setGrundStellungen("A A A A");
        encrypted=enigma.encodeDecode("the quick brown fox jumps over the lazy dogs");
        expected=new String("ikiryvnxpjermijqmjhzlddrjrmthpjjkgbq").toUpperCase();
        assertEquals(expected, encrypted);
        
        // Reference: https://cryptii.com/pipes/enigma-machine
        enigma=new EnigmaM4();
        enigma.setWalzen("Beta I II III");
        enigma.setUmkehrWalze("UKW B2");
        enigma.setSteckers("bq cr di ej kw mt os px uz gh");
        enigma.setRingStellungen("Z A Z A");
        enigma.setGrundStellungen("A Z A Z");
        encrypted=enigma.encodeDecode("the quick brown fox jumps over the lazy dogs");
        expected=new String("ofbiixumlbtqxvmodoexjhnxxkrysggxouip").toUpperCase();
        assertEquals(expected, encrypted);
       
        // Reference: http://enigma.louisedade.co.uk/enigma.html
        enigma=new EnigmaM4();
        enigma.setWalzen("Beta VI VII VIII");
        enigma.setUmkehrWalze("UKW B2");
        enigma.setSteckers("bq cr di");
        enigma.setRingStellungen("Z A Z A");
        enigma.setGrundStellungen("A L L Y");
        encrypted=enigma.encodeDecode("the quick brown fox jumps over the lazy dogs");
        expected=new String("WBLUJHAYLUIDVAXZXYOUEZQBNXGKJZWATPLK").toUpperCase();
        assertEquals(expected, encrypted);
       
        
    }
}
