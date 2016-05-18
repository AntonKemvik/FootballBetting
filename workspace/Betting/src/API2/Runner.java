package API2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class Runner extends Thread implements Runnable {
	ArrayList<URL> list;
	private URL u;

	public Runner(ArrayList<URL> list) {
		this.list = list;
	}

	private synchronized URL listHandler() {
		if (!list.isEmpty()) {
			URL temp = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return temp;
		}
		return null;
	}

	@Override
	public void run() {
		while (true) {
			u = listHandler();
			
			System.out.println(Thread.currentThread().getName());
			if(u == null)
				break;
			
			try {
				String urlString = u.toString();
				String fileName = urlString.substring(urlString.lastIndexOf('/') + 1, urlString.lastIndexOf('.'));
				InputStream in = u.openStream();
				FileOutputStream fos = new FileOutputStream(new File(fileName + ".pdf"));

				// System.out.println("reading file: " + fileName);
				int length = -1;
				byte[] buffer = new byte[1024];

				while ((length = in.read(buffer)) > -1) {
					fos.write(buffer, 0, length);
				}

				fos.close();
				in.close();
				System.out.println(fileName + " was downloaded");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}