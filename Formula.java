package compute;

import java.util.Random;

public class Formula {
    static final int MAX = 100;
    static final int MIN = 0;
    public int left_num = 0, right_num = 0;
    public char symbol;
    public int answer;
    //�����ӷ�
    public void GenerateAddition() {
        Random random = new Random();
        symbol = '+';
        left_num = random.nextInt(MAX+1);
        do {
        	right_num = random.nextInt(MAX+1);
        	answer = left_num + right_num;
        }while(answer > MAX);  
    }
    //��������
    public void GenerateSubstract() {
    	Random random = new Random();
        left_num = random.nextInt(MAX+1);
        right_num = random.nextInt(left_num+1);
        symbol = '-';
        answer = left_num - right_num; 
    }
    //���String������ʽ
    public String toString() {
		return ""+left_num+""+symbol+""+right_num+"=";
	}
	//��ô�
	public int getAnswer() {
		return answer;
	}
	  
}
