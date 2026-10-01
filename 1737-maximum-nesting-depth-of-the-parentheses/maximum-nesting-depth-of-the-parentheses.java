class Solution {
    public int maxDepth(String s) {
        int cur = 0; 
        int res = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                cur++;
                res = Math.max(res, cur);
            } else if(c == ')'){
                cur--;
            }
        }
        return res;
    }
}
