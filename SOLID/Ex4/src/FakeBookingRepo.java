public interface FakeBookingRepo {
    public void save(String id, BookingRequest req, Money monthly, Money deposit);
    
}
