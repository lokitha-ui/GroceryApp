class Product
{
// properties
private String id;
private String pname;
private int qty;
private double price;
private double totalPrice;
// constructor
Product(String id, String pname, int qty, double price, double totalPrice)
{
this.id=id;
this.pname = pname;
this.qty = qty;
this.price = price;
this.totalPrice = totalPrice;
}
// getter methods
public String getId()
{
return id;
}
public String getPname()
{
return pname;
}
public int getQty()
{
return qty;
}
public double getPrice()
{
return price;
}
public double getTotalPrice()
{
return totalPrice;
}
//displayFormat
public static void displayFormat()
{
System.out.format("---------------------------------------------------------------------------------
--------------------------------------------------");
System.out.print("\nProduct ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal
Price\n");
System.out.format("---------------------------------------------------------------------------------
--------------------------------------------------\n");
}
// display
public void display()
{
System.out.format(" %-9s %-9s %5d %9.2f
%14.2f\n" ,id, pname, qty, price, totalPrice);
}
}
Coding For the Shopping Bill (Grocery)
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
public class ShoppingBill
{
public static void main(String args[])
{
// variables
String id = null;
String productName = null;
int quantity = 0;
double price = 0.0;
double totalPrice = 0.0;
double overAllPrice = 0.0;
double cgst, sgst, subtotal=0.0, discount=0.0;
char choice = '\0';
System.out.println("\t\t\t\t--------------------Invoice-----------------");
System.out.println("\t\t\t\t\t "+" "+"Fast N Fresh Grocery App");
System.out.println("\t\t\t\t\t4/12 Summer street,Wolfville,Nova scotia");
System.out.println("\t\t\t\t\t" +" " +" Canada ");
System.out.println("GSTIN: 03AWBPP8756K592"+"\t\t\t\t\t\t\tContact:
(+902) 9988776655232");
//format of date and time
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy
HH:mm:ss");
Date date = new Date();
Calendar calendar = Calendar.getInstance();
String[] days = new String[] { "Sunday", "Monday", "Tuesday",
"Wednesday", "Thursday", "Friday", "Saturday" };
//prints current date and time
System.out.println("Date: "+formatter.format(date)+"
"+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t (902)
999888777032");
Scanner scan = new Scanner(System.in);
System.out.print("Enter Customer Name: ");
String customername=scan.nextLine();
//create Scanner class object
//creating an ArrayList to store the product
List<Product> product = new ArrayList<Product>();
do
{
// read input values
System.out.println("Enter the product details: ");
System.out.print("Product ID: ");
id = scan.nextLine();
System.out.print("product Name: ");
productName = scan.nextLine();
System.out.print("Quantity: ");
quantity = scan.nextInt();
System.out.print("Price (per unit): ");
price = scan.nextDouble();
//calculate total price for a particular product
totalPrice = price * quantity;
//calculates overall price
overAllPrice = overAllPrice + totalPrice;
//creates Product class object and add it to the List
product.add( new Product(id, productName, quantity, price,
totalPrice) );
// ask for continue shopping?
System.out.print("Want to add more items? (y or n): ");
//reads a character Y or N
choice = scan.next().charAt(0);
//read remaining characters, don't store (no use)
scan.nextLine();
}
while (choice == 'y' || choice == 'Y');
//display all product with its properties
Product.displayFormat();
for (Product p : product)
{
p.display();
}
//price calculation
System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " +overAllPrice);
//calculating discount
discount = overAllPrice*2/100;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t Discount (Rs.) " +discount);
//total amount after discount
subtotal = overAllPrice-discount;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t Subtotal "+subtotal);
//calculating tax
sgst=overAllPrice*12/100;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t SGST (%) "+sgst);
cgst=overAllPrice*12/100;
System.out.println("\n\t\t\t\t\t\t\t\t\t\t CGST (%) "+cgst);
//calculating amount to be paid by buyer
System.out.println("\n\t\t\t\t\t\t\t\t\t\t Invoice Total "
+(subtotal+cgst+sgst));
System.out.println("\t\t\t\t----------------Thank You for
Shopping!!-----------------");
System.out.println("\t\t\t\t Visit Again");
// close Scanner
scan.close();
}
}
