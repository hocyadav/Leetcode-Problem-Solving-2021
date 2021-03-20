package grab;

import java.util.PriorityQueue;

/**
 * @Author Hariom Yadav
 * @create 20-03-2021
 */
class Node {
    char chr;
    int count;
    public Node(int count, char chr) {
        this.chr = chr;
        this.count = count;
    }
    public void dec() {
        this.count--;
    }
}

public class Que1 {
    public String solution(int A, int B, int C) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.count - a.count);
        if (A > 0)
            queue.add(new Node(A, 'a'));
        if (B > 0)
            queue.add(new Node(B, 'b'));
        if (C > 0)
            queue.add(new Node(C, 'c'));
        StringBuilder ans = new StringBuilder();

        while (!queue.isEmpty()) {
            Node max1 = queue.poll();

            ans.append(max1.chr);//a
            max1.dec();
            if (queue.size() > 0) {
                Node max2 = queue.poll();
                if (max1.count > 0 && max1.count > max2.count) {
                    ans.append(max1.chr);//aa
                    max1.dec();
                    ans.append(max2.chr);//aab
                    max2.dec();
                }
                if (max2.count > 0) {
                    queue.add(max2);
                }
            } else {
                if (max1.count > 0) {
                    ans.append(max1.chr);
                    max1.dec();
                    return ans.toString();
                }
            }
            if (max1.count > 0) {
                queue.add(max1);
            }
        }
        return ans.toString();
    }
}
