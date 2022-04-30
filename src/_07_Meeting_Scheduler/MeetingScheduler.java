package _07_Meeting_Scheduler;

import java.util.ArrayList;
import java.util.HashMap;

public class MeetingScheduler {
    /*
     * Your task is to code a method to find a meeting time for two people
     * given their schedules.
     * 
     * Code the method below so that it returns a Schedule object that contains
     * all the times during the week that are in BOTH people's schedules. The
     * Schedule class is included in this package.
     * 
     * Example:
     * person1 availability - Monday at 9, Tuesday at 14, and Friday 10
     * person2 availability - Tuesday at 14, Friday 8, and Monday at 9
     * The returned HashMap should contain: Tuesday 14 and Monday 9
     * 
     * The returned Schedule object represents the times both people are
     * available for a meeting.
     * 
     * Time availability is always at the top of the hour, so 9:30 is not valid
     * Time availability always represents 1 hour
     * Assume both schedules are in the same time zones
     */

    public static Schedule getMutualAvailability(Schedule person1, Schedule person2) {
    	System.out.println("test");
    	 	HashMap<String, ArrayList<Integer>> schedule1 = person1.getSchedule();
    	 	HashMap<String, ArrayList<Integer>> schedule2 = person2.getSchedule();
    	 	Schedule finalSchedule = new Schedule();
    	 	
        for(String day: schedule1.keySet()) {
        		ArrayList<Integer> hours1 = schedule1.get(day);
        		ArrayList<Integer> hours2 = schedule2.get(day);
        		
        		
        		//Loop to find days in common
        			for(int i = 0; i<hours1.size(); i++) {    				
        				int hour1 = hours1.get(i);

        				for(int e = 0; e<hours2.size(); e++) {
        					int hour2 = hours2.get(e);
        					
        					if(hour1 == hour2) {
        						finalSchedule.addAvailability(day, hour1);
        					}
        				}
        			}
		}
        
        System.out.println("Person 1: ");
        person1.printSchedule();
        System.out.println("Person 2: ");
        person2.printSchedule();

        return finalSchedule;
    }
}
