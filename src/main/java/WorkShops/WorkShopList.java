package WorkShops;

import WorkShops.AutoRepairShop.AutoRepairShop;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class WorkShopList implements Serializable {

    private ArrayList<AutoRepairShop> workshops;

    public WorkShopList(){
        workshops = new ArrayList<>();
    }

    public void put(AutoRepairShop repairShop){
        workshops.add(repairShop);
    }

    public AutoRepairShop get(int index){
        return workshops.get(index);
    }

    public void serializeBinary() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("WorkShops.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(workshops);

        objectOutputStream.close();
    }

    public void deserializeBinary() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("WorkShops.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        workshops = (ArrayList<AutoRepairShop>) objectInputStream.readObject();

        objectInputStream.close();
    }

    public void serializeXML() throws FileNotFoundException {
        XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("WorkShops.xml"));

        xmlEncoder.writeObject(workshops);

        xmlEncoder.close();
    }

    public void deserializeXML() throws FileNotFoundException {
        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("WorkShops.xml")));

        workshops = (ArrayList<AutoRepairShop>) xmlDecoder.readObject();

        xmlDecoder.close();
    }

    public void writeToFiles() throws IOException {
        for(int i = 0; i < workshops.size(); i++){
            int index = i + 1;
            workshops.get(i).writeToFile("input" + index + ".txt");
        }
    }

    public int getSize() {
        return workshops.size();
    }
}
