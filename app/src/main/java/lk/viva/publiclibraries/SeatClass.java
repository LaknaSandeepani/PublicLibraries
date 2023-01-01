package lk.viva.publiclibraries;

public class SeatClass {
    String Name,Gender,Nic,Room,Seat,Date,FromTime,ToTime;

    public SeatClass() {
    }

    public SeatClass(String name, String gender, String nic, String room, String seat, String date, String fromTime, String toTime) {
        Name = name;
        Gender = gender;
        Nic = nic;
        Room = room;
        Seat = seat;
        Date = date;
        FromTime = fromTime;
        ToTime = toTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getNic() {
        return Nic;
    }

    public void setNic(String nic) {
        Nic = nic;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }

    public String getSeat() {
        return Seat;
    }

    public void setSeat(String seat) {
        Seat = seat;
    }
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
    public String getFromTime() {
        return FromTime;
    }

    public void setFromTime(String fromTime) {
        FromTime = fromTime;
    }
    public String getToTime() {
        return ToTime;
    }

    public void setToTime(String toTime) {
        ToTime = toTime;
    }
}
