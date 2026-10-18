# Assignment 4 — Facade Pattern
- **Name:** Medina Alish
- **Group:** SE-2538
- **Topic:** B — Online Order Processing Facade

## Role Map
| Role | Class | Source |
|---|---|---|
| Facade | OrderFacade | src/OrderFacade.java |
| Subsystem 1 | InventoryService | src/subsystem/InventoryService.java |
| Subsystem 2 | PaymentProcessor | src/subsystem/PaymentProcessor.java |
| Subsystem 3 | ShippingService | src/subsystem/ShippingService.java |
| Subsystem 4 | NotificationService | src/subsystem/NotificationService.java |
| Model | Cart | src/model/Cart.java |
| Model | Customer | src/model/Customer.java |
| Model | Order | src/model/Order.java |
| Client | Main | src/Main.java |

## Key Locations
- **Orchestration:** `OrderFacade.placeOrder(Cart, Customer)` — coordinates the exact sequence of checking stock, charging payment, scheduling shipping, and sending confirmation.
- **Rollback Logic:** `OrderFacade.placeOrder` — if `payment.charge()` returns `false`, the Facade catches the failure and calls `inventory.releaseStock()` before throwing an `IllegalStateException`.
- **Subsystem Encapsulation:** All subsystem classes are instantiated privately inside `OrderFacade` (`private final InventoryService inventory;`). The Client (`Main.java`) has zero imports from the `subsystem` package.
- **T1–T2 Demo Check:** `Main.main()` — T1 verifies a successful order (passes through all 4 subsystems). T2 verifies a failed payment on an expensive item to trigger and prove the rollback mechanism works.

## Build & Run
1. Ensure you have **Java JDK 17** (or higher) installed.
2. Open the project in **IntelliJ IDEA** (or your preferred IDE).
3. Navigate to `src/Main.java`.
4. Run the `main` method.

## Expected Results (T1–T2)

    [Inventory] Checking stock for BOOK-67
    [Inventory] Reserved 2 x BOOK-67
    [Payment] Charging $30.0
    [Shipping] Scheduled 2 x BOOK-67 to aruzhan@mail.com (TRK-1792341739338)
    [Facade] Shipment tracking ID: TRK-1792341739338
    [Notify] Confirmation sent to aruzhan@mail.com for order ORD-1792341739348
    Order placed: ORD-1792341739348

    T1 PASS | Place Order | Order successfully orchestrated through 4 subsystems

    [Inventory] Checking stock for TV-67
    [Inventory] Reserved 1 x TV-67
    [Payment] Charging $99999.0
    [Inventory] Released 1 x TV-67
    Error! Payment declined (stock was released)

    T2 PASS | Rollback on Failure | Inventory released after payment declined
    SUMMARY: 2/2 PASS
