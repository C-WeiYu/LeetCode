class Solution {
    public long repairCars(int[] ranks, int cars) {
        int min = ranks[0] ;
        int max = ranks[0];
        for(int rank : ranks){
            min = Math.min(rank, min);
            max = Math.max(rank, max);
        }

        int[] freq = new int[max + 1];
        for(int rank : ranks){
            freq[rank]++;
        }
      
        long low = 1 ;
        long high = 1L * min * cars * cars ;
        while(low < high){
            long mid = low + (high-low) / 2 ;
            long sum = 0 ;

            for(int rank = 1; rank <= max; rank++){
                sum += freq[rank] * (long) Math.sqrt(mid / (long) rank);
            }
            
            if(sum < cars){
                low = mid + 1 ;
            }
            else{
                high = mid ;
            }
        }
        return low ;
    }
}
