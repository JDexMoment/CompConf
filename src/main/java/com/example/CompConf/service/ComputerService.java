package Service;

import Model.Computer;

import java.util.List;
import java.util.Optional;

public interface ComputerService {
    List<Computer> getComputers();
    Optional<Computer> getComputerById(Long id);
}
