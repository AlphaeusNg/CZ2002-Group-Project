import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order implements Serializable {

	private int orderID;
	private LocalDateTime dateTimeOrderCreated;
	private ArrayList<MenuItem> itemsOrdered;
	private Customer customer;
	private Staff orderCreatedBy;
	private Boolean completedStatus;
	private double totalPriceOfOrder;
	private Invoice orderInvoice;
	private int assignedTable;

	public Order() {
		orderID = 9999;
		dateTimeOrderCreated = LocalDateTime.now();
		itemsOrdered = new ArrayList<MenuItem>();
		customer = null;
		orderCreatedBy = null;
		completedStatus = false;
		totalPriceOfOrder = 0;
		orderInvoice = null;
		assignedTable = -1;
	}

	/**
	 *
	 * @param parameter
	 */
	public Order(int parameter) {
		// TODO - implement Order.Order
		throw new UnsupportedOperationException();
	}

	public LocalDateTime getDateTimeOrderCreated() {
		return dateTimeOrderCreated;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Invoice getInvoice() {
		return orderInvoice;
	}
	public void createInvoice(Order order) {
		orderInvoice = new Invoice();
		orderInvoice.setOrder(order);
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID ;
	}
	public int getOrderID() {
		return this.orderID;
	}

	public Boolean isCompleted() {
		return completedStatus;
	}
	public void setOrderAsCompleted() {
		this.completedStatus = true;
	}

	public int getAssignedTable() {
		return assignedTable;
	}

	public void setAssignedTable(int assignedTable) {
		this.assignedTable = assignedTable;
	}
	public Staff getStaff() {
		return orderCreatedBy;
	}

	public ArrayList<MenuItem> getListOfItemsOrdered() {
		return itemsOrdered;
	}

	public void calculatePriceOfOrder() {
		totalPriceOfOrder=0;
		for(int i = 0; i< itemsOrdered.size(); i++) {
			totalPriceOfOrder = totalPriceOfOrder+itemsOrdered.get(i).getPrice();
		}
	}
	public double getTotalPriceOfOrder() {
		calculatePriceOfOrder();
		return totalPriceOfOrder;
	}

	public void addItemToOrder(MenuItem itemToBeAdded) {
		itemsOrdered.add(itemToBeAdded);
	}
	public void removeItemFromOrder(int index) {
		itemsOrdered.remove(index);
	}

	public void setStaff(Staff s) {
		orderCreatedBy = s;
	}


}
