package worldofzuul;

public class Game
{
    private Parser parser;
    private Room currentRoom;
    Inventory inventory = new Inventory();


    public Game() 
    {
        createRooms();
        createTrashCans();
        parser = new Parser();
    }

    private void createTrashCans() {
        Trashcan plastic = new Trashcan(Trashtype.PLASTIC, "Plastik. " +
                "\nDenne Skraldespand er til plastik." +
                "\nHeri kan der komme f.eks. emballage, plastikposer, fryseposer, madfilm samt andre plastikting.");

        Trashcan metalAndGlass = new Trashcan(Trashtype.METAL_AND_GLASS, "Metal og glas. " +
                "\nDenne Skraldespand er til metal og glas." +
                "\nHeri kan der komme f.eks. Glasflasker, Dåser, Alubakker, låg samt alufilm.");

        Trashcan foodWaste = new Trashcan(Trashtype.FOOD_WASTE, "Madaffald. " +
                "\nDenne skraldespand er til madaffald." +
                "\nHeri kan der komme f.eks. Rester, Kaffegrums, frugter, grøntsager samt teblade.");

        Trashcan paper = new Trashcan(Trashtype.PAPER, "Papir og pap. " +
                "\nDenne skraldespand er til papir og pap." +
                "\nHeri kan der komme f.eks. Blade, Kuverter, Telefonbøger, Morgenmadspakker, Æggebakker samt paprør");

        Trashcan residualWaste = new Trashcan(Trashtype.RESIDUAL_WASTE, "Restaffald. " +
                "\nDenne skraldespand er til restaffald." +
                "\nHeri kan der komme f.eks. Kartoner, Pizzabakker, Bleer samt støvsugerposer.");
    }

    private void createRooms()
    {
        Room outside, garbageArea, entrance, livingRoom, kitchen, bedRoom, bathRoom, parentsRoom;
      
        outside = new Room("udenfor. " +
                "\nMod øst er dit hus, prop fyldt med affald der skal sorteres. " +
                "\nMod nord er skraldespandene");

        garbageArea = new Room("ved skraldespandene, Foran dig er der et sæt skraldespande." +
                "\nHver skraldespand har et nummer:" +
                "\n1. Plastik.\n2. Metal.\n3. Madaffald.\n4. Pap og papir.\n5. Restaffald." +
                "\nDu burde nu have en masse affald i din taske, som skal sorteres. Ellers, kom i gang!");

        entrance = new Room("i indgangen. Væggene er dekoreret med kedelige malerier og familiefotos. " +
                "\nDu vender mod væggen der har billederne hængende.Udenfor er mod vest og stuen er mod øst");

        livingRoom = new Room("i stuen. Et stort tæppe dækker gulvet, og i et hjørne ser du et TV og en sofa. " +
                "\nVæggene er dekoreret med familiefotos. " +
                "\nMod nord er køkkenet, mod vest er indgangen og mod øst er dine forældresværelse");

        kitchen = new Room("i køkkenet." +
                "\nI midten af rummet er et spisebord." +
                "\nEt helt almindelig og uspecial køkken." +
                "\nMod syd er stuen, mod vest er dit værelse og mod øst er badeværelset");

        bedRoom = new Room("på dit værelse!" +
                "\nProp fyldt med alt det legetøj, som du elsker. Måske er der noget affald i nærheden..." +
                "\nMod øst er køkkenet");

        bathRoom = new Room("på badeværelset." +
                "\nEgentlig et ret lille badeværelse for en børnefamilie." +
                "\nMod vest er køkkenet og mod syd er dine forældresværelse");

        parentsRoom = new Room("i dine forældresværelse." +
                "\nStor redt seng, hvor hver side af sengen har et natbord." +
                "\nMod nord er badeværelset og mod vest er stuen");
        
        outside.setExit("øst", entrance);
        outside.setExit("nord", garbageArea);

        garbageArea.setExit("syd", outside);

        entrance.setExit("vest", outside);
        entrance.setExit("øst", livingRoom);

        livingRoom.setExit("øst", parentsRoom);
        livingRoom.setExit("nord", kitchen);
        livingRoom.setExit("vest", entrance);

        kitchen.setExit("vest", bedRoom);
        kitchen.setExit("øst", bathRoom);
        kitchen.setExit("syd", livingRoom);

        bedRoom.setExit("øst", kitchen);

        bathRoom.setExit("vest", kitchen);
        bathRoom.setExit("syd", parentsRoom);

        parentsRoom.setExit("vest", livingRoom);
        parentsRoom.setExit("nord", bathRoom);

        currentRoom = outside;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Tak for spillet.  Farvel.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Velkommen til En Verden af Affald!");
        System.out.println("En Verden af Affald! er et nyt spændende affaldsindsamlingsspil.");
        System.out.println("Skriv '" + CommandWord.HELP + "' hvis du har brug for hjælp, eller ikke ved hvad du kan gøre.");
        System.out.println();
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("Jeg forstår ikke hvad du mener...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.PICKUP){
            pickup(command);
        }
        else if (commandWord == CommandWord.INVENTORY){
            printInventory(inventory);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("Du er forvirret. Der er mange steder at gå hen, og mange ting du kan gøre.");
        System.out.println();
        System.out.println("Dine muligheder er:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Gå hvorhen?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Der er ikke nogen dør!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Afslut hvad?");
            return false;
        }
        else {
            return true;
        }
    }

    private void pickup(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Tag hvad?");
            return;
        }


    }

    private void printInventory(Inventory inventory) {
        System.out.println("Du kan max have 5 stykker affald i dine lommer. " +
                "\nI dine lommer har du: " +
                "\n");

        for (int i = 0; i < inventory.inventory.length; i++) {
            if (inventory.inventory[i] == null) {
                System.out.println("Der er ikke noget i denne lomme!");

            } else {
                System.out.print(inventory.inventory[i] + " ");
                System.out.println(" ");
            }
        }
    }
}
