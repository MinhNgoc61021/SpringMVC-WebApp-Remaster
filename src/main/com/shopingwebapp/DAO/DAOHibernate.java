package main.com.shopingwebapp.DAO;

import main.com.entity.product.Product;
import main.com.entity.product.ProductType;
import main.com.entity.user.User;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public interface DAOHibernate {
    //The SessionFactory is a factory of session and client of ConnectionProvider. It holds second level cache (optional) of data. The org.hibernate.SessionFactory interface provides factory method to get the object of Session.

    //Get user account
    public User getAccount(String Username, String Password);

    //Create new account from form
    public boolean Create_New_Account(String Create_Username, String Create_Password, String Fullname, String Address, String Phone, String Gender, String BirthDate, String Email);

    //Store User review about product into db
    public void Review_Create(int UserID, int ProductID, String review_cmt, double rating);

    //Store User reply about product into db
    public void Reply_Create(int Uid, int PostID, String Reply);

    //Create Like by UserID and PostID
    public boolean Like_Create(int userID, int postID);

    //unlike by UserID and PostID
    public boolean Remove_Like(int userID, int postID);

    public long Get_Like_Count(int postID);

    //Get total like number
    public long Get_Total_Rating(int ProductID);

    //Get rating percentage for progress bar
    public HashMap<String, Long> Get_Total_Rating_by_Type(int ProductID);

    //Product access by user using id
    public Product product_access(int ProductID);

    //Get producttype by ID
    public ProductType get_ProductType_by_ID(int ID);

    //Get productlist by sorting type and option
    public List<Product> get_Product_List(String type, String sort_option);

    public List<Product> Product_Search(String search, int typeid);

    public int ProductQuantity_In_Cart(int ProductID, int UserID);

    public void Preorder_Product(int ProductID, int UserID);

    public void Add_More_To_Quantity(int ProductID, int UserID);

    public void Quantity_Adjust(int ProductID, int UserID, int New_Quantity);

    public void Remove_Preorder(int UserID);

    public void Remove_Product_From_Preorder(int UserID, int ProductID);

    public void InStock_Decrease(int ProductID, int Quantity);

    public boolean Complete_Order(String orderDate, String requiredDate, int UserID, String note, String comments, String status, long payment, String paymentMethod);

    public boolean Set_Order_Details(int ProductID, Long Price, int Quantity);
}
