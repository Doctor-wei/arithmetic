package compute3;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public abstract class Exercise {
	LinkedHashSet<String> formula = new LinkedHashSet<>();//����ʽ
	ArrayList<Integer>    answer = new ArrayList<Integer>();//���
	protected abstract void GenerateExercise(int count);//����ΪFormula����,countΪ�������� 
    public void FormatPrint(int num) {//��������Ϊ�����ʽ��numΪÿ���������
   	 int i = 0;
   	 for(String s:formula) {
   		 i++;
   		 System.out.print(s+"\t");
   		 if (i % num == 0)
   			 System.out.print("\n"); 
   	 }	 
    }
    public void FormatAnswerPrint(int num) {//�����ʽ��,numΪһ���������
   	 for(int i = 0;i < answer.size();i++) {
			System.out.print(answer.get(i)+"\t");
			if ((i+1) % num == 0)
   			   System.out.print("\n"); 
    	 }
   	 	 
    }
}
