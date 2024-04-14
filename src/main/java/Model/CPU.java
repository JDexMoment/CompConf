package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CPU {
    private Long CPUId;
    private String Name;
    private int Cost;
    private Text Description;
}
