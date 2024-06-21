/**
 *  Program 8
 *  This program is a ring buffer
 *  CS160-1001
 *  6/20/24
 *  @author  Jacob Archer
  */

import java.util.Arrays;

public class RingBuffer implements QueueInterface {
    private Integer[] buffer;
    private int size;
    private int front;
    private int rear;

    public RingBuffer() {
        this(10);
    }

    public RingBuffer(int capacity) {
        buffer = new Integer[capacity];
        size = 0;
        front = -1;
        rear = -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean enQueue(Integer value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % buffer.length;
        buffer[rear] = value;
        size++;
        return true;
    }

    @Override
    public Integer deQueue() {
        if (isEmpty()) {
            return null;
        }
        Integer value = buffer[front];
        buffer[front] = null;
        front = (front + 1) % buffer.length;
        size--;
        if (isEmpty()) {
            front = -1;
            rear = -1;
        }
        return value;
    }

    @Override
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return buffer[front];
    }

    public boolean isFull() {
        return size == buffer.length;
    }

    public Integer last() {
        if (isEmpty()) {
            return null;
        }
        return buffer[rear];
    }

    public Integer[] getArray() {
        return buffer;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return buffer.length;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = front; count < size; i = (i + 1) % buffer.length) {
            sb.append(buffer[i]);
            if (count < size - 1) {
                sb.append(", ");
            }
            count++;
        }
        return sb.toString();
    }
}
