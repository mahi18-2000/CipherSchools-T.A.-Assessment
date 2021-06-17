import java.util.LinkedList;
import java.util.List;

class Question3 {
    public static void main(String arg[]) {
        // input
        int weights[] = {2, 1, 3, 2};
        int values[] = {12, 10, 21, 15};
        int capacity = 7;

        /// solve
        Question3 question = new Question3();
        Answer3 answer = question.getAnswer(capacity, weights, values, values.length);

        // print
        System.out.println("By Selecting weights: " + answer.selectedWeights +
                "you will get maximum value " + answer.maximumValue + ".");
    }

    public Answer3 getAnswer(int capacity, int weights[],
                          int values[], int n)
    {
        int i, w;
        int KnapSack[][] = new int[n + 1][capacity + 1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    KnapSack[i][w] = 0;
                else if (weights[i - 1] <= w)
                    KnapSack[i][w] = Math.max(values[i - 1] +
                            KnapSack[i - 1][w - weights[i - 1]], KnapSack[i - 1][w]);
                else
                    KnapSack[i][w] = KnapSack[i - 1][w];
            }
        }

        int maximumValue = KnapSack[n][capacity];

        Answer3 answer = new Answer3();
        LinkedList selectedWeights = new LinkedList();

        answer.maximumValue = maximumValue;
        answer.selectedWeights = selectedWeights;

        w = capacity;
        for (i = n; i > 0 && maximumValue > 0; i--) {
            if (maximumValue == KnapSack[i - 1][w])
                continue;
            else {
                selectedWeights.add(weights[i - 1]);
                maximumValue = maximumValue - values[i - 1];
                w = w - weights[i - 1];
            }
        }

        return answer;
    }

    class Answer3 {
        int maximumValue;
        List<Integer> selectedWeights;
    }
}