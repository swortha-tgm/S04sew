package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import connection.ChatClient;

/**
 * @author Samuel Schober
 *
 */
public class ChatClientTest {

	/**
	 * 
	 */
	@Test (expected = java.io.IOException.class)
	public void testHostname() {
		ChatClient chat = new ChatClient(null, 0);
		
		assertEquals("null", chat.getHostName());
	}
	

	@Test (expected = java.io.IOException.class)
	public void testPort() {
		ChatClient chat = new ChatClient(null, 0);
		
		assertEquals("0", chat.getPortNumber());
	}
	
}
