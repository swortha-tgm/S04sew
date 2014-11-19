package connection;

public class TestMain {
	public static void main(String[] args) {
		Thread server = new Thread(new ChatServer(6666));
		server.start();
		Thread client = new Thread(new ChatClient("127.0.0.1", 6666));
		client.start();
	}
}
