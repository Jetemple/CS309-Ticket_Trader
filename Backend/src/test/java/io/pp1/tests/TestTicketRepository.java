package io.pp1.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.pp1.tickets.Ticket;
import io.pp1.tickets.TicketController;
import io.pp1.tickets.TicketRepository;
import io.pp1.tickets.TicketService;

public class TestTicketRepository {

//	@InjectMocks
//	TicketController ticketController;
//	
//
//
//	@Mock
//	TicketRepository repo;
//
//	@Before
//	public void init() {
//		MockitoAnnotations.initMocks(this);
//	}
//	
//	@Test
//	public void findAllTest() {
//		List<Ticket> list = new ArrayList<Ticket>();
//		
//		Ticket acctOne = new Ticket(1, "SportTest", "LocationTest", "DateTest", "TimeTest", 1, 11, "Baylor");
//		Ticket acctTwo = new Ticket(2, "SportTest2", "LocationTest2", "DateTest2", "TimeTest2", 2, 22, "ISU");
//		
//		
//		list.add(acctOne);
//		list.add(acctTwo);
//		
//		
//		
//	//when(repo.getTicketByID(1)).thenReturn(new TicketService Ticket(1, "SportTest", "LocationTest", "DateTest", "TimeTest", 0, 99, "Baylor"));
//	
//
//	when(repo.findAll()).thenReturn(list);
//
////	List<Ticket> acctList = (List<Ticket>) ticketController.getAll();
//
//	assertEquals(2, list.size());
//	assertEquals(list.get(1).getSport(), "SportTest2");
//	assertEquals(list.get(0).getGame_date(), "DateTest");
//	assertEquals(list.get(1).getGame_location(), "LocationTest2");
//	assertEquals(list.get(0).getGame_time(), "TimeTest");
//	}
//	
//	@Test
//	public void  getTicketByID() {
//		List<Ticket> list = new ArrayList<Ticket>();
//		
////		Ticket acctOne = new Ticket(1, "SportTest", "LocationTest", "DateTest", "TimeTest", 1, 11, "Baylor");
////		Ticket acctTwo = new Ticket(9, "SportTest2", "LocationTest2", "DateTest2", "TimeTest2", 2, 22, "ISU");
//		
//		
//		list.add(acctOne);
//		list.add(acctTwo);
//		
//		when(repo.getTicketByID(10)).thenReturn(list);
//		 
//		List<Ticket> test = repo.getTicketByID(10);
//		assertEquals("SportTest", test.get(0).getSport());
//		
////		when(repo.getTicketByID(2)).thenReturn(list);
////		 
////		List<Ticket> test2 = repo.getTicketByID(2);
////		assertEquals("SportTest2", test2.get(1).getSport());
//		
//	}
}














