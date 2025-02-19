package com.chestnut.aigc.likou.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class DesignASelfBillingSystem {
    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public static void main(String[] args) {
        DesignASelfBillingSystem demo = new DesignASelfBillingSystem();
        System.out.println(demo.get_max());
        demo.add(5);
        demo.add(1);
        demo.add(3);
        demo.add(33);
        demo.add(31);
        demo.add(318);
        demo.add(22);
        System.out.println(demo.remove());
    }

    public DesignASelfBillingSystem() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int get_max() {
        if (queue.isEmpty()) {
            return -1;
        }
        return deque.getFirst();
    }

    public void add(int value) {
        queue.add(value);
        while (!deque.isEmpty()) {
            if (deque.getLast() < value) {
                deque.removeLast();
            }else {
                break;
            }
        }
        deque.addLast(value);
    }

    public int remove() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer remove = queue.remove();
        if (Objects.equals(deque.getFirst(), remove)) {
            deque.removeFirst();
        }
        return remove;
    }
}
