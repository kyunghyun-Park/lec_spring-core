package hello.core.singleton;

public class StateFulService {

    private int price; //상태를 유지하는 필드 10,000 -> 20,000 로 바뀜

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 문제!
    }

    //무상태로 바꾼 버전
    public int order2(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

    public int getPrice(){
        return price;
    }
}
