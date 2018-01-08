package service;

import java.math.BigDecimal;

/**
 * Created by gadzik on 08.01.18.
 */
public interface OperationService {
    void saveOperation(Long accountId, String type, BigDecimal money);
}
