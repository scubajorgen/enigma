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
public class TestEnigma
{
    @Test
    public void testGetPositions()
    {
        Enigma enigma;
        
        enigma=new Enigma(3);
        enigma.setWalzen("I II III");
        enigma.setGrundStellungen("K D O");
        assertEquals("KDO", enigma.getGrundStellungen());
    }
    
    @Test
    public void testGetAdvance()
    {
        Enigma enigma;
        
        enigma=new Enigma(3);
        enigma.setWalzen("III II I");
        enigma.setGrundStellungen("K D O");
        enigma.encodeDecode("A");
        assertEquals("KDP", enigma.getGrundStellungen());
        enigma.encodeDecode("A");
        assertEquals("KDQ", enigma.getGrundStellungen());
        enigma.encodeDecode("A");
        assertEquals("KER", enigma.getGrundStellungen());
        enigma.encodeDecode("A");
        assertEquals("LFS", enigma.getGrundStellungen());
        enigma.encodeDecode("A");
        assertEquals("LFT", enigma.getGrundStellungen());
        enigma.encodeDecode("A");
        assertEquals("LFU", enigma.getGrundStellungen());
    }
    
    @Test
    public void testEncodeDecode()
    {
        Enigma  enigma;
        String  encrypted;
        
        enigma=new Enigma(3);
        enigma.setWalzen("I II III");
        enigma.setUmkehrWalze("UKW B");
        enigma.setSteckerBrett("");
        enigma.setRingStellungen("1 17 12");
        enigma.setGrundStellungen("1 2 3");
        encrypted=enigma.encodeDecode("HEIL HITLER");
        assertEquals("RCGXFEAJCT", encrypted);

        enigma=new Enigma(3);
        enigma.setWalzen("I II III");
        enigma.setUmkehrWalze("UKW B");
        enigma.setSteckerBrett("");
        enigma.setRingStellungen("1 1 1");
        enigma.setGrundStellungen("P D U");
        encrypted=enigma.encodeDecode("HEIL HITLER");
        assertEquals(new String("mpyjllkozy").toUpperCase(), encrypted);
        
        enigma=new Enigma(3);
        enigma.setWalzen("VI I III");
        enigma.setUmkehrWalze("UKW C");
        enigma.setSteckerBrett("bq cr di ej kw mt os px uz gh");
        enigma.setRingStellungen("06 23 12");
        enigma.setGrundStellungen("1 17 12");
        encrypted=enigma.encodeDecode("boot klar x bei j schnoor j etwa zwo siben x nov x sechs nul cbm x proviant bis zwo nul x dez x benoetige glaeser y noch vier klar x stehe marqu bruno bruno zwo funf x lage wie j schaefer j x nnn www funf y eins funf mb steigend y gute sicht vvv j rasch");
        String expected=new String("yythxjlxteuxajgmuwmgwafqlufthqmfyexmgczduqgpnnfehruuwngmfmqadflwznqvvwqwgxhbggnxhwflcouzpdzaptubqheoqimftqjqdkdefppubagwzzxscjyxppwupsthnvkamnacpyaproeezfzctnchqjumielxpuzfthhyipaolyxwxowqzjqnjlyi").toUpperCase();
        assertEquals(expected, encrypted);
 /*       
        enigma=new Enigma(4);
        enigma.setRotors("Beta I III VI");
        enigma.setReflector("UKW B2");
        enigma.setSwitchBoard("bq cr di ej kw mt os px uz gh");
        enigma.setRingStellung("06 23 12 13");
        enigma.setRingPosition("01 17 12 13");
        encrypted=enigma.encodeDecode("the quick brown fox jumps over the lazy dogs");
        expected=new String("pnqxcexwsssywldoqwjmkcuigeqmprxizdsk").toUpperCase();
        assertEquals(expected, encrypted);
*/        
    }
    
    
}
