import java.util.LinkedList;

public class BuildBinaryExpressionTreeFromInfix {
    static class TreeNode{
        char data;
        TreeNode left;
        TreeNode right;
        TreeNode(char data){
            this.data = data;
        }
    }
    public TreeNode expTree(String s) {
        // iterate over the String s, and first check for open parenthesis, and make recursive call
        LinkedList<TreeNode> l = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                int j= i+1;
                int balance = 1;
                while(balance>0){
                    if(s.charAt(j)=='(') balance++;
                    if(s.charAt(j)==')') balance--;
                    j++;
                }
                // make the recursive call
                //after this loop j will be at the next position of ), so move it one place back
                l.add(expTree(s.substring(i+1,j-1)));
                i=j-1;
            }
            else{
                l.add(new TreeNode(s.charAt(i)));
            }
        }
        return op(op(l, '*', '/'), '+', '-').getFirst();
    }
    private LinkedList<TreeNode> op(LinkedList<TreeNode> l, char op1, char op2){
        LinkedList<TreeNode> l1 = new LinkedList<>();
        for(int i= 0; i<l.size(); i++){
            TreeNode o = l.get(i);
            if(o.left==null && (o.data==op1 || o.data==op2)){
                // this is an unused operator
                o.left = l1.removeLast();
                o.right = l.get(++i);
                l1.add(o);
            }
            else{
                l1.add(o);
            }
        }
        return l1;
    }
}
