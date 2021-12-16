package user;

public class Doctor {
    private int idDoctor;
    private String doctorName;
    private String department;
    private int cabinetNumber;
    private String phoneNumber;

    public Doctor(int idDoctor, String doctorName, String department, int cabinetNumber, String phoneNumber) {
        this.idDoctor = idDoctor;
        this.doctorName = doctorName;
        this.department = department;
        this.cabinetNumber = cabinetNumber;
        this.phoneNumber = phoneNumber;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(int cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
