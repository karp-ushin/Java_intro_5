import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class PhoneBook {
    static HashMap<String, LinkedList<String>> db = new HashMap<>();
    static String inputName, inputPhone;
    static LinkedList<String> phoneNumbers = new LinkedList<String>();
    static void show(){
        for(String fullName : db.keySet()){
            System.out.printf("%s ", fullName);
            for(String phoneNumber : db.get(fullName)){
                System.out.printf("%s ", phoneNumber);
            }
            System.out.printf("\n");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Enter full name: ");
            inputName = sc.nextLine();
            if(inputName.equalsIgnoreCase("q")){
                break;
            }
            System.out.println("Enter phone number: ");
            inputPhone = sc.nextLine();
            if (db.containsKey(inputName)){
                phoneNumbers = db.get(inputName);
                phoneNumbers.add(inputPhone);
            } else {
                phoneNumbers = new  LinkedList<String>();
                phoneNumbers.add(inputPhone);
                db.put(inputName, phoneNumbers);
            }
            show();
        }
        sc.close();
    }    
}