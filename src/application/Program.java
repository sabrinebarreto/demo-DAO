package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
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
		
		
	}	
}
