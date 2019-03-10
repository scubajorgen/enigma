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
public class Toolbox
{

    /**
     * Converts a user position setting to a position value
     * @param positionSetting 1-26, A-Z, a-z
     * @return Value 0-25
     */
    public static int settingToPosition(int positionSetting)
    {
        int newPosition;
        
        newPosition=0;
        // 1-26
        if (positionSetting>0 && positionSetting<26)
        {
            newPosition=positionSetting-1;
        }
        // 'A'-'Z'
        else if (positionSetting>='A' && positionSetting<='Z')
        {
            newPosition=positionSetting-'A';
        }
        // 'a'-'z'
        else if (positionSetting>='a' && positionSetting<='z')
        {
            newPosition=positionSetting-'a';
        }
        else
        {
            Logger.logError("Invalid position setting");
        }
        return newPosition;
    }
    
    /**
     * Converts a setting string to an integer setting
     * @param setting 01-26, A-Z, a-z
     * @return Integer setting 1-26
     */
    public static int settingToPositionSetting(String setting)
    {
        int position;
        
        position=0;
        
        if (setting.length()==1)
        {
            position=setting.toUpperCase().charAt(0);
            if (position>='A' && position<='Z')
            {
                position-='A';
                position++;
            }
            else if (position>='1' && position<='9')
            {
                position-='0';
            }
            else
            {
                position=0;
                Logger.logError("Illegal position setting");
            }
        }
        else if (setting.length()==2)
        {
            position=Integer.parseInt(setting);
            if ((position<=0) || (position>26))
            {
                position=0;
                Logger.logError("Illegal position setting");
            }
        }
        else
        {
            Logger.logError("Illegal position setting");
        }
        return position;
    }    
}
