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
        Enigma  enigma;
        String  text;
        String  encrypted;
        
       
        enigma=new EnigmaM3();
        enigma.setWalzen("I II III");
        enigma.setUmkehrWalze("UKW B");
        enigma.setSteckers("bq cr di ej kw mt os px uz gh");
        enigma.setRingStellungen("1 2 3");
        enigma.setGrundStellungen("Q D U");

        text="Die Enigma ist eine Rotor-Schlusselmaschine, die im Zweiten Weltkrieg verwendet wurde";

        System.out.println("ENCRYPT");
        System.out.println("Grundstellung : "+enigma.getGrundStellungen());
        encrypted=enigma.encodeDecode(text);
        System.out.println("Text to ecrypt: "+text);
        System.out.println("Encrypted     : "+encrypted);
        System.out.println("Grundstellung : "+enigma.getGrundStellungen());
        
        
        System.out.println("DECRYPT");
        enigma.setGrundStellungen("Q D U");
        System.out.println("Grundstellung : "+enigma.getGrundStellungen());
        text=enigma.encodeDecode(encrypted);
        System.out.println("Decrypted     : "+text);
        System.out.println("Grundstellung : "+enigma.getGrundStellungen());
        
  
    }

    
    
    
    
}
