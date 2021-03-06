package companies101.org.softlang.swing.model;

import companies101.org.softlang.company.Basic;
import companies101.org.softlang.company.Company;
import companies101.org.softlang.company.Department;
import companies101.org.softlang.company.Employee;
import companies101.org.softlang.operations.Cut;
import companies101.org.softlang.operations.Total;

/**
 * The data model.
 * 
 * @author Tobias Zimmer
 */
public class Model {

	private Company company;
	private Basic currentValue;

	/**
	 * Constructor
	 */
	public Model() {
		// The serialized object has been copied over from elsewhere
	  // You need to save your own
		//company = Company.readObject("sampleCompany.ser");
	  company = new Company();
	}

	/**
	 * This method returns the total value for the current company, department
	 * or employee.
	 * 
	 * @return current total value
	 */
	public String getTotal() {
		if (currentValue != null) {
			if (currentValue.isCompany()) {
				return Double.toString(Total.total((Company) currentValue));
			} else if (currentValue.isDepartment()) {
				return Double.toString(Total.total((Department) currentValue));
			} else if (currentValue.isEmployee()) {
				return Double.toString(Total.total((Employee) currentValue));
			} else {
				return "0";
			}
		} else {
			return "0";
		}
	}

	/**
	 * This method cuts the current company, department or employee.
	 */
	public void cut() {
		if (currentValue != null) {
			if (currentValue.isCompany()) {
				Cut.cut((Company) currentValue);
			} else if (currentValue.isDepartment()) {
				Cut.cut((Department) currentValue);
			} else if (currentValue.isEmployee()) {
				Cut.cut((Employee) currentValue);
			}
		}
	}

	// ----------------------------------- GETTER & SETTER
	public void setName(String newValue) {
		currentValue.setName(newValue);
	}

	public void setAddress(String newValue) {
		((Employee) currentValue).setAddress(newValue);
	}

	public void setSalary(String newValue) {
		((Employee) currentValue).setSalary(Double.parseDouble(newValue));
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Basic getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Basic currentValue) {
		this.currentValue = currentValue;
	}

}
