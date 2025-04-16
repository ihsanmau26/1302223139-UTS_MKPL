package lib;

public class EmployeeInfo {
    public String employeeId;
    public String firstName;
    public String lastName;
    public String idNumber;
    public String address;

    public int yearJoined;
    public int monthJoined;
    public int dayJoined;

    public Nationality nationality;
    public Gender gender;

    public EmployeeInfo(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, Nationality nationality, Gender gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.nationality = nationality;
        this.gender = gender;
    }
}
