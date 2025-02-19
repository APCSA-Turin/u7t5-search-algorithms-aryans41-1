package com.example.project.Repair;
import java.util.ArrayList;

public class RepairSchedule {
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n) {
        numberOfMechanics = n;
        schedule = new ArrayList<CarRepair>();
    }


    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b) {
        boolean available = true;
        for (int i = 0; i < schedule.size(); i++) {
            if (schedule.get(i).getMechanicNum() == m || schedule.get(i).getBayNum() == b) {
                return false;
            }
        }
        if (available == true) {
            CarRepair repair = new CarRepair(m, b);
            schedule.add(repair);
        }
        return true;
    }

    public ArrayList<CarRepair> getSchedule() {
        return schedule;
    }
    
    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics() {
        ArrayList<Integer> takenMechanics = new ArrayList<Integer>();
        ArrayList<Integer> availableMechanics = new ArrayList<Integer>();
        for (int i = 0; i < schedule.size(); i++) {
            takenMechanics.add(schedule.get(i).getMechanicNum());
        }
        for (int i = 0; i < numberOfMechanics; i++) {
            boolean contains = false;
            for (int x = 0; x < takenMechanics.size(); x++) {
                if (takenMechanics.get(x) == i) {
                    contains = true;
                    break;
                }
            }
            if (contains == false) {
                availableMechanics.add(i);
            }
        }
        return availableMechanics;
    }


    /** Removes an element from schedule when a repair is complete.
        THIS METHOD HAS BEEN ADDED FOR ILLUSTRATIVE PURPOSES ONLY,
        AS DESCRIBED IN PART B; you do NOT need to call this
        method as part of your solution to part B
      */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}
