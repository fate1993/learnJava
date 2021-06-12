package day0604;

import java.sql.*;
import java.util.*;

public final class ConnectionPool {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	} // static 블록으로 드라이버 로딩(Class.forName)

	// 사용하지 않은 커넥션 즉, 초기 커넥션을 저장하는 변수
	private ArrayList<Connection> free;

	// 사용 중인 커넥션을 저장하는 변수
	private ArrayList<Connection> used;

	private String url;
	private String user;
	private String password;

	// 초기 커넥션수
	private int initialCons = 0;

	// 최대 커넥션수
	private int maxCons = 0;

	// 총 커넥션수
	private int numCons = 0;
	private static ConnectionPool cp;

	// ConnectionPool 객체 리턴. 주소값 반환. 
	// 객체는 한번만 만들고 여러군데서 객체를 사용할 수 있게함(싱글톤 패턴)
	public static ConnectionPool getInstance(String url, String user, String password, int initialCons, int maxCons) {
		try {
			if (cp == null) {
				synchronized (ConnectionPool.class) {
					cp = new ConnectionPool(url, user,

							password, initialCons, maxCons);
					// null인 경우 현재 클래스를 객체로 만들어놓음(처음 호출했을 때)
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return cp;	// 커넥션 풀 주소값 리턴						
	}			

	// 생성자로 인스턴스 변수 초기화. private으로 외부에서 접근 못함. 대신 static 통해서 return
	private ConnectionPool(String url, String user, String password, int initialCons, int maxCons) throws SQLException {
		
		this.url = url;
		this.user = user;
		this.password = password;
		this.initialCons = initialCons;
		this.maxCons = maxCons;

		if (initialCons < 0) // 잘못된 값인 음수 전달될 경우
			initialCons = 5;
		if (maxCons < 0) // 잘못된 값인 음수 전달될 경우
			maxCons = 10; 

		/*
		 * 초기 커넥션 개수를 각각의 ArrayList에 저장할 수 있도록 초기 커넥션 수만큼 ArrayList를 생성한다.
		 */
		free = new ArrayList<Connection>(initialCons);
		used = new ArrayList<Connection>(initialCons);

		// initialCons 수만큼 Connection을 생성(free)한다.
		while (numCons < initialCons) {

			addConnection(); // 연결, 추가 반복
		}
	}

	// free에 커넥션 객체를 저장한다.
	private void addConnection() throws SQLException {
		free.add(getNewConnection());
	}

	// 새로운 커넥션 객체를 생성한다.
	private Connection getNewConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("About to connect to " + con);
		// 컨넥션 생성될 때마다 숫자가 증가한다.
		++numCons;
		return con;
	}

	/*
	 * free에 있는 커넥션을 used로 옮기는 작업 => free--->used
	 */
	public synchronized Connection getConnection() throws SQLException {
		/*
		 * 동기화 처리 >> 다른 스레드가 동작하고 있으면 잠시 정지
		 * free에 Connection이 없으면 maxCons만큼 Connection을 더 생성한다.
		 */
		if (free.isEmpty()) {
			// 모든 커넥션을 이미 사용하고 있는 경우
			while (numCons < maxCons) {
				addConnection();
			} // 커넥션된 숫자가 최대로 커넥션된 숫자보다 작을 때까지 계속 커넥션을 증가
		}
		Connection _con; 
		_con = free.get(free.size() - 1); 
		// 사용하고 있지 않은 get(index)
		// size -1 >> 마지막 인덱스 값
		free.remove(_con);
		used.add(_con);
		return _con;
	}

	/*
	 * used에 있는 커넥션을 free로 반납한다.
	 */
	public synchronized void releaseConnection(Connection _con) throws SQLException {
		boolean flag = false;
		if (used.contains(_con)) {
			used.remove(_con);
			numCons--;
			flag = true;
		} else {
			throw new SQLException("ConnectionPool" + "에 있지않네요!!");
		}
		try {
			if (flag) {
				free.add(_con);
				numCons++;
			} else {
				_con.close();
			}

		} catch (SQLException e) {

			try {
				_con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	// 모든 Connection 자원을 반납한다.
	public void closeAll() {
		// used에 있는 커넥션을 모두 삭제한다.
		for (int i = 0; i < used.size(); i++) {
			Connection _con = (Connection) used.get(i);
			used.remove(i--);
			try {
				_con.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}

		// free에 있는 커넥션을 모두 삭제한다.
		for (int i = 0; i < free.size(); i++) {
			Connection _con = (Connection) free.get(i);
			free.remove(i--);
			try {
				_con.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	public int getMaxCons() {
		return maxCons;
	}

	public int getNumCons() {

		return numCons;
	}
}