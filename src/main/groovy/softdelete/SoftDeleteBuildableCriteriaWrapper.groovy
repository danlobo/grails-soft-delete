package softdelete

import org.grails.datastore.mapping.query.Query
import org.grails.datastore.mapping.query.api.BuildableCriteria
import org.grails.datastore.mapping.query.api.Criteria
import org.grails.datastore.mapping.query.api.QueryableCriteria

/**
 * Created by daniel on 16/08/17.
 */
class SoftDeleteBuildableCriteriaWrapper implements BuildableCriteria {
    private BuildableCriteria builder
    public SoftDeleteBuildableCriteriaWrapper(BuildableCriteria builder) {
        this.builder = builder
    }
    @Override
    Class getTargetClass() {
        return builder.getTargetClass()
    }

    @Override
    Criteria exists(QueryableCriteria<?> subquery) {
        subquery.eq('deleted', false)
        return builder.exists(subquery)
    }

    @Override
    Criteria notExists(QueryableCriteria<?> subquery) {
        subquery.eq('deleted', false)
        return builder.notExists(subquery)
    }

    @Override
    Criteria idEquals(Object value) {
        return builder.idEquals(value)
    }

    @Override
    Criteria isEmpty(String propertyName) {
        return builder.isEmpty(propertyName)
    }

    @Override
    Criteria isNotEmpty(String propertyName) {
        return builder.isNotEmpty(propertyName)
    }

    @Override
    Criteria isNull(String propertyName) {
        return builder.isNull(propertyName)
    }

    @Override
    Criteria isNotNull(String propertyName) {
        return builder.isNotNull(propertyName)
    }

    @Override
    Criteria eq(String propertyName, Object propertyValue) {
        return builder.eq(propertyName, propertyValue)
    }

    @Override
    Criteria idEq(Object propertyValue) {
        return builder.idEq(propertyValue)
    }

    @Override
    Criteria ne(String propertyName, Object propertyValue) {
        return builder.ne(propertyName, propertyValue)
    }

    @Override
    Criteria between(String propertyName, Object start, Object finish) {
        return builder.between(propertyName, start, finish)
    }

    @Override
    Criteria gte(String property, Object value) {
        return builder.gte(property, value)
    }

    @Override
    Criteria ge(String property, Object value) {
        return builder.ge(property, value)
    }

    @Override
    Criteria gt(String property, Object value) {
        return builder.gt(property, value)
    }

    @Override
    Criteria lte(String property, Object value) {
        return builder.lte(property, value)
    }

    @Override
    Criteria le(String property, Object value) {
        return builder.le(property, value)
    }

    @Override
    Criteria lt(String property, Object value) {
        return builder.lt(property, value)
    }

    @Override
    Criteria like(String propertyName, Object propertyValue) {
        return builder.like(propertyName, propertyValue)
    }

    @Override
    Criteria ilike(String propertyName, Object propertyValue) {
        return builder.ilike(propertyName, propertyValue)
    }

    @Override
    Criteria rlike(String propertyName, Object propertyValue) {
        return builder.rlike(propertyName, propertyValue)
    }

    @Override
    Criteria and(Closure callable) {
        return builder.and(callable)
    }

    @Override
    Criteria or(Closure callable) {
        return builder.or(callable)
    }

    @Override
    Criteria not(Closure callable) {
        return builder.not(callable)
    }

    @Override
    Criteria "in"(String propertyName, Collection values) {
        return builder."in"(propertyName, values)
    }

    @Override
    Criteria "in"(String propertyName, QueryableCriteria<?> subquery) {
        return builder."in"(propertyName, subquery)
    }

    @Override
    Criteria inList(String propertyName, QueryableCriteria<?> subquery) {
        return builder.inList(propertyName, subquery)
    }

    @Override
    Criteria "in"(String propertyName, Closure<?> subquery) {
        return builder."in"(propertyName, subquery)
    }

    @Override
    Criteria inList(String propertyName, Closure<?> subquery) {
        return builder.inList(propertyName, subquery)
    }

    @Override
    Criteria inList(String propertyName, Collection values) {
        return builder.inList(propertyName, values)
    }

    @Override
    Criteria inList(String propertyName, Object[] values) {
        return builder.inList(propertyName, values)
    }

    @Override
    Criteria "in"(String propertyName, Object[] values) {
        return builder."in"(propertyName, values)
    }

    @Override
    Criteria notIn(String propertyName, QueryableCriteria<?> subquery) {
        return builder.notIn(propertyName, subquery)
    }

    @Override
    Criteria notIn(String propertyName, Closure<?> subquery) {
        return builder.notIn(propertyName, subquery)
    }

    @Override
    Criteria order(String propertyName) {
        return builder.order(propertyName)
    }

    @Override
    Criteria order(Query.Order o) {
        return builder.order(o)
    }

    @Override
    Criteria order(String propertyName, String direction) {
        return builder.order(propertyName, direction)
    }

    @Override
    Criteria sizeEq(String propertyName, int size) {
        return builder.sizeEq(propertyName, size)
    }

    @Override
    Criteria sizeGt(String propertyName, int size) {
        return builder.sizeGt(propertyName, size)
    }

    @Override
    Criteria sizeGe(String propertyName, int size) {
        return builder.sizeGe(propertyName, size)
    }

    @Override
    Criteria sizeLe(String propertyName, int size) {
        return builder.sizeLe(propertyName, size)
    }

    @Override
    Criteria sizeLt(String propertyName, int size) {
        return builder.sizeLt(propertyName, size)
    }

