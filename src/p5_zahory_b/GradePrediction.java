package p5_zahory_b;

import java.util.Scanner;

public interface GradePrediction {

    public void predictGrade();

    public BTNode<DecisionPoint> advance(BTNode<DecisionPoint> cur, Scanner sc);

    public boolean processAnswer(Scanner sc);
}