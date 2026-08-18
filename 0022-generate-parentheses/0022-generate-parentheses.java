class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        gen(0,0,n,"",ans);
        return ans;
    }
    public void gen(int open,int close,int n, String str,List<String>ans){
        if(str.length()==2*n){
            ans.add(str);
            return;
        }
        if(open<n){
        gen(open+1,close,n,str+"(",ans);
        }
        if(close<open){
        
        gen(open,close+1,n,str+")",ans);
        }
    }
}