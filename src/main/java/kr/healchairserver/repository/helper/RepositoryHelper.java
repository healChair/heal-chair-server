package kr.healchairserver.repository.helper;

import javax.persistence.EntityManager;
import kr.healchairserver.domain.model.FastCharger;
import kr.healchairserver.service.helper.ServiceErrorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class RepositoryHelper {

    private final EntityManager em;
    private final ServiceErrorHelper errorHelper;

    @Autowired
    public RepositoryHelper(EntityManager em,
        ServiceErrorHelper errorHelper) {
        this.em = em;
        this.errorHelper = errorHelper;
    }

    public <T> T findOrThrow(Class<T> clazz, Object primaryKey) throws ResponseStatusException {
        T entity = em.find(clazz, primaryKey);
        if (entity == null) {
            String reason = String.format("%s id was not found", clazz.getName());
            throw errorHelper.notFound(reason);
        }
        return entity;
    }

    public FastCharger findFastChargerOrThrow(Long id) {
        return findOrThrow(FastCharger.class, id);
    }
}
