package repository;

import exception.NoGateFoundException;
import model.Bill;
import model.Gate;
import model.Ticket;

import java.util.Map;
import java.util.Optional;

public class BillRepo {
    private long lastSavedId;
    private Map<Long, Bill> billMap;

    public Bill save(Bill bill){
        lastSavedId++;
        bill.setId(lastSavedId);
        billMap.put(lastSavedId,bill);
        return bill;
    }


    public Optional<Bill> getBillByNumber(String  billNo){
        if (!billMap.isEmpty()) {
            for (Bill bill : billMap.values()){
                if (bill.getBillNo().equals(billNo)){
                    return Optional.of(bill);
                }
            }
        }
        return Optional.empty();
    }
}
