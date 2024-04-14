package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerUnit {
    private Long id;
    private String Name;
    private int Cost;
    private String Description;
}
