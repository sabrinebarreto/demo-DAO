package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDAO sellerDAO = DAOFactory.createSellerDao();
		
		System.out.println(" === TEST 1: seller findById ===");
		Seller seller = sellerDAO.findById(1);
		System.out.println(seller);
		
		System.out.println("\n === TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TEST 3: seller findAll ===");
		list = sellerDAO.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDAO.insert(newSeller);
		System.out.println("Inserted! New ID: " + newSeller.getId());
		
		
		System.out.println("\n === TEST 5: seller insert ===");
		seller = sellerDAO.findById(1);
		seller.setName("Martha Waine");
		sellerDAO.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n === TEST 6: seller delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDAO.deleteById(id);
		System.out.println("Delete completed");
		
		DepartmentDAO departmentDao = DAOFactory.createDepartmentDao();

		System.out.println("=== TEST 1: findById =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: findAll =======");
		List<Department> list1 = departmentDao.findAll();
		for (Department d : list1) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: insert =======");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());

		System.out.println("\n=== TEST 4: update =======");
		dep = departmentDao.findById(6);
		dep.setName("Home");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id1 = sc.nextInt();
		departmentDao.deleteById(id1);
		System.out.println("Delete completed");
		
		sc.close();
		
		
	}	
}
