package Service;

import Model.Complect;

import java.util.List;
import java.util.Optional;

public interface ComplectService {

    boolean getCPUTypeById(Long id);
    boolean getGPUTypeById(Long id);
    boolean getMotherBoardTypeById(Long id);
    boolean getCoolerTypeById(Long id);
    boolean getRAMTypeById(Long id);
    boolean getSSDTypeById(Long id);
    boolean getHDDTypeById(Long id);
    boolean getComputerCaseTypeById(Long id);
    boolean getPowerUnitTypeById(Long id);

    Optional<String> getNameById(Long id);

    Optional<String> setCPUNameById(Long id);
    Optional<String> setGPUNameById(Long id);
    Optional<String> setMotherBoardNameById(Long id);
    Optional<String> setCoolerNameById(Long id);
    Optional<String> setRAMNameById(Long id);
    Optional<String> setSSDNameById(Long id);
    Optional<String> setHDDNameById(Long id);
    Optional<String> setComputerCaseNameById(Long id);
    Optional<String> setPowerUnitNameById(Long id);

    List<Complect> getCPU();
    List<Complect> getGPU();
    List<Complect> getMotherBoard();
    List<Complect> getCooler();
    List<Complect> getRAM();
    List<Complect> getSSD();
    List<Complect> getHDD();
    List<Complect> getComputerCase();
    List<Complect> getPowerUnit();

    Optional<Complect> getComplectById(Long id);

    void registerComplect(Complect complect);

}
