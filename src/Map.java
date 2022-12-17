public class Map {

    //For the map we have established the variables x and y, which will determine the size of the map. The variables currentx and currenty will be involved in tracking the player's position. 
	
    int x;
    int y;
    int currentx;
    int currenty;
    // This constructor will be used to generate an instance of the class map, i.e it will create a new map when invoked in the main program.
    
    public Map(int x1, int y1) {
        this.x = x1;
        this.y = y1;
        
        //The getters and setters will be used for various functions in the game, for instance tracking the player's location in the map as well as invoking special events dependant on where the player is.
        
    }

    public int getCurrentx() {
        return currentx;
    }

    public void setCurrentx(int currentx) {
        this.currentx = currentx;
    }

    public void setCurrenty(int currenty) {
        this.currenty = currenty;
    }

    public int getCurrenty() {
        return currenty;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // This is one of the main functions in the game, which works on the movements of the character. To ensure that the character is not out of bounds, the program will first evaluate whether the coordinates of the player is within the size of the map, i.e whether the player is inside the map, if  they are not, then their position will be reset to zero, however if they are within the map, then the player's input will move the player around through incrementing the currentx and currenty values or decrementing them.
    
    public void move(String direction) {
        if (direction.equals("N")) {
            if (this.currenty == this.y) {
                this.currenty = 0;
            } else {
                this.currenty = this.currenty + 1;
            }
        } else if (direction.equals("S")) {
            if (this.currenty == this.y) {
                this.currenty = 0;

            } else {
                this.currenty = this.currenty - 1;
            }
        }

        if (direction.equals("E")) {
            if (this.currentx == this.x) {
                this.currentx = 0;
            } else {
                this.currentx = this.currentx + 1;
            }
        } else if (direction.equals("W")) {
            if (this.currentx == this.x) {
                this.currentx = 0;
            } else {
                this.currentx = this.currentx - 1;
            }
        }
    }
}