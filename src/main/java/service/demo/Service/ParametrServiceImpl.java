package service.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import service.demo.Model.Parametr;
import service.demo.Repository.ParametrRepository;

import java.util.ArrayList;
import java.util.List;

public class ParametrServiceImpl  implements ParametrService {

    private ParametrRepository parametrRepository;


    @Autowired
    public ParametrServiceImpl(ParametrRepository parametrRepository) {
        this.parametrRepository = parametrRepository;

    }

    @Override
    public List<Parametr> listAll() {
        List<Parametr> products = new ArrayList<>();
        parametrRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Parametr getById(Long id,Long idP) {
        return parametrRepository.findOne(id);
    }

    @Override
    public Parametr saveOrUpdate(Parametr parametr) {
        parametrRepository.save(parametr);
        return parametr;
    }

    @Override
    public void delete(Long id,Long idP) {
        parametrRepository.delete(id);

    }


}

