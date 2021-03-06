package worldofzuul;

/**
 * The type Regular room.
 */
public class RegularRoom extends Room {
    /**
     * Instantiates a new Regular room.
     *
     * @param description the description
     */
    public RegularRoom(String description) {

        super(description);
        fillUpRoom();
    }

    /**
     * Fill up room.
     */
    public void fillUpRoom() {

        if (roomInventory.inventory.size() < 5 + (int) (Math.random()*5)) {

            for (int i = 0; i < (5 + (int) (Math.random()*5)); i++) {
                double trashTypeNumber;

                trashTypeNumber = Math.random() * 5;
                if (trashTypeNumber <= 1) {
                    roomInventory.inventory.add(new Trash(Trashtype.PLASTIC));
                } else if (trashTypeNumber <= 2) {
                    roomInventory.inventory.add(new Trash(Trashtype.METAL_AND_GLASS));
                } else if (trashTypeNumber <= 3) {
                    roomInventory.inventory.add(new Trash(Trashtype.FOOD_WASTE));
                } else if (trashTypeNumber <= 4) {
                    roomInventory.inventory.add(new Trash(Trashtype.PAPER));
                } else if (trashTypeNumber <= 5) {
                    roomInventory.inventory.add(new Trash(Trashtype.RESIDUAL_WASTE));
                }
            }
        }
    }

    /**
     * Print room inventory.
     */
    public void printRoomInventory() { //can print the contents of the roomInventory without throwing a nullpointerexception
        if (roomInventory.inventory.isEmpty()) {
            System.out.println("Der er ikke noget affald.");
        }
        else {
            for (Trash trash: roomInventory.inventory) {
                System.out.println(trash.getType().toString());
            }
        }
    }
}

