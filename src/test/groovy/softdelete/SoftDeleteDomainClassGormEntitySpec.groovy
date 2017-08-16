package softdelete

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock([SoftDeleteDomainClass])
class SoftDeleteDomainClassGormEntitySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test soft delete"() {
        when:
        def obj = new SoftDeleteDomainClass()

        then:
        obj.save()
        SoftDeleteDomainClass.list().size() == 1
        SoftDeleteDomainClass.list(physical: true).size() == 1

        when:
        obj.delete()

        then:
        SoftDeleteDomainClass.list().size() == 0
        SoftDeleteDomainClass.list(physical: true).size() == 1
    }

    void "test physical delete"() {
        when:
        def obj = new SoftDeleteDomainClass()

        then:
        obj.save()
        SoftDeleteDomainClass.list().size() == 1
        SoftDeleteDomainClass.list(physical: true).size() == 1

        when:
        obj.delete(physical: true)

        then:
        SoftDeleteDomainClass.list().size() == 0
        SoftDeleteDomainClass.list(physical: true).size() == 0
    }

    void "test get"() {
        when:
        def obj = new SoftDeleteDomainClass()

        then:
        obj.save()
        SoftDeleteDomainClass.get(obj.id) != null
        SoftDeleteDomainClass.list(physical: true).size() == 1

        when:
        obj.delete()

        then:
        SoftDeleteDomainClass.get(obj.id) == null
        SoftDeleteDomainClass.list(physical: true).size() == 1
    }

    void "test getAll"() {
        when:
        def obj = new SoftDeleteDomainClass()
        def obj1 = new SoftDeleteDomainClass()

        then:
        obj.save(flush: true)
        obj1.save(flush: true)
        SoftDeleteDomainClass.getAll([obj.id, obj1.id]).size() == 2
        SoftDeleteDomainClass.getAll(obj.id, obj1.id).size() == 2
        SoftDeleteDomainClass.list().size() == 2
        SoftDeleteDomainClass.list(physical: true).size() == 2

        when:
        obj.delete()
        obj1.delete()

        then:
        SoftDeleteDomainClass.getAll([obj.id, obj1.id]).size() == 0
        SoftDeleteDomainClass.getAll(obj.id, obj1.id).size() == 0
        SoftDeleteDomainClass.list().size() == 0
        SoftDeleteDomainClass.list(physical: true).size() == 2
    }

    void "test first"() {
        when:
        def obj = new SoftDeleteDomainClass()
        def obj1 = new SoftDeleteDomainClass()

        then:
        obj.save()
        obj1.save()
        SoftDeleteDomainClass.first().id == obj.id
        SoftDeleteDomainClass.list().size() == 2
        SoftDeleteDomainClass.list(physical: true).size() == 2

        when:
        obj.delete()

        then:
        SoftDeleteDomainClass.first().id == obj1.id
        SoftDeleteDomainClass.list().size() == 1
        SoftDeleteDomainClass.list(physical: true).size() == 2
    }

    void "test last"() {
        when:
        def obj = new SoftDeleteDomainClass()
        def obj1 = new SoftDeleteDomainClass()

        then:
        obj.save()
        obj1.save()
        SoftDeleteDomainClass.last().id == obj1.id
        SoftDeleteDomainClass.list().size() == 2
        SoftDeleteDomainClass.list(physical: true).size() == 2

        when:
        obj1.delete()

        then:
        SoftDeleteDomainClass.last().id == obj.id
        SoftDeleteDomainClass.list().size() == 1
        SoftDeleteDomainClass.list(physical: true).size() == 2
    }

    void "test findBy"() {
        when:
        def obj = new SoftDeleteDomainClass(nome:'mock')

        then:
        obj.save()
        SoftDeleteDomainClass.findByNome('mock') != null
        SoftDeleteDomainClass.list().size() == 1
        SoftDeleteDomainClass.list(physical: true).size() == 1


        when:
        obj.delete()

        then:
        SoftDeleteDomainClass.findByNome('mock') == null
        SoftDeleteDomainClass.list().size() == 0
        SoftDeleteDomainClass.list(physical: true).size() == 1
    }
}