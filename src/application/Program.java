package application;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDAO sellerDAO = DAOFactory.createSellerDao();
		
		System.out.println(" === TEST 1: seller findById ===");
		
		Seller seller = sellerDAO.findById(1);
		System.out.println(seller);
		
		
	}	
}
