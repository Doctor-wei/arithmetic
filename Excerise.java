package compute;

import java.util.LinkedHashSet;
import java.util.Random;

public class Excerise {
	 private static final short formula_num = 50;
     private static final short col_num = 5;
     int i = 0, temp = 0;
     int [] answer = new int[51];//��Ŵ�
     LinkedHashSet<String> Set_formula = new LinkedHashSet<>();
     //����ϰ�⣨50�����ظ���ʽ��
     public void GenerateExerise() {
       for(i = 0;i < formula_num;i++) {
    	   Formula formula = new Formula();
    	   Random random = new Random();
    	   if (temp == 0) {
    		 formula.GenerateAddition();//���ɼӷ���ʽ
    		 if (Set_formula.add(formula.toString())==false) {
    			 i--;//����ظ�ѭ������ִ��һ�Σ����ظ��ͼ���
    		 }	 
    	   }else {
    		 formula.GenerateSubstract();//���ɼ�����ʽ
    		 if (Set_formula.add(formula.toString())==false) {
    			 i--;//����ظ�ѭ������ִ��һ�Σ����ظ��ͼ���
    		 }
    	   }
    	   answer[i] = formula.getAnswer(); 
    	   temp = random.nextInt(2);
       }
     }
     //�����ʽ
     public void printformula() {
    	 int i = 0;
    	 for(String s:Set_formula) {
    		 i++;
    		 System.out.print(s+"\t");
    		 if (i % col_num == 0)
    			 System.out.print("\n"); 
    		
    	 }
     }
     //�����
     public void printanswer() {
    	 for(i = 0;i < formula_num;i++) {
			System.out.print(answer[i]+"\t");
			if ((i+1) % col_num == 0)
   			   System.out.print("\n"); 
    	 }
     }
     //Main����
    public static void main(String[] args) {
		Excerise exercise = new Excerise();
		exercise.GenerateExerise();
		exercise.printformula();
		exercise.printanswer();
	}        
}