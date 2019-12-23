package compute3;

import java.io.IOException;
import java.nio.charset.Charset;

import com.csvreader.CsvWriter;

public class AddFile extends FileIO{
	
	@Override
	protected void Createfile(int file_count, int exercise_count) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= file_count; i++) {
			AddExercise exercise = new AddExercise();
			exercise.GenerateExercise(exercise_count);
			String pathCSVWrite = "E:\\test\\Exercise\\";
			pathCSVWrite += "Add_" + i + ".csv";
			
			try {
				CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("gb2312"));
				String[] csvHeader = { "���", "��ʽ", "��" };
				csvWriter.writeRecord(csvHeader);
				int j = 0;
				for (String s : exercise.formula) {
					String[] csvContent = { String.valueOf(j + 1), s, exercise.answer.get(j).toString() };
					csvWriter.writeRecord(csvContent);
					j++;
				}

				csvWriter.close();
				System.out.println("---------------�ӷ�ϰ�������д�����--------------");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
