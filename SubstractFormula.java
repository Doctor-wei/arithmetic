package compute3;

public class SubstractFormula extends Formula{
	public  SubstractFormula() {
		super.GenerateFormula('-');
	}//���ɼ���
	
	public boolean CheckAnswer(int num) {
		// TODO Auto-generated method stub
		return num > MIN;
	}//�жϴ��Ƿ�����Ҫ��
	
	public int ComputeAnswer(int left, int right){
		return left - right;
	}//������
	
	public String toString() {
		return ""+left_num+"-"+right_num+"=";
	}//�����ַ�����ʽ
}
