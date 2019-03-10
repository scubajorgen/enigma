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
public class Enigma
{
    private static final    int             MAX_POSITIONS=26;
    private static final    int             MAX_ROTORS=5;
    
    protected               int             numberOfRotors;
    protected               Walze[]         rotors;         // 0 is rightmost or least significant rotor :-)
    protected               SteckerBrett    board;
    protected               UmkehrWalze     reflector;
    
    
    public Enigma(int numberOfRotors)
    {
        this.numberOfRotors  =numberOfRotors;
        this.rotors          =new Walze[numberOfRotors];
        this.board           =new SteckerBrett();
        this.reflector       =new UmkehrWalze("UKW B");        
    }
    
    /**
     * Construct the rotors based on the definition given
     * @param rotorDefinition Space separated string of rotornames "VI I II",
     *        from left to right
     */
    public void setWalzen(String rotorDefinition)
    {
        String[]    split;
        int         i;
        
        split   =rotorDefinition.split(" ");
        
        if (split.length==numberOfRotors)
        {
            i=0;
            while (i<numberOfRotors)
            {
                rotors[numberOfRotors-i-1]=new Walze(split[i]);
                i++;
            }
        }
        else
        {
            Logger.logError("Not correct number of rotors");
        }
    }
    
    /**
     * Choose the reflector to use based on name
     * @param name The name
     */
    public void setUmkehrWalze(String name)
    {
        reflector=new UmkehrWalze(name);
    }
    
    /**
     * Chooses the switchboard
     * @param switches String of interchanged letters "bf cg zy ...". Max 13 
     *                 pairs. Leave empty if not Steckers plugged 
     */
    public void setSteckers(String switches)
    {
        String[]    split;
        int         i;
        
        split=switches.split(" ");
        if (split.length<=MAX_POSITIONS/2)
        {
            i=0;
            while (i<split.length)
            {
                if (split[i].length()>0)
                {
                    split[i]=split[i].toUpperCase();
                    board.setExchange(split[i].charAt(0), split[i].charAt(1));
                }
                i++;
            }
        }
    }
    
    /**
     * Sets the position of each rotor
     * @param positions String of positions, either as number or letter.
     *                  Space separated "A B C" or "1 2 3" or "01 02 03"
     */
    public void setGrundStellungen(String positions)
    {
        String[]    split;
        int         i;
        
        split=positions.split(" ");
        if (split.length==this.numberOfRotors)
        {
            i=0;
            while (i<split.length)
            {
                rotors[numberOfRotors-i-1].setGrundStellung(Toolbox.settingToPositionSetting(split[i]));
                i++;
            }
        }
        else
        {
            Logger.logError("Invalid number of ring positions");
        }
    }
    
    /**
     * Sets the RingStellung of all rotors
     * @param positions String of positions, either as number or letter.
     *                  Space separated "A B C" or "1 2 3" or "01 02 03"
     */
    public void setRingStellungen(String positions)
    {
        String[]    split;
        int         i;
        
        split=positions.split(" ");
        if (split.length==this.numberOfRotors)
        {
            i=0;
            while (i<split.length)
            {
                rotors[numberOfRotors-i-1].setRingStellung(Toolbox.settingToPositionSetting(split[i]));
                i++;
            }
        }
        else
        {
            Logger.logError("Invalid number of ring positions");
        }
    }    
    
    /**
     * Returns the positions of the rotors 
     * @return Position string like "ABC"
     */
    public String getGrundStellungen()
    {
        int     i;
        String  positions;
        
        positions="";
        i=0;
        while (i<numberOfRotors)
        {
            positions+=String.format("%c", rotors[numberOfRotors-i-1].getGrundStellung());
            i++;
        }
        return positions;
    }

    /**
     * This method advances the rotors
     */
    private void advance()
    {
        int i;
        boolean revolveNext;        
        
        // Advance rotors
        i               =0;
        revolveNext     =true;
        // Only the 1st three rotors advance
        while (i<3 && revolveNext)
        {
            revolveNext=false;
            if (rotors[i].isNotch())
            {
                revolveNext=true;
            }
            
            // The double step of the 2nd rotor
            if (i==0)
            {
                if (rotors[i+1].isNotch())
                {
                    revolveNext=true;
                }
            }
            
            rotors[i].advance();
            
            
            i++;
        }
        
    }

    
    
    public String encodeDecode(String text)
    {
        int     chars;
        int     i;

        String  encodeDecode;
        int     intermediate;
        int     currentChar;
        
        text=text.toUpperCase();
        
        encodeDecode=new String();
        chars=0;
        while (chars<text.length())
        {
            currentChar=text.charAt(chars);
            
            if (currentChar>='A' && currentChar<='Z')
            {
                advance();

                intermediate=text.charAt(chars);
                intermediate=board.exchange(intermediate);

                i=0;
                while (i<numberOfRotors)
                {
                    intermediate=rotors[i].rightToLeft(intermediate);
                    i++;
                }

                intermediate=reflector.reflect(intermediate);

                i=numberOfRotors-1;
                while (i>=0)
                {
                    intermediate=rotors[i].leftToRight(intermediate);
                    i--;
                }

                intermediate=board.exchange(intermediate);

                encodeDecode+=String.format("%c", intermediate);
            }
            chars++;
        }    
        
        return encodeDecode;
    }
    

            
    
}
