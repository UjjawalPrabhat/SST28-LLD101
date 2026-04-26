import java.util.Map;

public class Calculator {
    private final Map<AddOn, AddOnDetails> addOnMap;
    private final Map<Integer, RoomDetails> roomMap;

    public Calculator(Map<AddOn, AddOnDetails> addOnMap, Map<Integer, RoomDetails> roomMap) {
        this.addOnMap = addOnMap;
        this.roomMap = roomMap;
    }

    public Money calculateMonthly(BookingRequest req) {
        double base = 0.0;
        if (roomMap.containsKey(req.roomType))
            base = roomMap.get(req.roomType).getRoomBasePrice();
        else
            base = 16000.0;

        double add = 0.0;
        for (AddOn a : req.addOns) {
            if (addOnMap.containsKey(a))
                add += addOnMap.get(a).getAddOnPrice();
        }
        return new Money(base + add);
    }
}