import java.util.*;



public class MaximumProfitInJobScheduling_1235 {
    static class Job implements Comparable<Job>{
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
        // we need to sort a job according to the startTime
        @Override
        public int compareTo(Job o) {
            return Integer.compare(this.startTime, o.startTime);
        }
    }

    private int upperBound(int[] startTime, int value) {
        int low = 0 , high = startTime.length -1;
        int candidateAns = startTime.length;
        while(low<=high) {
            int mid = low + (high - low)/2;
            if(startTime[mid]>=value) {
                candidateAns = mid;
                // go left
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return candidateAns;
    }

    // only the index i is changing, so we need only 1d dp
    private int f(Job[] jobs, int i, int[] startTime, int[] dp) {
        // if you include the ith job, then you have to go to the endTime of it by binary searching, so we have to find the upper bound of job.endTime
        if(i>=jobs.length) return 0;
        // there are 2 options now, you can either take this job or you can skip this job
        if(dp[i]!=-1) return dp[i];
        int dontInclude = f(jobs, i+1, startTime, dp);
        int include = jobs[i].profit;
        // then you need to find the next index by upper bound where you need to move the i
        // if this is the last job, you need not find the nextIndex
        if(i==jobs.length-1) return dp[i] = Math.max(dontInclude, include);
        int nextIndex = upperBound(startTime, jobs[i].endTime);
        include += f(jobs, nextIndex, startTime, dp);

        return dp[i] = Math.max(include, dontInclude);

    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // create a list of jobs
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for(int i=0; i<n; i++) {
            jobs[i] = (new Job(startTime[i], endTime[i], profit[i]));
        }
        Arrays.sort(jobs);
        // after the jobs are sorted, we can create the sorted startTimeList
        int i = 0;
        for(Job j: jobs) {
            startTime[i] = j.startTime;
            i++;
        }
        // so now we have sorted jobs in a list, we need to apply dp so that we can have the maximum profit
        // tabulation
        int[] dp = new int[n+1];
        // last index is as it is
        dp[n-1] = jobs[n-1].profit;
        for(i= n-2; i>=0; i--) {
            int dontInclude = dp[i+1];
            int include = jobs[i].profit + dp[upperBound(startTime, jobs[i].endTime)];
            dp[i] = Math.max(include, dontInclude);
        }
        return dp[0];
    }

    static void main() {
        MaximumProfitInJobScheduling_1235 obj = new MaximumProfitInJobScheduling_1235();
        System.out.println(obj.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50, 10, 40, 70}));
    }
}
