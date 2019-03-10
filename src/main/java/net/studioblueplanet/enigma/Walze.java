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
public class Walze
{
    private static final int MAX_POSITIONS=26;
    
    private String[]    names=
    {
        "I",
        "II",
        "III",
        "IV",
        "V",
        "VI",
        "VII",
        "VIII",
        "Beta",
        "Gamma"
            
    };
    private int[][]     tables=
    {
        {
            'E','K','M','F','L','G','D','Q','V','Z','N','T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J'
        },
        {
            'A','J','D','K','S','I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'
        },
        {
            'B','D','F','H','J','L','C','P','R','T','X','V','Z','N','Y','E','I','W','G','A','K','M','U','S','Q','O'
        },
        {
            'E','S','O','V','P','Z','J','A','Y','Q','U','I','R','H','X','L','N','F','T','G','K','D','C','M','W','B'
        },
        {
            'V','Z','B','R','G','I','T','Y','U','P','S','D','N','H','L','X','A','W','M','J','Q','O','F','E','C','K'
        },
        {
            'J','P','G','V','O','U','M','F','Y','Q','B','E','N','H','Z','R','D','K','A','S','X','L','I','C','T','W'
        },
        {
            'N','Z','J','H','G','R','C','X','M','Y','S','W','B','O','U','F','A','I','V','L','P','E','K','Q','D','T'
        },
        {
            'F','K','Q','H','T','L','X','O','C','B','J','S','P','D','Z','R','A','M','E','W','N','I','U','Y','G','V'
        },
        {
            'L','E','Y','J','V','C','N','I','X','W','P','B','Q','M','D','R','T','A','K','Z','G','F','U','H','O','S'
        },
        {
            'F','S','O','K','A','N','U','E','R','H','M','B','T','I','Y','C','W','L','Q','P','Z','X','V','G','J','D'
        }
    };
    
    private int[]       verse;
    private int[]       inverse;
    
    private boolean[]   hasSecondNotch={false, false, false, false, false, true, true, true, true, true};
    
    /* Notch positions as seen from the window */
    private int         notchPosition1[]={'Q','E','V','J','Z','Z','Z','Z','?','?'};
    private int         notchPosition2[]={'?','?','?','?','?','M','M','M','?','?'};
    
    private int         rotorIndex;
    
    private int         position;
    private int         ringStellung;
    
    /**
     * Constructor. Finds the index of this rotor based on the name given
     * @param name 
     */
    public Walze(String name)
    {
        int     i;
        int     j;
        boolean found;
        
        found   =false;
        i       =0;
        while ((i<names.length) && !found)
        {
            if (name.equals(names[i]))
            {
                found=true;
                rotorIndex=i;
            }
            i++;
        }
        if (!found)
        {
            System.err.println("Not a valid rotor chosen");
        }
        else
        {
            // calculate function and inverse function
            verse   =new int[MAX_POSITIONS];
            inverse =new int[MAX_POSITIONS];
            i=0;
            while (i<MAX_POSITIONS)
            {
                verse[i]=tables[rotorIndex][i]-'A';
                inverse[tables[rotorIndex][i]-'A']=i;
                i++;
            }
            
        }
        position    =0;
        ringStellung=0;
    }
    
    /**
     * Set the rotor in given position
     * @param positionValue Position of the rotor 1-26, A-Z, a-z
     */
    public void setGrundStellung(int positionValue)
    {
        this.position=Toolbox.settingToPosition(positionValue);
    }
    
    /**
     * Get the rotor position as letter
     * @return Position A-Z
     */
    public int getGrundStellung()
    {
        return 'A'+position;
    }
    
    /**
     * Sets the RingStellung
     * @param positionValue Position 1-26, A-Z, a-z
     */
    public void setRingStellung(int positionValue)
    {
        this.ringStellung=Toolbox.settingToPosition(positionValue);
    }
    
    public boolean isNotch()
    {
        boolean isNotch;
        
        isNotch=(position==notchPosition1[rotorIndex]-'A') ||
                (hasSecondNotch[rotorIndex] && (position==notchPosition2[rotorIndex]-'A'));
        
        return isNotch;
    }
    
    
    /**
     * Advances the rotor one position
     */
    public void advance()
    {
        this.position++;
        if (this.position==MAX_POSITIONS)
        {
            this.position=0;
        }
    }
    
    
    /**
     * Encode decode
     * @param letter
     * @return 
     */
    public int rightToLeft(int letter)
    {
        int realPosition;
        int entry;
        int exit;
        int encodeDecode;
        
        if (letter>='A' && letter<='Z')
        {
            letter-='A';
        }
        
        realPosition=position-ringStellung;
        if (realPosition<0)
        {
            realPosition+=MAX_POSITIONS;
        }
        if (realPosition>=MAX_POSITIONS)
        {
            realPosition-=MAX_POSITIONS;
        }
        entry=realPosition+letter;
        if (entry>=MAX_POSITIONS)
        {
            entry-=MAX_POSITIONS;
        }
        
        exit=verse[entry];
        
        encodeDecode=exit-realPosition;
        
        if (encodeDecode<0)
        {
            encodeDecode+=MAX_POSITIONS;
        }
        
        
        return encodeDecode+'A';
    }

    
    /**
     * Encode decode
     * @param letter
     * @return 
     */
    public int leftToRight(int letter)
    {
        int realPosition;
        int entry;
        int exit;
        int encodeDecode;
        
        
        // Convert letter to position
        if (letter>='A' && letter<='Z')
        {
            letter-='A';
        }
        
        // Real position of the wireing
        realPosition=position-ringStellung;
        if (realPosition<0)
        {
            realPosition+=MAX_POSITIONS;
        }
        if (realPosition>=MAX_POSITIONS)
        {
            realPosition-=MAX_POSITIONS;
        }
        
        
        entry=realPosition+letter;
        if (entry>=MAX_POSITIONS)
        {
            entry-=MAX_POSITIONS;
        }
        
        exit=inverse[entry];
        
        encodeDecode=exit-realPosition;
        
        if (encodeDecode<0)
        {
            encodeDecode+=MAX_POSITIONS;
        }
        
        
        return encodeDecode+'A';
    }
    
    
}
