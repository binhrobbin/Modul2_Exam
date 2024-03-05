package dto;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private static final File file = new File("data/product.csv");
    public static List<Product> readFile(){
        List<Product> productsInFile = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(", ");
                Product product = new Product(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]),Integer.parseInt(data[3]),data[4]);
                productsInFile.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("lỗi đọc file");
        }
        return productsInFile;
    }
    public static void writeFile(List<Product> listWriteFile){
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = "mã sp, tên sp, giá, số lượng, mô tả\n";
            for (Product u: listWriteFile){
                data += u.getId()+", "+u.getNameProduct()+", "+u.getPrice()+", "+u.getQuantity()+", "+u.getDescriber()+"\n";
            }
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("lỗi ghi file");
        }
    }
}