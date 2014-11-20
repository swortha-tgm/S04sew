package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import connection.ChatClient;

public class ChatClientTest {

	@Test
	public void test() {
		ChatClient chat = new ChatClient(null, 0);
		
		assertEquals(1, chat);
	}

}
