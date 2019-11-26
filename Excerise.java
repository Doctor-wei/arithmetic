package compute;

import java.util.LinkedHashSet;
import java.util.Random;

public class Excerise {
	 private static final short formula_num = 50;
     private static final short col_num = 5;
     int i = 0, temp = 0;
     int [] answer = new int[51];//存放答案
     LinkedHashSet<String> Set_formula = new LinkedHashSet<>();
     //生成习题（50道不重复算式）
     public void GenerateExerise() {
       for(i = 0;i < formula_num;i++) {
    	   Formula formula = new Formula();
    	   Random random = new Random();
    	   if (temp == 0) {
    		 formula.GenerateAddition();//生成加法算式
    		 if (Set_formula.add(formula.toString())==false) {
    			 i--;//如果重复循环继续执行一次，不重复就加入
    		 }	 
    	   }else {
    		 formula.GenerateSubstract();//生成减法算式
    		 if (Set_formula.add(formula.toString())==false) {
    			 i--;//如果重复循环继续执行一次，不重复就加入
    		 }
    	   }
    	   answer[i] = formula.getAnswer(); 
    	   temp = random.nextInt(2);
       }
     }
     //输出算式
     public void printformula() {
    	 int i = 0;
    	 for(String s:Set_formula) {
    		 i++;
    		 System.out.print(s+"\t");
    		 if (i % col_num == 0)
    			 System.out.print("\n"); 
    		
    	 }
     }
     //输出答案
     public void printanswer() {
    	 for(i = 0;i < formula_num;i++) {
			System.out.print(answer[i]+"\t");
			if ((i+1) % col_num == 0)
   			   System.out.print("\n"); 
    	 }
     }
     //Main函数
    public static void main(String[] args) {
		Excerise exercise = new Excerise();
		exercise.GenerateExerise();
		exercise.printformula();
		exercise.printanswer();
	}        
}