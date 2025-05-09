package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	public static int calculateTax(TaxData data) {
        if (data.numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        int totalIncome = calculateTotalIncome(data);
        int nonTaxable = calculateNonTaxableIncome(data);
        int taxableIncome = calculateTaxableIncome(totalIncome, data.incomeInfo.annualDeductible, nonTaxable);
        return calculateTaxAmount(taxableIncome);
    }

    private static int calculateTotalIncome(TaxData data) {
        return (data.incomeInfo.monthlySalary + data.incomeInfo.otherMonthlyIncome) * data.numberOfMonthWorking;
    }

    private static int calculateNonTaxableIncome(TaxData data) {
        int nonTaxable = 54000000;
        if (data.familyInfo.isMarried) {
            nonTaxable += 4500000;
        }
        nonTaxable += data.familyInfo.numberOfChildren * 1500000;
        return nonTaxable;
    }

    private static int calculateTaxableIncome(int totalIncome, int deductible, int nonTaxable) {
        return totalIncome - deductible - nonTaxable;
    }

    private static int calculateTaxAmount(int taxableIncome) {
        if (taxableIncome < 0) {
            return 0;
        } else {
            return taxableIncome;
        }
    }
	
}
