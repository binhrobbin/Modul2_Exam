package view;

import input.Input;
import model.Product;
import service.ProductService;

import java.util.List;

public class ProductMenu {
    static ProductService productService = new ProductService();
    public void showProductManager() {
        while (true){
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            System.out.println("Chọn chức năng: ");
            int choice = Input.number();
            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    showFormAdd();
                    break;
                case 3:
                    showFormEdit();
                    break;
                case 4:
                    showDeleteForm();
                    break;
                case 5:
                    showArrange();
                    break;
                case 6:
                    showPriceMax();
                    break;
                case 7:
                    productService.readFile();
                    break;
                case 8:
                    productService.writeFile();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("... Nhập sai lựa chọn");
            }
        }
    }
    public void showArrange() {
        while (true){
            System.out.println("---- Sắp xếp giá ----");
            System.out.println("1. Giảm dần");
            System.out.println("2. Tăng dần");
            System.out.println("3. Quay lại");
            System.out.println("Nhập lựa chọn: ");
            int choice = Input.number();
            switch (choice) {
                case 1:
                    productService.arrangePrice();
                    break;
                case 2:
                    productService.arrangePrice2();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("... Nhập sai lựa chọn");
            }
        }
    }
    public void showAll(){
        System.out.println("-----Hiển thị sản phẩm-----");
        System.out.println("1: Thêm mới");
        List<Product> list = productService.getAll();
        for (Product product: list){
            System.out.println(product);
        }
        int choice = Input.number();
        if (choice == 1) showFormAdd();
        else return;
    }
    public void showFormAdd(){
        System.out.println("-----Thêm sản phẩm mới-----");
        System.out.print("Nhập mã sản phẩm: ");
        int newId = Input.number();
        System.out.print("Nhâp tên sản phẩm: ");
        String newName = Input.string();
        System.out.print("Nhập giá: ");
        double newPrice = Input.inputDoubleNumber();
        System.out.print("Nhập số lượng: ");
        int newQuantity= Input.number();
        System.out.print("Nhập chi tiết: ");
        String newDescriber = Input.string();
        Product product = new Product(newId,newName,newPrice,newQuantity,newDescriber);
        productService.add(product);
    }
    public void showFormEdit(){
        System.out.println("-----Sửa sản phẩm-----");
        System.out.println("Nhập mã sản phẩm cần sửa: ");
        int id = Input.number();
        int index =  productService.findByID(id);
        if (index != -1){
            System.out.println("Nhập mã sản phẩm sửa lại: ");
            int newId = Input.number();
            System.out.print("Nhâp tên sản phẩm: ");
            String newName = Input.string();
            System.out.print("Nhập giá: ");
            double newPrice = Input.inputDoubleNumber();
            System.out.print("Nhập số lượng: ");
            int newQuantity= Input.number();
            System.out.print("Nhập chi tiết: ");
            String newDescriber = Input.string();
            Product product = new Product(newId,newName,newPrice,newQuantity,newDescriber);
            productService.edit(index,product);
        }else System.out.println("... Không tìm được sản phẩm với mã sản phẩm trên");
    }
    public void showDeleteForm(){
        System.out.println("-----Xóa sản phẩm-----");
        System.out.println("Nhập mã sản phẩm cần xóa: ");
        int id = Input.number();
        int index =  productService.findByID(id);
        productService.delete(index);
    }
    public void showPriceMax(){
        System.out.println("-----Hiển thị sản phẩm giá cao nhất-----");
        productService.maxPrice();
    }
}
