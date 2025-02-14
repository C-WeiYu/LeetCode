class ProductOfNumbers {
    List<Integer> list ;
    int prod ;
    public ProductOfNumbers() {
        this.list = new ArrayList<>();
        this.prod = 1;
    }
    
    public void add(int num) {
        if(num == 0 ){
            this.list = new ArrayList<>();
            this.prod = 1;
            return ;
        }
        this.prod *= num;
        this.list.add(prod);
    }
    
    public int getProduct(int k) {
        int len = this.list.size();
        if(len < k){
            return 0 ;
        }
        int res = list.get(len-1);
        if(len == k){
            return res ;
        }
        return res/this.list.get(len-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
