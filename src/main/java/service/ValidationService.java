package service;

import java.math.BigDecimal;

/**
 * Created by gadzik on 08.01.18.
 */
public interface ValidationService {
    boolean validateOutgoingMoney(BigDecimal accoutMoney, BigDecimal outGoingMoney);
}
