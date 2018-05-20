package Model;

import Integration.SaleDTO;

/**
 * A observer interface used to construct observers in the system
 */
public interface Observer {
   void updateObserver(SaleDTO saleDTO);
}
