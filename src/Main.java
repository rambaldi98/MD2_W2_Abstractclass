import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

    Material[] materials = new Material[5];
    materials[0] = new Meat("ds","helo",LocalDate.now().plusDays(6),30,20);
    materials[1] = new CrispyFlour("ds","helo",LocalDate.now().plusDays(6),30,20);

    for (Material opp : materials){
        if(opp!= null){
            System.out.println(  opp.getRealMoney());
            System.out.println(  opp.getPriceDifferent());
            System.out.println(opp.toString());
        }

    }

    }
}
