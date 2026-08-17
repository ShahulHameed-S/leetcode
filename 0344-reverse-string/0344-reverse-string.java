class Solution {
    public void reverseString(char[] s) {
       int l=0;
       int r=s.length-1;
       f(l,r,s);
    //  for(int k=0;k<j+1;k++){
    //         char t=s[i];
    //         s[i]=s[j];
    //         s[j]=t;
    //         i++;
    //         j--;
    //     }
    }
    static void f(int l,int r,char[] s){
        if (l>=r){
            return;
        }
        char t=s[l];
        s[l]=s[r];
        s[r]=t;
        f(l+1,r-1,s);
    }
}