    @Override
    Criteria sizeNe(String propertyName, int size) {
        return builder.sizeNe(propertyName, size)
    }

    @Override
    Criteria eqProperty(String propertyName, String otherPropertyName) {
        return builder.eqProperty(propertyName, otherPropertyName)
    }

    @Override
    Criteria neProperty(String propertyName, String otherPropertyName) {
        return builder.neProperty(propertyName, otherPropertyName)
    }

    @Override
    Criteria gtProperty(String propertyName, String otherPropertyName) {
        return builder.gtProperty(propertyName, otherPropertyName)
    }

    @Override
    Criteria geProperty(String propertyName, String otherPropertyName) {
        return builder.geProperty(propertyName, otherPropertyName)
    }

    @Override
    Criteria ltProperty(String propertyName, String otherPropertyName) {
        return builder.ltProperty(propertyName, otherPropertyName)
    }

    @Override
    Criteria leProperty(String propertyName, String otherPropertyName) {
        return builder.leProperty(propertyName, otherPropertyName)
    }

    @Override
    Criteria allEq(Map<String, Object> propertyValues) {
        return builder.allEq(propertyValues)
    }

    @Override
    Criteria eqAll(String propertyName, Closure<?> propertyValue) {
        return builder.eqAll(propertyName, propertyValue)
    }

    @Override
    Criteria gtAll(String propertyName, Closure<?> propertyValue) {
        return builder.gtAll(propertyName, propertyValue)
    }

    @Override
    Criteria ltAll(String propertyName, Closure<?> propertyValue) {
        return builder.ltAll(propertyName, propertyValue)
    }

    @Override
    Criteria geAll(String propertyName, Closure<?> propertyValue) {
        return builder.geAll(propertyName, propertyValue)
    }

    @Override
    Criteria leAll(String propertyName, Closure<?> propertyValue) {
        return builder.leAll(propertyName, propertyValue)
    }

    @Override
    Criteria eqAll(String propertyName, QueryableCriteria propertyValue) {
        return builder.eqAll(propertyName, propertyValue)
    }

    @Override
    Criteria gtAll(String propertyName, QueryableCriteria propertyValue) {
        return builder.gtAll(propertyName, propertyValue)
    }

    @Override
    Criteria ltAll(String propertyName, QueryableCriteria propertyValue) {
        return builder.ltAll(propertyName, propertyValue)
    }

    @Override
    Criteria geAll(String propertyName, QueryableCriteria propertyValue) {
        return builder.geAll(propertyName, propertyValue)
    }

    @Override
    Criteria leAll(String propertyName, QueryableCriteria propertyValue) {
        return builder.leAll(propertyName, propertyValue)
    }

    @Override
    Criteria gtSome(String propertyName, QueryableCriteria propertyValue) {
        return builder.gtSome(propertyName, propertyValue)
    }

    @Override
    Criteria gtSome(String propertyName, Closure<?> propertyValue) {
        return builder.gtSome(propertyName, propertyValue)
    }

    @Override
    Criteria geSome(String propertyName, QueryableCriteria propertyValue) {
        return builder.geSome(propertyName, propertyValue)
    }

    @Override
    Criteria geSome(String propertyName, Closure<?> propertyValue) {
        return builder.geSome(propertyName, propertyValue)
    }

    @Override
    Criteria ltSome(String propertyName, QueryableCriteria propertyValue) {
        return builder.ltSome(propertyName, propertyValue)
    }

    @Override
    Criteria ltSome(String propertyName, Closure<?> propertyValue) {
        return builder.ltSome(propertyName, propertyValue)
    }

    @Override
    Criteria leSome(String propertyName, QueryableCriteria propertyValue) {
        return builder.leSome(propertyName, propertyValue)
    }

    @Override
    Criteria leSome(String propertyName, Closure<?> propertyValue) {
        return builder.leSome(propertyName, propertyValue)
    }

    @Override
    BuildableCriteria cache(boolean cache) {
        return builder.cache(cache)
    }

    @Override
    BuildableCriteria readOnly(boolean readOnly) {
        return builder.readOnly(readOnly)
    }

    @Override
    BuildableCriteria join(String property) {
        return builder.join(property)
    }

    @Override
    BuildableCriteria select(String property) {
        return builder.select(property)
    }



    @Override
    Object list(@DelegatesTo(Criteria.class) Closure closure) {
        def deletedClosure = {
            closure.delegate = delegate
            eq('deleted', false)
            closure()
        }

        return builder.list(deletedClosure)
    }

    @Override
    Object list(Map params, @DelegatesTo(Criteria.class) Closure closure) {
        def deletedClosure = {
            closure.delegate = delegate
            eq('deleted', false)
            closure()
        }

        return builder.list(params, deletedClosure)
    }

    @Override
    Object listDistinct(@DelegatesTo(Criteria.class) Closure closure) {
        def deletedClosure = {
            closure.delegate = delegate
            eq('deleted', false)
            closure()
        }

        return builder.listDistinct(deletedClosure)
    }

    @Override
    Object scroll(@DelegatesTo(Criteria.class) Closure closure) {
        def deletedClosure = {
            closure.delegate = delegate
            eq('deleted', false)
            closure()
        }

        return builder.scroll(deletedClosure)
    }

    @Override
    Object get(@DelegatesTo(Criteria.class) Closure closure) {
        def deletedClosure = {
            closure.delegate = delegate
            eq('deleted', false)
            closure()
        }

        return builder.get(deletedClosure)
    }
}
