import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final Calculator calculator;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;

        Map<AddOn, AddOnDetails> addOnMap = new HashMap<>();
        addOnMap.put(AddOn.MESS, new MessAddOn());
        addOnMap.put(AddOn.LAUNDRY, new LaundaryAddOn());
        addOnMap.put(AddOn.GYM, new GymAddOn());

        Map<Integer, RoomDetails> roomMap = new HashMap<>();
        roomMap.put(LegacyRoomTypes.SINGLE, new SingleRoomDetails());
        roomMap.put(LegacyRoomTypes.DOUBLE, new DoubleRoomDetails());
        roomMap.put(LegacyRoomTypes.TRIPLE, new TripleRoomDetails());

        this.calculator = new Calculator(addOnMap, roomMap);
    }

    public void process(BookingRequest req) {
        Money monthly = calculator.calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = BookingIdGenerator.genBookingId();
        repo.save(bookingId, req, monthly, deposit);
    }
}
