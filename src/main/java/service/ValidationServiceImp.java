package service;

import java.math.BigDecimal;

/**
 * Created by gadzik on 08.01.18.
 */
public class ValidationServiceImp implements ValidationService {
    public boolean validateOutgoingMoney(BigDecimal accoutMoney,BigDecimal outGoingMoney) {
        if(accoutMoney.compareTo(outGoingMoney) >= 0){
            return true;
        }
        return false;
    }
}
