/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.studioblueplanet.enigma;

/**
 *
 * @author jorgen
 */
public class EnigmaSimulator
{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Enigma enigma;
        
       
        enigma=new EnigmaM3();
        enigma.setWalzen("I II III");
        enigma.setUmkehrWalze("UKW B");
        enigma.setSteckerBrett("");
        enigma.setRingStellungen("1 1 1");
        enigma.setGrundStellungen("Q D U");
        
        
        int i=0;
        while (i<30)
        {
            System.out.println("Encoding: "+enigma.encodeDecode("a")+" "+enigma.getGrundStellungen());
            i++;
        }

/*
            String test="";
            int i=0;
            while (i<1)
            {
                test+="aaaaaaaaaaaaaaaaaaaaaaaaaa";
                i++;
            }
            System.out.println("Encoding: "+enigma.encodeDecode(test));
*/
    }
    
}
