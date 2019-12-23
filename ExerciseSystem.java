package compute3;

import java.util.Scanner;
import java.util.ArrayList;

public class ExerciseSystem {
	public static void main(String[] args) {
		int answer;
		Scanner in = new Scanner(System.in);
		AddFile add = new AddFile();
//	    SubFile sub = new SubFile();
//	    MixFile mix = new MixFile();
//	    add.Createfile(5,5);
//	    sub.Createfile(5,5);
//	    mix.Createfile(5,5);
//	    add.print("Practice", "Add", 3);
//		add.CreatePractice("Add", 3);//从已有的加法第二套习题中创建练习文件
		add.practice("Add", 3);
		add.Correct("Add",3);        
//		add.Read("Practice", "Add", 1);
        
		
		
		

}
}