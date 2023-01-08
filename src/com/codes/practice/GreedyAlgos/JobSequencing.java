package src.com.codes.practice.GreedyAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given a set of jobs with a particular deadline and profit pick the jobs in
//such a way that we get the max profit
public class JobSequencing {


    public static void main(String[] args) {
        Job job1 = new Job(2,100);
        Job job2 = new Job(1,19);
        Job job3 = new Job(2,27);
        Job job4 = new Job(1,25);
        Job job5 = new Job(3,15);
        List<Job> jobList = new ArrayList<>();
        jobList.add(job1);
        jobList.add(job2);
        jobList.add(job3);
        jobList.add(job4);
        jobList.add(job5);
        System.out.println("Maximum profit: "+findMaximumProfit(jobList));

    }

    private static int findMaximumProfit(List<Job> jobList) {
        Collections.sort(jobList);
        for(Job job : jobList)
            System.out.println(job);
        int[] jobsDone = new int[jobList.size()];
        for(int i=0;i<jobsDone.length;i++){
            jobsDone[i] = -1;
        }
        for(int k=0;k<jobList.size();k++){
            for(int j=jobsDone.length-1;j>=0;j--){
                if(j<jobList.get(k).getDeadline() && jobsDone[j]==-1){
                    jobsDone[j] = jobList.get(k).getProfit();
                    break;
                }
            }
        }
        int sum = 0;
        for(int i=0;i<jobsDone.length;i++){
            if(jobsDone[i]==-1)
                break;
            System.out.println(jobsDone[i]);
            sum+=jobsDone[i];
        }
        return sum;
    }
}
class Job implements Comparable<Job>{
    int deadline;
    int profit;

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job o) {
        return o.getProfit()-this.getProfit();
    }

    @Override
    public String toString() {
        return "Job{" +
                "deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}
