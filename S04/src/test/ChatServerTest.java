package test;

import static org.junit.Assert.*;
import gui.Controller;
import gui.View;

import org.junit.Test;

import connection.ChatServer;

public class ChatServerTest {
	
	private final Controller c = new Controller("127.0.0.1", 1234);
	private final View v = new View(c);
	
	@Test
	public void testPortNumber() {
		ChatServer server = new ChatServer(1234, v);
		
		assertEquals(1234, server.getPortNumber());
	}

}
