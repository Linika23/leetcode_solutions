class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        boolean[] used=new  boolean[s.length];
        int child=0;
        int cookie=0;

        int satChild=0;

        while(child<g.length && cookie<s.length){
            if(s[cookie]>=g[child]){
                satChild++;
                child++;
                cookie++;

            }else{
                cookie++;
            }
        }

        return satChild;

        
    }
}