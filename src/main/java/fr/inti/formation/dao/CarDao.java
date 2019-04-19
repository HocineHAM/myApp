package fr.inti.formation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.inti.formation.entity.Car;


public class CarDao {

	public Car ajoutCar(Car car) {
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/cardb";

		String username = "root";
		String password = "root";
		PreparedStatement pste;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
			// System.out.println("Connection established"+connect);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String req = "insert into car(cname,color,speed,Manufactured_Country) values(?,?,?,?)";
		try {
			pste = connect.prepareStatement(req);
			pste.setString(1, car.getCname());
			pste.setString(2, car.getColor());
			pste.setInt(3, car.getSpeed());
			pste.setString(4, car.getMfdctry());
			pste.executeUpdate();
			pste.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Votre voiture est ajoutée");
		return car;
	}

	public void Delete(int id) {
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/cardb";

		String username = "root";
		String password = "root";
		PreparedStatement pste;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
			// System.out.println("Connection established"+connect);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			String req = "delete from car where car_id=?";
			pste = connect.prepareStatement(req);

			pste.setInt(1, id);
			pste.executeUpdate();
			pste.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Car getById(int id) {
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/cardb";

		String username = "root";
		String password = "root";
		PreparedStatement pste;
		Car car = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
			// System.out.println("Connection established"+connect);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			String req = "select cname,color,speed,Manufactured_Country from car where car_id=?";

			pste = connect.prepareStatement(req);

			pste.setInt(1, id);
			ResultSet rs = pste.executeQuery();
			if (rs.next()) {
				car = new Car();
				car.setCid(id);
				car.setCname(rs.getString(1));
				car.setColor(rs.getString(2));
				car.setSpeed(rs.getInt(3));
				car.setMfdctry(rs.getString(4));
			}
			pste.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}
	
	
	public Car Update(Car car) {
		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/cardb";

		String username = "root";
		String password = "root";
		PreparedStatement pste;
		

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
			// System.out.println("Connection established"+connect);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			String req = "update car set cname=?,color=?,speed=?,Manufactured_Country=? where car_id=?";
			pste = connect.prepareStatement(req);
			pste.setString(1, car.getCname());
			pste.setString(2, car.getColor());
			pste.setInt(3, car.getSpeed());
			pste.setString(4, car.getMfdctry());

			pste.setInt(5, car.getCid());
			pste.executeUpdate();
			pste.close();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return car;
	}
	public List<Car> getCars()  {

		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/cardb";

		String username = "root";
		String password = "root";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
			// System.out.println("Connection established"+connect);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Car> cars = new ArrayList<Car>();
		PreparedStatement pstmt;
		try {
			pstmt = connect
					.prepareStatement("select car_id, cname, color, speed, Manufactured_Country from Car");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Car car = new Car();
				car.setCid(rs.getInt("car_id"));
				car.setCname(rs.getString("cname"));
				car.setColor(rs.getString("color"));
				car.setSpeed(rs.getInt("speed"));
				car.setMfdctry(rs.getString("Manufactured_Country"));

				cars.add(car);
//				rs.close();

//				pstmt.close();
//				connect.close();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

		// close resources
	

		return cars;

	}
}
