class MovingAverage {
    LinkedList<Integer> list;
    int size;
    int maxSize;
    int sum;

    public MovingAverage(int size) {
        list = new LinkedList<>();
        this.size = 0;
        this.maxSize = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        list.offer(val);
        this.sum += val;
        if(list.size() > this.maxSize) this.sum -= list.poll();
        else this.size++;
        return (double)this.sum / (double)this.size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */