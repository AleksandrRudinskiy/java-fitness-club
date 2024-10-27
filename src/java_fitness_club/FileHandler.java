
package java_fitness_club;

import java.util.LinkedList;
import java.io.*;
import java.util.List;

public class FileHandler {
    
    public List<Member> readFile() {
        /*формат данных в csv:
        -тип посетителя
        -id
        -name
        -оплата
        -идентификатор клуба
        */
        String line;
        List<Member> members = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            line = reader.readLine();
            while (line != null) {
                String []lineArr = line.split(", ");
                Member member = null;
                if (lineArr[0].equals("S")) {
                member = new SingleClubMember(
                        lineArr[0].charAt(0), 
                        Integer.parseInt(lineArr[1]), 
                        lineArr[2], 
                        Double.parseDouble(lineArr[3]),
                        Integer.parseInt(lineArr[4])
                );            
                } else if (lineArr[0].equals("M")) {
                    member = new MultiClubMember(
                        lineArr[0].charAt(0), 
                        Integer.parseInt(lineArr[1]), 
                        lineArr[2], 
                        Double.parseDouble(lineArr[3]),
                        Integer.parseInt(lineArr[4])
                );
                }
               members.add(member);
               line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return members;
    }
    
    public void appendFile(String mem) {
        try (BufferedWriter writer = new BufferedWriter (new FileWriter("members.csv", true))) {
            writer.write(mem);
            writer.newLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void overWriteFile(List<Member> members) {
        File csvFile = new File("members.csv");
        File tempFile = new File("members.temp");
        try (BufferedWriter writer = new BufferedWriter (new FileWriter(tempFile.getName()))) {
            StringBuilder sb = new StringBuilder();
            for (Member member: members ) {
                sb.append(member.toString());
                sb.append("\n");
               
            }
         writer.write(sb.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        csvFile.delete();
        tempFile.renameTo(csvFile);
    }
}
