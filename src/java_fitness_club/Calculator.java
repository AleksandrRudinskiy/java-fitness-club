
package java_fitness_club;

public interface Calculator <T extends Number> {
    
    double calculateFees(T clubId);
}
