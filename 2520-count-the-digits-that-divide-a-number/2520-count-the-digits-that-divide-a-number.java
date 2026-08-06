class Solution {
    public int countDigits(int num) {
        int count=0;
        int n=num;
        while(num>0){
            int d=num%10;
            num/=10;
            if(n%d==0){
                count++;
            }
            
        }
        return count;
    }
}