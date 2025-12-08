Fucnitonal Requirements
Each user should be able to create account..
Support trading of multiple Stcoks..
allow user to place Limit Orders, markert ( Buy or Sell) 
cancel order

User should be Notified about Updates in the order..
User can subscribe to Stock for price updates.. and receive Notifications.. 
Before placing order, system should check funds and validate order..

Non Functional Requirements:
Concurrency: system is thread safe..cfro concurrent requests..
MOdular 
Extensible


THe Core Enitites: 
User
Account
Stock
Order
OrderType: Enum
OrderStatus: ENUM
StockExchangeSystem : centralised system : Singleton
StockExchangeService: which will all calls : Singleton
Notification: Observer

State : to mamange the order lifecycle

