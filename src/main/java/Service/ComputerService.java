package Service;

import Model.*;

import java.util.Optional;

public interface ComputerService {
    static Optional<CPU> getCPUNameById(Long id) {
        return Optional.empty();
    }

    static Optional<GPU> getGPUNameById(Long id) {
        return Optional.empty();
    }

    static Optional<MotherBoard> getMotherBoardNameById(Long id) {
        return Optional.empty();
    }

    static Optional<Cooler> getCoolerNameById(Long id) {
        return Optional.empty();
    }

    static Optional<RAM> getRAMNameById(Long id) {
        return Optional.empty();
    }

    static Optional<SSD> getSSDNameById(Long id) {
        return Optional.empty();
    }

    static Optional<HDD> getHDDNameById(Long id) {
        return Optional.empty();
    }

    static Optional<ComputerCase> getComputerCaseNameById(Long id) {
        return Optional.empty();
    }

    static Optional<PowerUnit> getPowerUnitNameById(Long id) {
        return Optional.empty();
    }
}
