package hashmap;

public class HashMapCustomApp {

    public static void main(String[] args) {
        HashMapCustom<Integer, Integer> hashMapCustom = new HashMapCustom<Integer, Integer>();
        hashMapCustom.put(21, 12);
        hashMapCustom.put(25, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);

        System.out.println("\n///////////////////////HashMap///////////////////////");

        System.out.println("\nGet value with key 21 = "
                + hashMapCustom.get(21));
        System.out.println("Get value with key 51 = "
                + hashMapCustom.get(51));

        System.out.println("\nContains value with key 33 = " + hashMapCustom.contains(33));
        System.out.println("Contains value with key 65 = " + hashMapCustom.contains(65));

        System.out.print("\nDisplaying : ");
        System.out.println(hashMapCustom);

        System.out.println("\nValue with key 21 removed: "
                + hashMapCustom.remove(21));
        System.out.println("Value with key 51 removed: "
                + hashMapCustom.remove(51));

        System.out.print("\nDisplaying : ");
        System.out.println(hashMapCustom);
    }
}