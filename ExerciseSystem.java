package compute3;

import java.util.Scanner;
import java.util.ArrayList;

public class ExerciseSystem {
	public static void main(String[] args) {
		int answer;
		Scanner in = new Scanner(System.in);
	    
	    SubFile sub = new SubFile();
	    MixFile mix = new MixFile();
	    AddFile add = new AddFile();
	    sub.CreatePractice("Sub", 1);
	    add.CreatePractice("Add", 1);
	    mix.CreatePractice("Mix", 1);
	    
	    
//	    add.print("Practice", "Add", 3);
//		add.CreatePractice("Add", 3);//从已有的加法第二套习题中创建练习文件
//		add.practice("Add", 3);
//		add.Correct("Add",3);        
////		add.Read("Practice", "Add", 1);
        
		
		
		

}
}