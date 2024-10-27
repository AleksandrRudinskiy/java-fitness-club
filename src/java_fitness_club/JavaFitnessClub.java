
package java_fitness_club;

import java.util.List;

public class JavaFitnessClub {

    public static void main(String[] args) {
       FileHandler fh = new FileHandler();
       List<Member> members = fh.readFile();
       
       members.forEach(System.out::println);
    //   members.remove(2);
       
       System.out.println("After remove: ");
       members.forEach(System.out::println);
       
       fh.overWriteFile(members);
       List<Member> updateMembers = fh.readFile();
       
       System.out.println("Update Members: ");
       updateMembers.forEach(System.out::println);
            
    }
    
}
