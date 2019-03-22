/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.studioblueplanet.enigma;

import java.util.ArrayList;

/**
 *
 * @author jorgen
 */
public class EnigmaSimulator
{
    private static String exampleCypher=
                        "MLETW NNJZJ ECTHJ JUUVD DBAZS"+
                        "XBVOF SEWLR MLSBX GNLNL LLIGO"+
                        "IMYMU HBGRI HZTFG TXKCT CRPJN"+
                        "BHZMQ QWGUA KBJXJ BITQI BFXMZ"+
                        "MHHWK OBSSD OGELQ UWQXG IMLVG"+
                        "YJQSL PIQNZ VQVFN LGQXN PUJEZ"+
                        "MPUNC MLETS JIXZP HUNBN AGVCB"+
                        "SAAIN IIHJV CWISA NHEMW JOEIY"+
                        "MXSFE JAEPU FJLIT VUZYS HYWYP"+
                        "XTAYJ CARWI YORFI VANOM BXWDT";            

    private static void simpleExample()
    {
        Enigma  enigma;
        String  plaintext;
        String  cyphertext;
        
        enigma=new EnigmaM3();
        enigma.setWalzen("I II III");
        enigma.setUmkehrWalze("UKW B");
        enigma.setSteckers("bq cr di ej kw mt os px uz gh");
        enigma.setRingStellungen("1 2 3");
        enigma.setGrundStellungen("Q D U");

        plaintext="Die Enigma ist eine Rotor-Schlusselmaschine, die im Zweiten Weltkrieg verwendet wurde";

        System.out.println("ENCRYPT");
        System.out.println("Grundstellung : "+enigma.getGrundStellungen());
        cyphertext=enigma.encodeDecode(plaintext);
        System.out.println("Text to ecrypt: "+plaintext);
        System.out.println("Encrypted     : "+cyphertext);
        System.out.println("Grundstellung : "+enigma.getGrundStellungen());
        
        
        System.out.println("DECRYPT");
        enigma.setGrundStellungen("Q D U");
        System.out.println("Grundstellung : "+enigma.getGrundStellungen());
        plaintext=enigma.encodeDecode(cyphertext);
        System.out.println("Decrypted     : "+plaintext);
        System.out.println("Grundstellung : "+enigma.getGrundStellungen());
    }
    
    private static void findWaltzen()
    {
        Enigma                  enigma;
        String                  decoded;
        Integer[]               permutation;
        ArrayList<Integer[]>    permutations;
        int                     i;
        boolean                 found;

        int             limit;
        int             count;

        String[]        waltzen       ={"I", "II", "III", "IV", "V"};
        int[]           permElements     ={0, 1, 2, 3, 4};

        enigma=new EnigmaM3(); 

        enigma.setSteckers("au cm dp ev hl iz jw no qx st");
        enigma.setUmkehrWalze("UKW B");


        permutations=new ArrayList<Integer[]>();
        Toolbox.permute(permutations, permElements, 3, 0);
        
        limit=exampleCypher.length()*9/100;

        found=false;
        i=0;
        while ((i<permutations.size()) && !found)
        {
            permutation=permutations.get(i);

            System.out.println("Permuation: "+permutation[0]+" "+permutation[1]+" "+permutation[2]+
                               ": "+waltzen[permutation[0]]+" "+waltzen[permutation[1]]+" "+waltzen[permutation[2]]);

            enigma.setWalzen(waltzen[permutation[0]]+" "+waltzen[permutation[1]]+" "+waltzen[permutation[2]]);
            

            enigma.setRingStellungen("05 22 11");    
            enigma.setGrundStellungen("U I O");
            
            decoded=enigma.encodeDecode(exampleCypher);
            
            count=Toolbox.countCharacter(decoded, 'E');
            if (count>limit)
            {
                System.out.println("Found: "+decoded);
                found=true;
            }   
            i++;
        }

     }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("############## SIMPLE EXAMPLE ######################");
        simpleExample();
        
        System.out.println();
        System.out.println("############## FIND WALTZEN ########################");
        findWaltzen();
    }

    
    
    
    
}
