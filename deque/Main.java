import java.io.*;

public class Main {
    static final int MX = 1000005;
    static int[] dat = new int[2 * MX + 1];
    static int head = MX;
    static int tail = MX;

    public static void main(String[] args) throws IOException {
    }

    static boolean empty() {
        return head == tail;
    }

    static int size() {
        return tail - head;
    }

    static void push_front(int x) {
        dat[--head] = x;
    }

    static void push_back(int x) {
        dat[tail++] = x;
    }

    static int pop_front() {
        if (empty()) return -1;
        return dat[head++];
    }

    static int pop_back() {
        if (empty()) return -1;
        return dat[--tail];
    }

    static int front() {
        if (empty()) return -1;
        return dat[head];
    }

    static int back() {
        if (empty()) return -1;
        return dat[tail - 1];
    }
}