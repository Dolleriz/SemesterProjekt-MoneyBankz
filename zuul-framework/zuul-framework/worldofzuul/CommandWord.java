package worldofzuul;

public enum CommandWord
{
    GO("gå"), QUIT("afslut"), HELP("hjælp"), UNKNOWN("?"),
    PICKUP("tag"), INVENTORY("taske");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
