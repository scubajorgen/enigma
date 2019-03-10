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
public class SteckerBrett
{
    private static final int MAX_POSITIONS=26;
    
    private int[]       exchange;
    
    
    /**
     * Initialises the switchboard. Removes all wires
     */
    public SteckerBrett()
    {
        int i;
        
        exchange        =new int[MAX_POSITIONS];
        clearBoard();
    }
    
    /**
     * Clears the switchboard: removes all wires
     */
    public void clearBoard()
    {
        int letter;

        letter='A';
        while (letter<='Z')
        {
            exchange[letter-'A']=letter;
            letter++;
        }
    }
    
    /**
     * Inserts a wire between given letters
     * @param letter1 First letter
     * @param letter2 Second letter
     */
    public void setExchange(int letter1, int letter2)
    {
        exchange[letter1-'A']=letter2;
        exchange[letter2-'A']=letter1;
    }
    
    /**
     * Returns the exchanged letter or the same letter if not exchanged
     * @param letter Letter to exchange
     * @return The exchanged letter
     */
    public int exchange(int letter)
    {
        return exchange[Toolbox.settingToPosition(letter)];
    }
}
