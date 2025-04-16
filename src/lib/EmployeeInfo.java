package lib;

public class EmployeeInfo {
    public String employeeId;
    public PersonalIdentity identity;
    public JoinDate joinDate;
    public Nationality nationality;
    public Gender gender;

    public EmployeeInfo(String employeeId, PersonalIdentity identity, JoinDate joinDate, Nationality nationality, Gender gender) {
        this.employeeId = employeeId;
        this.identity = identity;
        this.joinDate = joinDate;
        this.nationality = nationality;
        this.gender = gender;
    }
}
