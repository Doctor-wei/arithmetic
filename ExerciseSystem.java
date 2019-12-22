package compute3;

import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseSystem {
	public static void main(String[] args) {
    SubExercise sub = new SubExercise();
    AddExercise add = new AddExercise();
    MixExercise mix = new MixExercise();
    //三类习题各产生20道
    sub.GenerateExercise(20);
    add.GenerateExercise(20);
    mix.GenerateExercise(20);
    //三类习题格式输出算式
    sub.FormatPrint(5);
    add.FormatPrint(5);
    mix.FormatPrint(5);
    //三类习题格式化输出答案
    sub.FormatAnswerPrint(5);//每行5个
    add.FormatAnswerPrint(5);//每行5个
    mix.FormatAnswerPrint(5);//每行5个
    
    
    
    
    
        
	}

}
