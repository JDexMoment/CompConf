package Service;

import Model.Computer;
import Repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ComputerServiceImpl implements ComputerService {
    private final ComputerRepository computerRepository;


    @Override
    public List<Computer> getComputers() {
        return computerRepository.findAll();
    }

    @Override
    public Optional<Computer> getComputerById(Long id) {
        return computerRepository.findById(id);
    }
}
