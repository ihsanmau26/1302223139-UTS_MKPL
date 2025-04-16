package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	private int yearJoined;
	private int monthJoined;
	private int dayJoined;
	private int monthWorkingInYear;
	
	private Gender gender;
	private Nationality nationality;
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(EmployeeInfo info) {
		this.employeeId = info.employeeId;
		this.firstName = info.identity.firstName;
		this.lastName = info.identity.lastName;
		this.idNumber = info.identity.idNumber;
		this.address = info.identity.address;
	
		this.yearJoined = info.joinDate.year;
		this.monthJoined = info.joinDate.month;
		this.dayJoined = info.joinDate.day;
	
		this.gender = info.gender;
		this.nationality = info.nationality;
	
		childNames = new LinkedList<>();
		childIdNumbers = new LinkedList<>();
	}
	
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	 public void setMonthlySalary(int grade) {
		switch (grade) {
			case 1:
				monthlySalary = 3000000;
				break;
			case 2:
				monthlySalary = 5000000;
				break;
			case 3:
				monthlySalary = 7000000;
				break;
			default:
				monthlySalary = 0;
		}
	
		if (nationality == Nationality.FOREIGNER) {
			monthlySalary = (int) (monthlySalary * 1.5);
		}
	}	
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = spouseIdNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		}else {
			monthWorkingInYear = 12;
		}
		
		IncomeInfo incomeInfo = new IncomeInfo(monthlySalary, otherMonthlyIncome, annualDeductible);
		FamilyInfo familyInfo = new FamilyInfo(!spouseIdNumber.equals(""), childIdNumbers.size());

		TaxData taxData = new TaxData(incomeInfo, monthWorkingInYear, familyInfo);

		return TaxFunction.calculateTax(taxData);
	}
}
