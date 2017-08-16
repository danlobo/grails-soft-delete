package softdelete

class SoftDeleteDomainClass implements SoftDeleteGormEntity<SoftDeleteDomainClass> {
    String nome
    static constraints = {
        nome nullable: true
    }
}
