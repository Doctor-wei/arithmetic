package compute3;

import java.util.Random;

public abstract class Formula {
	static final int MAX = 100;
    static final int MIN = 0;
    public int left_num = 0, right_num = 0, answer = 0;
    public abstract boolean CheckAnswer(int num);
    public abstract int ComputeAnswer(int left, int right);
    protected void GenerateFormula(char symbol) {
    	Random random = new Random();
    	left_num = random.nextInt(MAX+1);
    	do {
    		right_num = random.nextInt(MAX+1);
        	answer = ComputeAnswer(left_num,right_num);
    	}while(!CheckAnswer(answer));
    }
	public int getAnswer() {
		return answer;
	}
}
