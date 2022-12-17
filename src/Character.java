public class Character {

    //For our character, we define a couple of attributes that belong to the character, in this case, they are name, health and alignment. The varabiles will be private so that they cannot be modified outside the class in which the player cannot cheat in the game by giving themselves increased health etc..
    private String name;
    private int health;
    private boolean armour;

    // Here we create the constructor for the character class, which will be used in the main program to create an instance of character, i.e create a new character. There are also the setters and getters of each of the attributes for the character.
    public Character(String n, int h, boolean a) {
        this.name = n;
        this.health = h;
        this.armour = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean getArmour() {
        return armour;
    }

    public void setArmour(boolean armour) {
        this.armour = armour;
    }




}
