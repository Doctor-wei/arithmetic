package compute3;

public class SubExercise extends Exercise {
	@Override
	protected void GenerateExercise(int count) {
		// TODO Auto-generated method stub
		 for(int i = 0;i < count;i++) {
			 SubstractFormula substraction = new SubstractFormula();
			 if(!formula.add(substraction.toString()))
            	 i--;
             else 
    	     answer.add(substraction.getAnswer());
    	 }	 
	}
}
