package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {

    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long duration() {
        // .getTime return a millisecond data
        long diff = checkOut.getTime() - checkIn.getTime();

        // Change milliseconds to days
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut) {

        Date now = new Date();
        if (!checkIn.before(now) || (checkOut.before(now))) {
            return "Error in reservation: REservation dates should be after the current date";
        }
        if (!checkOut.after(checkIn)) {
            return "Error in reservation: Check-Out date must be after Check-in date.";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber + " " +
                "CheckIn: " + sdf.format(checkIn) + " " +
                "CheckOut: " + sdf.format(checkOut) + " " +
                "Duration: " + duration() + " nights";
    }

}
