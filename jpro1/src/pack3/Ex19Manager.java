package pack3;

public class Ex19Manager extends Ex19Regular {
    private double salary;
    
    
    
    

    public Ex19Manager(String irum, int nai, double salary) {
        super(irum, nai, salary);
        this.salary = salary;
    }

    @Override
    public double pay() {
    	 
    	        if (salary >= 2500000) {
    	            return salary * 1.6;
    	        } else if (salary >= 2000000) {
    	            return salary * 1.5;
    	        } else {
    	            return salary * 1.4;
    	        }
    	    
        
    }

    @Override
    public void print() {
        display();
        System.out.println("임금: " + pay());
    }
}
