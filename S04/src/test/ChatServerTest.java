package test;

import static org.junit.Assert.*;
import gui.Controller;
import gui.View;

import org.junit.Test;

import connection.ChatServer;

public class ChatServerTest {
	
	private final Controller c = new Controller(null, 0);
	private final View v = new View(c);
	
	@Test
	public void testPortNumber() {
		ChatServer server = new ChatServer(0, v);
		
		assertEquals(0, server.getPortNumber());
	}

}
