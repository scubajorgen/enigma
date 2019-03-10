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
public class TestSteckerBrett
{
    @Test
    public void testExchange()
    {
        SteckerBrett board=new SteckerBrett();
        
        board.setExchange('B', 'K');
        assertEquals('A', board.exchange('A'));
        assertEquals('B', board.exchange('K'));
        assertEquals('K', board.exchange('B'));
        assertEquals('A', board.exchange('a'));
        assertEquals('B', board.exchange('k'));
        assertEquals('K', board.exchange('b'));
        assertEquals('A', board.exchange(1));
        assertEquals('B', board.exchange(11));
        assertEquals('K', board.exchange(2));
        
    }

    
    @Test
    public void testClearBoard()
    {
        SteckerBrett board=new SteckerBrett();
        
        board.setExchange('B', 'K');
        board.clearBoard();
        assertEquals('A', board.exchange('A'));
        assertEquals('B', board.exchange('B'));
        assertEquals('K', board.exchange('K'));
        
    }
}
