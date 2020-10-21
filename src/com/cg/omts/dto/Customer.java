package com.cg.omts.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Customer {
		private int customerId;
		private String customerName;
		private String customerPassword;
		private Date dateOfBirth;
		private List<Ticket> myTickets;
		private String customerContact;
		private String roleCode;
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Customer(int customerId, String customerName, String customerPassword, Date dateOfBirth,
				String customerContact, String roleCode) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.customerPassword = customerPassword;
			this.dateOfBirth = dateOfBirth;
			this.customerContact = customerContact;
			this.roleCode = roleCode;
		}

		public Customer(int customerId, String customerName, String customerPassword, Date dateOfBirth,
				List<Ticket> myTickets, String customerContact, String roleCode) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.customerPassword = customerPassword;
			this.dateOfBirth = dateOfBirth;
			this.myTickets = myTickets;
			this.customerContact = customerContact;
			this.roleCode = roleCode;
		}

		public Customer(int customerId, String customerPassword) {
			super();
			this.customerId = customerId;
			this.customerPassword = customerPassword;
		}
		
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getCustomerPassword() {
			return customerPassword;
		}
		public void setCustomerPassword(String customerPassword) {
			this.customerPassword = customerPassword;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public List<Ticket> getMyTickets() {
			return myTickets;
		}
		public void setMyTickets(List<Ticket> myTickets) {
			this.myTickets = myTickets;
		}
		public String getCustomerContact() {
			return customerContact;
		}
		public void setCustomerContact(String customerContact) {
			this.customerContact = customerContact;
		}
		public String getRoleCode() {
			return roleCode;
		}
		public void setRoleCode(String roleCode) {
			this.roleCode = roleCode;
		}

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
					+ customerPassword + ", dateOfBirth=" + dateOfBirth + ", myTickets=" + myTickets
					+ ", customerContact=" + customerContact + ", roleCode=" + roleCode + "]";
		}
		
		
}
