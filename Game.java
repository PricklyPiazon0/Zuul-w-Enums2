/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room patientRoom, hallwayNorth, surgicalTheatre, nursesOffice, doctorsOffice, hallwaySouth, secretExit, darkPassage, medicineLocker, hospitalFrontSteps, outsideWest, outsideEast, frontGate, backSideOfHospital, basementLobby, barracks, officersQuaters, radioRoom;
      
        // create the rooms
        patientRoom = new Room("in a patient recovery room with rod brass framed beds dawned with white pressed sheets that smell of a recent bleaching, wooden night stands supporting vases of fresh flowers and sturdy metal lamps.  The walls have wood paneleling covering all the walls except where giant metal framed windows allow the sunlight in.  The room remeinds you of every other hospital room you have been in.");
        hallwayNorth = new Room("in one half of a hallway that exhibts 3 sturdy wooden doors, cermaic tile walls, and linoleam squares on the well worn floor.  This hallway looks like it was built to be easily cleaned.");
        nursesOffice = new Room("in a room with Wooden Wainscotting running across the lower half of the 4 walls.  Against the far wall lies a giant oak desk with a mechanical typewritter sitting on top and rows of wooden folding chairs assembled infront of the desk.  Along the wall are a handfull of lockable wooden filling cabinets mostlikey containing patients' medical records, and similiar metal cots to the patients' rooms covered with general issue blankets.");
        doctorsOffice = new Room("in a room with wood panels adorning the walls save for the two small windows both opening to the outside courtyard.  There are two huge book shelfs with medical books and paper binders slovenly stored in them.  There sits a fancy desk on the south side of the room, and a leather couch on the west side.  Theere is a what looks like a frayed mulitcolor pattenerd rug on the floor.");
        hallwaySouth = new Room("in the other half of the tiled wall, linoleam floored hallway, this time also containing three sturdy wood doors");
        secretExit = new Room("in a dark passage through the forest surrounding the hospital.  On the worn dirt road you can see disgarded Nazi field grey uniforms, no doubt from soldiers who had previously left the Russian front and looking to escape themselves, knowing they will soon be defeated.");
        darkPassage = new Room("in a poorly lighted stone staircase stands before you.  Through the sporatic flikkering of the elictric light bulbs you can tell this passage is part of a much older constructed foundation below the hospital");
        medicineLocker = new Room("in a room with no windows, and minimalitic fixtures and melding.  Only Two details make with room uniques, the thick firedoor, that looks like it prevents anyone without a key from entering.  And two large thick steel cabinets that have glass windows alowwing you to see inside.");
        hospitalFrontSteps = new Room("in front of a cozy white porch with rocking chairs that no doubt are tharee to ease patients's suffering.  Below the porch stands a perfectly manicured lawn with a stone walkway that leads in two directions");
        outsideWest = new Room("standing on another maticously taken care of lawn with no bald spots to be seen.  There is a stone walkway that seperates into 3 differnt paths.");
        outsideEast = new Room("on the stone walkway entering from both sides of the hospital, but you see it's connectiong middle section torn up.  In its place a small garden with what looks like potatoes and suger beets have been planted recently in the same spot next to the outside hospital wall, where the stone walkway was torn up, and between the stone compound wall.");
        frontGate = new Room("led to the break in the compound's encompassing stone wall.  In the break of the wall, stands a giant open steel gate.  This is the only visable entrance into the hospital complex and mostlekely, the avenuee in which patients and supplies arive at the hospital."); 
        backSideOfHospital = new Room("on the stone walkway after it has wrapped around the hospital lawn to the back wall of the hospital.  Curiously, there is no door to exit or enter the hospital from this side, only a rusted set of bilco doors that were clearly built at one time to move the bodies from the now dilapidated and unused morgue.");
        basementLobby = new Room("in a well adorned stone laiden room hanging two huge blood red flags showcassing the black swastika symbol in a white circle on the wall next to the surface entrance.  Between the two flags lays a fire pit with a brigh high flame, and a six foot by four foot portrait of the Furher.  In the middle of the room sits a large desk with a divider not allowing one to enter any of the three subturanean attached rooms without passing through the divider.");
        barracks = new Room("in a room entirely made of stone.  The stone walls are obstructed by wooden bunks, probably as many as thirty men could sleep here.  There are two alcoves, one containg a handfull of toilest and showers.  The other alcove containing wall hooks that hold both american and nazi dress uniforms.");
        officersQuaters = new Room("in a room containing only a few brass beds with high quality bedding on them and foot locker infront of each one.  A prominent picture of Adolf Hitler stood on one of the walls, in a postion that when lying in the beds the officers could always see his face.");
        radioRoom = new Room("in a room with a door leading out on each side of it.  Along the walls large metal tables are lined up to support large metal cladd electronic devices no doubt to send and recieve communications with the high command.");
        surgicalTheatre = new Room("in a room well lighted by the cieling to floor length window built into the far corner of the room.  There stands a metal operationg gurney, and table to hold instruments, both covered with clean linen as if ready for surgery.  The cieling holds a truss of powerfull looking lights assembles as if in a downward pointing chandellier formation.  The wall in this room are tiled and there sits a viewing section complete with seating on the other side of the room.");
        
        // initialise room exits
        patientRoom.setExit("south", hallwayNorth);
        
        hallwayNorth.setExit("north", patientRoom);
        hallwayNorth.setExit("east", nursesOffice);
        hallwayNorth.setExit("west", doctorsOffice);
        hallwayNorth.setExit("south", hallwaySouth);
        
        nursesOffice.setExit("south", hallwayNorth);
        
        doctorsOffice.setExit("east", hallwayNorth);
        doctorsOffice.setExit("north", secretExit);
        doctorsOffice.setExit("down", darkPassage);
        
        hallwaySouth.setExit("west", surgicalTheatre);
        hallwaySouth.setExit("east", medicineLocker);
        hallwaySouth.setExit("north", hallwayNorth);
        hallwaySouth.setExit("south", hospitalFrontSteps);
        
        surgicalTheatre.setExit("east", hallwaySouth);
        
        medicineLocker.setExit("west", hallwaySouth);
        
        hospitalFrontSteps.setExit("north", hallwaySouth);
        hospitalFrontSteps.setExit("west", outsideWest);
        hospitalFrontSteps.setExit("east", outsideEast);
        
        outsideWest.setExit("east", hospitalFrontSteps);
        outsideWest.setExit("west", frontGate);
        outsideWest.setExit("south", backSideOfHospital);
        
        frontGate.setExit("east", outsideWest);
        
        outsideEast.setExit("west", hospitalFrontSteps);
        outsideEast.setExit("south", backSideOfHospital);
        
        backSideOfHospital.setExit("down", basementLobby);
        backSideOfHospital.setExit("west", outsideWest);
        backSideOfHospital.setExit("east", outsideEast);
        
        basementLobby.setExit("up", backSideOfHospital);
        basementLobby.setExit("west", barracks);
        basementLobby.setExit("east", officersQuaters);
        basementLobby.setExit("south", radioRoom);
        
        barracks.setExit("east", basementLobby);
        
        officersQuaters.setExit("west", basementLobby);
        
        radioRoom.setExit("north", basementLobby);
        radioRoom.setExit("up", darkPassage);
        
        darkPassage.setExit("up", doctorsOffice);
        darkPassage.setExit("down", radioRoom);


        currentRoom = patientRoom;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Beware of the Dog");
        System.out.println("Your name is Jeff Pike, and the last thing you remember is");
        System.out.println("having been giving special orders after attending General Eisenhower's");
        System.out.println("final brieffing on the Normandy landings.  The orders brought you to");
        System.out.println("Lisbon, Portugal on June 1, 1944, to make sure through contact with a");
        System.out.println("Nazi informer, that the third Riech mistankently believes the Allies are");
        System.out.println("intending to land at Pas De Calais, instead of Normandy.  Your memory is");
        System.out.println("hazy with the last memorable detail being, your arrival in Lisbon.  You");
        System.out.println("head is throbbing worse than the hangovers you used to get from spending");
        System.out.println("the night drinking dime store whiskey with guys from the neighborhood.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
