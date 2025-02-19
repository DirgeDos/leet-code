package com.chestnut.aigc.likou.stackandqueue;


import java.util.LinkedList;


public class BookFinishing2 {
    LinkedList<Integer> list1;
    LinkedList<Integer> list2;

    public static void main(String[] args) {
        BookFinishing2 book = new BookFinishing2();
    }

    public BookFinishing2() {
        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        list1.addLast(value);
    }

    public int deleteHead() {
        if (list1.isEmpty() && list2.isEmpty()) {
            return -1;
        }
        if (!list2.isEmpty()) {
            return list2.removeLast();
        }
        if (list2.isEmpty() && !list1.isEmpty()) {
            while (!list1.isEmpty()) {
                list2.addLast(list1.removeLast());
            }
            return list2.removeLast();
        }
        return 0;
    }
}
