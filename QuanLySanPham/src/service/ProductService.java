package service;

import dto.ProductDTO;
import model.Product;

import java.util.Collections;
import java.util.List;

public class ProductService {
    private List<Product> list = ProductDTO.readFile();
    public List<Product> getAll() {
        ProductDTO.readFile();
        return list;
    }
    public void readFile(){
        ProductDTO.readFile();
        System.out.println("...Đọc thành công");
    }
    public void writeFile(){
        ProductDTO.writeFile(list);
        System.out.println("...Ghi thành công");
    }
    public void add(Product product) {
        list.add(product);
//        Collections.sort(list);
        ProductDTO.writeFile(list);
        System.out.println("... Thêm mới sản phẩm thành công");
        System.out.println(product);
    }
    public void edit(int index, Product product) {
        list.set(index,product);
        ProductDTO.writeFile(list);
        System.out.println("... Sửa sản phẩm thành công thành: ");
        System.out.println(product);
    }
    public void delete(int index) {
        if (index != -1) {
            System.out.println("... Xóa thành công");
            System.out.println(list.get(index));
            list.remove(index);
            ProductDTO.writeFile(list);
        }else System.out.println("... Không có mã sản phẩm trong danh sách");
    }
    public int findByID(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public void arrangePrice() {
        System.out.println("Sắp xếp giá giảm dần là: ");
        Collections.sort(list);
        for (Product p:list){
            System.out.println(p);
        }
    }
    public void arrangePrice2() {
        System.out.println("Sắp xếp giá tăng dần là: ");
        Collections.sort(list);
        Collections.reverse(list);
        for (Product p:list){
            System.out.println(p);
        }
    }
    public void maxPrice() {
        System.out.println("Sản phẩm có giá đắt nhất là: ");
        Collections.sort(list);
        for (Product p:list){
            if (p.getPrice() == list.get(0).getPrice()){
                System.out.println(p);
            }
        }
    }
}
