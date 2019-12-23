package compute3;

import java.io.IOException;
import java.nio.charset.Charset;

import com.csvreader.CsvWriter;

public class SubFile extends FileIO {

	@Override
	protected void Createfile(int file_count, int exercise_count) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= file_count; i++) {
			SubExercise exercise = new SubExercise();
			exercise.GenerateExercise(exercise_count);
			String pathCSVWrite = "E:\\test\\Exercise\\";
			pathCSVWrite += "Sub_" + i + ".csv";
			try {
				CsvWriter csvWriter = new CsvWriter(pathCSVWrite, ',', Charset.forName("gb2312"));
				String[] csvHeader = { "序号", "算式", "答案" };
				csvWriter.writeRecord(csvHeader);
				int j = 0;
				for (String s : exercise.formula) {
					String[] csvContent = { String.valueOf(j + 1), s, exercise.answer.get(j).toString() };
					csvWriter.writeRecord(csvContent);
					j++;
				}

				csvWriter.close();
				System.out.println("------------减法习题已完成写入操作--------------");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
