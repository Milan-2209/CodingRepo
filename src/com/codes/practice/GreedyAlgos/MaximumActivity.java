package src.com.codes.practice.GreedyAlgos;

import java.util.*;

//Given n activities with their start and finish times. Select the maximum number of activities that can
//be performed by a single person, assuming that a person can only work on a single activity at a time

public class MaximumActivity {

    public static void main(String[] args) {
        Activity a1 = new Activity(0,6);
        Activity a2 = new Activity(3,4);
        Activity a3 = new Activity(1,2);
        Activity a4 = new Activity(5,9);
        Activity a5 = new Activity(5,7);
        Activity a6 = new Activity(8,9);
        List<Activity> activities = new ArrayList<>(){{
            add(a1);
            add(a2);
            add(a3);
            add(a4);
            add(a5);
            add(a6);
        }};

        System.out.println("Total activities completed: "+maximumActivities(activities));
    }

    private static int maximumActivities(List<Activity> activities) {
        List<Activity> sortedActivities = activities.stream()
                .sorted().toList();
        System.out.println(sortedActivities);
        int activity = 0;
        int prevActFinishTime = -1;
        for(Activity a: sortedActivities){
            if(a.getStartTime() > prevActFinishTime){
                activity+=1;
                prevActFinishTime = a.getFinishTime();
            }
        }
        return activity;

    }
}

class Activity implements Comparable<Activity>{
    int startTime;
    int finishTime;

    public Activity(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public int compareTo(Activity o) {
        return this.finishTime-o.finishTime;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "startTime=" + startTime +
                ", finishTime=" + finishTime +
                '}';
    }
}
