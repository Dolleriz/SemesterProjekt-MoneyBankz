package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    Inventory roomInventory = new Inventory(5);

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "Du er " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Udgange:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    protected void enterRoom() {
        System.out.println(roomInventory.toString());
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

