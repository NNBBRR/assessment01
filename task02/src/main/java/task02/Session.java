package task02;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;

public class Session {

	private Socket sock;
	private OutputStream os;
	private ObjectOutputStream oos;
	private InputStream is;
	private ObjectInputStream ois;

	public Session(Socket sock) {
		this.sock = sock;
	}

	public float start() throws IOException {

		initializeStreams(sock);

		String request = read();

		// Split request into 2 groups
		String[] terms = request.split(" ", 2);

		String reqID = terms[0];
		String num = (terms[1]).replaceAll("," ," ");

		Integer numberTerms = Integer.parseInt(num);

		LinkedList<Integer> numList = new LinkedList<Integer>();
		numList.add(numberTerms);

		// Calculate the average of terms
		float total = 0f;
		for (int i = 0; i < numList.size(); i++) {
			total += numList.get(i);
		}

		Float avg = total / numList.size();
		return avg;

		// Write

		write(reqID);
		write("Ng Bing Rong");
		write("ngbingrong@gmail.com");
		oos.writeFloat((float) avg);

		if (ois.readBoolean() != true) {
			System.out.println(read());
			System.out.println("FAILED/n");
			System.err.println("There is an error.");

		} else {
			System.out.println("SUCCESS/n");
			// oos.writeUTF("SUCCESS");
		}

		try {
			close();
		} catch (IOException e) {
		}

	}

	private String read() throws IOException {
		return ois.readUTF();
	}

	private void write(String output) throws IOException {
		oos.writeUTF(output);
		oos.flush();
	}

	private void initializeStreams(Socket sock)
			throws IOException {
		os = sock.getOutputStream();
		oos = new ObjectOutputStream(os);
		is = sock.getInputStream();
		ois = new ObjectInputStream(is);
	}

	private void close() throws IOException, NumberFormatException {
		is.close();
		os.close();
	}
}
