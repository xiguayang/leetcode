package TestDome.JAVA;

import java.util.Deque;
import java.util.LinkedList;

public class TrainComposition {
    private final Deque<Integer> wagons = new LinkedList<>();
    public void attachLeft(int wagonNumber) {
        wagons.addFirst(wagonNumber);
    }
    
    public void attachRight(int wagonNumber) {
        wagons.addLast(wagonNumber);
    }
    
    public void detachLeft() {
        wagons.pollFirst(); // Alternative if exception should not be bubbled up: wagons.pollFirst()
    }
    
    public void detachRight() {
          wagons.pollLast(); // Alternative if exception should not be bubbled up: wagons.pollLast()
    }
    
}
