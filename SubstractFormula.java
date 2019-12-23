package compute3;

public class SubstractFormula extends Formula{
	public  SubstractFormula() {
		super.GenerateFormula('-');
	}//生成减法
	
	public boolean CheckAnswer(int num) {
		// TODO Auto-generated method stub
		return num > MIN;
	}//判断答案是否满足要求
	
	public int ComputeAnswer(int left, int right){
		return left - right;
	}//计算结果
	
	public String toString() {
		return ""+left_num+"-"+right_num+"=";
	}//返回字符串算式
}
