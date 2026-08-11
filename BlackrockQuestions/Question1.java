import java.util.*;

///  LEETCODE PREMIUM 2534

class Result {

    /*
     * Complete the 'getTimes' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY time
     *  2. INTEGER_ARRAY direction
     */

    public static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {
        int n = time.size();
        Integer[] result = new Integer[n];
        Queue<Integer> enterQueue = new ArrayDeque<>();
        Queue<Integer> exitQueue = new ArrayDeque<>();

        int currentTime = 0;
        int lastDirection = -1;
        int personIdx = 0;

        while(personIdx < n || !exitQueue.isEmpty() || !enterQueue.isEmpty()) {
            // iterate for the current time
            while(personIdx<n && time.get(personIdx)<=currentTime) {
                // add it to the enter queue or the exit queue based on its direction
                if(direction.get(personIdx) == 1) {
                    exitQueue.add(personIdx);
                } else{
                    enterQueue.add(personIdx);
                }
                personIdx++;
            }

            // now based on the state of the queues, we will allot the current time to a person index
            // CASE 1: no person arrived and the current time is idle
            if(exitQueue.isEmpty() && enterQueue.isEmpty()) {
                currentTime = time.get(personIdx);
                lastDirection = -1;
                continue;
            }
            int chosenPerson;
            // CASE 2: a person arrived from no direction or from exit direction
            if(lastDirection==-1 || lastDirection==1) {
                // poll from the exit queue if available
                if(!exitQueue.isEmpty()) {
                    chosenPerson = exitQueue.poll();
                    lastDirection = 1;
                } else{
                    chosenPerson = enterQueue.poll();
                    lastDirection = 0;
                }
            } else{
                if(!enterQueue.isEmpty()) {
                    chosenPerson = enterQueue.poll();
                    lastDirection = 0;
                } else{
                    chosenPerson = exitQueue.poll();
                    lastDirection = 1;
                }
            }
            result[chosenPerson]= currentTime;
            currentTime++;
        }
        return List.of(result);
    }
}
public class Question1 {
    static void main() {
        System.out.println( Result.getTimes(List.of(0,1,1,3,3), List.of(0,1,0,0,1)));
    }
}
