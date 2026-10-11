class Solution {
    public String clearStars(String s) {
     char[] arr=s.toCharArray();
     PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);


     for(int i=0;i<arr.length;i++){
        if(arr[i]=='*'){
            int[] top=pq.poll();
            arr[top[1]]='*';
        }else{
            pq.add(new int[]{arr[i],i});
        }

     }

     StringBuilder sb=new StringBuilder();
     for(char c:arr){
        if(c!='*'){
            sb.append(c);
        }
     }
     return sb.toString();
        
    }
}