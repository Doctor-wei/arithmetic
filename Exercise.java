package compute3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;


import compute.Formula;

public class Exercise {
	 private static final short formula_num = 50;
     Random random = new Random();
     int i = 0, temp = 0;
     LinkedHashSet<String> Set_add = new LinkedHashSet<>();//��ӷ�
     LinkedHashSet<String> Set_sub = new LinkedHashSet<>();//�����
     LinkedHashSet<String> Set_mix = new LinkedHashSet<>();//����
     ArrayList Add_answer = new ArrayList();//�ӷ���
     ArrayList Sub_answer = new ArrayList();///������
     ArrayList Mix_answer = new ArrayList();//��ϴ�
     
     public void GenerateAdd(int count) {
    	 for(i = 0;i < count;i++) {
    		 AdditionFormula addition = new AdditionFormula();
    		 do {
    			 Set_add.add(addition.toString());
    		 }while(Set_add.add(addition.toString()));
    	 Add_answer.add(addition.getAnswer());
    	 }	 
     }//����һ�������ļӷ���ʽ,countΪ����
     
     public void GenerateSub(int count) {
    	 for(i = 0;i < count;i++) {
    		 SubstractFormula substraction = new SubstractFormula();
    		 do {
    			 Set_sub.add(substraction.toString());
    		 }while(Set_sub.add(substraction.toString()));
    	 Sub_answer.add(substraction.getAnswer());
    	 }
     }//����һ�������ļ�����ʽ
  
     public void GenerateExerise(int count) {
    	 for(i = 0;i < count;i++) {
    	    temp = random.nextInt(2);
    	   if(temp == 0) {
    		   AdditionFormula addition = new AdditionFormula();
    		   do {
      			 Set_mix.add(addition.toString());
      		   }while(Set_mix.add(addition.toString()));
    		   Mix_answer.add(addition.getAnswer());
    	   }else {
    		   SubstractFormula substraction = new SubstractFormula();
    		   do {
      			 Set_mix.add(substraction.toString());
      		   }while(Set_mix.add(substraction.toString()));
    	   Mix_answer.add(substraction.getAnswer());
    	   }
    	 }	 
     }//����һ�����������ʽ
     
     public void Format_add_print(int count, int num) {
    	 int i = 0;
    	 for(String s:Set_add) {
    		 System.out.print(s+"\t");
    		 i++;
    		 if (i % num == 0)
    			 System.out.print("\n"); 
    		
    	 }	 
     }//����ӷ���ʽ
     
     public void Format_sub_print(int count, int num) {
    	 int i = 0;
    	 for(String s:Set_sub) {
    		 i++;
    		 System.out.print(s+"\t");
    		 if (i % num == 0)
    			 System.out.print("\n"); 
    		
    	 }	 
     }//���������ʽ
     
     public void Format_mix_print(int count, int num) {
    	 int i = 0;
    	 for(String s:Set_mix) {
    		 i++;
    		 System.out.print(s+"\t");
    		 if (i % num == 0)
    			 System.out.print("\n"); 
    		
    	 }	 
     }//��������ʽ
     
     public void FormatMixAnswerPrint(int num) {
    	 for(int i = 0;i < Mix_answer.size();i++) {
 			System.out.print(Mix_answer.get(i)+"\t");
 			if ((i+1) % num == 0)
    			   System.out.print("\n"); 
     	 }
    	 	 
     }//��������ʽ��,numΪһ���������
     
     public void FormatAddAnswerPrint(int num) {
    	 for(int i = 0;i < Add_answer.size();i++) {
 			System.out.print(Add_answer.get(i)+"\t");
 			if ((i+1) % num == 0)
    			   System.out.print("\n"); 
     	 }
    	 	 
     }//����ӷ���ʽ��,numΪһ���������
     
     public void FormatSubAnswerPrint(int num) {
    	 for(int i = 0;i < Sub_answer.size();i++) {
 			System.out.print(Sub_answer.get(i)+"\t");
 			if ((i+1) % num == 0)
    			   System.out.print("\n"); 
     	 }
    	 	 
     }//���������ʽ��,numΪһ���������
     
     
}
