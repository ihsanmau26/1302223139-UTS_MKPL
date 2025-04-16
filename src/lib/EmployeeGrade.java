package lib;

public class EmployeeGrade {
    private int level;

    public EmployeeGrade(int level) {
        if (level < 1 || level > 3) {
            throw new IllegalArgumentException("Grade must be 1, 2, or 3.");
        }
        this.level = level;
    }

    public int getBaseSalary() {
        switch (level) {
            case 1:
                return 3000000;
            case 2:
                return 5000000;
            case 3:
                return 7000000;
            default:
                return 0;
        }
    }
}
