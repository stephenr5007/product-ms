package com.infosys.infymarket.ProductMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.infosys.infymarket.product.dto.ProductDTO;
import com.infosys.infymarket.product.dto.SubscribedproductDTO;
import com.infosys.infymarket.product.entity.Product;
import com.infosys.infymarket.product.entity.Subscribedproduct;
import com.infosys.infymarket.product.exception.InfymarketException;
import com.infosys.infymarket.product.repository.ProductRepository;
import com.infosys.infymarket.product.repository.SubscribedproductRepository;
import com.infosys.infymarket.product.service.ProductService;
import com.infosys.infymarket.product.service.SubscribedProdService;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMicroserviceApplicationTests {

//	@Test
//	public void contextLoads() {
//	}

	@Mock
	ProductRepository productrepo;

	@InjectMocks
	ProductService productService = new ProductService();

	@Mock
	SubscribedproductRepository subscribedprodrepo;

	@InjectMocks
	SubscribedProdService subscribedprodService = new SubscribedProdService();

	@Test
	public void productValidTest() throws InfymarketException {
		List<Product> productList = new ArrayList<Product>();

		Product productEntity = new Product();
		productEntity.setProdid("P101");
		productEntity.setProductname("electronics");
		productEntity.setPrice(500.0);
		productEntity.setStock(10000);
		productEntity.setDescription("mobile");
		productEntity.setImage("https://m.media-amazon.com/images/I/41jRzGyDUJL.jpeg");
		productEntity.setSellerid("1");
		productEntity.setCategory("smart phone");
		productEntity.setSubcategory("one plus");
		productEntity.setProductrating(4);

		productList.add(productEntity);

		Mockito.when(productrepo.findAll()).thenReturn(productList);

		List<ProductDTO> reProduct = productService.getAllProduct();

		Assertions.assertEquals(reProduct.isEmpty(), productList.isEmpty());

	}

	@Test
	public void productinvalidtest() throws InfymarketException {
		List<Product> productList = new ArrayList<Product>();

		Product productEntity = new Product();
		productEntity.setProdid("P101");
		productEntity.setProductname("vivo");
		productEntity.setPrice(5000.0);
		productEntity.setStock(5);
		productEntity.setDescription("abc");
		productEntity.setImage("asada");
		productEntity.setSellerid("2");
		productEntity.setCategory("ads");
		productEntity.setSubcategory("ads");
		productEntity.setProductrating(3);

		Optional opt = Optional.of(productEntity);// Valid

		Optional opt1 = Optional.empty();// Invalid

		Mockito.when(productrepo.findById(Mockito.anyString())).thenReturn(opt1);

//	     Mockito.when(productrepo.findAll()).thenReturn(productList);

		List<ProductDTO> reProduct = productService.getAllProduct();
//	          System.out.println(reProduct.get(0));
		Assertions.assertEquals(reProduct.isEmpty(), productList.isEmpty());
	}

	@Test
	public void subscribedprodValidTest() throws InfymarketException {
		List<Subscribedproduct> subscribedprodList = new ArrayList<Subscribedproduct>();

		Subscribedproduct subscribedprodEntity = new Subscribedproduct();
		subscribedprodEntity.setProdid("P101");
		subscribedprodEntity.setBuyerid("electronics");
		subscribedprodEntity.setQuantity(50);

		Optional product1 = Optional.of(subscribedprodEntity);

		subscribedprodList.add(subscribedprodEntity);

		Mockito.when(subscribedprodrepo.findAll()).thenReturn(subscribedprodList);

		List<SubscribedproductDTO> reProduct = subscribedprodService.getAllSubProduct();

		Assertions.assertEquals(reProduct.isEmpty(), subscribedprodList.isEmpty());

	}

	@Test
	public void subscribedprodinValidTest() throws InfymarketException {
		List<Subscribedproduct> subscribedprodList = new ArrayList<Subscribedproduct>();

		Subscribedproduct subscribedprodEntity = new Subscribedproduct();
		subscribedprodEntity.setProdid("P101");
		subscribedprodEntity.setBuyerid("electronics");
		subscribedprodEntity.setQuantity(50);

//	     Optional opt1=Optional.empty();  
		Optional opt = Optional.of(subscribedprodEntity);// Valid

		Optional opt1 = Optional.empty();// Invalid

		Mockito.when(subscribedprodrepo.findById(Mockito.anyString())).thenReturn(opt1);

//	Mockito.when(subscribedprodrepo.findAll()).thenReturn(opt1);

		List<SubscribedproductDTO> reProduct = subscribedprodService.getAllSubProduct();

		Assertions.assertEquals(reProduct.isEmpty(), subscribedprodList.isEmpty());

	}

}

