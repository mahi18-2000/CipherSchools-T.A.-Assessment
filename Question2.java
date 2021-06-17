public class Question2 {
    public static void main(String args[]) {
        // input
        int gadgetPrices[] = {100, 300, 100, 400};
        int totalMoney = 100;
        // Robots response 'k'
        int robotsResponse = 2;

        /// solve
        Question2 question = new Question2();
        boolean isRobotCorrect = question.isRobotsResponseCorrect(gadgetPrices,
                totalMoney, robotsResponse);
        
        // print
        System.out.println(isRobotCorrect ?
                "Right" : "Wrong");
    }

    public boolean isRobotsResponseCorrect(int gadgetPrices[],
                                          int totalMoney, int robotsResponse) {
        return isRobotsResponseCorrect(gadgetPrices, totalMoney, robotsResponse, 0);
    }

    private boolean isRobotsResponseCorrect(int gadgetPrices[], int moneyLeft, int itemsLeft, int gadgetIndex) {

        if(itemsLeft < 0) {
            return false;
        }
        if(moneyLeft == 0)
            return true;

        if(moneyLeft < 0)
            return false;

        if (gadgetIndex == gadgetPrices.length ) {
                return false;
        }
        
        return isRobotsResponseCorrect(gadgetPrices, moneyLeft - gadgetPrices[gadgetIndex], itemsLeft-1, gadgetIndex+1)
                || isRobotsResponseCorrect(gadgetPrices, moneyLeft, itemsLeft, gadgetIndex+1);
    }

}