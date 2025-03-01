class MyCircularQueue {
    int[]q;
    int front;
    int rear;
    int size;
    int maxSize;

    public MyCircularQueue(int k) {
        this.q = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.maxSize = k;
    }
    
    public boolean enQueue(int value) {
        if(this.size == this.maxSize) return false;
        this.q[this.rear] = value;
        this.rear++;
        this.rear %= this.maxSize;
        this.size++;
        // System.out.println("enque: rear: " + this.rear + "; size: " + this.size);
        return true;
    }
    
    public boolean deQueue() {
        if(this.size == 0) return false;
        this.front++; this.front %= this.maxSize;
        this.size--;
        return true;
    }
    
    public int Front() {
        if(this.size == 0) return -1;
        return this.q[this.front];
    }
    
    public int Rear() {
        // for(int i: this.q) System.out.print(i + "; ");
        // System.out.println();
        if(this.size == 0) return -1;
        return this.q[this.rear - 1 < 0 ? this.rear - 1 + this.maxSize : this.rear - 1];
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */