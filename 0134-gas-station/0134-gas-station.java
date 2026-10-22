class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalKamai=Arrays.stream(gas).sum();
        int totalKharch=Arrays.stream(cost).sum();

        int result_index=0;
        int total = 0;

        if(totalKamai < totalKharch ){
               return -1;
        }


        for ( int i = 0 ; i < n ; i++ ){
            total = total + gas[i] - cost[i];
            if( total < 0 ){
                result_index = i+1;
                total = 0 ;

            }
            

        }

        return result_index ; 
        
    }
}