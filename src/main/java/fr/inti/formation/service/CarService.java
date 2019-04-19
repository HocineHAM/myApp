package fr.inti.formation.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.inti.formation.dao.CarDao;
import fr.inti.formation.entity.Car;

@Path("/car")
public class CarService {

	private CarDao dao = new CarDao();

	public CarDao getDao() {
		return dao;
	}

	public void setDao(CarDao dao) {
		this.dao = dao;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	
	public List<Car> getAll() {
		
		List<Car>cars=dao.getCars();
		
		

		return cars;

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car getById(@PathParam("id") int id) {

		return dao.getById(id);

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Car addCar(Car car) {

		return dao.ajoutCar(car);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Car UpdateCar(Car car) {

		return dao.Update(car);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCar(@PathParam("id") int id) {

		dao.Delete(id);
	}

}
