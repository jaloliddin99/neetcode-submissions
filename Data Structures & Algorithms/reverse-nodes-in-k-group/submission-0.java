/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int segments = length / k;
        if (segments == 0) {
            return head;
        }

        List<ListNode> chunks = new ArrayList<>();
        for (int s = 0; s < segments; s++) {
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            for (int i = 0; i < k; i++) {
                tail.next = head;
                head = head.next;
                tail = tail.next;
            }
            tail.next = null;
            chunks.add(dummy.next);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode chunk : chunks) {
            ListNode newTail = chunk;
            ListNode newHead = reversed(chunk);

            tail.next = newHead;
            tail = newTail;


        }

        tail.next = head;
        return dummy.next;
    }

    private ListNode reversed(ListNode chunk) {
        ListNode reversed = null;
        while (chunk != null) {
            ListNode currentChunk = chunk.next;
            chunk.next = reversed;
            reversed = chunk;
            chunk = currentChunk;
        }

        return reversed;
    }
}
