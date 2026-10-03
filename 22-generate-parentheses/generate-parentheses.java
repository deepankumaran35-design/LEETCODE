class Solution {
    ArrayList<String>sol=new ArrayList<>();   
    public List<String> generateParenthesis(int n){
        generate(0,0,n,"");
        return sol;
    }
    public void generate(int ob,int cb,int n,String ans){
        if(ans.length()==n*2){
            sol.add(ans);
            return;
        }
        if(ob<n){
            generate(ob+1,cb,n,ans+"(");
        }
        if(cb<ob){
            generate(ob,cb+1,n,ans+")");
        }
        }
    }
