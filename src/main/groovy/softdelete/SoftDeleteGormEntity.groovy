package softdelete

import grails.artefact.Enhances
import grails.gorm.DetachedCriteria
import groovy.transform.CompileStatic
import org.grails.core.artefact.DomainClassArtefactHandler
import org.grails.datastore.gorm.GormEnhancer
import org.grails.datastore.gorm.GormEntity
import org.grails.datastore.gorm.GormInstanceApi
import org.grails.datastore.gorm.GormStaticApi
import org.grails.datastore.mapping.query.api.BuildableCriteria
import org.grails.datastore.mapping.query.api.Criteria

/**
 * Created by daniel on 15/08/17.
 */
@CompileStatic
@Enhances(DomainClassArtefactHandler.TYPE)
trait SoftDeleteGormEntity<D> extends GormEntity<D> {
    Boolean deleted = false

    void delete() {
        this.deleted = true
        currentGormInstanceApi().save((D) this)
    }

    void delete(Map params) {
        if (params?.physical == true)
        {
            params.remove('physical')
            if (params)
                currentGormInstanceApi().delete((D)this, params)
            else
                currentGormInstanceApi().delete((D)this)
        } else {
            if (params) {
                this.deleted = true
                currentGormInstanceApi().save((D) this, params)
            } else {
                currentGormInstanceApi().save((D) this)
            }
        }
    }

//    static DetachedCriteria<D> where(Closure callable) {
//        currentGormStaticApi().where callable
//    }

//    static DetachedCriteria<D> whereLazy(Closure callable) {
//        currentGormStaticApi().whereLazy callable
//    }

//    static DetachedCriteria<D> whereAny(Closure callable) {
//        currentGormStaticApi().whereAny callable
//    }

//    static List<D> findAll(Closure callable) {
//        currentGormStaticApi().findAll callable
//    }

//    static List<D> findAll(Map args, Closure callable) {
//        currentGormStaticApi().findAll args, callable
//    }

//    static D find(Closure callable) {
//        currentGormStaticApi().find callable
//    }

//    static void deleteAll(Object... objectsToDelete) {
//        currentGormStaticApi().deleteAll objectsToDelete
//    }

//    static void deleteAll(Iterable objectToDelete) {
//        currentGormStaticApi().deleteAll objectToDelete
//    }

    static D get(Serializable id) {
        (D) createCriteria().get {
            eq('id', id)
        }
    }

    static D read(Serializable id) {
        get(id)
    }

//    static D load(Serializable id) {
//        currentGormStaticApi().load id
//    }

//    static D proxy(Serializable id) {
//        currentGormStaticApi().proxy id
//    }

    static List<D> getAll(Iterable<Serializable> ids) {
        getAll(ids as Serializable[])
    }

    static List<D> getAll(Serializable... ids) {
        def l = createCriteria().list {
            inList('id', ids.flatten())
        }
        return l as List<D>
    }

    static BuildableCriteria createCriteria() {
        def builder = new SoftDeleteBuildableCriteriaWrapper(currentGormStaticApi().createCriteria())
        return builder
    }

//    static Integer count() {
//        currentGormStaticApi().count
//    }

//    static Integer getCount() {
//        currentGormStaticApi().getCount()
//    }

    static List<D> list(Map params) {
        if(params?.physical == true) {
            params.remove('physical')
            return currentGormStaticApi().list(params)
        } else {
            return (List<D>) createCriteria().list(params) {}
        }
    }

    static List<D> list() {
        return (List<D>) createCriteria().list {}
    }

    static List<D> findAll(Map params = Collections.emptyMap()) {
        list(params)
    }

//    static List<D> findAll(D example) {
//        currentGormStaticApi().findAll example
//    }

//    static List<D> findAll(D example, Map args) {
//        currentGormStaticApi().findAll example, args
//    }

    static D first() {
        first([sort:'id'] as Map)
    }

    static D first(String propertyName) {
        first([sort: propertyName] as Map)
    }

    static D first(Map queryParams) {
        List<D> l = (List<D>) createCriteria().list([max: 1, order:'asc'] << queryParams) {}
        return l ? l[0] : null
    }

    static D last() {
        last([sort: 'id'] as Map)
    }

    static D last(String propertyName) {
        last([sort: propertyName] as Map)
    }

    static D last(Map queryParams) {
        List<D> l = (List<D>) createCriteria().list([max: 1, order:'desc'] << queryParams) {}
        return l ? l[0] : null
    }

    static Object staticMethodMissing(String methodName, arg) {
        if(methodName.startsWith('findAllBy') || methodName.startsWith('findBy') || methodName.startsWith('countBy')) {
            methodName += 'AndDeleted'
            if (arg.getClass().isArray()) {
                arg = ((Object[]) arg).plus(false)
            } else {
                arg = [false]
            }
        }
        currentGormStaticApi().methodMissing(methodName, arg)
    }

//    static List<D> findAllWhere(Map queryMap) {
//        currentGormStaticApi().findAllWhere queryMap
//    }

//    static List<D> findAllWhere(Map queryMap, Map args) {
//        currentGormStaticApi().findAllWhere queryMap, args
//    }

//    static D findWhere(Map queryMap) {
//        currentGormStaticApi().findWhere queryMap
//    }

//    static D findWhere(Map queryMap, Map args) {
//        currentGormStaticApi().findWhere queryMap, args
//    }

//    static D findOrCreateWhere(Map queryMap) {
//        currentGormStaticApi().findOrCreateWhere queryMap
//    }

//    static D findOrSaveWhere(Map queryMap) {
//        currentGormStaticApi().findOrSaveWhere queryMap
//    }

    private GormInstanceApi<D> currentGormInstanceApi() {
        (GormInstanceApi<D>)GormEnhancer.findInstanceApi(getClass())
    }

    private static GormStaticApi<D> currentGormStaticApi() {
        (GormStaticApi<D>)GormEnhancer.findStaticApi(this)
    }

}