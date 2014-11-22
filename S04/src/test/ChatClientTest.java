package test;

import static org.junit.Assert.*;
import gui.Controller;
import gui.View;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import connection.ChatClient;
import connection.ChatServer;

/**
 * @author Samuel Schober
 *
 */
public class ChatClientTest {


	@Test
	public void testHostname() throws UnknownHostException, IOException{
		Controller c = new Controller("127.0.0.1", 1234);
		View v = new View(c);
		
		ChatServer server = new ChatServer(1234, v);
		
		ChatClient chat = new ChatClient("127.0.0.1", 1234);
		
		assertEquals("127.0.0.1", chat.getHostName());
	}
	

	@Test
	public void testPort() throws UnknownHostException, IOException{
		Controller c = new Controller("127.0.0.1", 1234);
		View v = new View(c);
		
		ChatServer server = new ChatServer(1234, v);
		
		ChatClient chat = new ChatClient("127.0.0.1", 1234);
		
		assertEquals(1234, chat.getPortNumber());
	}
	
	
}
