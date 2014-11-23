package test;

import static org.junit.Assert.assertEquals;
import gui.Controller;
import gui.View;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Assert;
import org.junit.Test;

import connection.ChatClient;
import connection.ChatServer;

/**
 * @author Samuel Schober
 *
 */
public class ChatClientTest {


	@Test
	public void testHostname() throws UnknownHostException, IOException{
		Controller c = new Controller("127.0.0.1", 123);
		View v = new View(c);
		
		ChatServer server = new ChatServer(123, v);
		
		ChatClient chat = new ChatClient("127.0.0.1", 123);
		
		assertEquals("127.0.0.1", chat.getHostName());
	}
	

	@Test
	public void testPort() throws UnknownHostException, IOException{
		Controller c = new Controller("127.0.0.1", 12);
		View v = new View(c);
		
		ChatServer server = new ChatServer(12, v);
		
		ChatClient chat = new ChatClient("127.0.0.1", 12);
		
		assertEquals(12, chat.getPortNumber());
	}
	
	@Test
	public void testError() {
		Controller c = new Controller("127.0.0.1", 32);
		View v = new View(c);
		
		ChatServer server = new ChatServer(32, v);
		
		try {
			ChatClient chat = new ChatClient("127.0.0.1", 32);
		} 
		catch (Exception e) {
	    String expectedMessage = "Exception caught when trying to listen on port 0 or listening for a connection";
	    Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
		} 
	}
	
	@Test
	public void testSendMessage() throws UnknownHostException, IOException{
		Controller c = new Controller("127.0.0.1", 13);
		View v = new View(c);
		
		ChatServer server = new ChatServer(13, v);
		
		ChatClient chat = new ChatClient("127.0.0.1", 13);
		
		chat.sendMessage("test");
		
		assertEquals("test", "test");
	}
}
