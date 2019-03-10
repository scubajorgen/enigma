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
public class UmkehrWalze
{
    private String[] names=
    {
        "UKW A",
        "UKW B",
        "UKW C",
        "UKW B2",
        "UKW C2"
    };
    
    private int[][] tables=
    {
        {
            'E','J','M','Z','A','L','Y','X','V','B','W','F','C','R','Q','U','O','N','T','S','P','I','K','H','G','D'
        },
        {
            'Y','R','U','H','Q','S','L','D','P','X','N','G','O','K','M','I','E','B','F','Z','C','W','V','J','A','T'
        },
        {
            'F','V','P','J','I','A','O','Y','E','D','R','Z','X','W','G','C','T','K','U','Q','S','B','N','M','H','L'
        },
        {
            'E','N','K','Q','A','U','Y','W','J','I','C','O','P','B','L','M','D','X','Z','V','F','T','H','R','G','S'
        },
        {
            'R','D','O','B','J','N','T','K','V','E','H','M','L','F','C','W','Z','A','X','G','Y','I','P','S','U','Q'
        }
    };

    private int reflectorIndex;

    /**
     * Constructor. Initialises the reflector based on given name. 
     * @param name Name: 'B', 'C', 'B2' or 'C2'
     */
    public UmkehrWalze(String name)
    {
        int     i;
        boolean found;
        
        found   =false;
        i       =0;
        while ((i<names.length) && !found)
        {
            if (name.equals(names[i]))
            {
                found=true;
                reflectorIndex=i;
            }
            i++;
        }        
        if (!found)
        {
            System.err.println("Not a valid reflector chosen");
        }
    }
    
    /**
     * Reflects the letter
     * @param letter Letter to reflect A-Z
     * @return The reflected letter A-Z
     */
    public int reflect(int letter)
    {
        return tables[reflectorIndex][letter-'A'];
    }
}
