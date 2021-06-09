package Unirest.UnirestProject;

import java.util.List;

public class ComplexPojo {
	
	
    private List<Accounting> accounting;
    private List<Sales> sales;
	public List<Accounting> getAccounting() {
		return accounting;
	}
	public void setAccounting(List<Accounting> accounting) {
		this.accounting = accounting;
	}
	public List<Sales> getSales() {
		return sales;
	}
	public void setSales(List<Sales> sales) {
		this.sales = sales;
	}
	public ComplexPojo(List<Accounting> accounting, List<Sales> sales) {
		super();
		this.accounting = accounting;
		this.sales = sales;
	}
    
    

}
