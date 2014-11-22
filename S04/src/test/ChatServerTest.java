package test;

import static org.junit.Assert.*;

import java.io.IOException;

import gui.Controller;
import gui.View;

import org.junit.Test;

import connection.ChatServer;

public class ChatServerTest {
	
	@Test
	public void testPortNumber() throws IOException{
		Controller c = new Controller("127.0.0.1", 1234);
		View v = new View(c);
		
		ChatServer server = new ChatServer(1234, v);
		
		assertEquals(1234, server.getPortNumber());
	}
	
	@Test
	public void testError() throws IllegalArgumentException, IOException{
		Controller c2 = new Controller("localhost", 0);
		View v2 = new View(c2);
		
		ChatServer server = new ChatServer(0, v2);
		
		assertEquals(0, server.getPortNumber());
	}

}
