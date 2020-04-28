public class Result {
    private int carryOne;
    private int sum;
    private ListNode node;
    private ListNode l1;
    private ListNode l2;

    public Result(int carryOne, int sum, ListNode node, ListNode l1, ListNode l2) {
        this.carryOne = carryOne;
        this.sum = sum;
        this.node = node;
        this.l1 = l1;
        this.l2 = l2;
    }

    public int getCarryOne() {
        return carryOne;
    }

    public int getSum() {
        return sum;
    }

    public ListNode getNode() {
        return node;
    }

    public ListNode getL1() {
        return l1;
    }

    public ListNode getL2() {
        return l2;
    }

}
