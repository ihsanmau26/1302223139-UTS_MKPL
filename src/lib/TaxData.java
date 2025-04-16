package lib;

public class TaxData {
    public int numberOfMonthWorking;
    public IncomeInfo incomeInfo;
    public FamilyInfo familyInfo;

    public TaxData(IncomeInfo incomeInfo, int numberOfMonthWorking, FamilyInfo familyInfo) {
        this.incomeInfo = incomeInfo;
        this.numberOfMonthWorking = numberOfMonthWorking;
        this.familyInfo = familyInfo;
    }
}
