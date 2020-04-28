import java.sql.SQLOutput;

class Main {

    public static void main(String[] args) {
        ListNode firstRoot = getFirstRoot();
        ListNode secondRoot = getSecondRoot();

        ListNode current = addTwoNumbers(firstRoot, secondRoot);

        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static ListNode getFirstRoot() {
        ListNode root = new ListNode(2);
        ListNode current = root;
        ListNode node = new ListNode(4);
        current.next = node;
        current = node;
        node = new ListNode(3);
        current.next = node;

        return root;
    }

    public static ListNode getSecondRoot() {
        ListNode root = new ListNode(5);
        ListNode current = root;
        ListNode node = new ListNode(6);
        current.next = node;
        current = node;
        node = new ListNode(4);
        current.next = node;

        return root;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOne = 0;
        Result result = getSum(l1, l2, carryOne);
        l1 = result.getL1();
        l2 = result.getL2();
        carryOne = result.getCarryOne();
        ListNode rootNode = result.getNode();
        ListNode currentNode = rootNode;

        while (l1 != null || l2 != null) {
            result = getSum(l1, l2, carryOne);
            l1 = result.getL1();
            l2 = result.getL2();
            carryOne = result.getCarryOne();
            currentNode.next = new ListNode(result.getSum());
            currentNode = currentNode.next;
        }

        if (carryOne == 1) {
            currentNode.next = new ListNode(carryOne);
        }

        return rootNode;
    }

    public static Result getSum(ListNode l1, ListNode l2, int carryOne) {
        int first = 0;
        int second = 0;

        if (l1 != null) {
            first = l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            second = l2.val;
            l2 = l2.next;
        }

        int sum = first + second + carryOne;

        if (sum > 9) {
            carryOne = 1;
            sum = sum - 10;
        }
        else {
            carryOne = 0;
        }

        ListNode node = new ListNode(sum);
        return new Result(carryOne, sum, node, l1, l2);
    }
}
