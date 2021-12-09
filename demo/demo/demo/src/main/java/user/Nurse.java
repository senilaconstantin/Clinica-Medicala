package user;

public class Nurse {
    private int idNurse;
    private String nurseName;
    private String department;
    private String phoneNumber;

    public Nurse(int nurseId, String nurseName, String department, String phoneNumber) {
        this.idNurse = nurseId;
        this.nurseName = nurseName;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }

    public int getNurseId() {
        return idNurse;
    }

    public void setNurseId(int nurseId) {
        this.idNurse = nurseId;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
