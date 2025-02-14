class ProductOfNumbers {
    int len;
    LinkedList<Integer> list;
    LinkedList<Integer> pref;

    public ProductOfNumbers() {
        this.len = 0;
        this.list = new LinkedList<>();
        this.pref = new LinkedList<>();
        
    }
    
    public void add(int num) {
        this.list.addLast(num);
        this.len++;
        if(pref.size() == 0){
                pref.addLast(num);
        } else {
            if(num == 0){ // clean the array
                for(int i = pref.size()-1; i >= 0 && pref.get(i) != 0; i--) pref.set(i, 0); 
                pref.addLast(0);
            } else {
                if(pref.peekLast() != 0)
                    pref.addLast(pref.peekLast() * num);
                else
                    pref.addLast(num);
            }
        }
        // System.out.println();
        // for(int j: pref){System.out.print("; " + j);}
    }
    
    public int getProduct(int k) {
        if(k == this.len){
            if(pref.get(0) == 0) return 0;
            return pref.getLast();
        }
        if(pref.get(this.len - k-1) == 0 && pref.get(this.len - k) == 0) return 0;
        else if(pref.get(this.len - k-1) == 0) return pref.getLast();
        return pref.getLast() / pref.get(this.len - k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */