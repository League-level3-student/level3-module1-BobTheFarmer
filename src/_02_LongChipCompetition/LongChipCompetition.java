package _02_LongChipCompetition;

import java.util.ArrayList;
import java.util.Random;

public class LongChipCompetition {
    /*
     * The Beatles are eating lunch and playing a game to see who has the
     * longest chip. (In England, french fries are called "chips".)
     * Find the Beatle with the longest chip. You may not edit the Chip or
     * Beatle classes. Make sure to initialize The Beatles before you start
     * your search.
     */
    private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

    public static void main(String[] args) {
        LongChipCompetition lcc = new LongChipCompetition();
        lcc.initializeBeatles();
        lcc.findLongestChip();
    }
    
    void findLongestChip() { 
    	double chipRecord = -1;
    	boolean tie = false;
    	int winnerIndex = 0;
    	int winnerChipIndex = 0;
    	for (int i = 0; i < theBeatles.size(); i++) {
    		//Check if has longest chip
    		for (int j = 0; j < theBeatles.get(i).getChips().size(); j++) {
				Chip chip = theBeatles.get(i).getChips().get(j);
							
					if(chip.getLength() < chipRecord) {
						//Not a record
					} else if(chip.getLength() > chipRecord) {
						//Record
						System.out.println("New record by " + theBeatles.get(i).getName() + "; " + chip.getLength());
						winnerIndex = i;
						winnerChipIndex = j;
						chipRecord = chip.getLength();
					} else {
						//Tie
						tie = true;
					}
			}
    		
    			
		}
    	System.out.println("");
		System.out.println(theBeatles.get(winnerIndex).getName() + " won with a " + theBeatles.get(winnerIndex).getChips().get(winnerChipIndex).getLength() + " length chip");
		if(tie) { 
			System.out.print(", there was a tie");
		}                                           
    }

    private void initializeBeatles() {
        Beatle george = new Beatle("George");
        Beatle john = new Beatle("John");
        Beatle paul = new Beatle("Paul");
        Beatle ringo = new Beatle("Ringo");
        theBeatles.add(george);
        theBeatles.add(john);
        theBeatles.add(paul);
        theBeatles.add(ringo);
    }

    public ArrayList<Beatle> getTheBand(){
        return theBeatles;
    }
}

class Beatle {
    private String name;
    private ArrayList<Chip> chips = new ArrayList<Chip>();

    public Beatle(String name) {
        this.name = name;
        initializePlateOfChips();
        System.out.println("Beatle Complete");
    }

    private void initializePlateOfChips() {
        int numberOfChips = 10000000;
        		//new Random().nextInt(100);
        for (int i = 0; i < numberOfChips; i++) {
            chips.add(new Chip(new Random().nextDouble() * 10));
        }
    }

    public ArrayList<Chip> getChips() {
        return this.chips;
    }

    public String getName() {
        return this.name;
    }
}

class Chip {
    private double length;

    public double getLength() {
        return length;
    }

    Chip(double d) {
        this.length = d;
    }
}
