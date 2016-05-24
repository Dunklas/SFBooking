package server.payment;

import server.utils.storage.StorageException;

public interface PaymentAdapter{
  
  void paymentCheck() throws StorageException;
}
