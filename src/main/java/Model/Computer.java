package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
    private Long id;
    private String CPU;
    private String GPU;
    private String MotherBoard;
    private String Cooler;
    private String RAM;
    private int CountRAM;
    private String SSD;
    private int CountSSD;
    private String HDD;
    private int CountHDD;
    private String ComputerCase;
    private String PowerUnit;
    private int totalCost;
}
