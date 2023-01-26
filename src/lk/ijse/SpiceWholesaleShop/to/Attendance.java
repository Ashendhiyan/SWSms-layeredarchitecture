package lk.ijse.SpiceWholesaleShop.to;

public class Attendance {
    private String employeeId;
    private String attendanceId;
    private String date;
    private String state;

    public Attendance(String employeeId, String attendanceId, String date, String state) {
        this.employeeId = employeeId;
        this.attendanceId = attendanceId;
        this.date = date;
        this.state = state;
    }

    public Attendance() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
