package compute3;

public class AdditionFormula extends Formula{
 
	public  AdditionFormula() {
		super.GenerateFormula('+');
	}//生成加法
	
	public boolean CheckAnswer(int num) {
		// TODO Auto-generated method stub
		return num < MAX;
	}//判断答案是否满足要求
	
	public int ComputeAnswer(int left, int right){
		return left + right;
	}//计算结果
	
	public String toString() {
		return ""+left_num+"+"+right_num+"=";
	}//返回字符串算式

}
