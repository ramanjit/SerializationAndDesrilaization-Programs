package com.ramanjit.io.examples;

import java.io.Serializable;

public class Customer implements Serializable {
	private String customerId;
	private String customerName;
	private transient String customerPassword; // It will not be visible in
												// data.txt file
	private long customerPinCode;
	private String customerCity;

	/**
	 * @param customerId
	 * @param customerName
	 * @param customerPassword
	 * @param customerPinCode
	 * @param customerCity
	 */
	public Customer(String customerId, String customerName, String customerPassword, long customerPinCode,
			String customerCity) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerPinCode = customerPinCode;
		this.customerCity = customerCity;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", customerPinCode=" + customerPinCode + ", customerCity=" + customerCity + "]";
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public long getCustomerPinCode() {
		return customerPinCode;
	}

	public String getCustomerCity() {
		return customerCity;
	}

}
