import java.util.Random;

public class compute { 
	static int Formula[][]= new int[51][3];//�洢��ʽ
	static int Answer[] = new int[51];//��Ŵ�
	int i=0;
	public  void generateEquations()//������ʽ
	{
		int num1,num2,temp;
	    int flag=0;
		Random random=new Random();
		while(i<50) {
		num1=random.nextInt(101);//��һ����
		num2=random.nextInt(101);//�ڶ�����
		temp=random.nextInt(2);//����
		if(i==1&&temp==Formula[0][1])//ȷ��һ�����ڼӷ��ͼ���
			temp=1-Formula[0][1];
		flag=this.CheckRepeate(num1, num2, temp); //����ظ�
		if(temp==1&&flag==0) {
			if(num1+num2<=100) {
				Formula[i][0]=num1;
				Formula[i][1]=temp;
				Formula[i][2]=num2;
				Answer[i]=num1+num2;
				i++;
			}
		}
		else if(temp==0&&flag==0){
			if(num1-num2>=0) {
				Formula[i][0]=num1;
				Formula[i][1]=temp;
				Formula[i][2]=num2;
				Answer[i]=num1-num2;
				i++;
			}
		}
		flag=1;
		
		}
	}	
	public int CheckRepeate(int num1,int num2,int temp) {
	    int flag1=0;
		for(int j=0;j<i;j++) {
			if(num1==Formula[j][0]&&temp==Formula[j][1]&&num2==Formula[j][2]) {
				  flag1=1;
				  break;
			}
		}
		return flag1;
			
	}
	
	public void printEquations() {	//�����ʽ
		for(int i=0;i<50;i++) {
			System.out.print("��"+(i+1)+"����:"+Formula[i][0]+"");
			if(Formula[i][1]==0)
			System.out.print("-");
			else
			System.out.print("+");
			System.out.print(Formula[i][2]+"=\t\t");
			if((i+1)%5==0) {
				System.out.println();
			}
		}
	}
	public void printAnswers() {	//�����
		for(int i=0;i<50;i++) {
			System.out.print("��"+(i+1)+"����:"+Answer[i]+"     ");
			if((i+1)%5==0) {
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		compute a = new compute();
		a.generateEquations();
		a.printEquations();
		a.printAnswers();
	}
}
