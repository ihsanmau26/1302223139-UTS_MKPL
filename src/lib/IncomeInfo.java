package lib;

public class IncomeInfo {
    public int monthlySalary;
    public int otherMonthlyIncome;
    public int annualDeductible;

    public IncomeInfo(int monthlySalary, int otherMonthlyIncome, int annualDeductible) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.annualDeductible = annualDeductible;
    }
}