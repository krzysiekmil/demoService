package service.demo.Service;

import service.demo.Model.Parametr;

import java.util.List;

public interface ParametrService {
    List<Parametr> listAll();

    Parametr getById(Long id,Long idP);

    Parametr saveOrUpdate(Parametr parametr);

    void delete(Long id,Long idP);
}
