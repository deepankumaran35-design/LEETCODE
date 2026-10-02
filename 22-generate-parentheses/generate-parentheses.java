class Solution {
    List<String> result = new ArrayList<>();
    public void solve(int n , String temp , int open , int close){
        if(temp.length() == 2*n){
            result.add(temp);
            return;
        }
        if(open<n) solve(n , temp+'(', open+1, close);
        if(close<open) solve(n , temp+')',open , close+1);
    }
    public List<String> generateParenthesis(int n) {
        solve(n , "", 0 , 0);
        return result;
    }
}