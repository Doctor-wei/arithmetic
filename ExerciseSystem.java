package compute3;

import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseSystem {
	public static void main(String[] args) {
    SubExercise sub = new SubExercise();
    AddExercise add = new AddExercise();
    MixExercise mix = new MixExercise();
    //����ϰ�������20��
    sub.GenerateExercise(20);
    add.GenerateExercise(20);
    mix.GenerateExercise(20);
    //����ϰ���ʽ�����ʽ
    sub.FormatPrint(5);
    add.FormatPrint(5);
    mix.FormatPrint(5);
    //����ϰ���ʽ�������
    sub.FormatAnswerPrint(5);//ÿ��5��
    add.FormatAnswerPrint(5);//ÿ��5��
    mix.FormatAnswerPrint(5);//ÿ��5��
    
    
    
    
    
        
	}

}
