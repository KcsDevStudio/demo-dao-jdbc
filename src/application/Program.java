package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: Seller findById ===");
		Seller seller = sellerDao.finById(2);
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2: Seller findByDepartment ===");
		Department department = new  Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=== TESTE 3: Seller findByAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=== TESTE 4: Seller insert ===");
		Seller newSeller = new Seller(null, "Greg" , "greg@gmail.com", new Date() , 4000.0 , department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted new id = " + newSeller.getId());
		System.out.println("\n=== TESTE 5: Seller Update ===");
		seller =sellerDao.finById(1);
		seller.setName("Martha Whine");
		sellerDao.update(seller);
		System.out.println("Update completed.");
		System.out.println("\n=== TESTE 6: Seller delete ===");
		System.out.println("Enter id for delete teste:");
		int id = sc.nextInt();
		sellerDao.deleteByID(id);
		System.out.println("Delete completed");
		
		sc.close();
		
	}
}
