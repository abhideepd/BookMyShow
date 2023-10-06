public class FrontDeskAssistant extends Member{
    public FrontDeskAssistant(String id, String name, String email, String phone){
        super(id, name, email, phone);
    }
    public boolean createBookingAndIssueTicket(Booking booking){
        return true;
    }
    public boolean checkIn(Booking booking){
        return booking.checkIn();
    }
}
