public class CustomerCareRepresentative extends Member{
    public CustomerCareRepresentative(String id, String name, String email, String phone){
        super(id, name, email, phone);
    }
    public boolean createBooking(Booking booking){
        return true;
    }
}
