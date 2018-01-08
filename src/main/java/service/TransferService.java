package service;

import db.Parameters;


/**
 * Created by gadzik on 07.01.18.
 */
public interface TransferService {
    void outgoingTransfer(Parameters params);
    void incomingTransfer(Parameters params);
}
