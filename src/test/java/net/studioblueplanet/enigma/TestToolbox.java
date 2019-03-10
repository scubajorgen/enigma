/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.studioblueplanet.enigma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**

/**
 *
 * @author jorgen
 */
public class TestToolbox
{
    @Test
    public void testSettingToPosition()
    {
        assertEquals(0, Toolbox.settingToPosition('A'));
        assertEquals(2, Toolbox.settingToPosition('C'));
        assertEquals(0, Toolbox.settingToPosition('a'));
        assertEquals(2, Toolbox.settingToPosition('c'));
        assertEquals(0, Toolbox.settingToPosition(1)  );
        assertEquals(2, Toolbox.settingToPosition(3)  );
    }
    
    @Test
    public void testSettingToPositionSetting()
    {
        assertEquals(5, Toolbox.settingToPositionSetting("5") );
        assertEquals(5, Toolbox.settingToPositionSetting("05"));
        assertEquals(26,Toolbox.settingToPositionSetting("26"));
        assertEquals(0, Toolbox.settingToPositionSetting("27"));
        assertEquals(5, Toolbox.settingToPositionSetting("e") );
        assertEquals(5, Toolbox.settingToPositionSetting("E") );
        assertEquals(0, Toolbox.settingToPositionSetting("#") );
    }
}
