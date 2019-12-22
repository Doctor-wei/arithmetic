package compute3;

public class AddExercise extends Exercise {
	@Override
	protected void GenerateExercise(int count) {
		// TODO Auto-generated method stub
		 for(int i = 0;i < count;i++) {
    		 AdditionFormula addition = new AdditionFormula();
             if(!formula.add(addition.toString()))
            	 i--;
             else 
    	     answer.add(addition.getAnswer());
    	 }	 
	}
}
