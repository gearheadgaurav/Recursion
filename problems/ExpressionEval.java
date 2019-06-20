package problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ExpressionEval {
	/*
     * Complete the function below.
     */
    static String[] generate_all_expressions(String s, long target) {
        List<String> expressions = new ArrayList<String>();
        generate_all_expressions_helper(expressions, String.valueOf(s.charAt(0)), s, 1, target);
        return expressions.toArray(new String[expressions.size()]);
    }
    
    private static void generate_all_expressions_helper(List<String> expressions, String prefix, String s, int index, long target){
        
        //guard
        if(index == s.length()){
            System.out.println(prefix);
            //base condition
            if(evaluateExpression(prefix) == target){
                expressions.add(prefix);
            }
            
            return;
        }
        
        char currentChar = s.charAt(index);
        generate_all_expressions_helper(expressions, prefix + "*"+ currentChar, s, index+1, target);
        generate_all_expressions_helper(expressions, prefix + "+" + currentChar, s, index+1, target);
        generate_all_expressions_helper(expressions, prefix + currentChar, s, index+1, target);
        
    }

    private static long evaluateExpression(String expression){
    	return 0L;
    } 
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] res;
        String s;
        try {
            s = in.nextLine();
        } catch (Exception e) {
            s = null;
        }

        long target;
        target = Long.parseLong(in.nextLine().trim());

        res = generate_all_expressions(s, target);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}
