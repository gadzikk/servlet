package service;

import db.Parameters;
import model.Transfer;

import java.util.List;


/**
 * Created by gadzik on 07.01.18.
 */
public interface TransferService {
    void outgoingTransfer(Parameters params);
    void incomingTransfer(Parameters params);
    void saveTransfer(Parameters params);
    List<Transfer> getByAccountWithPagination(Parameters params);
    int countByAccount(Parameters params);
}
