public class Question1 {
    public static void main(String args[]) {
        // input
        int n = 4;

        /// solve
        Question1 question = new Question1();
        int answer[] = question.getArrayWithUniqueNumbersThatSumToZero(n);

        // print
        for (int integer : answer) {
            System.out.print(integer + " ");
        }
    }

    /**
     *
     * @param n, where 1 <= n <= 100
     * @return Array of size n with unique integers, which sum to zero
     */
    public int[] getArrayWithUniqueNumbersThatSumToZero(int n) {
        int output[] = new int[n];

        for (int i = 0; i<n-1 ; i++)
            output[i] = i+1;
        output[n-1] = -(((n-1)*(n))/2);

        return output;
    }
}
