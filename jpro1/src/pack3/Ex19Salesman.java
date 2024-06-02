package pack3;

public class Ex19Salesman extends Ex19Regular {
    private double sales;
    private double commissionRate;

    public Ex19Salesman(String irum, int nai, double salary, double sales, double commissionRate) {
        super(irum, nai, salary);
        this.sales = sales;
        this.commissionRate = commissionRate;
    }

    @Override
    public double pay() {
        return salary + (sales * commissionRate);
    }

    @Override
    public void print() {
        display();
        System.out.println("수령액: " + pay());
    }
}

