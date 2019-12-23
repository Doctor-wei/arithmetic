package compute3;
import java.util.Random;

public class MixExercise extends Exercise {
	@Override
	protected void GenerateExercise(int count) {
		// TODO Auto-generated method stub
		int temp=0;
		Random random = new Random();
		 for(int i = 0;i < count;i++) {
	    	    temp = random.nextInt(2);
	    	   
	    	   if(temp == 0) {
	    		   AdditionFormula addition = new AdditionFormula();
	    		 if(!formula.add(addition.toString()))
	              	 i--;
	             else 
	    		   answer.add(addition.getAnswer());
	    	   }else {
	    		   SubstractFormula substraction = new SubstractFormula();
	    		   if(!formula.add(substraction.toString()))
	                   i--;
	               else 
	    	          answer.add(substraction.getAnswer());
	    	   }
	    	 }	 
	}
}
