package compute3;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public abstract class Exercise {
	LinkedHashSet<String> formula = new LinkedHashSet<>();//存算式
	ArrayList<Integer>    answer = new ArrayList<Integer>();//存答案
	protected abstract void GenerateExercise(int count);//类型为Formula对象,count为产生数量 
    public void FormatPrint(int num) {//函数作用为输出算式，num为每行输出几个
   	 int i = 0;
   	 for(String s:formula) {
   		 i++;
   		 System.out.print(s+"\t");
   		 if (i % num == 0)
   			 System.out.print("\n"); 
   	 }	 
    }
    public void FormatAnswerPrint(int num) {//输出算式答案,num为一行输出几个
   	 for(int i = 0;i < answer.size();i++) {
			System.out.print(answer.get(i)+"\t");
			if ((i+1) % num == 0)
   			   System.out.print("\n"); 
    	 }
   	 	 
    }
}
