class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
     for(int k=0;k<j+1;k++){
            char t=s[i];
            s[i]=s[j];
            s[j]=t;
            i++;
            j--;
        }

    }
}