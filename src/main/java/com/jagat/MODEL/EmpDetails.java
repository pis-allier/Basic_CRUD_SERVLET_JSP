package com.jagat.MODEL;

public class EmpDetails {

	private long empId;
	private String empBankAcc;
	private String empCompany;
	private String empJobTitle;
	private String empLastName;
	private String empName;
	private double empSalary;
	private double pfAccBalance;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpBankAcc() {
		return empBankAcc;
	}

	public void setEmpBankAcc(String empBankAcc) {
		this.empBankAcc = empBankAcc;
	}

	public String getEmpCompany() {
		return empCompany;
	}

	public void setEmpCompany(String empCompany) {
		this.empCompany = empCompany;
	}

	public String getEmpJobTitle() {
		return empJobTitle;
	}

	public void setEmpJobTitle(String empJobTitle) {
		this.empJobTitle = empJobTitle;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public double getPfAccBalance() {
		return pfAccBalance;
	}

	public void setPfAccBalance(double pfAccBalance) {
		this.pfAccBalance = pfAccBalance;
	}

	public EmpDetails(long empId, String empBankAcc, String empCompany, String empJobTitle, String empLastName,
			String empName, double empSalary, double pfAccBalance) {
		super();
		this.empId = empId;
		this.empBankAcc = empBankAcc;
		this.empCompany = empCompany;
		this.empJobTitle = empJobTitle;
		this.empLastName = empLastName;
		this.empName = empName;
		this.empSalary = empSalary;
		this.pfAccBalance = pfAccBalance;
	}

	public EmpDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmpDetails [empId=" + empId + ", empBankAcc=" + empBankAcc + ", empCompany=" + empCompany
				+ ", empJobTitle=" + empJobTitle + ", empLastName=" + empLastName + ", empName=" + empName
				+ ", empSalary=" + empSalary + ", pfAccBalance=" + pfAccBalance + "]";
	}

}
