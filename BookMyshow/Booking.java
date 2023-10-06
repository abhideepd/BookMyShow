import java.awt.print.Book;
import java.util.List;

public class Booking {
    public enum BookingStatus{
        PENDING, CONFIRMED, CHECKED_IN, CANCELLED
    }
    private String bookingNumber;
    private long createdOn;
    private BookingStatus status;
    private Show show;
    private List<Seat> seats;
    private Payment payment;

    public Booking(String bookingNumbe, Show show, List<Seat> seats, Payment payment){
        this.bookingNumber=bookingNumber;
        this.createdOn=System.currentTimeMillis();
        this.status=BookingStatus.PENDING;
        this.show=show;
        this.seats=seats;
        this.payment=payment;
    }
    public boolean makePayment(Payment payment){
        return true;
    }
    public boolean cancel(){
        if(status!=BookingStatus.CHECKED_IN){
            status=BookingStatus.CANCELLED;
            return true;
        }
        return false;
    }
    public boolean reserveSeat(Seat seat){
        return seat.book();
    }
    public boolean reserveSeats(List<Seat> requestedSeats){
        for(Seat seat:requestedSeats){
            if(!seat.book()){
                unreserve(seats);
                return false;
            }
        }
        return true;
    }
    private void unreserve(List<Seat> seats){
        for(Seat seat:seats){
            if(!seat.isReserved()){
                return;
            }
            seat.markAsAvailable();
        }
    }
    public boolean confirmBooking(){
        if(status==BookingStatus.PENDING){
            status=BookingStatus.CONFIRMED;
            return true;
        }
        return false;
    }
    public boolean checkIn(){
        if(status==BookingStatus.CONFIRMED){
            status= BookingStatus.CHECKED_IN;
            return true;
        }
        return false;
    }
}
