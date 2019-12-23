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
	protected abstract void Createfile(int file_count, int exercise_count);//�������ӷ��������ȣ��ļ�,file_count�ļ�������exerciseϰ������
	public void Create_Dir(String Name) {// ��������Ϊ����Ŀ¼��nameΪ�����ļ�������
		String destDirName = "E:\\test\\";
		destDirName += Name;
		File dir = new File(destDirName);
		if (dir.exists()) {
			System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�Ŀ��Ŀ¼�Ѿ�����");
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// ����Ŀ¼
		if (dir.mkdirs()) {
			System.out.println("����Ŀ¼" + destDirName + "�ɹ���");
		} else {
			System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�");
		}

	}
	public ArrayList<String[]> Read(String FileType, String type ,int num) {// typeΪ��ϰ������ͣ�FileTypeΪ�ļ����ͣ�ϰ�⡢��ϰ�����ģ�,numΪ���ڼ���ϰ��
		ArrayList<String[]> ReadList = new ArrayList<String[]>();
		String pathCSV = "E:\\test\\";
		pathCSV += FileType+"\\";
		pathCSV += type+"_" + num + ".csv";
		try {
			CsvReader reader = new CsvReader(pathCSV, ',', Charset.forName("gb2312"));// �����ɶ��ŷָ�
			reader.readHeaders();// ������ͷ
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
	
	
//    public void print(String FileType, String type,int num) {//���type���͵ĵ�num��ϰ��
//    	System.out.println("����ϰ���ǵ�" + num + "��" + type + "ϰ��");// ��ʾ
//		for (int row = 0; row < lstFile.size(); row++) {
//			for (int col = 1; col < lstFile.get(row).length; col++) {
//				String cell = lstFile.get(row)[col];// ȡ�õ�row�е�col�е�����
//				System.out.print(cell);
//			}
//			System.out.println();
//		} // �������
//    }
    
    public void print(String type, int num) { 
    	ArrayList<String[]> PrintList = new ArrayList<String[]>();
    	PrintList=Read("Practice",type,num);
    	if(PrintList.get(PrintList.size()-1)[2]!="") {
    		System.out.println("����ϰ���Ѿ����꣬�뻻һ������ϰ��");
    	}
    	else {
    	int number = 0;//����ϴ���������
    	for(int i=0;i<PrintList.size();i++)
    		if(PrintList.get(i)[2]!="") {
    			number=i+1;
    		}
//    		System.out.println(lstFile.get(i).length);
    	if(number==0)
    		System.out.println("��û��������ϰ�⣬�ӵ�һ����Ŀ��ʼ");
    	else
    	    System.out.println("���Ѿ��������ױ���ϰ�⣬���ڴӵ�"+(number+1)+"��ϰ�����");
    	for (int row = number; row < PrintList.size(); row++) {//�´δӵ�num����Ŀ������
			String cell = PrintList.get(row)[1];
			System.out.print(cell);
			int answer = in.nextInt();
			if(answer == -1) {
				System.out.println("������ϰ��Ŀ"+(row-number)+"��"+"��ʣ"+(PrintList.size()-row)+"����Ŀ");
				break;//����-1ֹͣ���
				}
			else
			Answer.add(String.valueOf(answer));
			if(row==PrintList.size()-1)
				System.out.println("����ϰ��������");
     }
    	}
    }
    public void CreatePractice(String type, int num) {
    	ArrayList<String[]> ExerciseList = new ArrayList<String[]>();
    	ExerciseList=this.Read("Exercise", type, num);//����ϰ��������б�ֵ����ϰ�б���ϰ�б���д�����
    	String pathCSVWrite = "E:\\test\\Practice\\";
		pathCSVWrite += type + "_" + num + ".csv";
		try {
			CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("gb2312"));
			String[] csvHeader = { "���", "��ʽ", "���" };
			csvWriter.writeRecord(csvHeader);
			String[] csvContent = new String[4];
			for(int row=0;row<ExerciseList.size();row++) {
			csvContent[0] = ExerciseList.get(row)[0];
			csvContent[1] = ExerciseList.get(row)[1];
			csvContent[2] = "";
            csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
			System.out.println("----------ϰ���ļ��������----------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	public void practice(String type, int num) {// typeΪϰ������ͣ�numΪ�ڼ���ϰ�⣬ansΪ��
		ArrayList<String[]> PracticeList = new ArrayList<String[]>();
		PracticeList=Read("Practice",type,num);
		this.print(type,num);//�������������ͬʱҲ��ȡ��
		int i=0;
		int count=Answer.size();
		String pathCSVWrite = "E:\\test\\Practice\\";
		pathCSVWrite += type + "_" + num + ".csv";
		try {
			CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("gb2312"));
			String[] csvHeader = { "���", "��ʽ", "���" };
			csvWriter.writeRecord(csvHeader);
			String[] csvContent = new String[4];
			for(int row=0;row<PracticeList.size();row++) {
			csvContent[0] = PracticeList.get(row)[0];
			csvContent[1] = PracticeList.get(row)[1];
			if(PracticeList.get(row)[2]!="") {
			csvContent[2] = PracticeList.get(row)[2];
			}else if((PracticeList.get(row)[2]=="")&&(count!=0)){//ԭ�ļ��޴����û������˴�
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
			String[] csvHeader = { "���", "��ʽ", "���" ,"��ȷ��","��ȷ��"};
			csvWriter.writeRecord(csvHeader);
			String[] csvContent = new String[5];
			for(int row=0;row<PracticeList.size();row++) {
			csvContent[0] = PracticeList.get(row)[0];
			csvContent[1] = PracticeList.get(row)[1];
			if(PracticeList.get(row)[2]!="") {
			csvContent[2] = PracticeList.get(row)[2];
			}else {
				System.out.println("������ɣ���������"+(row)+"����Ŀ");
				break;
			}
			csvContent[3] = ExerciseList.get(row)[2];
			
			if(ExerciseList.get(row)[2].equals(PracticeList.get(row)[2]))
				csvContent[4]="��ȷ";
			else
				csvContent[4]="����";
            csvWriter.writeRecord(csvContent);
			}
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
