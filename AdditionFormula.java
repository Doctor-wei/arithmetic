package compute3;

public class AdditionFormula extends Formula{
 
	public  AdditionFormula() {
		super.GenerateFormula('+');
	}//���ɼӷ�
	
	public boolean CheckAnswer(int num) {
		// TODO Auto-generated method stub
		return num < MAX;
	}//�жϴ��Ƿ�����Ҫ��
	
	public int ComputeAnswer(int left, int right){
		return left + right;
	}//������
	
	public String toString() {
		return ""+left_num+"+"+right_num+"=";
	}//�����ַ�����ʽ

}
