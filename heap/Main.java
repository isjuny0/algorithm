import java.io.*;
import java.util.*;

public class Main {
    static int heap[] = new int[100005];
    static int size = 0; // 원소의 개수

    public static void main(String[] args) throws IOException {
        test();
    }

    static void push(int x) {
        // 마지막 자리에 넣고 부모와 비교(부모보다 클 때까지)
        heap[++size] = x;
        int x_pos = size;
        while (x_pos != 1) {
            int parent = x_pos / 2;
            if (heap[parent] <= heap[x_pos]) {
                break;
            }
            heap[x_pos] = heap[parent];
            heap[parent] = x;
            x_pos = parent;
        }
    }

    static int top() {
        return heap[1];
    }

    static void pop() {
        // 루트와 마지막 값 교환 후 자식과 비교(자식보다 작을 때 까지)
        heap[1] = heap[size--];
        int x_pos = 1;
        while((2 * x_pos) <= size) {
            int left_child = 2 * x_pos;
            int right_child = 2 * x_pos + 1;
            int min_child = left_child;

            if (right_child <= size && heap[right_child] < heap[left_child]) {
                min_child = right_child;
            }

            if (heap[x_pos] < heap[min_child]) {
                break;
            }

            int temp = heap[x_pos];
            heap[x_pos] = heap[min_child];
            heap[min_child] = temp;
            x_pos = min_child;
        }
    }

    static void test() {
        push(10);
        push(2);
        push(5);
        push(9);
        System.out.println("top: " + top());

        pop();
        System.out.println("top after pop: " + top());
        pop();
        System.out.println("top after pop: " + top());
        pop();
        System.out.println("top after pop: " + top());
    }
}