package example.proxy.httpProxy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class proxyd {

	public static void main(String[] args) {
			int port = 8888;
			ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(port);
				System.out.println("The proxy have start on port:" + port + "\n");
//				while (true) {
					Socket socket = null;
					try {
						System.out.println("我已经进入阻塞状态");
						socket = serverSocket.accept();
						new HttpProxyMainThread(socket).start();
						System.out.println("已经建立一个连接");
					} catch (Exception e) {
						System.out.println("Thread start fail");
					}
//				}
			} catch (IOException e1) {
				System.out.println("proxyd start fail\n");
			}finally{
				try {
					serverSocket.close();
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}
		}
	}
	