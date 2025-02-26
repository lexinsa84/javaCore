package InterShop.services;

import InterShop.models.Order;

public interface IPurchaseService {
    Order makePurchase(String customerName, String productName, int quantity);
    void processOrders();
    void printSummary();
}
