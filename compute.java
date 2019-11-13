import java.util.Random;

public class compute { 
	public static void main(String[] args) {
		int a=0,b=0,o=0;
		char s='+';
		Random random =new Random();
		for(int i=0;i<50;i++) {
			o=(int)random.nextInt(2);
			a=(int)random.nextInt(101);
			b=(int)random.nextInt(101);
			if(o==1)
				s='+';
			else
				s='-';
			System.out.println(""+(i+1)+":\t"+a+s+b+"=");
		}
	}
}
