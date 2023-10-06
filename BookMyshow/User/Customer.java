public class Customer extends Member{
    private List<Booking> currentBookings=new ArrayList<>();
    public Customer(String name, String email, String phone){
        super(name, email, phone);
    }
    public boolean makeBooking(Booking booking){
        return true;
    }
    public List<Booking> getBookings(){
        return currentBookings;
    }
    public boolean cancelBooking(Booking booking){
        return true;
    }
}
