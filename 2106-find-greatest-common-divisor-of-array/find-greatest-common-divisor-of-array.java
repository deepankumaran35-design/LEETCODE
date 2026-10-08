class Solution {
    public int findGCD(int[] n) {
        int min = n[0];
        int max = n[0];
        for(int num:n){
            if(num<min){
                min=num;
            }
            if(num>max){
                max=num;
            }
        }
        return gcd(min,max);
        
    }
    private int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;


        }
        return a;
    }
}