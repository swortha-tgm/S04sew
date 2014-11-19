package connection;

public class TestMain {
	public static void main(String[] args) {
		Thread server = new Thread(new ChatServer(6666));
		server.start();
		Thread client = new Thread(new ChatClient("10.0.105.227", 6666));
		client.start();
	}
}
