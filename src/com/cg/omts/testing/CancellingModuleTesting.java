package com.cg.omts.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.CancellingServiceImpl;
import com.cg.omts.service.ICancellingService;

public class CancellingModuleTesting {
	ICancellingService cancellingService = new CancellingServiceImpl();

	@Test
	public void deleteBookingDetailsTest() throws OMTSException {
		try {
			int ticketId = 1;

			int isDeleted = cancellingService.deleteBookingDetails(ticketId);
			assertTrue(isDeleted > 0);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void getSeatsByTicketTest() throws OMTSException {
		try {
			int ticketId = 1;
			List<Integer> expectedSeatsList = new ArrayList<Integer>();
			expectedSeatsList.add(1);
			expectedSeatsList.add(2);
			expectedSeatsList.add(3);
			expectedSeatsList.add(4);

			List<Integer> actualSeatsList = cancellingService.getSeatsByTicket(ticketId);
			assertEquals(expectedSeatsList, actualSeatsList);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void deleteAllocatedSeatsTest() throws OMTSException {
		try {
			int ticketId = 1;

			int isDeleted = cancellingService.deleteAllocatedSeats(ticketId);
			assertTrue(isDeleted > 0);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void deleteSeatDetailsTest() throws OMTSException {
		try {
			List<Integer> seatsList = new ArrayList<Integer>();
			seatsList.add(1);
			seatsList.add(2);
			seatsList.add(3);
			seatsList.add(4);

			int isDeleted = cancellingService.deleteSeatDetails(seatsList);
			assertTrue(isDeleted > 0);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void getTransactionDetailsTest() throws OMTSException {
		try {
			int ticketId = 1;
//Transaction actualTransaction = new Transaction(1, 123456, 900);

			Transaction expectedTransaction = cancellingService.getTransactionDetails(ticketId);
			assertNotNull(expectedTransaction);

		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void deleteTransactionTest() throws OMTSException {
		try {
			int ticketId = 1;

			int isDeleted = cancellingService.deleteTransaction(ticketId);
			System.out.println(isDeleted);
			assertTrue(isDeleted > 0);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void cancelTicketTest() throws OMTSException {
		try {
			int ticketId = 1;

			int isCancelled = cancellingService.cancelTicket(ticketId);
			assertTrue(isCancelled > 0);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void deleteTicketFromUser() throws OMTSException {
		try {
			int ticketId = 1;
			int isDeleted = cancellingService.deleteTicketFromUser(ticketId);
			assertTrue(isDeleted > 0);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}

	@Test
	public void refundAfterCancellation() throws OMTSException {
		try {
			Transaction transaction = new Transaction(5002, 6474822, 567);
			int currentBalance = 675;
			int validate = cancellingService.refundAfterCancellation(transaction, currentBalance);
			assertTrue(validate > 0);
		} catch (OMTSException e) {
			throw new OMTSException("Exception in testing");
		}
	}
}