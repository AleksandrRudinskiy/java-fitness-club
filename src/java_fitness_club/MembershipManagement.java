
package java_fitness_club;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);
    
    private int getIntInput() {
        int choice = 0;
        while (choice==0) {
            try {
                choice = reader.nextInt();
                
                if (choice == 0) {
                    throw new InputMismatchException();
                }
                reader.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println("Введите число заново!" + ex.getMessage());
            }
        }
        return choice;
}
    
    private void printClubOptions() {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }
    
    public int getChoice() {
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("===============================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println("Please select an option (or Enter -1 to quit):");
        return getIntInput();
    }
    
    public String addMembers(LinkedList<Member> members ) {
        String name;
        int club;
        String mem;
        double fees;
        int memberId;
        Member mbr;
        Calculator<Integer> cal;
        
        System.out.println("Введите имя посетителя ");
        name = reader.nextLine();
        printClubOptions();
        club = reader.nextInt();
        while (club < 1 || club > 4) {
            System.out.println("Неверно введено значение, введите еще раз");
        club = getIntInput();
        }
        if (!members.isEmpty()) {
            memberId = members.getLast().getMemberId()+1;
        } else {
            memberId =1;
        }
        
        cal = (n) -> {
                switch (n)
                {
                case 1:
                return 900;
                case 2:
                return 950;
                case 3:
                return 1000;
                default:
                return -1;
        }
                };
        fees = cal.calculateFees(club);
        if (club != 4) {
            mbr = new SingleClubMember('S', memberId, name, fees, club );
            members.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Single Club Member added\n");
        } else {
            mbr = new MultiClubMember('M', memberId, name, fees, 100);
            members.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Multi Club Member added\n");
    }
     return mem;   
}
    
    public void removeMember(LinkedList<Member> m) {
        int memberId;
        System.out.println("Введите Id посетителя, данные которого вы хотите удалить");
        memberId = getIntInput();
        
        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberId() == memberId) {
                m.remove(i);
                System.out.println("Посетитель с Id = " + memberId + " удален.");
                return;
            }
        }
        System.out.println("Посетитель с Id = " + memberId + " не найден.");
    }
    
    public void printMemberInfo(LinkedList<Member> m) {
        
    }
}
