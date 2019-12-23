package compute3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;


import java.io.File;

public abstract class FileIO {
	ArrayList<String> Answer = new ArrayList<String>();
	Scanner in = new Scanner(System.in);
	protected abstract void Createfile(int file_count, int exercise_count);//创建（加法、减法等）文件,file_count文件数量，exercise习题数量
	public void Create_Dir(String Name) {// 函数作用为创建目录，name为二级文件夹名称
		String destDirName = "E:\\test\\";
		destDirName += Name;
		File dir = new File(destDirName);
		if (dir.exists()) {
			System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// 创建目录
		if (dir.mkdirs()) {
			System.out.println("创建目录" + destDirName + "成功！");
		} else {
			System.out.println("创建目录" + destDirName + "失败！");
		}

	}
	public ArrayList<String[]> Read(String FileType, String type ,int num) {// type为读习题的类型，FileType为文件类型（习题、练习、批改）,num为读第几套习题
		ArrayList<String[]> ReadList = new ArrayList<String[]>();
		String pathCSV = "E:\\test\\";
		pathCSV += FileType+"\\";
		pathCSV += type+"_" + num + ".csv";
		try {
			CsvReader reader = new CsvReader(pathCSV, ',', Charset.forName("gb2312"));// 数据由逗号分隔
			reader.readHeaders();// 跳过表头
			while (reader.readRecord()) {
				// System.out.println(reader.getRawRecord());
				ReadList.add(reader.getValues());
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ReadList;
	}
	
	
//    public void print(String FileType, String type,int num) {//输出type类型的第num套习题
//    	System.out.println("您练习的是第" + num + "套" + type + "习题");// 提示
//		for (int row = 0; row < lstFile.size(); row++) {
//			for (int col = 1; col < lstFile.get(row).length; col++) {
//				String cell = lstFile.get(row)[col];// 取得第row行第col列的数据
//				System.out.print(cell);
//			}
//			System.out.println();
//		} // 输出操作
//    }
    
    public void print(String type, int num) { 
    	ArrayList<String[]> PrintList = new ArrayList<String[]>();
    	PrintList=Read("Practice",type,num);
    	if(PrintList.get(PrintList.size()-1)[2]!="") {
    		System.out.println("本套习题已经做完，请换一套其他习题");
    	}
    	else {
    	int number = 0;//标记上次做到哪里
    	for(int i=0;i<PrintList.size();i++)
    		if(PrintList.get(i)[2]!="") {
    			number=i+1;
    		}
//    		System.out.println(lstFile.get(i).length);
    	if(number==0)
    		System.out.println("您没做过此套习题，从第一套题目开始");
    	else
    	    System.out.println("您已经做过本套本套习题，现在从第"+(number+1)+"道习题继续");
    	for (int row = number; row < PrintList.size(); row++) {//下次从第num道题目继续读
			String cell = PrintList.get(row)[1];
			System.out.print(cell);
			int answer = in.nextInt();
			if(answer == -1) {
				System.out.println("本次练习题目"+(row-number)+"道"+"还剩"+(PrintList.size()-row)+"道题目");
				break;//等于-1停止存答案
				}
			else
			Answer.add(String.valueOf(answer));
			if(row==PrintList.size()-1)
				System.out.println("本套习题已做完");
     }
    	}
    }
    public void CreatePractice(String type, int num) {
    	ArrayList<String[]> ExerciseList = new ArrayList<String[]>();
    	ExerciseList=this.Read("Exercise", type, num);//将从习题读出的列表赋值给练习列表，练习列表负责写入操作
    	String pathCSVWrite = "E:\\test\\Practice\\";
		pathCSVWrite += type + "_" + num + ".csv";
		try {
			CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("gb2312"));
			String[] csvHeader = { "序号", "算式", "结果" };
			csvWriter.writeRecord(csvHeader);
			String[] csvContent = new String[4];
			for(int row=0;row<ExerciseList.size();row++) {
			csvContent[0] = ExerciseList.get(row)[0];
			csvContent[1] = ExerciseList.get(row)[1];
			csvContent[2] = "";
            csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
			System.out.println("----------习题文件创建完成----------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	public void practice(String type, int num) {// type为习题的类型，num为第几套习题，ans为答案
		ArrayList<String[]> PracticeList = new ArrayList<String[]>();
		PracticeList=Read("Practice",type,num);
		this.print(type,num);//调用输出函数，同时也获取答案
		int i=0;
		int count=Answer.size();
		String pathCSVWrite = "E:\\test\\Practice\\";
		pathCSVWrite += type + "_" + num + ".csv";
		try {
			CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("gb2312"));
			String[] csvHeader = { "序号", "算式", "结果" };
			csvWriter.writeRecord(csvHeader);
			String[] csvContent = new String[4];
			for(int row=0;row<PracticeList.size();row++) {
			csvContent[0] = PracticeList.get(row)[0];
			csvContent[1] = PracticeList.get(row)[1];
			if(PracticeList.get(row)[2]!="") {
			csvContent[2] = PracticeList.get(row)[2];
			}else if((PracticeList.get(row)[2]=="")&&(count!=0)){//原文件无答案且用户输入了答案
				csvContent[2]=Answer.get(i);
				count--;
				i++;
			}else {
				csvContent[2]="";
			}
            csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Correct(String type, int num) {
		ArrayList<String[]> ExerciseList = new ArrayList<String[]>();
		ArrayList<String[]> PracticeList = new ArrayList<String[]>();
		ExerciseList=this.Read("Exercise", type, num);
		PracticeList=this.Read("Practice", type, num);
		String pathCSVWrite = "E:\\test\\Result\\";
		pathCSVWrite += type + "_" + num + "_result.csv";
		try {
			CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("gb2312"));
			String[] csvHeader = { "序号", "算式", "结果" ,"正确答案","正确性"};
			csvWriter.writeRecord(csvHeader);
			String[] csvContent = new String[5];
			for(int row=0;row<PracticeList.size();row++) {
			csvContent[0] = PracticeList.get(row)[0];
			csvContent[1] = PracticeList.get(row)[1];
			if(PracticeList.get(row)[2]!="") {
			csvContent[2] = PracticeList.get(row)[2];
			}else {
				System.out.println("批改完成，共计批改"+(row)+"道题目");
				break;
			}
			csvContent[3] = ExerciseList.get(row)[2];
			
			if(ExerciseList.get(row)[2].equals(PracticeList.get(row)[2]))
				csvContent[4]="正确";
			else
				csvContent[4]="错误";
            csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
