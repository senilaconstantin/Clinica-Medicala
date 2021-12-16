package user;

public class Pacient {
    private int idPacient;
    private String CNP;
    private String address;
    private String pacientName;
    private String phoneNumber;

    public Pacient(int idPacient, String CNP, String address, String pacientName, String phoneNumber) {
        this.idPacient = idPacient;
        this.CNP = CNP;
        this.address = address;
        this.pacientName = pacientName;
        this.phoneNumber = phoneNumber;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPacientName() {
        return pacientName;
    }

    public void setPacientName(String pacientName) {
        this.pacientName = pacientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
