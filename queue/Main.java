import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        MyQueue que = new MyQueue();

        que.push(5);
        que.push(4);
        que.push(3);
        que.push(2);

        que.pop();

        System.out.println(que.front());    // 4
        System.out.println(que.back());     // 2
    }

    static class MyQueue {
        private int dat[] = new int[100];
        private int head = 0;
        private int tail = 0;

        private void push(int x) {
            dat[tail] = x;
            tail++;
        }
        private void pop() {
            head++;
        }
        private int front() {
            return dat[head];
        }
        private int back() {
            return dat[tail - 1];
        }
    }
}