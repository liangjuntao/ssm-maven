package example.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MyProxy {
	private static final Logger log = LogManager.getLogger(MyProxy.class);
	public static void main(String[] args) throws IOException {
		//localhost proxy
		ServerSocket serverSocket = new ServerSocket(8888);
		while(true){
			try {
				Socket socket = serverSocket.accept();
				String address = socket.getRemoteSocketAddress().toString();
				log.info("地址是:" + address);
				//浏览器输入流
				InputStream ci = socket.getInputStream();
				//浏览器输出流
				OutputStream co = socket.getOutputStream();
				//读取流获取将要访问的远程服务器ip和端口
				String host = "" ;
				int port =  0 ;
				
				
				//获取版本号,socket协议中第一个字节表示版本号
//				byte[] tmp = new byte[1];
				//从流中读取数据，并存入缓冲区。
//				int b = a_in.read(tmp);
				//从流中读取一个字节
				int b = ci.read();
				char c = (char) b;
				log.info(c);
				
				//创建本地代理socket，和远程服务器做通信
//			Socket proxy_socket = new Socket(host, port);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				serverSocket.close();
			}
		}
	}

}
